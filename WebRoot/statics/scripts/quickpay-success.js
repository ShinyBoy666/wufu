$(function () {
    bind();
    function bind() {
        setCookie("randomMoney", "", "s1");
        //分享赋值
        $("#wximgurl").val("http://wap.51shunkai.com/statics/img/image/logo.png");
        $("#wxhref").val("http://wap.51shunkai.com/pages/1/quickpay-description.html");

        if (is_weixn()) {
            $("#share").show();
        } else {
            $("#share").hide();
            $("#getConpon").css("width", "88%");
        }

        if (getQueryString("o", 0) !== 0) {
            $.postJson("1094", { rechargeId: getQueryString("o") }, function (f, m, d) {
                if (f === 1) {
                    var totalAmount = d.totalAmount;
                    $("#shopName").text(d.shopName);
                    $("#price").text(d.totalAmount);
                    $("#orderId").text(d.orderId);
                    $("#wxdescription").val("你的小伙伴" + d.nickname + "在舜凯云商使用了优惠买单，获得了" + d.totalAmount + "元的大优惠。他没有把你忘记，也给你送来惊喜啦，赶快去看看吧！");
                    setCookie("openId", d.openId, "d1");
                    $.postJson("1095", { openId: d.openId }, function (f, m, d) {
                        if (f === 1) {
                            $("#wxtitle").val("你的小伙伴" + d.nickname + "给你送惊喜啦");
                        } else {
                            layer.msg(m);
                        }
                    });
                    $.postJson("1091", { orderId: d.orderId, amount: d.totalAmount, customerId: getCookie("customerId",0) }, function (f, m, d) {
                        if (d.amountList.length <= 0) {
                            $("#price2").text("恭喜您买单成功，谢谢您的支持!");
                            $("#getConpon").hide();
                            $("#share").css({ width: "88%", margin: '0 6%'});
                        } else {
                            $("#price2").text("恭喜您获得价值" + totalAmount + "元的优惠券!");
                            $("#getConpon").show();
                        }
                    });
                } else {
                    layer.msg(m);
                }
            });
        } else {
            var shop = new ShopInfo();
            var orderId = getQueryString("orderid", 0);
            var totalAmount = getQueryString("totalAmount", 0);
            $("#shopName").text(shop.shopName);
            $("#price").text(totalAmount);
            $("#orderId").text(orderId);

            $.postJson("1095", { openId: getCookie("openId") }, function (f, m, d) {
                if (f === 1) {
                    $("#wxdescription").val("你的小伙伴" + d.nickname + "在舜凯云商使用了优惠买单，获得了" + totalAmount + "元的大优惠。他没有把你忘记，也给你送来惊喜啦，赶快去看看吧！");
                    $("#wxtitle").val("你的小伙伴" + d.nickname + "给你送惊喜啦");
                } else {
                    layer.msg(m);
                }
            });
            $.postJson("1091", { orderId: orderId, amount: totalAmount, customerId: getCookie("customerId",0) }, function (f, m, d) {
                if (d.amountList.length <= 0) {
                    $("#price2").text("恭喜您买单成功，谢谢您的支持!");
                    $("#getConpon").hide();
                    $("#share").css({ width: "88%", margin: '0 6%'});
                } else {
                    $("#price2").text("恭喜您获得价值" + totalAmount + "元的优惠券!");
                    $("#getConpon").show();
                }
            });
        }

    }

    $("#getConpon").click(function () {
        if ($.trim($("#getConpon").text()) == "去领优惠券")
            location.href = "quickpay-couponlist.html?o=" + $("#orderId").text();
    });
    $("#sharp").click(function () {
        layer.msg("对接中");
    });
});

function goshare() {
    $("#J-guide").show();
}
function closeshare() {
    $("#J-guide").hide();
}
function getConfigInfo() {
    var url = location.href.split('#')[0];
    url = encodeURIComponent(url);
    $.postSync("1076", { url: url }, function (flag, msg, data) {
        if (flag == 1) {
            var d = $.parseJSON(data);
            $("#hidtimestamp").val(d.Timestamp);
            $("#hidnoncestr").val(d.Noncestr);
            $("#hidsignature").val(d.Signature);

        }
    });
}

///=================分享========================================
var timestamp;
var nonceStr;
var signature;
var title;
var description;
var imgurl;
var locationurl;//location.href.split('#')[0];

