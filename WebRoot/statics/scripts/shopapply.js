//选择是否有微信公众号
function gzhSelect(dom) {
    $(".radio-list .radio").removeClass("checked");
    $(dom).addClass("checked");
    if ($(".radio-list .yes .radio").hasClass("checked")) {
        $(".wx-yes").show();
    } else {
        $(".wx-yes").hide();
    }
}

//选择系统版本
function versionSelect(dom,amount) {
    $(".version .radio").removeClass("checked");
    $(dom).find(".radio").addClass("checked");
    $(".amount").html(amount);
}

//提交
function apply() {
    var json = $("form").serializeJson();
    if ($.trim(json.enterpriseName) == "") return layer.msg("请输入企业名称");
    if ($.trim(json.linkman) == "") return layer.msg("请输入联系人名称");
    if ($.trim(json.telephone) == "") return layer.msg("请输入联系人电话");
    if ($.trim(json.email) == "") return layer.msg("请输入邮箱地址");

    if (!(/^\d[\d-]{6,16}\d$/).test(json.telephone)) return layer.msg("请输入正确的联系人电话");
    if (!(/^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/).test(json.email))
        return layer.msg("请输入正确的邮箱地址");
    if ($(".radio-list .yes .radio").hasClass("checked")) {
        if ($.trim(json.gzhAccount) == "") return layer.msg("请输入微信公众号账号");
        if ($.trim(json.gzhPassword) == "") return layer.msg("请输入微信公众号密码");
    }
    if ($(".version .radio.checked").length === 0) {
        return layer.msg("请选择需要购买的版本");
    } else {
        json.appLevel = $(".version .radio.checked").data("level");
    }

    json.flashActivity = 0;
    json.groupActivity = 0;
    json.haggleActivity = 0;
    json.onlinePayment = $.trim($(".amount").text());
    json.id = 0;
    $.postJson("1078", json, function(f, m, d) {
        if (f == 1) {
            layer.alert('提交成功，工作人员会在3个工作\r\n<br/>日内与您联系。', function () {
                location.href = "homepage.html";
            });
        } else {
            layer.msg(m);
        }
    });
}
