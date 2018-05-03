var pageIdx = 1;
var totalpages = 1;
var ishave = true;

$(document).ready(function () {
    loadBanner();
    loadInfo();
});

//获取Banner
function loadBanner() { 
    $.postJson("1061", {}, function (flag, msg, data) {
        if (flag === 1) {
            $("#bannercontent").bindList(data, "banner-content");
            var banner = new Swiper('.swiper-banner', {
                pagination: '.pagination-banner',
                paginationClickable: true,
                spaceBetween: 30,
                centeredSlides: true,
                autoplay: 4000,
                autoplayDisableOnInteraction: false
            });

        } else {
            layer.msg(msg);
        }
    });
}

function openbanner(t) {
    var showtype = $(t).data("showtype");
    var objectid = $(t).data("objectid");
    var linkurl = $(t).data("linkurl");
    switch (showtype) {
        case 1:
            location.href = "productdetail.html?pid=" + objectid;
            break;
        case 2:
            window.open(linkurl);
            break;
        default:
    }
}
//获取云商城商品
function loadInfo() {
    ishave = false;
    $.postJson("1062", { currentPage: pageIdx, limit: 10 }, function (flag, msg, data) {
        if (flag === 1) {
            pageIdx++;
            totalpages = data.totalPage;
            $("#list_products").bindListAppend(data.list, "tmp-list-products");
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
