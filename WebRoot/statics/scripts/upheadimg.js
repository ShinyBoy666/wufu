var istrue = true;
$(document).ready(function () {
    loadInfo();
});
//获取钱包信息
function loadInfo() {
    var user = new UserInfo();
    $.postJson("1003", { customerId: 0, token: user.token, shopId: user.loginShopId }, function (flag, msg, data) {
        if (flag === 1) {
            $("#spannickname").html(data.nickname);
            $("#spancellphone").html(data.cellphone);
            $("#txtnickname").val(data.nickname);
            if (data.sex == 0) {
                $("#men").unChoose();
                $("#women").unChoose();
                $("#spansex").html("未知");
            } else if (data.sex == 1) {
                $("#man").choose();
                $("#women").unChoose(); $("#spansex").html("男");
            }
            else {
                $("#women").choose();
                $("#men").unChoose(); $("#spansex").html("女");
            }

        } else {
            layer.msg(msg, {
                icon: 2,
                time: 2000
            });
        }
    });
}
function AjaxData(code, data) {
    var token = getCookie("token") || "";
    var url = window.location.pathname.replace("/pages/", "");
    var loginShopId = url.substring(0, url.indexOf('/'));
    var sourceShopId = get("sid", loginShopId) || loginShopId;
    var timestamp = new Date().getTime();

    return {
        "source": "wap",
        "code": code,
        "imei": "",
        "token": token, //token,
        "timestamp": timestamp,
        "mak": "",
        "sourceShopId": sourceShopId,
        "loginShopId": loginShopId,
        "data": $.jsonToString(data)
    };
}
function uploadhead() {
    if (istrue) {
        istrue = false;
    } else {
        return;
    }
    var base64Img1 = $("#img1").attr("ng-src");
    if (base64Img1 != "") {
        base64Img1 = $("#img1").attr("ng-src").split(",")[1];
    }
    // $("#btnupload").css("display", "none");

    base64Img1 = base64Img1 || "";
    $.ajax({
        type: "post",
        url: "/dispatcher.htm?callback=?",
        data: new AjaxData(1025, { customerId: 0, base64String: base64Img1, imgType: 0 }),
        async: false,
        success: function (data) {
            if (data.data != "") {
                layer.msg("上传成功！", {
                    icon: 1,
                    time: 2000
                }, function () { location.href = "mypage.html"; });
            } else {
                layer.msg("上传失败！", {
                    icon: 2,
                    time: 2000
                }); istrue = true;
            }
        },
        error: function (msg, textStatus, errorThrown) {
            if (errorThrown.code == 19)
                layer.msg("上传成功！", {
                    icon: 1,
                    time: 2000
                }, function () { location.href = "mypage.html"; });
            else {
                layer.msg("上传失败！", {
                    icon: 2,
                    time: 2000
                }); istrue = true;
            }
        }
    });





    //$.postJson("1025", { customerId: 0, base64String: base64Img1, imgType: 0 }, function (flag, msg, data) {
    //    if (flag === 1) {
    //        if (data) {
    //            layer.msg("上传成功！", {
    //                icon: 2,
    //                time: 2000
    //            });
    //            istrue = true;
    //          //  $("#btnupload").css("display", "block");
    //        } else {
    //            layer.msg(msg, {
    //                icon: 2,
    //                time: 2000
    //            });
    //        }
    //    } else {
    //        layer.msg(msg, {
    //            icon: 2,
    //            time: 2000
    //        });
    //    }
    //});
}

function shownickname() {
    layer.open({
        type: 1,
        title: false,
        closeBtn: 0,
        shadeClose: true,
        area: ['300px', '123px'], //宽高
        skin: 'layui-layer-rim',
        content: $("#divnickname")
    });
}
function showsex() {
    layer.open({
        type: 1,
        title: false,
        closeBtn: 0,
        shadeClose: true,
        area: ['300px', '190px'], //宽高
        skin: 'layui-layer-rim',
        content: $("#divsex")
    });
}

function updatenickname() {
    var nickname = $("#txtnickname").val();
    if ($.trim(nickname) == "") {
        layer.msg("请填写昵称", {
            icon: 2,
            time: 2000
        });
        return;
    }
    $.postJson("1026", { customerId: 0, nickname: nickname }, function (flag, msg, data) {
        if (flag === 1) {
            if (data) {
                layer.msg("修改成功！", {
                    icon: 1,
                    time: 2000
                }, function () { location.href = "mypage.html"; });
            }
        } else {
            layer.msg(msg, {
                icon: 2,
                time: 2000
            });
            layer.closeAll();
        }
    });
}

function updatesex() {
    var sex = 2;
    if ($("#man").hasClass("choose1")) {
        sex = 1;
    }
    $.postJson("1026", { customerId: 0, sex: sex }, function (flag, msg, data) {
        if (flag === 1) {
            if (data) {
                layer.msg("修改成功！", {
                    icon: 1,
                    time: 2000
                }, function () { location.href = "mypage.html"; });
            }
        } else {
            layer.msg(msg, {
                icon: 2,
                time: 2000
            });
            layer.closeAll();
        }
    });
}

function choosesex(f) {
    if (f == 1) {
        $("#man").choose();
        $("#women").unChoose();
    } else if (f == 2) {
        $("#man").unChoose();
        $("#woman").choose();
    }
}