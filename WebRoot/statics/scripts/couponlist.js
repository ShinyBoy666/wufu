$(document).ready(function () {
    bind(1);
});
var pageIdx = 1;
var totalpages = 1;
var ishave = true;
var u = new UserInfo();
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
    $.postJson("1034", { currentPage: idx, limit: 30,  shopId: u.loginShopId }, function (f, m, d) {

        if (d.totalPage == 0) {
            $("#nodata").show();
        }
        if (pageIdx == 1) {
            $("#list").bindList(d.list, "tmp-list");
            for (var i = 0; i < d.list.length; i++) {
                drawcircular(d.list[i]["id"]);
                drawcircular2(d.list[i]["id"]);
            }
        }
        else {
            $("#list").bindListAppend(d.list, "tmp-list");
            for (var i = 0; i < d.list.length; i++) {
                drawcircular(d.list[i]["id"]);
                drawcircular2(d.list[i]["id"]);
            }
        }
        pageIdx++;
        ishave = true;
    });
}

function getCoupon(dom, id, useShopId) {
    if ($.trim($(dom).text()) == "立即领取") {
        $(dom).text('领取中');
        $.postJson("1032", {  shopId: u.loginShopId, useShopId: useShopId, couponApplyId: id }, function (f, m, d) {
            $(dom).text('已领取');
            //bind(1);
        });
    } else {
        layer.msg('您已领取过');
    }
}

function drawcircular(id) {
    var btn = "#myStat" + id;
    $(btn).circliful();
}
function drawcircular2(id) {
    var btn = "#myoverStat" + id;
    $(btn).circliful();
}

function ShowtPercent(r, o) {
    var t = r + o;
    var s=r * 100.0 / t;
    return "已抢" + s;
}
function GetPercent(r, o) {
    return r * 100.0 / o;
}
