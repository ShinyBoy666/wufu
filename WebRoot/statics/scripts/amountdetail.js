$(document).ready(function () {
    loadInfo(1);
});
var pageIdx = 1;
var totalpages = 1;
var ishave = true;
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
                loadInfo(pageIdx);
        }
    });
});

//获取消费明细
function loadInfo(num) {
    ishave = false;
    var user = new UserInfo(false);
    $.postJson("1024", { currentPage: num, customerId: 22, id: 0, limit: 10, paymentType: "", shopId: user.loginShopId }, function (flag, msg, data) {
        if (flag === 1) {
            pageIdx++;
            totalpages = data.totalPage;
            if (data.totalPage == 0) {
                $("#nodata").show();
            }
            $("#amountlist").bindListAppend(data.list, "amount-list");
        } else {
            layer.msg(msg);
        }
        ishave = true;
    });
}
