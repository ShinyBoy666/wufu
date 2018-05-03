
function SetCashAccount() {
    var account = $("#txtaccount").val();
    if ($.trim(account) == "") {
        layer.alert("请输入支付宝账号！");
        return;
    }
    var name = $("#txtname").val();
    if ($.trim(name) == "") {
        layer.alert("请输入支付宝对应的真实姓名！");
        return;
    }
    $.postJson("1047", { customerId: 0, alipay: account, realname: name }, function (flag, msg, data) {
        if (flag === 1) {
            if (data) {
                layer.msg('设置成功', {
                    icon: 1,
                    time: 2000 
                }, function () {
                    location.href = "mycash.html";
                });
            }
        } else {
            layer.msg(msg, {
                icon: 1,
                time: 2000
            });
        }
    });
}