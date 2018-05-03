var pageIdx = 1;
var totalpages = 1;
var ishave = true;
var s;
function loadInfo(p) {
    ishave = false;
    pageIdx = p;
    $.postSync("1038", { limit: 20, currentPage: p, type: getQueryString("t",1), shopName: $("#txtKeyword").val() }, function (f, m, d) {
        if (f == 1) {
            totalpages = d.totalPage;
            if (pageIdx == 1) {
                if (!d.list || d.list.length == 0) {
                    $("#nodata").show();
                } else {
                    $("#nodata").hide();
                }
                $("#randomList").bindList(d.list, "tmp-randomList");
            } else {
                $("#randomList").bindListAppend(d.list, "tmp-randomList");
            }
            pageIdx++;
        } else {
            layer.msg(m);
        }
        ishave = true;
    });
}


//首页定位头部
$(function () {
    //获取要定位元素距离浏览器顶部的距离
    //滚动条事件
    $(window).scroll(function () {
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
                loadInfo(pageIdx);
        }
    });
});

function goshopdetail(id) {
    var p = new Params();
    if (p.openid != "" && p.openid != undefined && p.openid != null) {
        location.href = "/pages/" + id + "/quickpay.html?o=" + p.openid;
    }
}

function Params() { 
    this.openid = getCookie("openId");
    this.oid = getQueryString("openid", "");
}
$(function () {
    var p = new Params();
    if (p.oid != "") {
        //更新cookie记录openid
        setCookie("openId", p.oid, "100d");
    }
    if (p.openid == "" || p.openid == undefined||p.openid==null) {
        var rurl = encodeURIComponent("http://pay.51shunkai.com/WxPay/OAuthWxOpenId");
        location.href = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx7f398dabeaf2b088&redirect_uri=" + rurl + "&response_type=code&scope=snsapi_base&state=003#wechat_redirect";
        return false;
    }
    loadInfo(1);
    return true;
});

function move(t) {
    location.href = 'quickpay-search.html?t=' + t;
}