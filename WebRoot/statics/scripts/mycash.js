$(document).ready(function () {
    loadInfo();
});
var user = new UserInfo();
//获取支付宝信息
function loadInfo() {
    $.postJson("1051", { customerId: 0, id: 0, shopId: user.loginShopId }, function (flag, msg, data) {
        if (flag === 1) {
            if (data != undefined) {
                $("#divalipay").html(data.alipay);
                $("#divrealname").html(data.realname);
                $("#hidalipay").val(data.alipay);
                $("#hidrealname").val(data.realname);
                $("#divcash").html("切换提现账户？马上设置");
            }
        } else {
            layer.msg(msg, {
                icon: 2,
                time: 2000
            });
        }
    });
}

function withdrawcash() {

    var alipay = $("#hidalipay").val();
    var realname = $("#hidrealname").val();
    var amount = $("#txtamount").val();
    if ($.trim(alipay) == "") {
        layer.msg("请先设置提现账号！", {
            icon: 2,
            time: 2000
        });
        return;
    }
    if ($.trim(realname) == "") {
        layer.msg("请先设置提现账号！", {
            icon: 2,
            time: 2000
        });
        return;
    }
    if ($.trim(amount) == "") {
        layer.msg("请填写提现金额！", {
            icon: 2,
            time: 2000
        });
        return;
    }
    if (isNaN(amount)) {
        layer.msg("请填写有效金额！", {
            icon: 2,
            time: 2000
        });
        return;
    }
    $.postJson("1030", { customerId: 0, enchashmentType: 1, amount: amount }, function (flag, msg, data) {
        if (flag === 1) {
            if (data) {
                layer.msg("提现成功，请等待后台审核！", {
                    icon: 1,
                    time: 2000
                }, function () {
                    location.href = "mypurse.html";
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