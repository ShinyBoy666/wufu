
function getQueryString(name, defValue) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return decodeURI(r[2]);
    if (defValue != undefined)
        return defValue;
    return null;
}
function get(name, defValue) {
    return getQueryString(name, defValue);
}

function toUtf8(str) {
    var out, i, len, c;
    out = "";
    len = str.length;
    for (i = 0; i < len; i++) {
        c = str.charCodeAt(i);
        if ((c >= 0x0001) && (c <= 0x007F)) {
            out += str.charAt(i);
        } else if (c > 0x07FF) {
            out += String.fromCharCode(0xE0 | ((c >> 12) & 0x0F));
            out += String.fromCharCode(0x80 | ((c >> 6) & 0x3F));
            out += String.fromCharCode(0x80 | ((c >> 0) & 0x3F));
        } else {
            out += String.fromCharCode(0xC0 | ((c >> 6) & 0x1F));
            out += String.fromCharCode(0x80 | ((c >> 0) & 0x3F));
        }
    }
    return out;
}

function getsec(str) {
    var str1 = str.substring(1, str.length) * 1;
    var str2 = str.substring(0, 1);
    if (str2 == "s") {
        return str1 * 1000;
    }
    else if (str2 == "h") {
        return str1 * 60 * 60 * 1000;
    }
    else if (str2 == "d") {
        return str1 * 24 * 60 * 60 * 1000;
    }
};

function htmlencode(s) {
    var div = document.createElement('div');
    div.appendChild(document.createTextNode(s));
    return div.innerHTML;
}
function htmldecode(s) {
    var div = document.createElement('div');
    div.innerHTML = s;
    return div.innerText || div.textContent;
}

//设置cookie
function setCookie(name, value, time) {
    delCookie(name);
    var strsec = getsec(time);
    var exp = new Date();
    exp.setTime(exp.getTime() + strsec * 1);
    document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString() + ";path=/";

}

//读取cookies
function getCookie(name) {
    try {
        var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
        if (arr = document.cookie.match(reg))
            return unescape(arr[2]);
        else
            return null;
    } catch (e) {
        return "";
    }
}

//删除cookies
function delCookie(name) {
    //var date = new Date();
    //date.setTime(date.getTime() - 10000);
    //document.cookie = name + "=''; expires=" + date.toGMTString();
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null)
        document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString() + ";path=/";;
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

//验证手机号码
function checkCellPhone(cellPhone) {
    var regPartton = /^1[3|4|5|7|8]\d{9}$/;
    if (!cellPhone || cellPhone == 'undefined') {
        layer.msg("请输入手机号码！");
        return false;
    } else if (!regPartton.test(cellPhone)) {
        layer.msg("手机号不正确！");
        return false;
    } else {
        return true;
    }
}

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

function formatDate(timestamp, time) {
    var now = new Date(timestamp);
    var year = now.getFullYear();
    var month = now.getMonth() + 1;
    var date = now.getDate();
    if (month < 10) {
        month = "0" + month;
    }
    if (date < 10) {
        date = "0" + date;
    }
    if (time) {
        var hour = now.getHours();
        var minute = now.getMinutes();
        var second = now.getSeconds();
        if (hour < 10) {
            hour = "0" + hour;
        }
        if (minute < 10) {
            minute = "0" + minute;
        }
        if (second < 10) {
            second = "0" + second;
        }

        if (time === 2) {
            return hour + ":" + minute;
        } else {
            return year + "-" + month + "-" + date + "   " + hour + ":" + minute + ":" + second;
        }
    }
    return year + "." + month + "." + date;
}
//保存登入信息
function setLoginInfo(d) {
    var exp = new Date();
    exp.setTime(exp.getTime());
    document.cookie = 'customerId=0;expires=' + exp.toGMTString() + ";path=/";
    document.cookie = 'UserInfo=0;expires=' + exp.toGMTString() + ";path=/";
    document.cookie = 'token=0;expires=' + exp.toGMTString() + ";path=/";

    setCookie("customerId", d.id, "d100");
    setCookie("UserInfo", $.jsonToString(d), "d100");
    setCookie("token", d.token, "d100");
}

//当前登录的详细信息
function UserInfo(mastLogin) {
    var url = window.location.pathname.replace("/pages/", "");
    var loginShopId = url.substring(0, url.indexOf('/'));
    var userinfo = eval('(' + getCookie("UserInfo") + ')');
    var sourceShopId = get("sid", loginShopId) || loginShopId;
    this.serverPhone = getCookie("serverPhone") || "";

    this.isLogin = userinfo != null && userinfo != undefined && userinfo.token != undefined && userinfo.token.length > 0;
    if (this.isLogin) {
        this.id = userinfo.id;
        this.token = userinfo.token;
        this.sourceShopId = sourceShopId;
        this.loginShopId = loginShopId;
        this.recommendCode = userinfo.recommendCode;
        this.cellphone = userinfo.cellphone;
        this.customerCategory = userinfo.customerCategory;
        this.headSculpture = userinfo.headSculpture;
        this.sex = userinfo.sex;
        this.cashAmount = userinfo.cashAmount;
        this.nickname = userinfo.nickname;
        this.recommendCustomerId = userinfo.recommendCustomerId;
        this.openId = userinfo.openId;
    } else {
        if (mastLogin === 1) {
            var floderpath = window.location.pathname.indexOf("/find/");
            if (floderpath >= 0) {
                location.href = "../login.html?url=" + encodeURIComponent(window.location.href);
            } else {
                location.href = "login.html?url=" + encodeURIComponent(window.location.href);
            }
        }
        this.id = 0;
        this.token = "";
        this.sourceShopId = sourceShopId;
        this.loginShopId = loginShopId;
        this.recommendCode = "";
        this.cellphone = "";
        this.customerCategory = 0;
        this.headSculpture = "";
        this.sex = 0;
        this.cashAmount = 0;
        this.nickname = "匿名";
        this.recommendCustomerId = 0;
        this.openId = "";
    }
}

