$(function () {
    var app = angular.module('app', ['localResizeIMG']);
    app.controller('appCtrl', function ($scope) {
        $scope.ok = function (stop, data) {
            data.original.size = (data.original.size / 1024).toFixed(2);
            $scope.$apply();

            setTimeout(function () {
                stop();
            }, 1000);
        };
    });
    angular.bootstrap(document, ['app']);
    var u = new UserInfo(0);
    var pageIdx = 1;
    var totalpages = 1;
    var ishave = true;

    $(function () {
        $("#groupName").text(getQueryString("n"));
        bind(1);
    });

    //首页定位头部
    //获取要定位元素距离浏览器顶部的距离
    //滚动条事件
    $(window).scroll(function () {
        //滚动条到网页头部的 高度，兼容ie,ff,chrome
        var top = document.documentElement.scrollTop + document.body.scrollTop;
        //网页的高度
        var textheight = $(document).height();
        // 网页高度-top-当前窗口高度
        if (textheight - top - $(window).height() <= 10) {
            if (pageIdx > totalpages) {
                return;
            }
            if (ishave)
                bind(pageIdx);
        }
    });

    //绑定初始化
    function bind(p) {
        ishave = false;
        pageIdx = p;
        if (u.id == getQueryString("c")) {
            $(".add").show();
        } else {
            $(".add").hide();
        }
        $(".product-page .selecter").removeClass("selecter");
        $.postJson("1109", {id:getQueryString("id"), customerId: u.id, currentPage: p, limit: 20 }, function (f, m, d) {
            if (f === 1) {
                totalpages = d.totalPage;
                if (pageIdx === 1) {
                    if (!d.list || d.list.length === 0) {
                        $("#nodata").show();
                    } else {
                        $("#nodata").hide();
                    }
                    $("#list").bindList(d.list, "tmp-list");
                } else {
                    $("#list").bindListAppend(d.list, "tmp-list");
                }
                pageIdx++;
            } else {
                layer.msg(m);
            }
            ishave = true;
        });
    }

    //打开添加小组表单
    $(".add").click(function () {
        location.href = 'msgadd.html?id=' + getQueryString("id")+"&n="+getQueryString("n")+"&c="+getQueryString("c");
    });

    $("#goback").click(function () {
        history.back();
    });

    $("#list").on("click", "img", function () {
        $("#showImg img").attr("src", this.src);
    });
    $("#show img").load(function () {
        layer.open({
            title: false,
            type: 1,
            skin: 'layui-layer-demo', //样式类名
            closeBtn: 0, //不显示关闭按钮
            shift: 1,
            shadeClose: true,
            area: ["90%", 'auto'],
            content: $("#showImg"),
            end: function () {
                $("#showImg img").attr("src", "");
            }
        });
    });
});
