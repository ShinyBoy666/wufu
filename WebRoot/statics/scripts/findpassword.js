//发送验证码
function getCode(dom) {
    var a = $(dom).find("a");
    if (a.text() == "获取验证码") {
        var d = $("#form").serializeJson();
        if (!$.trim(d.txtPhoneNumber)) return layer.msg("请输入手机号码");
        if (!checkCellPhone($.trim(d.txtPhoneNumber))) return layer.msg("请输入正确的手机号码");


        var time = 60;
        var t = setInterval(function () {
            time--;
            a.html(time + "秒后获取");
            if (time == 0) {
                clearInterval(t);
                a.html("获取验证码");
            }
        }, 1000);


        var u = new UserInfo();
        $.postJson("1035", { cellphone: d.txtPhoneNumber,type:3 }, function (f, m, d) {
            layer.msg(m);
        },false);
    }
}

//找回密码
function findPassword() {
    var d = $("#form").serializeJson();
    if (!$.trim(d.txtPhoneNumber)) return layer.msg("请输入手机号码");
    if (!checkCellPhone($.trim(d.txtPhoneNumber))) return layer.msg("请输入正确的手机号码");
    if (!$.trim(d.txtCode)) return layer.msg("请输入验证码");
    if (!$.trim(d.txtPassword)) return layer.msg("请输入密码");


    $.postJson("1048", { cellphone: d.txtPhoneNumber, smsCode: d.txtCode, newPassword: d.txtPassword }, function (f, m, d) {
        if (f == 1) {
            setCookie("UserInfo", $.jsonToString(d), "d100");
            setTimeout(function() { location.href = "homepage.html" }, 1000);
        }
        layer.msg(m);
    });
}

function goback() {
    if (get("url", "").length > 1) {
        location.href = "login.html?url=" + get("url");
    } else {
        location.href = "login.html";
    }
}