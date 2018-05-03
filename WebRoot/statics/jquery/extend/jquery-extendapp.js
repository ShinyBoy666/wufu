


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
    function AjaxData(code, data) {
        var token = getCookie("token") || "";
        var sourceShopId = getCookie("sourceShopId")||"0";
        var loginShopId = getCookie("loginShopId") || "0";
        var timestamp = new Date().getTime();

        return {
            "source": "wap",
            "code": code,
            "imei": "",
            "token": token, //token,
            "timestamp": timestamp,
            "mak": "",
            "sourceShopId": sourceShopId,
            "loginShopId": loginShopId,
            "data": $.jsonToString(data)
        };
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
                //url: "http://192.168.0.20:8080/dispatcher.htm?callback=?",
                type: "post",
                async: isSync,
                dataType: "json",
                jsonp: 'callback',
                data: d,
                success: function (rst, textStatus, errorThrown) {
                    if (bg) ajaxStop();
                    if (rst.success == 3) { location.href = "login.html?url=" + encodeURIComponent(window.location.href) }
                    rst.message = rst.message == '请求成功...' ? '成功' : rst.message;
                    callback(rst.success, rst.message, rst.data);
                    if ($.isFunction(after)) {
                        after(rst);
                    }
                },
                error: function (msg, textStatus, errorThrown) {
                    if (bg) ajaxStop();
                    layer.msg("请求出错，请检查网络" + JSON.stringify(msg));
                }
            });
        },
        postSync: function (code, data, callback, bg, after) {
            $.postAjax(false, code, data, callback, bg, after);
        },
        postJson: function (code, data, callback, bg, after) {
            $.postAjax(true, code, data, callback, bg, after);
        },
        jsonToString: function (json) {
            return JSON.stringify(json);
        }
    });

    $.fn.extend({
        //异步绑定列表数据
        bindList: function (list, template) {
            this.children().not("script").remove();
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
            this.children().not("script").remove();
            var container = this;
            var tpl = $("#" + template).html();
            laytpl(tpl).render(data, function (render) {
                container.append(render);
            });
        },
        //同步绑定列表数据
        bindSyncList: function (list, template) {
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
            this.children().not("script").remove();
            var container = this;
            var tpl = $("#" + template).html();
            container.append(laytpl(tpl).render(data));
        },
        //同步绑定列表数据
        bindSyncListAppend: function (list, template) {
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