
function searchMoney() {
    $('#pover0').toggle();
}
function Search_pover(value) {
    var text;
    $("#hidmoney").val(value);
    if (value == 0) {
        text = "金额<i class=\"sort-down sort-icon\"></i>";
        $("#search_a2").html(text);
    } else {
        text = "¥" + value;
        $("#search_a2").html(text);
    }
    $('#pover0').css("display", "none");

    pageIdx = 1;
    loadList();
}

function openSearch(type) {
    var t;
    if (type == 0) {
        t = $("#hiddistance").val();
        $("#hidsearchtype").val(0);
        if (t == 0) {
            $("#hiddistance").val(1);
            $("i", $("#searchLine li").eq(0)).addClass("sort-up-active").removeClass("sort-down-active").removeClass("sort-down");
        } else {
            $("#hiddistance").val(0);
            $("i", $("#searchLine li").eq(0)).removeClass("sort-up-active").addClass("sort-down-active").removeClass("sort-down");;
        }
    } else {
        t = $("#hidpopularity").val();
        $("#hidsearchtype").val(1);
        if (t == 0) {
            $("#hidpopularity").val(1);
            $("i", $("#searchLine li").eq(1)).addClass("sort-up-active").removeClass("sort-down-active").removeClass("sort-down");;
        } else {
            $("#hidpopularity").val(0);
            $("i", $("#searchLine li").eq(1)).removeClass("sort-up-active").addClass("sort-down-active").removeClass("sort-down");;
        }
    }
    pageIdx = 1;
    loadList();
}
var shop = ShopInfo();
function Params() {
    this.o = getQueryString("o", "");
    this.c = (getCookie("customerId") == null || getCookie("customerId") == "") ? 0 : getCookie("customerId");
    this.currentPage = pageIdx;
    this.limit = 10;
    this.log = shop.longitude;
    this.lat = shop.latitude;
    this.openid = shop.openId;
}
function loadCurCoupons() {
    var p = new Params();
    var json = {
        "orderId": p.o,
        "longitude": p.log,
        "latitude": p.lat,
        "customerId": p.c
    };
    ishave = false;
    $.postSync("1097", json, function (flag, msg, datalist) {
        if (flag === 1) {
            $(".conpon-list").bindList(datalist.list, "tmp-model");
            $("#couponlist_title").html("本次消费可领取" + datalist.scAmount + "元优惠券");
            $("#hidtotalAmounct").val(datalist.scAmount);
            if (datalist.list.length == 0) {
                $(".conpon-list").hide();
                $("#nodata").show();
            }
        } else {
            layer.msg(msg);
        }
        ishave = true;
    });
}

function loadList() {
    var p = new Params();
    var searchtype = $("#hidsearchtype").val();
    var json = "";
    if (searchtype == 0) {
        json = {
            "currentPage": p.currentPage,
            "limit": p.limit,
            "distanceType": $("#hiddistance").val(),
            "couponMoney": $("#hidmoney").val(),
            "orderId": p.o,
            "longitude": p.log,
            "latitude": p.lat,
            "customerId": p.c
        };
    } else {
        json = {
            "currentPage": p.currentPage,
            "limit": p.limit,
            "popularityType": $("#hidpopularity").val(),
            "couponMoney": $("#hidmoney").val(),
            "orderId": p.o,
            "longitude": p.log,
            "latitude": p.lat,
            "customerId": p.c
        };
    } 
    ishave = false;
    $.postSync("1098", json, function (flag, msg, datalist) {
        if (flag === 1) {
            if (pageIdx == 1) {
                $(".conpon-list-collection").bindList(datalist.list, "tmp-list");
            } else {
                $(".conpon-list-collection").bindListAppend(datalist.list, "tmp-list");
            }
            if (datalist.totalRecord == 0) { 
                $("#nodata").show();
            } else {
                $("#nodata").hide();
            }
            pageIdx++;
            totalpages = datalist.totalPage;
        } else {
            layer.msg(msg);
        }
        ishave = true;
    });
}

function getMoreCoupons() {
    iscanuse = 0;
    pageIdx = 1;
    $("#inner").show();
    $(".shop-bottom").hide();
    $(".conpon-list").hide();
    $(".conpon-list-collection").show();
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
                loadList(pageIdx);
        }
    });
    loadList();
}


var pageIdx = 1;
var totalpages = 1;
var iscanuse = 1;
var ishave = true;
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
//首页定位头部


//领取优惠券
function couponclick(f, t) {
    var p = new Params();
    var cid = p.c;
    if (cid == 0) {
        //绑定客户手机号
        $("#login_div").show();
    } else {
        //判断点击事件
        switch (f) {
            case 1:
                receive(t);
                break;
            case 2:
                collection(t);
                break;
            case 3:
                receiveforself(t);
                break;
            default:
        }
    }
}

