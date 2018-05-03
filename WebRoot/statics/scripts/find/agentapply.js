
function levelSelect(dom) {
    $(".radio-list .checked").removeClass("checked");
    $(dom).addClass("checked");
    $(dom).children().addClass("checked");
    var idx = $(dom).index();
    if (idx == 0) {
        $(".desc").html("权益说明:拥有整套系统平台定价权与代理权一年,即合作伙伴可以按照自己对市场的了解与把控自由定价，但舜凯云商享有每套系统销售50%的分利");
    } else if (idx == 1) {
        $(".desc").html("权益说明:拥有整套系统平台定价权与代理权一年,即合作伙伴可以按照自己对市场的了解与把控自由定价，但舜凯云商享有每套系统销售20%的分利");
    } else if (idx == 2) {
        $(".desc").html("权益说明:拥有整套系统平台定价权与代理权一年,即合作伙伴可以按照自己对市场的了解与把控自由定价，舜凯云商不享有分利权。");
    }
}

function gotodetail() {
    var openid = getCookie("openId");
    if (openid != undefined && openid != "") {
        location.href = "/pages/1/quickpay.html?o=" + openid;
    } else {
        layer.msg("请在微信中打开!");
    }
}


//提交
function apply() {
    var json = $("form").serializeJson();
    if ($.trim(json.enterpriseName) == "") return layer.msg("请输入企业名称");
    if ($.trim(json.linkman) == "") return layer.msg("请输入联系人名称");
    if ($.trim(json.telephone) == "") return layer.msg("请输入联系人电话");
    if ($.trim(json.email) == "") return layer.msg("请输入邮箱地址");
    json.agentType = $(".block4-1.checked").index()+1;
    if (json.agentType <= 0) return layer.msg("亲选择代理商级别");
    $.postJson("1077", json, function (f, m, d) {
        if (f == 1) {
            layer.msg("申请成功");
            setTimeout(function () {
                location.href = "applysuccess.html";
            }, 1000);
        } else {
            layer.msg(m);
        }
    });
}