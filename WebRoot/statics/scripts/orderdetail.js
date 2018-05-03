var u = new UserInfo(1);
$(function () {
    bind();
});

//绑定初始化
function bind() {
    $.postJson("1019", { customerId: u.id, childOrderId: get("cid"), parentOrderId: get("pid") }, function (f, m, d) {
        $("#list").bindList(d.productList, "tmp-list");
        $("#address").bindModel(d, "tmp-address");
        $("#amount").bindModel(d, "tmp-amount");
        $("#payAmount").bindModel(d, "tmp-payAmount");
        $("#orderId").text(d.childOrderId);
        $(".shopName").text(d.shopName);
        $("#shopLogo").attr("src", d.shopLogo);
        $("#btnState").text(d.stateValue);
        $("#serverPhone").attr("href", "tel:" + u.serverPhone);

        if (d.state == 2) $("#btnReceipt").show();
        if (d.state == 1) $("#btnGoPay").show();
    });
}
function more(dom) {
    $(dom).remove();
    $("#list").removeClass("product-number3");
}

//确认收货
function receipt(dom) {
    $(dom).remove();
    $.postJson("1020", { customerId: u.id, childOrderId: get("cid"), parentOrderId: get("pid"), state: 1 }, function (f, m, d) {
        if (f) {
            layer.msg(m);
        }
    });
}
function goPay(dom) {
    $(dom).remove();
    location.href = "repay.html?cid=" + get("cid") + "&pid=" + get("pid");
}