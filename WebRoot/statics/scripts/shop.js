var pageIdx = 1;
var totalpages = 1;
var ishave = true;

var sid = get("sid", 0);

$(document).ready(function () {
    loadShopInfo();
    loadProductInfo();
});

//获取店铺商品
function loadShopInfo() {
    $.postJson("1063", { shopId: sid }, function (flag, msg, data) {
        if (flag === 1) {
            if (data.shopImage !== "") {
                $("#shopimg").attr("src", data.shopImage);
            }
            $("#shopLogo").attr("src", data.shopLogo);
            $("#shopName").text(data.shopName);
        } else {
            layer.msg(msg);
        }
    });
}

//获取店铺商品
function loadProductInfo() {
    ishave = false;
    $.postJson("1006", { currentPage: pageIdx, limit: 10, shopId: sid }, function (flag, msg, data) {
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
                loadProductInfo();
        }
    });
});

