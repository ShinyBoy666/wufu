//该js必须依赖于<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
function wxshare(title, description, imgurl, locationurl) {
    var url = location.href.split('#')[0];
    url = encodeURIComponent(url);
    //获取分析所需的验证信息
    $.postSync("1076", { url: url }, function (flag, msg, data) {
        if (flag === 1) {
            var d = $.parseJSON(data);
            var timestamp = d.Timestamp;
            var nonceStr = d.Noncestr;
            var signature = d.Signature;
            title = title;
            description = description;
            imgurl = imgurl;
            locationurl = locationurl;
            
            if (timestamp && nonceStr && signature && title && description && imgurl) {
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
        }
    });
}