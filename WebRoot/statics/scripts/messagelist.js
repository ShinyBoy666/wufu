
var pageIdx = 1;
var totalpages = 1;
var ishave = true;
var u = new UserInfo(1);
$(function () {
    bind(1);
});

//首页定位头部
$(function () {
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
});

function bind(idx) {
    ishave = false;
    $.postJson("1052", { currentPage: idx, limit: 3, shopId: u.loginShopId }, function (f, m, d) {
        if (f == 1) {
            totalpages = d.totalPage;
            if (pageIdx == 1) {
                $("#list").bindList(d.list, "tmp-list");
                if (d.list.length==0) {
                    $("#nodata").show();
                }
            } else {
                $("#list").bindListAppend(d.list, "tmp-list");
            }
            pageIdx++;
        }
        ishave = true;
    });
}