function imgOnload(t,i){
	if(t.height>t.width){
		if(i%2 == 0){
			var height = t.width-0.5;
			
		}else{
			var height = t.width+0.5;
		}
	}else if(t.height<t.width){
		var height = t.width-0.5;
	}
	$(t).attr("height0",height)
	.css('height',height);
}
function changeShowType(t) {
    if ($("#hidshowtype").val() == 1) {
        $(t).addClass("search-much-list").removeClass("search-much");
        $("#hidshowtype").val(0);
        loadjscssfile("/statics/style/productsearch.css", "css");
        $("img[height0]").each(function(){
        	$(this).css('height',$(this).attr("height0"));
        });
    } else {
        $("#hidshowtype").val(1);
        $(t).addClass("search-much").removeClass("search-much-list");
        removejscssfile("/statics/style/productsearch.css", "css");
        $("img[height0]").css("height","");
    }
}

function opendetails(t) {
    var pid = $(t).data("pid");
    location.href = "productdetail.html?pid=" + pid;
}
function searchsort(t) {
    //0-销量由高到低；1-销量由低到高；2-价格由高到低；3-价格由低到高
    var temp = $("#hidsort").val();
    if (t == 1) {
        $(".PROsearch ul li").eq(0).addClass("active");
        $(".PROsearch ul li").eq(1).removeClass("active");
        $("i", $(".PROsearch ul li").eq(1)).addClass("sort-down").removeClass("sort-up-active").removeClass("sort-down-active");
        if (temp == "0") {
            $("i", $(".PROsearch ul li").eq(0)).addClass("sort-up-active").removeClass("sort-down-active").removeClass("sort-down");
            $("#hidsort").val(1);
        } else {
            $("i", $(".PROsearch ul li").eq(0)).addClass("sort-down-active").removeClass("sort-up-active");
            $("#hidsort").val(0).removeClass("sort-down");
        }
    } else {
        $(".PROsearch ul li").eq(1).addClass("active");
        $(".PROsearch ul li").eq(0).removeClass("active");
        $("i", $(".PROsearch ul li").eq(0)).addClass("sort-down").removeClass("sort-up-active").removeClass("sort-down-active");
        if (temp == "2") {
            $("#hidsort").val(3);
            $("i", $(".PROsearch ul li").eq(1)).addClass("sort-up-active").removeClass("sort-down-active").removeClass("sort-down");
        } else {
            $("#hidsort").val(2);
            $("i", $(".PROsearch ul li").eq(1)).addClass("sort-down-active").removeClass("sort-up-active").removeClass("sort-down");
        }
    }
    pageIdx = 1;
    loadlist();
}

function Params() {
    this.currentPage = pageIdx;
    this.limit = 10;
    this.shopId = new UserInfo().loginShopId;
    this.brandId = 0;
    this.categoryId = getQueryString("cid", 0);
    this.level = 3;
    this.sortType = $("#hidsort").val();
    this.keyword = $("#search").val();
}

function loadlist() {
    var p = new Params();
    var json = {
        "currentPage": p.currentPage,
        "limit": p.limit,
        "shopId": p.shopId,
        "brandId": p.brandId,
        "categoryId": p.categoryId,
        "level": p.level,
        "sortType": p.sortType,
        "keyword": p.keyword
    };
    ishave = false;
    $.postSync("1006", json, function (flag, msg, datalist) {
        if (flag === 1) {
            if (pageIdx == 1) {
                $("#list_products").bindList(datalist.list, "tmp-list-products");
            } else {
                $("#list_products").bindListAppend(datalist.list, "tmp-list-products");
            }
            pageIdx++;
            totalpages = datalist.totalPage;
        } else {
            layer.msg(msg);
        }
        ishave = true;
    });
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
$(function () {
    var keyword = getQueryString("k", "");
    $("#search").val(keyword);
    $("#search").keypress(function (event) {
        var code = event.keyCode;
        if (13 == code) {
            pageIdx = 1;
            loadlist();
        }
    });

    loadlist();
});