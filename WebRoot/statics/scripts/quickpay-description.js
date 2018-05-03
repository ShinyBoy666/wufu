function loadInfo() {
    $.postSync("1096", { openId: "" }, function (flag, msg, data) {
        if (flag === 1) {
            $("#orderlist").bindSyncModel(data, "tmp-model");
        } else {
            layer.msg(msg);
        }
    });
}

function showhide(m, t) {
    var v;
    switch (m) {
        case 1:
            v = $("#hidrandomList").val();
            if (v == 1) {
                $("#hidrandomList").val(0);
                $("#randomList").hide();
                $(t).removeClass("sub-icon").addClass("add-icon");
            } else {
                $("#hidrandomList").val(1);
                $("#randomList").show();
                $(t).addClass("sub-icon").removeClass("add-icon");
            }

            break;
        case 2:
            v = $("#hidfullreduceList").val();
            if (v == 1) {
                $("#hidfullreduceList").val(0);
                $("#fullreduceList").hide();
                $(t).removeClass("sub-icon").addClass("add-icon");
            } else {
                $("#hidfullreduceList").val(1);
                $("#fullreduceList").show();
                $(t).addClass("sub-icon").removeClass("add-icon");
            }
            break;
        case 3:
            v = $("#hidsaleList").val();
            if (v == 1) {
                $("#hidsaleList").val(0);
                $("#saleList").hide();
                $(t).removeClass("sub-icon").addClass("add-icon");
            } else {
                $("#hidsaleList").val(1);
                $("#saleList").show();
                $(t).addClass("sub-icon").removeClass("add-icon");
            }
            break;
        case 4:
            v = $("#hidcouponList").val();
            if (v == 1) {
                $("#hidcouponList").val(0);
                $("#couponList").hide();
                $(t).removeClass("sub-icon").addClass("add-icon");
            } else {
                $("#hidcouponList").val(1);
                $("#couponList").show();
                $(t).addClass("sub-icon").removeClass("add-icon");
            }
            break;
        default:
    }

}

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
        location.href = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx7f398dabeaf2b088&redirect_uri=" + rurl + "&response_type=code&scope=snsapi_base&state=002#wechat_redirect";
        return false;
    }
    loadInfo();
    return true;
});

function more(t) {
    location.href = 'quickpay-search.html?t=' + t;
}