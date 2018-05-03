$(document).ready(function () {
    loadInfo();
});
var user = new UserInfo();
//获取钱包信息
function loadInfo() {
    $.postJson("1028", { customerId: 0, id: 0, shopId: user.loginShopId }, function (flag, msg, data) {
        if (flag === 1) {
            $("#spancashAmount").html(data.cashAmount + "元");
            if (data.cashing > 0)
                $("#pcashing").html("提现" + data.cashing + "元");
            else $("#divcash").hide();
            // $("#strongincome").html("+" + data.income);
            //$("#strongmonthIncome").html("+" + data.monthIncome);
            if (!data.cusotmerWithdrawals) {
                $("#wash").unbind("click");
                $("#wash").bind("click", function () { location.href = "vipupgrade.html?t=1"; });
            } else {
                $("#wash").unbind("click");
                $("#wash").bind("click", function () { location.href = "mycash.html"; });
            }
        } else {
            layer.msg(msg, {
                icon: 2,
                time: 2000
            });
        }
    });
}
