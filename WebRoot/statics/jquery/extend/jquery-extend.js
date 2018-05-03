
//读取cookies
function getCookie(name) {
    try {
        var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
        if (arr = document.cookie.match(reg))
            return unescape(arr[2]);
        else
            return null;
    } catch (e) {
        return "";
    }
}
function getQueryString(name, defValue) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return decodeURI(r[2]);
    if (defValue != undefined)
        return defValue;
    return null;
}

function AjaxData(code, data) {
    try {
        var token = getCookie("token") || "";
        var url = window.location.pathname.replace("/pages/", "");
        var loginShopId = url.substring(0, url.indexOf('/'));
        var sourceShopId = getQueryString("sid", loginShopId) || loginShopId;
        var timestamp = new Date().getTime();

        return {
            "source": "wap",
            "code": code,
            "imei": "",
            "token": token, //token,
            "timestamp": timestamp,
            "mak": "",
            "sourceShopId": sourceShopId || 1,
            "loginShopId": loginShopId || 1,
            "data": $.jsonToString(data)
        };
    } catch (e) {
        console.log(e);
    }
}

(function ($) {
    var ajaxNum = 0, loading;
    function ajaxStart() {
        ajaxNum = ajaxNum < 0 ? 0 : ajaxNum;
        if (ajaxNum === 0) {
            loading = layer.load(2, { shade: [0.1, '#fff'] });
        }
        ajaxNum++;
    };

    function ajaxStop() {
        ajaxNum--;
        if (ajaxNum === 0) {
            setTimeout(layer.close(loading), 1000);
        }
    }
    $.extend({
        postAjax: function (isSync, code, data, callback, bg, after) {
            if (bg == undefined) bg = true;
            if ($.isFunction(data)) {
                after = callback;
                callback = data;
                data = undefined;
            }
            if ($.isFunction(bg)) {
                after = bg;
            }
            if (bg) ajaxStart();
            var d = new AjaxData(code, data);
            return $.ajax({
                url: "/dispatcher.htm?callback=?",
                type: "post",
                async: isSync,
                dataType: "json",
                jsonp: 'callback',
                data: d,
                success: function (rst, textStatus, errorThrown) {
                    try {
                        if (bg) ajaxStop();
                        if (rst.success == 3) {
                            var floderpath = window.location.pathname.indexOf("/find/");
                            if (floderpath >= 0) {
                                layer.msg("您还未登入！");
                                setTimeout(function () {
                                    location.href = "../login.html?url=" + encodeURIComponent(window.location.href);
                                }, 1000);
                            } else {
                                layer.msg("您还未登入！");
                                setTimeout(function () {
                                    location.href = "login.html?url=" + encodeURIComponent(window.location.href);
                                }, 1000);
                            }
                        }
                        rst.message = rst.message == '请求成功...' ? '成功' : rst.message;
                        callback(rst.success, rst.message, rst.data);
                        if ($.isFunction(after)) {
                            after(rst);
                        }
                    } catch (e) {
                        //var msg = { code: code, err: e, requery: data, response: rst }
                        //layer.alert("你太牛了，这种错误都被你试出来了，赶快截图反馈吧:" + JSON.stringify(msg));
                        layer.msg("请检查网络");
                    }
                },
                error: function (msg, textStatus, errorThrown) {
                    if (bg) ajaxStop();
                    //layer.msg("请求出错，请检查网络" + JSON.stringify(msg));
                    layer.alert("请求出错，请检查网络");
                }
            });
        },
        postSync: function (code, data, callback, bg, after) {
            $.postAjax(false, code, data, callback, bg, after);
        },
        postJson: function (code, data, callback, bg, after) {
            $.postAjax(true, code, data, callback, bg, after);
        },
        postPager: function(url, data, fun, bg, after) {
            var args = {
                runing: true,
                totalPage: 0,
                pageIndex: 1,
                url: url,
                data: data,
                fun: fun,
                request: function(idx) {
                    data.currentPage = args.pageIndex;
                    $.postJson(args.url, args.data, function(f, m, d) {
                        args.totalPages = d.totalPage;
                        args.fun(f, m, d, idx);
                        args.pageIndex++;
                        d.$pageIndex = args.pageIndex;
                        args.runing = false;
                    }, bg, after);
                }
            }
            args.request(1);
            $(window).unbind("scroll.myscroll");
            $(window).bind("scroll.myscroll", function () {
                var top = document.documentElement.scrollTop + document.body.scrollTop;
                var textheight = $(document).height();
                if (textheight - top - $(window).height() <= 10) {
                    if (args.pageIndex > args.totalPages) {
                        return;
                    }
                    if (!args.runing) {
                        args.runing = true;
                        args.request(args.pageIndex);
                    }
                }
            });
        },
        jsonToString: function (json) {
            return JSON.stringify(json);
        }
});

$.fn.extend({
    //异步绑定列表数据
    bindList: function (list, template) {
        if (!$.isArray(list)) return;
        this.children().not("script").not(".script").remove();
        var container = this;
        var tpl = $("#" + template).html();
        for (var i = 0; i < list.length ; i++) {
            var d = list[i];
            d.$index = i;
            d.$length = list.length;
            laytpl(tpl).render(d, function (render) {
                container.append(render);
            });
        }
    },
    //异步绑定列表数据
    bindListAppend: function (list, template) {
        if (!$.isArray(list)) return;
        var container = this;
        var tpl = $("#" + template).html();
        for (var i = 0; i < list.length ; i++) {
            var d = list[i];
            d.$index = i;
            d.$length = list.length;
            laytpl(tpl).render(d, function (render) {
                container.append(render);
            });
        }
    },
    //异步绑定model数据
    bindModel: function (data, template) {
        if (data == undefined) return;
        this.children().not("script").remove();
        var container = this;
        var tpl = $("#" + template).html();
        laytpl(tpl).render(data, function (render) {
            container.append(render);
        });
    },
    //同步绑定列表数据
    bindSyncList: function (list, template) {
        if (!$.isArray(list)) return;
        var container = this;
        var tpl = $("#" + template).html();
        for (var i = 0; i < list.length ; i++) {
            var d = list[i];
            d.$index = i;
            d.$length = list.length;
            container.append(laytpl(tpl).render(d));
        }
    },
    //同步绑定model数据
    bindSyncModel: function (data, template) {
        if (data == undefined) return;
        this.children().not("script").remove();
        var container = this;
        var tpl = $("#" + template).html();
        container.append(laytpl(tpl).render(data));
    },
    //同步绑定列表数据
    bindSyncListAppend: function (list, template) {
        if (!$.isArray(list)) return;
        this.children().not("script").remove();
        var container = this;
        var tpl = $("#" + template).html();
        for (var i = 0; i < list.length ; i++) {
            var d = list[i];
            d.$index = i;
            d.$length = list.length;
            container.append(laytpl(tpl).render(d));
        }
    },
    serializeJson: function () {
        var serializeObj = {};
        var array = this.serializeArray();
        $(array).each(function () {
            if (serializeObj[this.name]) {
                if ($.isArray(serializeObj[this.name])) {
                    serializeObj[this.name].push(this.value);
                } else {
                    serializeObj[this.name] = [serializeObj[this.name], this.value];
                }
            } else {
                serializeObj[this.name] = this.value;
            }
        });
        return serializeObj;
    },
    choose: function () {
        this.addClass("choose1").addClass("choose1-icon").removeClass("choose").removeClass("choose-icon");
    },
    unChoose: function () {
        this.addClass("choose").addClass("choose-icon").removeClass("choose1").removeClass("choose1-icon");
    },
    toggleChoose: function () {
        this.toggleClass("choose1").toggleClass("choose1-icon").toggleClass("choose").toggleClass("choose-icon")
    }
});
})(jQuery);
