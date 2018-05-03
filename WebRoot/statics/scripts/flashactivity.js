var u = new UserInfo(0);
var id = getQueryString("id");
var flag = 1;
var interval;
$(function () {
    bind();
});

function bind() {
    $.postJson("1075", { customerId: u.id, activityId: id, shopId: u.loginShopId, activityType: 1 }, function (f, m, d) {
        if (f === 1) {
            flag = d.activityState;
            $("#list").bindList(d.list, "tmp-list");
            $("#time").bindModel(d, "tmp-time");
            $("title").text(d.ActivityName);
            if (d.bannerList[0].imageUrl) {
                $("#activityImage").attr("src", d.bannerList[0].imageUrl);
                $("#activityImage").show();
            }
            timedCount();
        } else {
            layer.msg(m);
        }
    });
}

function detail(dom) {
    var activityId = $(dom).data("activityid");
    var productId = $(dom).data("productid");
    var productPriceId = $(dom).data("productpriceid");
    location.href = "activityproductdetail.html?flag=1&activityId=" + activityId + "&productId=" + productId + "&productPriceId=" + productPriceId;
}

function timedCount() {
    clearInterval(interval);
    interval = setInterval("countDown()", 1000);
}

function countDown() {
    $(".timerDiv").each(function (i, o) {
        var maxtime, hours, minutes, seconds, msg, days;
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

//原价购买
function noMore(dom) {
    var productId = $(dom).parents("product-item").data("productid");
    location.href = "productdetail.html?id=" + productId;
}

function goback() {
    location.href = "homepage.html";
}