$(function () {
    var pageIdx = 1;
    var totalpages = 1;
    var ishave = true;
    var u = new UserInfo(0);
    $(function () {
        bind(1);
    });

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
        $(".product-page .selecter").removeClass("selecter");
        $.postJson("1112", { customerId: u.id, currentPage: p, limit: 20 }, function (f, m, d) {
            if (f == 1) {
                totalpages = d.totalPage;
                if (pageIdx == 1) {
                    if (!d.list || d.list.length == 0) {
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

    //查看留言
    $("#list").on("click", '.msg-count', function () {
        var json = $(this).parents(".item").data("json");
        location.href = "chatmsg.html?cid=" + json.chatId + "&n=" + json.nickname;
    });

    //返回
    $("#goback").click(function () {
        history.back();
    });

    $("#list").on("click", ".item", function () {
        var json = $(this).data("json");
        $.postJson("1119", { customerId: u.id }, function (f, m, d) {
            if (f == 1) {
                if (d.isFindVip) {
                    location.href = "chatmsg.html?n=" + json.nickname + "&cid=" + json.id;
                } else {
                    layer.confirm('您须开通发现小组会员！', {
                        btn: ['去升级', '不升级'] //按钮
                    }, function () {
                        location.href = "../vipupgrade.html?q=2";
                    });

                }
            } else {
                layer.msg(m);
            }
        });
    });
});
