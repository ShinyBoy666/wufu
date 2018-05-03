
$(function () {
    //$(".keyboard-key > li > span").css("font-size",window.innerWidth>1080?"18px":"14px");
    var openId = getQueryString("o") ? getQueryString("o") : getCookie("openId");
    if (openId == "" || openId == undefined) {
        var userinfo = new UserInfo();
        var rurl = encodeURIComponent("http://pay.51shunkai.com/WxPay/OAuthWxOpenIdByParams");
        location.href = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx7f398dabeaf2b088&redirect_uri=" + rurl + "&response_type=code&scope=snsapi_base&state=001-" + userinfo.sourceShopId + "#wechat_redirect";
        return false;
    }

    setCookie("openId", openId, "d100");

    $("#quickpay").height($(document).height());
    $(".keyboard-key button").bind("touchstart", function () {
        var key = $(this).text();
        var text = $("#price").text();
        if (this.id == "back") {
            if (text.length > 0)
                text = text.substring(0, text.length - 1);
        } else {
            var arr = text.split(".");
            if (key == "0" && parseInt(arr[0]) === 0 && arr.length == 1) return;
            if (arr.length === 2) {
                if (arr[1].length >= 2 || key == ".") return;
                else {
                    text = text + key;
                }
            } else if (text.length <= 7) {
                text = text + key;
            }
        }
        if (text.indexOf("0") === 0) text = text.substring(1);
        if (text.indexOf(".") === 0) text = "0" + text;
        if (text.length === 0) text = "0";
        $("#price").text(text);
    });
    $("#clearPrice").bind("touchstart", function () {
        $("#price").text("0");
    });
    $("#submit").bind("touchstart", function () {
        var money = parseFloat($("#price").text());
        if (money > 0) {
            location.href = "quickpay-orderconfim.html?m=" + money;
        }
    });
    bind();
    function bind() {
        ShopInfo(function (shop) {
            if (shop.id > 0) {
                $("#shopName").text(shop.shopName);
                $("#shopImage").attr("src", shop.bossImage);
                if (shop.wifiPassword) {
                    $("#shopDesc").show();
                    $("#shopDesc .wifi").text("用户名:" + shop.wifiName + "  密码:" + shop.wifiPassword);
                }
                wxshare("优惠买单", "我正在" + shop.shopName + "店铺，买单享折扣优惠，最高立减20元，还等什么，快来体验吧。",
                    shop.bossImage, "http://wap.51shunkai.com/pages/1/quickpay.html");
            } else {
                layer.msg("店铺信息异常");
            }
        });
    }
});