

//获取请求头信息
function GetRequest() {
    var url = location.search;
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        var strs = str.split("&");
        for (var i = 0; i < strs.length; i++) {
            theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
        }
    }
    return theRequest;
}
///获取url参数
function getQueryString(name, defValue) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return decodeURI(r[2]);
    if (defValue != undefined)
        return defValue;
    return null;
}
//判断是否是微信
function is_weixn() {
    var ua = navigator.userAgent.toLowerCase();
    if (ua.match(/MicroMessenger/i) == "micromessenger") {
        return true;
    } else {
        return false;
    }
}

function showbg() {
    if (is_weixn()) {
        $("#mainBg").show();
        return false;
    }
}
function download() {
    var url = window.location.pathname.replace("/pages/", "");
    var sid = url.substring(0, url.indexOf('/'));
    var token = "";
    var timestamp = new Date().getTime();
    var d = {
        "source": "wap",
        "code": "1066",
        "imei": "",
        "token": token, //token,
        "timestamp": timestamp,
        "mak": "",
        "sourceShopId": sid,
        "loginShopId": sid,
        "data": JSON.stringify({ "shopId": sid })
    };
    $.ajax({
        url: "http://wap.51shunkai.com/dispatcher.htm?callback=?",
        type: "post",
        async: true,
        dataType: "json",
        jsonp: 'callback',
        data: d,
        success: function (rst, textStatus, errorThrown) {
            if (rst.success == 1) {
                var data = rst.data;
                $("#shopimg").attr("src", data.logo);
                $("#shopname").text(data.shopName); 
                 
            }
        },
        error: function (msg, textStatus, errorThrown) {
            layer.msg("请求出错，请检查网络" + JSON.stringify(msg));
        }
    });

    var res = GetRequest();
    var par = res['index'];
    if (is_weixn()) {
        if (par != 'gfan') {
            var ua = navigator.userAgent.toLowerCase();
            var contains = function (a, b) {
                if (a.indexOf(b) != -1) { return true; }
            };
            if (contains(ua, "android")) {
                $("#buttonBtnAndroid").show();
                $("#buttonBtnAndroid2").show();
                $("#buttonBtnIphone").hide();
                $("#buttonBtnIphone2").hide();
            } else if (contains(ua, "iphone")) {
                $("#buttonBtnAndroid").hide();
                $("#buttonBtnAndroid2").hide();
                $("#buttonBtnIphone").show();
                $("#buttonBtnIphone2").show();

            } else {
                $("#buttonBtnAndroid").show();
                $("#buttonBtnAndroid2").show();
                $("#buttonBtnIphone").hide();
                $("#buttonBtnIphone2").hide();
            }
        }
    } else {
        if (par != 'gfan') {
            var ua = navigator.userAgent.toLowerCase();
            var contains = function (a, b) {
                if (a.indexOf(b) != -1) { return true; }
            };
            if (contains(ua, "android")) {
                $("#buttonBtnAndroid").show();
                $("#buttonBtnAndroid2").show();
                $("#buttonBtnIphone").hide();

                $("#buttonBtnIphone2").hide();
            } else if (contains(ua, "iphone")) {
                $("#buttonBtnAndroid").hide();
                $("#buttonBtnAndroid2").hide();
                $("#buttonBtnIphone").show();

                $("#buttonBtnIphone2").hide();

            } else {
                $("#buttonBtnAndroid").show();
                $("#buttonBtnAndroid2").show();
                $("#buttonBtnIphone").hide();

                $("#buttonBtnIphone2").hide();
            }
        }
    }


}
$(function () {
    download();
});
