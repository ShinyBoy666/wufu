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
function versionSelect(dom, amount) {
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
    //if (!(/^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/).test(json.email))
    //    return layer.msg("请输入正确的邮箱地址");
    //if ($(".radio-list .yes .radio").hasClass("checked")) {
    //    if ($.trim(json.gzhAccount) == "") return layer.msg("请输入微信公众号账号");
    //    if ($.trim(json.gzhPassword) == "") return layer.msg("请输入微信公众号密码");
    //}
    //if ($(".version .radio.checked").length === 0) {
    //    return layer.msg("请选择需要购买的版本");
    //} else {
    //    json.appLevel = $(".version .radio.checked").data("level");
    //}
    if ($("#sex .checked").length == 0) return layer.msg("请选择性别");
    json.sex = $("#sex .checked").index() + 1;
    json.gzhAccount = "";
    json.gzhPassword = "";
    json.appLevel = 2;
    json.flashActivity = 0;
    json.groupActivity = 0;
    json.haggleActivity = 0;
    //json.onlinePayment = $.trim($(".amount").text());
    json.onlinePayment = 0;
    json.id = 0;
    if ($.trim($("#submit").val()) == "确认提交") {
        $("#submit").val("提交中");
        $.postJson("1078", json, function (f, m, d) {
            if (f == 1) {
                $("#submit").val("申请成功");
                layer.msg("申请成功,请耐心等待审核通知");
                setTimeout(function () {
                        location.href = 'quickpay-search.html?t=1';
                }, 1000);
            } else {
                layer.msg(m);
            }
        });
    }
}

function selectSex(dom) {
    $("#sex .checked").removeClass("checked");
    $(dom).addClass("checked");
}
