function toggleLogin(dom, id) {
    $("#CodeLogin,#AccountLogin").hide();
    $(".over-head a").css("color", "#999");
    $(dom).find("a").css("color", "#000033");
    $("#" + id).show();
}
//验证码登录
function codeLogin() {
    var d = $("#form").serializeJson();
    if (!$.trim(d.txtPhoneCode)) return layer.msg("请输入手机号码");
    if (!checkCellPhone($.trim(d.txtPhoneCode))) return layer.msg("请输入正确的手机号码");
    if (!$.trim(d.txtCode)) return layer.msg("请输入验证码");

    $.postJson("1004", { cellphone: d.txtPhoneCode, smsCode: d.txtCode }, function (f, m, d) {
        if (f == 1) {
            setLoginInfo(d);
            var url = decodeURIComponent(getQueryString("url", "0"));
            if (url == "0") {
                url = "mypage.html";
            }
            location.href = url;
        } else {
            layer.msg(m);
        }
    });
}


function accountLogin() {
    var d = $("#form").serializeJson();
    if (!$.trim(d.txtPhoneNumber)) return layer.msg("请输入手机号码");
    if (!checkCellPhone($.trim(d.txtPhoneNumber))) return layer.msg("请输入正确的手机号码");
    if (!$.trim(d.txtPassword)) return layer.msg("请输入密码");

    $.postJson("1001", { loginName: d.txtPhoneNumber, password: d.txtPassword }, function (f, m, d) {
        if (f == 1) {
            setLoginInfo(d);
            var url = decodeURIComponent(getQueryString("url", "0"));
            if (url == "0") {
                url = "mypage.html";
            }
            location.href = url;
        } else {
            layer.msg(m);
        }
    });
}
function getCode(dom,flag) {
	if(flag && flag == 1){
		var a = $(dom);
	}else{
		var a = $(dom).find("a");
	}
    if (a.text() == "获取验证码") {
        var d = $("#form").serializeJson();
        if (!$.trim(d.txtPhoneCode)) return layer.msg("请输入手机号码");
        if (!checkCellPhone($.trim(d.txtPhoneCode))) return layer.msg("请输入正确的手机号码");
        var u = new UserInfo();

        var time = 60;
        var t = setInterval(function () {
            time--;
            a.html(time + "秒后获取");
            if (time == 0) {
                clearInterval(t);
                a.html("获取验证码");
            }
        }, 1000);

        $.postJson("1035", { cellphone: d.txtPhoneCode, type: 2 }, function (f, m, d) {
            layer.msg(m);
        });
    }
}
function goback() {
    location = "homepage.html";
}
