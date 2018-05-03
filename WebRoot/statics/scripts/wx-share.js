jQuery.wxShare = {
    init: function (title, desc, link, imgUrl) {
        if (isEmpty(title) || isEmpty(desc) || isEmpty(link) || isEmpty(imgUrl)) {
            alert('参数错误！！！');
        } else {
            $.ajax({
                url: "http://wx.51shunkai.com/wechat/JsSdkParam",
                type: "post",
                async: true,
                dataType: "json",
                data: { url: window.location.href },
                success: function (data) {
                    wx.config({
                        debug: false,
                        appId: data.AppId,
                        timestamp: data.Timestamp,
                        nonceStr: data.Noncestr,
                        signature: data.Signature,
                        jsApiList: [
                            'checkJsApi',
                            'onMenuShareTimeline',
                            'onMenuShareAppMessage'
                        ]
                    });
                    wx.ready(function () {
                        //公共方法
                        var shareData = {
                            title: title,
                            desc: desc,
                            link: link,
                            imgUrl: imgUrl,
                            success: function (res) {
                                //alert('已分享');
                            },
                            cancel: function (res) {
                            }
                        };
                        //分享给朋友接口
                        wx.onMenuShareAppMessage(shareData);
                        //分享到朋友圈接口
                        wx.onMenuShareTimeline(shareData);
                    });
                    //处理失败验证
                    wx.error(function (res) {
                    });
                },
                error: function () {
                    alert("请求错误！！！");
                }
            });
        }
    }
}

function isEmpty(v) {
    switch (typeof v) {
        case 'undefined':
            return true;
        case 'string':
            if (v.replace(/(^[ \t\n\r]*)|([ \t\n\r]*$)/g, '').length == 0) return true;
            break;
        case 'boolean':
            if (!v) return true;
            break;
        case 'number':
            if (0 === v || isNaN(v)) return true;
            break;
        case 'object':
            if (null === v || v.length === 0) return true;
            for (var i in v) {
                return false;
            }
            return true;
    }
    return false;
}