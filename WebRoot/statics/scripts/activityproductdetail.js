var activityProductId = getQueryString("id");
var u = new UserInfo(false);
u.activityId = getQueryString("activityId");
u.productId = getQueryString("productId");
u.productPriceId = getQueryString("productPriceId");
u.flag = getQueryString("flag");

var myswiper;
var dt;
var interval;

$(function () {
    bind();
});
//绑定数据
function bind() {
    $.postJson("1069", { customerId: u.id, activityId: u.activityId, activityType: 1, productId: u.productId, productPriceId: u.productPriceId }, function (f, m, d) {
        if (f === 1) {
            $("#imgs").bindList(d.imageUrlList, "tmp-imgs");
            $("#price-detail").bindSyncModel(d, "tmp-price-detail");
            $("#product-detail").bindSyncModel(d, "tmp-product-detail");
            $("#proContent").html(d.productDetail);
            var max = (d.maxBuy === 0 || d.maxBuy > d.quantity) ? d.quantity : d.maxBuy;
            $("#txtNum").data("max", max);

            $("#activityDetail").html(d.activityDetail);

            //活动状态：1=为开始，2=进行中，3=已结束，4=已经购买一次，不能再次购买
            if (d.activityState == 1) {
                $(".tobuy").text("暂未开始").addClass("cantBuy");
            } else if (d.activityState == 2) {
                $(".tobuy").text("立即抢购");
            } else if (d.activityState == 3) {
                $(".tobuy").text("已经结束").addClass("cantBuy");;
            }
            if (d.alreadyBuy) {
                $(".tobuy").text("已经购买").addClass("cantBuy");
            }
            if (d.quantity <= 0) {
                $(".tobuy").text("已抢完").addClass("cantBuy");
            }

            //轮播图lunbojs方法
            if (myswiper) {
                myswiper.destroy(false);
            }
            myswiper = new Swiper('.swiper-container', {
                pagination: '.pagination',
                paginationClickable: true,
                spaceBetween: 30,
                centeredSlides: true,
                autoplay: 4000,
                autoplayDisableOnInteraction: false
            });
            timedCount();
        } else {
            layer.msg(msg);
        }
    });
}

function tobuy(dom) {
    if ($(dom).text() === "立即抢购") {
        var ci = new CartItem(dom);
        location.href = "activityorderconfim.html?p=" + u.productId +
            "&n=" + ci.num + "&a=" + u.activityId + "&priceid=" + u.productPriceId +
            "&sku=" + encodeURIComponent($(".pro-sku").text());
        return true;
    }
}


//数量+1
function plus(dom) {
    var s = new CartItem(dom);
    if (s.num >= s.maxbuy) { layer.msg("购买量最多为 " + s.maxbuy + " 个"); return; }
    var newNum = s.num + 1;
    s.numInput.val(newNum);
}
//数量-1
function dec(dom) {
    var s = new CartItem(dom);
    if (s.num <= 1) { layer.msg("购买量至少为 1 个"); return; }
    var newNum = s.num - 1;
    s.numInput.val(newNum);
}
//获取商品
function CartItem(dom) {
    var p = $(dom).parents(".productdetail");
    this.numInput = $("#txtNum");
    this.num = parseInt(this.numInput.val());
    this.maxbuy = parseInt($("#txtNum").data("max"));
}


function timedCount() {
    clearInterval(interval);
    interval = setInterval("countDown()", 1000);
}
function countDown() {
    $(".timerDiv").each(function (i, o) {
        var maxtime,hours,minutes,seconds,msg,days;
        if ($(o).data("isbegin") == "1") {
            maxtime = parseInt($(o).data("time"));
            if (maxtime >= 0) {
                days = Math.floor(maxtime / 86400);
                if (days < 10) {
                    days = "0" + days;
                }
                hours = Math.floor((maxtime / 3600) % 24);
                minutes = Math.floor((maxtime / 60) % 60);
                seconds = Math.floor(maxtime % 60);
                msg = "距离开始";
                if (days > 0) msg += "<span class='timer'>" + days + "</span>天";
                msg += "<span class='timer'>" + hours + "</span>:<span class='timer'>" + minutes + "</span>:<span class='timer'>" + seconds + "</span>";
                $(o).html(msg);
                $(o).parent().show();
                --maxtime;
                $(o).data("time", maxtime);
            } else {
                location.href = location.href;
            }
        } else if ($(o).data("isbegin") == "2") {
            maxtime = parseInt($(o).data("time"));
            if (maxtime >= 0) {
                days = Math.floor(maxtime / 86400);
                if (days < 10) {
                    days = "0" + days;
                }
                hours = Math.floor((maxtime / 3600) % 24);
                minutes = Math.floor((maxtime / 60) % 60);
                seconds = Math.floor(maxtime % 60);
                msg = "距离结束";
                if (days > 0) msg += "<span class='timer'>" + days + "</span>天";
                msg += "<span class='timer'>" + hours + "</span>:<span class='timer'>" + minutes + "</span>:<span class='timer'>" + seconds + "</span>";
                $(o).html(msg);
                $(o).parent().show();
                --maxtime;
                $(o).data("time", maxtime);
            } else {
                location.href = location.href;
            }
        }
    });
}

function goback() {
    if (u.flag == "1") {
        location.href = "flashactivity.html?id=" + u.activityId;
    } else {
        location.href = "homepage.html";
    }
}