function ShopInfo(fun) {
    var url = window.location.pathname.replace("/pages/", "");
    var id = url.substring(0, url.indexOf('/'));
    var shop = {};
    shop.id = getCookie("shopId");
    if (shop.id != id) {
        $.postJson("1066", { shopId: id }, function (f, m, d) {
            if (f === 1) {
                if (d) {
                    shop.id = d.id;
                    shop.shopName = d.shopName;
                    shop.shopLogo = d.logo;
                    shop.shopImage = d.shopImage;
                    shop.bossImage = d.bossImage;
                    shop.shopDesc = d.shopDescription;
                    shop.latitude = d.latitude;
                    shop.longitude = d.longitude;
                    shop.wifiName = d.wifiName;
                    shop.wifiPassword = d.wifiPassword;
                    setCookie("shopName", shop.shopName, "d1");
                    setCookie("shopLogo", shop.shopLogo, "d1");
                    setCookie("shopId", shop.id, "d1");
                    setCookie("shopImage", shop.shopImage, "d1");
                    setCookie("bossImage", shop.bossImage, "d1");
                    setCookie("shopDesc", shop.shopDesc, "d1");
                    setCookie("latitude", shop.latitude, "d1");
                    setCookie("longitude", shop.longitude, "d1");
                    setCookie("wifiName", shop.wifiName, "d1");
                    setCookie("wifiPassword", shop.wifiPassword, "d1");
                    if (fun) fun(shop);
                } else {
                    layer.msg("数据有误");
                }
            } else {
                layer.msg(m);
            }
        });
    } else {
        shop.openId = getCookie("openId");
        shop.shopName = getCookie("shopName");
        shop.shopLogo = getCookie("shopLogo");
        shop.shopImage = getCookie("shopImage");
        shop.bossImage = getCookie("bossImage");
        shop.shopDesc = getCookie("shopDesc");
        shop.latitude = getCookie("latitude");
        shop.longitude = getCookie("longitude");
        shop.wifiName = getCookie("wifiName");
        shop.wifiPassword = getCookie("wifiPassword");
        if (fun) fun(shop);
    }
    return shop;
}

//手机浏览器访问，禁止电脑访问   

//平台、设备和操作系统  
var system = {
    win: false,
    mac: false,
    xll: false
};
////检测平台  
//var p = navigator.platform;
//var u = navigator.userAgent;
//system.win = p.indexOf("Win") == 0;
//system.mac = p.indexOf("Mac") == 0;
//system.x11 = (p == "X11") || (p.indexOf("Linux") == 0);
////跳转语句  

//if (u.indexOf("Windows Phone") > -1) {
////判断是不是window phone手机
//} else {
//    if (system.win || system.mac || system.xll) { //转向电脑端
//        window.location.href = "http://www.baidu.com";
//    } else {
//        window.location.href = "http://www.jd.com";  //转向手机端
//    }
//}
//---------------------------------

//回到顶部
//当滚动条的位置处于距顶部100像素以下时，跳转链接出现，否则消失
$(function () {
    var u = new UserInfo(0);
    if (u.loginShopId == undefined || u.loginShopId == 0) {
        layer.msg("页面参数错误，店铺ID为空");
    }

    $(window).scroll(function () {
        if ($(window).scrollTop() > 400) {
            $("#back-to-top").fadeIn(500);
        }
        else {
            $("#back-to-top").fadeOut(500);
        }
    });
    //当点击跳转链接后，回到页面顶部位置
    $("#back-to-top").click(function () {
        $('body,html').animate({ scrollTop: 0 }, 1000);
        return false;
    });

    setInterval(function () {
        $("body").children().not(".jph,*[class^='layui-']").remove();
    }, 300);

    var first = true;
    //orderTip();

    //function orderTip() {
    //    if ($("#orderTip").length > 0) {
    //        if (!first) {
    //            $("#orderTip").text((Math.random() * 9 + 1).toFixed(0) + "秒前有一个小伙伴使用了优惠买单，优惠了"
    //                + (Math.random() * 1.9 + 0.1).toFixed(2) + "元，您也快来加入吧！");
    //            $("#orderTip").slideDown(600, function () { setTimeout(function () { $("#orderTip").slideUp() }, 4000) });
    //        }
    //        first = false;
    //        setTimeout(orderTip, Math.random() * 5000 + 9000);
    //    }
    //}

    var screenWidth = $(window).width();
    if (screenWidth < 375) {
        loadCss("/statics/style/screen/screen0-374.css");
        //iphone5以及以下屏幕
    } else if (screenWidth >= 375 && screenWidth < 414) {
        //iphone6以下
        loadCss("/statics/style/screen/screen375-413.css");
    } else if (screenWidth >= 414 && screenWidth < 441) {
        //iphone6 plus以下
        loadCss("/statics/style/screen/screen414-440.css");
    } else {
        loadCss("/statics/style/screen/screen441-max.css");
    }

    function loadCss(path) {
        if (!path || path.length === 0) {
            throw new Error('argument "path" is required !');
        }
        var head = document.getElementsByTagName('head')[0];
        var link = document.createElement('link');
        link.href = path;
        link.rel = 'stylesheet';
        link.type = 'text/css';
        head.appendChild(link);
    }


});
function isNull(obj) {
    return obj ? obj : "";
}