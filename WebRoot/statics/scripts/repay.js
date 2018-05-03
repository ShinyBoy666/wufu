var u = new UserInfo(1);
var cashAmount = 0;

$(function () {
    bind();
});

//数据初始化
function bind() {
    $.postJson("1003", { token: u.token }, function (f, m, d) {
        if (f === 1) {
            $("#cashAmount").text(d.cashAmount);
            if (d.accountDeduct) {
                $("#accountDeduct").show();
                if (d.cashAmount <= 0) {
                    if (is_weixn()) {
                        $("#wxPay").choose();
                        $("#accoutPay").unChoose();
                    } else {
                        $("#wxPay").unChoose();
                        $("#accoutPay").choose();
                    }
                }
            }
            else {
                    if (is_weixn()) {
                        $("#wxPay").choose();
                        $("#accoutPay").unChoose();
                    } else {
                        $("#wxPay").unChoose();
                        $("#accoutPay").choose();
                    }
            }
            $.postJson("1019", {
                customerId: u.id,
                childOrderId: get("cid"),
                parentOrderId: get("pid")
            }, function (f, m, d) {
                if (f === 1) {
                    $("#totalAmount").text(d.totalAmount.toFixed(2));
                    $("#postage").text(d.postage.toFixed(2));
                    $("#couponeMoney").text(d.discountAmount.toFixed(2));
                    $("#alreadyPaid").text(d.alreadyPaid.toFixed(2));
                    $("#payAmount").val(d.payAmount.toFixed(2));
                    total();
                } else {
                    layer.msg(m);
                }
            });
        } else {
            layer.msg(m);
        }
    });
}

//选择支付方式f=1账户支付，f=2微信支付，f=3支付宝支付
function payType(f) {
    var t = new total();
    if (f == 1 && t.cashAmount > 0) {
        $("#accoutPay").toggleChoose();
    }
    else if (f == 2) {
        if (!is_weixn()) {
            layer.msg("微信支付目前仅支持在微信浏览器中使用");
            return;
        }
        if (t.cashAmount > t.payAmount) { $("#accoutPay").unChoose() }
        $("#wxPay").choose();
        $("#zfbPay").unChoose();
    }
    else if (f == 3) {
        if (t.cashAmount > t.payAmount) { $("#accoutPay").unChoose() }
        $("#zfbPay").choose();
        $("#wxPay").unChoose();
    }
    if ($("#accoutPay").hasClass("choose1")) {
        //余额充足
        if (t.cashAmount > t.payAmount) {
            $("#accoutPay").choose();
            $("#wxPay").unChoose();
            $("#zfbPay").unChoose();
        }
    }
    total();
}

//计算页面数据
function total() {
    this.totalAmount = parseFloat($("#totalAmount").text()).toFixed(2);
    this.couponeMoney = parseFloat($("#couponeMoney").text()).toFixed(2);
    this.postage = parseFloat($("#postage").text()).toFixed(2);
    this.cashAmount = parseFloat($("#cashAmount").text()).toFixed(2);
    this.payAmount = parseFloat($("#payAmount").val()).toFixed(2);
    this.alreadyPaid = parseFloat($("#alreadyPaid").text()).toFixed(2);
    this.onlineMoney = parseFloat(this.payAmount - this.alreadyPaid).toFixed(2);
    this.accountDeduct = $("#accoutPay").hasClass("choose1");
    if (this.accountDeduct) {
        this.onlineMoney = parseFloat(this.onlineMoney - this.cashAmount).toFixed(2);
    }
    this.onlineMoney = this.onlineMoney < 0 ? 0 : this.onlineMoney;
    $("#onlineMoney").text(parseFloat(this.onlineMoney).toFixed(2));
    if (this.onlineMoney == 0) {
        $("#btnGoPay").text("立即支付");
    } else {
        $("#btnGoPay").text("去付款");
    }

    this.onlinePayType = $("#wxPay").hasClass("choose1") ? 2 : $("#zfbPay").hasClass("choose1") ? 1 : 0;
}

//再次支付
function goPay() {
    var t = new total();

    if ($("#accoutPay").hasClass("choose1")) {
        //余额充足
        if (t.cashAmount > t.onlineMoney) {
            $("#accoutPay").choose();
        } else if ($("#wxPay").hasClass("choose1")) {//余额不足，微信支付
            $("#zfbPay").unChoose();
        } else if ($("#zfbPay").hasClass("choose1")) {//余额不足，支付宝支付
            $("#wxPay").unChoose();
        } else {
            layer.msg("请选择支付方式");
            return;
        }
    } else if (!$("#wxPay").hasClass("choose1") && !$("#zfbPay").hasClass("choose1")) {
        layer.msg("请选择支付方式");
        return;
    }
    t = new total();

    var data = {
        orderFrom: 3,
        customerId: u.id,
        parentOrderId: get("pid"),
        onlinePayType: t.onlinePayType,
        accountDeduct: t.accountDeduct
    };
    //alert($("#txtCoupons").val());
    $.postJson("1023", data, function (f, m, d) {
        if (f) {
            if ($.trim(d.url).length > 0) {
                location.href = d.url;
            } else {
                location.href = "orderlist.html?f=2";
            }
        } else {
            layer.msg(m);
        }
    });
}