getConfigInfo();
var t;
t = setInterval(function () {
    timestamp = $("#hidtimestamp").val();
    nonceStr = $("#hidnoncestr").val();
    signature = $("#hidsignature").val();
    title = $("#wxtitle").val();
    description = $("#wxdescription").val();
    imgurl = $("#wximgurl").val();
    locationurl = $("#wxhref").val();
    //title = "你的小伙伴张三给你送惊喜啦";
    //description ="你的小伙伴张三在舜凯云商使用了优惠买单，获得了30元的大优惠。他没有把你忘记，也给你送来惊喜啦，赶快去看看吧！";
    //imgurl ="http://wap.51shunkai.com/statics/img/image/banner.jpg";
    if (!(timestamp == "" || nonceStr == "" || signature == "" || title == "" || description == "" || imgurl == "")) {
        configwx();
        clearInterval(t);
    }
}, 500);

function configwx() {
    wx.config({
        debug: false,
        appId: 'wx7f398dabeaf2b088',
        timestamp: parseInt(timestamp),
        nonceStr: nonceStr,
        signature: signature,
        jsApiList: [
            'checkJsApi',
            'onMenuShareTimeline',
            'onMenuShareAppMessage',
            'onMenuShareQQ',
            'onMenuShareWeibo',
            'hideMenuItems',
            'showMenuItems',
            'hideAllNonBaseMenuItem',
            'showAllNonBaseMenuItem',
            'translateVoice',
            'startRecord',
            'stopRecord',
            'onRecordEnd',
            'playVoice',
            'pauseVoice',
            'stopVoice',
            'uploadVoice',
            'downloadVoice',
            'chooseImage',
            'previewImage',
            'uploadImage',
            'downloadImage',
            'getNetworkType',
            'openLocation',
            'getLocation',
            'hideOptionMenu',
            'showOptionMenu',
            'closeWindow',
            'scanQRCode',
            'chooseWXPay',
            'openProductSpecificView',
            'addCard',
            'chooseCard',
            'openCard'
        ]
    });


    wx.ready(function () {
        // config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，
        //config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，
        //则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，
        //则可以直接调用，不需要放在ready函数中。
        // 2. 分享接口
        // 2.1 监听“分享给朋友”，按钮点击、自定义分享内容及分享结果接口 
        wx.onMenuShareAppMessage({
            title: title,
            desc: description,
            link: locationurl,
            imgUrl: imgurl,
            trigger: function (res) {
                //   alert('用户点击发送给朋友');
            },
            success: function (res) {
                alert('已分享');
            },
            cancel: function (res) {
                alert('已取消');
            },
            fail: function (res) {
                //  alert(JSON.stringify(res));
            }
        });


        // 2.2 监听“分享到朋友圈”按钮点击、自定义分享内容及分享结果接口 
        wx.onMenuShareTimeline({
            title: title,
            desc: description,
            link: locationurl,
            imgUrl: imgurl,
            trigger: function (res) {
                //  alert('用户点击分享到朋友圈');
            },
            success: function (res) {
                alert('已分享');
            },
            cancel: function (res) {
                alert('已取消');
            },
            fail: function (res) {
                //   alert(JSON.stringify(res));
            }
        });


        // 2.3 监听“分享到QQ”按钮点击、自定义分享内容及分享结果接口 
        wx.onMenuShareQQ({
            title: title,
            desc: description,
            link: locationurl,
            imgUrl: imgurl,
            trigger: function (res) {
                //  alert('用户点击分享到QQ');
            },
            complete: function (res) {
                //  alert(JSON.stringify(res));
            },
            success: function (res) {
                alert('已分享');
            },
            cancel: function (res) {
                alert('已取消');
            },
            fail: function (res) {
                // alert(JSON.stringify(res));
            }
        });


        // 2.4 监听“分享到微博”按钮点击、自定义分享内容及分享结果接口 
        wx.onMenuShareWeibo({
            title: title,
            desc: description,
            link: locationurl,
            imgUrl: imgurl,
            trigger: function (res) {
                // alert('用户点击分享到微博');
            },
            complete: function (res) {
                // alert(JSON.stringify(res));
            },
            success: function (res) {
                alert('已分享');
            },
            cancel: function (res) {
                alert('已取消');
            },
            fail: function (res) {
                //  alert(JSON.stringify(res));
            }
        });

    });
    wx.error(function (res) {
        //  alert(JSON.stringify(res));
        // config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。

    });
}

