var pageIdx = 1;
var totalpages = 1;
var ishave = true;

$(document).ready(function () {
    loadInfo();
});

//获取我关注的商品
function loadInfo() {
    ishave = false;
    var user = new UserInfo(1);
    $.postJson("1040", { currentPage: pageIdx, limit: 10, customerId: user.id }, function (flag, msg, data) {
        if (flag === 1) {
            pageIdx++;
            totalpages = data.totalPage;
            if (data.totalPage == 0) {
                $("#nodata").show();
            }
            $("#productList").bindListAppend(data.list, "product-list");
        } else {
            layer.msg(msg);
        }
        ishave = true;
});
}

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
                loadInfo();
        }
    });
});