function maskhide() {
    $("#login_div").hide();
}
//领取优惠券
function receive(t) {
    var p = new Params();
    var id = $(t).data("id");
    var couponmoney = $(t).data("couponmoney");
    var totalAmounct = $("#hidtotalAmounct").val();
    var useshopid = $(t).data("useshopid");
    var cid = p.c;
    $.postSync("1099", { customerId: cid, shopId: useshopid, useShopId: useshopid, couponApplyId: id, orderId: p.o }, function (f, m, d) {
        if (f == 1) {
            if (d == 1) {
                $("#hidtotalAmounct").val(parseInt(totalAmounct) - parseInt(couponmoney));
                $("#couponlist_title").html("本次消费可领取" + (parseInt(totalAmounct) - parseInt(couponmoney)) + "元优惠券");
                $(t).css("background-color", "#27A000").text("已领取");
                $(t).removeAttr('onclick');
                layer.msg("券领取成功！");
            } else if (d == 2) {
                layer.msg("券已被抢完！");
            } else if (d == 3) {
                layer.msg("券可领取张数达到");
            }
        } else {
            layer.msg(m);
        }
    });
}
//自己挑选界面中的点击领取优惠券
function receiveforself(t) {
    var p = new Params();
    var id = $(t).data("id");
    var couponmoney = $(t).data("couponmoney");
    var totalAmounct = $("#hidtotalAmounct").val();
    var useshopid = $(t).data("useshopid"); 
    var couponnumber = $(t).data("couponnumber");
    var couponreceivenumber = $(t).data("couponreceivenumber");
    var maxgetnumber = $(t).data("maxgetnumber");
    var customerreceivenumber = $(t).data("customerreceivenumber"); 
    var cid = p.c;
    $.postSync("1099", { customerId: cid, shopId: useshopid, useShopId: useshopid, couponApplyId: id, orderId: p.o }, function (f, m, d) {
        if (f == 1) {
            if (d == 1) {
                $("#hidtotalAmounct").val(parseInt(totalAmounct) - parseInt(couponmoney));
                $("#couponlist_title").html("本次消费可领取" + (parseInt(totalAmounct) - parseInt(couponmoney)) + "元优惠券");
                if (parseInt(couponreceivenumber + 1) >= parseInt(couponnumber)) {
                    $(t).css("background-color", "#6D6D6D").text("已抢完");
                    $(t).removeAttr('onclick');
                }
                if (parseInt(customerreceivenumber + 1) >= parseInt(maxgetnumber)) {
                    $(t).css("background-color", "#27A000").text("已领取");
                    $(t).removeAttr('onclick');
                }
                //更新优惠券显示状态
                 totalAmounct = $("#hidtotalAmounct").val();
                $(".conpon-list-collection .canuse").each(function () {
                    var couponmoney = $(this).data("couponmoney");
                    var collection = $(this).data("collection");
                    if (parseInt(couponmoney) > totalAmounct) {
                        if (collection) {
                            $(this).css("background-color", "#6D6D6D").text("已收藏");
                            $(this).removeAttr('onclick');
                        } else {
                            $(this).css("background-color", "#cc3333").text("收藏");
                            $(this).removeAttr('onclick');
                            $(this).bind("click", function() {
                                collection(this);
                            });
                        }
                    }
                });
                layer.msg("券领取成功！");
            } else if (d == 2) {
                layer.msg("券已被抢完！");
                $(t).css("background-color", "#6D6D6D").text("已抢完");
                $(t).removeAttr('onclick');
            } else if (d == 3) {
                layer.msg("券可领取张数达到");
                $(t).css("background-color", "#27A000").text("已领取");
                $(t).removeAttr('onclick');
            }
            
            
        } else {
            layer.msg(m);
        }
    });
}



//收藏优惠券
function collection(t) {
    var p = new Params();
    var id = $(t).data("id");
    var cid = p.c;
    $.postJson("1041", { customerId: cid, objectId: id, objectType: 3 }, function (f, m, d) {
        if (f == 1) {
            layer.msg("收藏成功");
            $(t).css("background-color", "#6D6D6D").text("已收藏");
            $(t).removeAttr('onclick');
        } else {
            layer.msg(m);
        }
    });
} 
function getCode() {
    var phone = $("#txtPhoneCode").val();
    if (!$.trim(phone)) return layer.msg("请输入手机号码");
    if (!checkCellPhone($.trim(phone))) return layer.msg("请输入正确的手机号码");
    var time = 60;
    var t = setInterval(function () {
        time--;
        $("#getcode").html(time + "秒后获取");
        if (time == 0) {
            clearInterval(t);
            $("#getcode").html("获取验证码");
        }
    }, 1000);
    $.postJson("1035", { cellphone: phone, type: 4 }, function (f, m, d) {
        layer.msg(m);
    });
    return true;
}
function bindPhone() {
    //更新cookie
    var phone = $("#txtPhoneCode").val();
    var code = $("#txtCode").val();
    if (!$.trim(phone)) return layer.msg("请输入手机号码");
    if (!checkCellPhone($.trim(phone))) return layer.msg("请输入正确的手机号码");
    if (!$.trim(code)) return layer.msg("请输入验证码");
    var p = new Params();
    $.postJson("1083", { openid: p.openid, cellphone: phone, smsCode: code }, function (f, m, d) {
        if (f == 1) {
            //更新cookie
            
            setLoginInfo(d);
            layer.msg("绑定成功！");
            setTimeout(function () {
                $("#login_div").hide();
            }, 1000);
        } else {
            layer.msg(m);
        }
    });
    return true;
}
$(function () {
    loadCurCoupons();

});