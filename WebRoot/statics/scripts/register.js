
//获取短信验证码
var validCode = true;
function GetVerificationCode() {
    var m = $("#cellphone").val();
    if ($.trim(m) == "") {
        layer.msg("请输入手机号码！", {
            icon: 2,
            time: 2000
        });
        return;
    }
    if (!m.match(/^13[0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|17[0-9]{9}|18[0-9]{9}$/)) {
        layer.msg("手机号不正确！", {
            icon: 2,
            time: 2000
        });
        return;
    }
    GetSmsCode(m);
    var time = 60;
    var btn = $("#phonecode");
    if (validCode) {
        validCode = false;
        btn.prop("disabled", "disabled");
        var t = setInterval(function () {
            time--;
            btn.html(time + "秒后重新获取");
            if (time == 0) {
                clearInterval(t);
                btn.html("重新获取");
                validCode = true;
                btn.removeAttr("disabled");
            }
        }, 1000);
    }
}

function GetSmsCode(m) {
    $.postJson("1035", { cellphone: m, type:1 }, function (flag, msg, data) {
        if (flag == 1) {
            if (data) {
                layer.msg("已发送", {
                    icon: 1,
                    time: 2000
                });

            } else {
                layer.msg(msg, {
                    icon: 2,
                    time: 2000
                });
            }
        } else {
            layer.msg(msg, {
                icon: 2,
                time: 2000
            });
        }
    });
}

function URegister() {
    var m = $("#cellphone").val();
    if ($.trim(m) == "") {
        layer.alert("请输入手机号码！");
        return;
    }
    if (!m.match(/^13[0-9]{9}$|14[0-9]{9}|17[0-9]{9}|15[0-9]{9}$|18[0-9]{9}$/)) {
        alert("手机号不正确");
        return;
    }
    var c = $("#verificationcode").val();
    if ($.trim(c) == "") {
        layer.alert("请输入验证码！");
        return;
    }
    var d = $("#pwd").val();
    if ($.trim(d) == "") {
        layer.alert("请输入密码！");
        return;
    }
    var u = new UserInfo();
    var inviteCode = getCookie("inviteCode");
    if (inviteCode == null) {
        inviteCode = "";
    }
    $.postJson("1000", { customerId: 0, id: 0, inviteCode: inviteCode, loginName: m, password: d, shopId: u.sourceShopId, smsCode: c }, function (flag, msg, data) {
        if (flag == 1) {
            setCookie("UserInfo", $.jsonToString(data), "d100");
            setCookie("token", data.token, "d100");
            var url = decodeURIComponent(getQueryString("url", "0"));
            if (url == "0") {
                url = "mypage.html";
            }
            layer.msg('注册成功', {
                icon: 1,
                time: 2000
            }, function () {
                location.href = url;
            });

        } else
            layer.msg(msg, {
                icon: 2,
                time: 2000
            });
    });
}