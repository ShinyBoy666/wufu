var shop = ShopInfo();
function Params() {
    this.currentPage = pageIdx;
    this.limit = 10;
    this.openid = getCookie("openId"); 
}
var pageIdx = 1;
var totalpages = 1;
var ishave = true;
//首页定位头部
$(function () {
    //获取要定位元素距离浏览器顶部的距离
    //滚动条事件
    $(window).scroll(function () {
        setTimeout(onScroll, 300);

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
                loadlist(pageIdx);
        }
    });
});

var scrollTimer = null;
function onScroll() {//滚动加载
    clearTimeout(scrollTimer);
    scrollTimer = setTimeout(function () {
        //返回顶部
        if ($(window).scrollTop() > 100) {
            $("#back-to-top").fadeIn(500);
        }
        else {
            $("#back-to-top").fadeOut(500);
        }

    }, 100);
}

function loadlist() {
    var p = new Params();
    var json;
    if (p.openid == null) {
        json = {
            "currentPage": p.currentPage,
            "limit": p.limit,
            "openid": ""
        };
    } else {
        json = {
            "currentPage": p.currentPage,
            "limit": p.limit,
            "openid": p.openid
        };
    }

    ishave = false;
    $.postSync("1084", json, function (flag, msg, datalist) {
        if (flag === 1) {
            $("#orderlist").show();
            $("#nodata").hide();
            if (datalist.totalRecord > 0) {
                if (pageIdx == 1) {
                    $("#orderlist").bindList(datalist.list, "tmp-list");
                } else {
                    $("#orderlist").bindListAppend(datalist.list, "tmp-list");
                }
                pageIdx++;
                totalpages = datalist.totalPage;
            } else {
                $("#orderlist").hide();
                $("#nodata").show();
            }
        } else {
            layer.msg(msg);
        }
        ishave = true;
    });
}
$(function () {
    
    loadlist();
});