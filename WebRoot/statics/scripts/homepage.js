
var obj = new Object();
var interval;  //定时器
function opensearch() {
    var keyword = $("#search").val();
    location.href = "productsearch.html?k=" + keyword;
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
function opendetails(t) {
    var key = $(t).data("id");
    var type = obj[key].type;
    if (type == 1) {
        if (obj[key].linkUrl == "") {
            //跳转到活动列表
            location.href = "homeactivity.html?mid=" + obj[key].id + "&title=" + obj[key].title;
        } else {
            window.open(obj[key].linkUrl);
        }
    } else if (type == 2) {
        if (obj[key].productInfos.length > 0) {
            var pid = obj[key].productInfos[0].productId;
            location.href = "productdetail.html?pid=" + pid;
        } else {
            layer.msg("商品异常");
        }
    }
}
function openproductdetail(pid) {
    location.href = "productdetail.html?pid=" + pid;
}
function openactivity(t) {
    var activityproductnum = $(t).data("activityproductnum");
    var activityid = $(t).data("activityid");
    var productpriceid = $(t).data("productpriceid");
    var productid = $(t).data("productid");
    if (activityproductnum == 1) {
        location.href = "activityproductdetail.html?activityId=" + activityid + "&productId=" + productid + "&productPriceId=" + productpriceid;
    } else {
        location.href = "flashactivity.html?id=" + activityid;
    }
}
function loadInfo() {
    var shop = new UserInfo();
    var shopid = shop.loginShopId;
    $.postSync("1037", { "shopId": shopid }, function (flag, msg, datalist) {
        var html = "";
        if (flag == 1) {
        	if(datalist.shopName){
        		$("title").text(datalist.shopName);
        	}
            if (datalist.noticeCount > 0) {
                $("#message_ico").addClass("xiaoxi_active").removeClass("xiaoxi");
            }
            if(datalist.cartCount && datalist.cartCount > 0){
            	$("#cartTotalItemNum").text(datalist.cartCount);
            }else{
            	$("#cartTotalItemNum").hide();
            }
            var res = datalist.modulList;
            var banners = datalist.bannerList;
            setCookie('serverPhone', datalist.serverPhone, 'd100');
            $("#bannercontent").bindSyncList(banners, "tmp-banner");
            $(".firstpage-absout").show();
           
            $("#topMenu").bindSyncList(datalist.topMenu, "tmp-topMenu");
            if(datalist.topMenu && datalist.topMenu.length > 0){
            	$(".homefunction").show();
            }
            var shareTitle = datalist.shopName+"已经开业啦，我们用最好的商品、最热情的服务欢迎您的光临！赶快进店吧！！！";
            if(shopid === "1"){
            	shareTitle = "维密有趣一个专业的情趣用品销售平台，保证正品，假一赔十，新用户注册立送30元！";
            }
        	//初始化分享参数
            $.wxShare.init(datalist.shopName, shareTitle, "http://wap.51shunkai.com/pages/"+shopid+"/homepage.html", datalist.shopLogo);
           
            var banner = new Swiper('.swiper-banner', {
                pagination: '.pagination-banner',
                paginationClickable: true,
                spaceBetween: 10,
                centeredSlides: true,
                autoplay: 4000,
                autoplayDisableOnInteraction: false
            });
            for (var i = 0; i < res.length; i++) {
                var data = res[i];
                switch (res[i].showType) {
                    case 1:
                        var temp1 = $("#templet1").clone();
                        if (data.list.length > 0) {
                            //如果标题设置为无，则隐藏标题
                            if (data.list[0].title == "无") {
                                $(".mypage-head-name",temp1).hide();
                            } else {
                                $(".platetitle", temp1).html(data.list[0].title);
                            }
                            $(".platecontent", temp1).removeClass("lr-hint").html("<img onclick=\"opendetails(this)\" data-id=\"" + data.list[0].id + "\" src=\"" + data.list[0].imgUrl + "\" style=\"width: 100%;height:100%\" />");
                            obj[data.id] = data.list[0];
                            html += temp1.html();
                        }
                        break;
                    case 2:
                        var temp2 = $("#templet2").clone();
                        //如果标题设置为无，则隐藏标题
                        if (data.title == "无") {
                            $(".mypage-head-name",temp2).hide();
                        } else {
                            $(".platetitle", temp2).html(data.title);
                        }
                        if (data.list.length == 1) {
                            $(".platecontent li", temp2).eq(0).removeClass("lr-hint").html("<img onclick=\"opendetails(this)\" data-id=\"" + data.list[0].id + "\"  src=\"" + data.list[0].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            obj[data.list[0].id] = data.list[0];
                        } else if (data.list.length > 1) {
                            $(".platecontent li", temp2).eq(0).removeClass("lr-hint").html("<img onclick=\"opendetails(this)\" data-id=\"" + data.list[0].id + "\"  src=\"" + data.list[0].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            $(".platecontent li", temp2).eq(1).removeClass("lr-hint").html("<img onclick=\"opendetails(this)\" data-id=\"" + data.list[1].id + "\"  src=\"" + data.list[1].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            obj[data.list[0].id] = data.list[0];
                            obj[data.list[1].id] = data.list[1];
                        }
                        html += temp2.html();
                        break;
                    case 3:
                        var temp3 = $("#templet3").clone();
                        //如果标题设置为无，则隐藏标题
                        if (data.title == "无") {
                            $(".mypage-head-name",temp3).hide();
                        } else {
                            $(".platetitle", temp3).html(data.title);
                        }
                        if (data.list.length == 1) {
                            $(".platecontent li", temp3).eq(0).removeClass("lr-hint").html("<img  onclick=\"opendetails(this)\" data-id=\"" + data.list[0].id + "\"  src=\"" + data.list[0].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            obj[data.list[0].id] = data.list[0];
                        } else if (data.list.length == 2) {
                            $(".platecontent li", temp3).eq(0).removeClass("lr-hint").html("<img  onclick=\"opendetails(this)\" data-id=\"" + data.list[0].id + "\"  src=\"" + data.list[0].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            $(".platecontent li p", temp3).eq(0).removeClass("lr-hint").html("<img  onclick=\"opendetails(this)\" data-id=\"" + data.list[1].id + "\"  src=\"" + data.list[1].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            obj[data.list[0].id] = data.list[0];
                            obj[data.list[1].id] = data.list[1];
                        } else if (data.list.length > 2) {
                            $(".platecontent li", temp3).eq(0).removeClass("lr-hint").html("<img  onclick=\"opendetails(this)\" data-id=\"" + data.list[0].id + "\"  src=\"" + data.list[0].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            $(".platecontent li p", temp3).eq(0).removeClass("lr-hint").html("<img  onclick=\"opendetails(this)\" data-id=\"" + data.list[1].id + "\"  src=\"" + data.list[1].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            $(".platecontent li p", temp3).eq(1).removeClass("lr-hint").html("<img  onclick=\"opendetails(this)\" data-id=\"" + data.list[2].id + "\"  src=\"" + data.list[2].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            obj[data.list[0].id] = data.list[0];
                            obj[data.list[1].id] = data.list[1];
                            obj[data.list[2].id] = data.list[2];
                        }
                        html += temp3.html();
                        break;
                    case 4:
                        var temp4 = $("#templet4").clone();
                        //如果标题设置为无，则隐藏标题
                        if (data.title == "无") {
                            $(".mypage-head-name", temp4).hide();
                        } else {
                            $(".platetitle", temp4).html(data.title);
                        }
                        if (data.list.length == 1) {
                            $(".platecontent li", temp4).eq(0).removeClass("lr-hint").html("<img  onclick=\"opendetails(this)\" data-id=\"" + data.list[0].id + "\"   src=\"" + data.list[0].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            obj[data.list[0].id] = data.list[0];
                        } else if (data.list.length == 2) {
                            $(".platecontent li ", temp4).eq(0).removeClass("lr-hint").html("<img  onclick=\"opendetails(this)\" data-id=\"" + data.list[0].id + "\"   src=\"" + data.list[0].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            $(".platecontent li div", temp4).eq(0).removeClass("lr-hint").html("<img  onclick=\"opendetails(this)\" data-id=\"" + data.list[1].id + "\"   src=\"" + data.list[1].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            obj[data.list[0].id] = data.list[0];
                            obj[data.list[1].id] = data.list[1];
                        } else if (data.list.length == 3) {
                            $(".platecontent li", temp4).eq(0).removeClass("lr-hint").html("<img  onclick=\"opendetails(this)\" data-id=\"" + data.list[0].id + "\"   src=\"" + data.list[0].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            $(".platecontent li div", temp4).eq(0).removeClass("lr-hint").html("<img  onclick=\"opendetails(this)\" data-id=\"" + data.list[1].id + "\"   src=\"" + data.list[1].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            $(".platecontent li div p", temp4).eq(0).removeClass("lr-hint").html("<img  onclick=\"opendetails(this)\" data-id=\"" + data.list[2].id + "\"   src=\"" + data.list[2].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            obj[data.list[0].id] = data.list[0];
                            obj[data.list[1].id] = data.list[1];
                            obj[data.list[2].id] = data.list[2];
                        } else if (data.list.length > 3) {
                            $(".platecontent li", temp4).eq(0).removeClass("lr-hint").html("<img  onclick=\"opendetails(this)\" data-id=\"" + data.list[0].id + "\"   src=\"" + data.list[0].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            $(".platecontent li div", temp4).eq(0).removeClass("lr-hint").html("<img  onclick=\"opendetails(this)\" data-id=\"" + data.list[1].id + "\"   src=\"" + data.list[1].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            $(".platecontent li div p", temp4).eq(0).removeClass("lr-hint").html("<img  onclick=\"opendetails(this)\" data-id=\"" + data.list[2].id + "\"   src=\"" + data.list[2].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            $(".platecontent li div p", temp4).eq(1).removeClass("lr-hint").html("<img  onclick=\"opendetails(this)\" data-id=\"" + data.list[3].id + "\"   src=\"" + data.list[3].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            obj[data.list[0].id] = data.list[0];
                            obj[data.list[1].id] = data.list[1];
                            obj[data.list[2].id] = data.list[2];
                            obj[data.list[3].id] = data.list[3];
                        }
                        html += temp4.html();
                        break;
                    case 5:
                        var temp5 = $("#templet5").clone();
                        //如果标题设置为无，则隐藏标题
                        if (data.title == "无") {
                            $(".mypage-head-name", temp5).hide();
                        } else {
                            $(".platetitle", temp5).html(data.title);
                        }
                        if (data.list.length == 1) {
                            $(".platecontent li", temp5).eq(0).removeClass("lr-hint").html("<img   onclick=\"opendetails(this)\" data-id=\"" + data.list[0].id + "\"  src=\"" + data.list[0].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            obj[data.list[0].id] = data.list[0];
                        } else if (data.list.length == 2) {
                            $(".platecontent li ", temp5).eq(0).removeClass("lr-hint").html("<img   onclick=\"opendetails(this)\" data-id=\"" + data.list[0].id + "\"  src=\"" + data.list[0].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            $("li", $(".platecontent li", temp5)).eq(0).removeClass("lr-hint").html("<img   onclick=\"opendetails(this)\" data-id=\"" + data.list[1].id + "\"  src=\"" + data.list[1].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            obj[data.list[0].id] = data.list[0];
                            obj[data.list[1].id] = data.list[1];
                        } else if (data.list.length == 3) {
                            $(".platecontent li", temp5).eq(0).removeClass("lr-hint").html("<img   onclick=\"opendetails(this)\" data-id=\"" + data.list[0].id + "\"  src=\"" + data.list[0].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            $("li", $(".platecontent li", temp5)).eq(0).removeClass("lr-hint").html("<img   onclick=\"opendetails(this)\" data-id=\"" + data.list[1].id + "\"  src=\"" + data.list[1].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            $("li", $(".platecontent li", temp5)).eq(1).removeClass("lr-hint").html("<img   onclick=\"opendetails(this)\" data-id=\"" + data.list[2].id + "\"  src=\"" + data.list[2].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            obj[data.list[0].id] = data.list[0];
                            obj[data.list[1].id] = data.list[1];
                            obj[data.list[2].id] = data.list[2];

                        } else if (data.list.length == 4) {
                            $(".platecontent li", temp5).eq(0).removeClass("lr-hint").html("<img    onclick=\"opendetails(this)\" data-id=\"" + data.list[0].id + "\"  src=\"" + data.list[0].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            $("li", $(".platecontent li", temp5)).eq(0).removeClass("lr-hint").html("<img   onclick=\"opendetails(this)\" data-id=\"" + data.list[1].id + "\"  src=\"" + data.list[1].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            $("li", $(".platecontent li", temp5)).eq(1).removeClass("lr-hint").html("<img    onclick=\"opendetails(this)\" data-id=\"" + data.list[2].id + "\" src=\"" + data.list[2].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            $("li", $(".platecontent li", temp5)).eq(2).removeClass("lr-hint").html("<img   onclick=\"opendetails(this)\" data-id=\"" + data.list[3].id + "\"  src=\"" + data.list[3].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            obj[data.list[0].id] = data.list[0];
                            obj[data.list[1].id] = data.list[1];
                            obj[data.list[2].id] = data.list[2];
                            obj[data.list[3].id] = data.list[3];
                        } else if (data.list.length > 4) {
                            $(".platecontent li", temp5).eq(0).removeClass("lr-hint").html("<img   onclick=\"opendetails(this)\" data-id=\"" + data.list[0].id + "\"  src=\"" + data.list[0].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            $("li", $(".platecontent li", temp5)).eq(0).removeClass("lr-hint").html("<img   onclick=\"opendetails(this)\" data-id=\"" + data.list[1].id + "\"  src=\"" + data.list[1].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            $("li", $(".platecontent li", temp5)).eq(1).removeClass("lr-hint").html("<img   onclick=\"opendetails(this)\" data-id=\"" + data.list[2].id + "\"  src=\"" + data.list[2].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            $("li", $(".platecontent li", temp5)).eq(2).removeClass("lr-hint").html("<img   onclick=\"opendetails(this)\" data-id=\"" + data.list[3].id + "\"  src=\"" + data.list[3].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            $("li", $(".platecontent li", temp5)).eq(3).removeClass("lr-hint").html("<img   onclick=\"opendetails(this)\" data-id=\"" + data.list[4].id + "\"  src=\"" + data.list[4].imgUrl + "\" style=\"width: 100%;height:100%;\" />");
                            obj[data.list[0].id] = data.list[0];
                            obj[data.list[1].id] = data.list[1];
                            obj[data.list[2].id] = data.list[2];
                            obj[data.list[3].id] = data.list[3];
                            obj[data.list[4].id] = data.list[4];
                        }
                        html += temp5.html();
                        break;
                    case 6:
                        var temp6 = $("#templet6").clone();
                        //如果标题设置为无，则隐藏标题
                        if (data.title == "无") {
                            $(".mypage-head-name", temp6).hide();
                        } else {
                            $(".platetitle", temp6).html(data.title);
                        }
                        var playehtml = "";
                        for (var j = 0; j < data.productInfos.length; j++) {
                            playehtml += "<div class=\"swiper-slide\" onclick=\"openproductdetail(" + data.productInfos[j].productId + ")\" ><a href=\"javascript:void(0);\"><p><img src=\"" + data.productInfos[j].imageUrl + "\" /></p><p style=\"text-align:center;color:#FF004D;margin-top:5px;margin-bottom:10px\">¥" + data.productInfos[j].retailPrice.toFixed(2) + "</p></a></div>";
                        }
                        $(".platecontent", temp6).html(playehtml);

                        html += temp6.html();
                        break;
                    case 7:
                        var temp7 = $("#templet7").clone();
                        //如果标题设置为无，则隐藏标题
                        if (data.title == "无") {
                            $(".mypage-head-name", temp7).hide();
                        } else {
                            $(".platetitle", temp7).html(data.title);
                        }
                        var playehtml7 = "";
                        for (var k = 0; k < data.productInfos.length; k++) {
                            playehtml7 += "<li><a href=\"javascript:void(0);\"   onclick=\"openproductdetail(" + data.productInfos[k].productId + ")\" ><p  style=\"text-align:center;\" ><img src=\"" + data.productInfos[k].imageUrl + "\"  /></p><p   style=\"color:#979797;height:36px;line-height:18px;padding-left:4px;overflow:hidden\">" + data.productInfos[k].productName + "</p><p style=\"font-size:16px;color:#FF004D;padding-left:4px;padding-bottom:10px;border-bottom: 1px solid #eee;\">¥" + data.productInfos[k].retailPrice.toFixed(2) + "</p></a></li>";
                        }
                        $(".platecontent", temp7).html(playehtml7);
                        html += temp7.html();
                        break;
                    case 8:
                        var temp8 = $("#templet8").clone();
                        //如果标题设置为无，则隐藏标题
                        if (data.title == "无") {
                            $(".mypage-head-name", temp8).hide();
                        } else {
                            $(".platetitle", temp8).html(data.title);
                        }
                        $(".platecontent", temp8).bindModel(data.list, "tmp-activity");
                        html += temp8.html();
                        break;
                    default:
                        break;
                }

            }
            $("#maincontent").append(html);
            var width = window.screen.width;
            if (width > 640) {
                width = 640;
            }
            $(".width-50").css("height", Math.round(width / 2));
            $(".width-25").css("height", Math.round(width / 4));
            timedCount();
            var swiper = new Swiper('.swiper-product', {
                pagination: '.product-pagination',
                slidesPerView: 4,
                paginationClickable: true,
                spaceBetween: 1,
                freeMode: true
            });


        } else {
            layer.msg(msg);
        }
    });
}

function loadshopinfo() {
    var shop = new UserInfo();
    var sid = shop.loginShopId;
    $.postJson("1066", { "shopId": sid }, function (flag, msg, data) {
        if (flag == 1) {
            var logo = data.logo;
            var name = data.shopName;
            loadjscssfile(logo, "applogo");
            document.title = name;
        } else {
            layer.msg(msg);
        }
    });
}
function timedCount() {
    clearInterval(interval);
    interval = setInterval("countDown()", 1000);
}
function countDown() {
    $(".timer").each(function (i, o) {
        var maxtime = 0;
        var days;
        var hours;
        var minutes;
        var seconds;
        var msg;
        if ($(o).data("isbegin") == "1") {
            maxtime = parseInt($(o).data("lastdate"));
            if (maxtime >= 0) {
                days = parseInt(Math.floor(maxtime / 86400));
                if (0 < days && days < 10) {
                    days = "0" + days;
                }
                hours = Math.floor((maxtime / 3600) % 24);
                minutes = Math.floor((maxtime / 60) % 60);
                seconds = Math.floor(maxtime % 60);
                msg = "<span style=\"color:#fff\">" + days + "天" + hours + ":" + minutes + ":" + seconds + "</span>";
                $(o).html("距离开始 " + msg);
                $(o).parent().show();
                --maxtime;
                $(o).data("lastdate", maxtime);
            } else {
                $(o).remove();
            }
        } else {
            maxtime = parseInt($(o).data("lastdate"));
            if (maxtime >= 0) {
                days = parseInt(Math.floor(maxtime / 86400));
                if (0 < days && days < 10) {
                    days = "0" + days;
                }
                hours = Math.floor((maxtime / 3600) % 24);
                minutes = Math.floor((maxtime / 60) % 60);
                seconds = Math.floor(maxtime % 60);
                msg = "<span style=\"color:#fff\">" + days + "天" + hours + ":" + minutes + ":" + seconds + "</span>";
                $(o).html("距离结束 " + msg);
                $(o).parent().show();
                --maxtime;
                $(o).data("lastdate", maxtime);
            } else {
                $(o).remove();
            }
        }
    });
}
$(function () {
    var isflag = true;
//    if (!is_weixn()) {
//        //初始化添加到主屏幕信息
//        var res = GetRequest();
//        var par = res['index'];
//        if (par != 'gfan') {
//            var ua = navigator.userAgent.toLowerCase();
//            var contains = function (a, b) {
//                if (a.indexOf(b) != -1) { return true; }
//            };
//            if (contains(ua, "iphone")) {
//                if (!window.navigator.standalone) {
//                    loadshopinfo();
//                    isflag = false;
//                }
//            }
//        }
//    }
    if (isflag) {
        $("#mask_main").show();
        loadInfo();
    } else {
        $("#mask_layer").show();

    }
});

//$(window).resize(function () {
//    //var width = $(window).width();
//    //alert(width);
//    //if (width > 640) {
//    //    width = 640;
//    //}
//    //$(".width-50").css("height", Math.round(width / 2));
//    //$(".width-25").css("height", Math.round(width / 4));
//});