var u = new UserInfo(true);
var cashAmount = 0;

$(function () {
    if (get("t", "").length > 0) {
        $("#tixian").show();
    }
    bind();
});

//数据初始化
function bind() {
    var t = new total();

    $.postJson("1120", { customerId: u.id, type: getQueryString('q',1) }, function (f, m, d) {
        if (f === 1) {
            $("#typeName").text(d.remark);
            $("#cashAmount").text(d.cashAmount);
            if (d.accountDeduct) {
                $("#accountDeduct").show();
                if (d.cashAmount <= 0) {
                	if (is_weixn()) {
                		$("#wxPay").choose();
                	}else{
                		$("#zfbPay").choose();
                	}
                    $("#accoutPay").unChoose();
                } else {
                    $("#accoutPay").choose();
                }
            }else {
            	if (is_weixn()) {
            		$("#wxPay").choose();
            	}else{
            		$("#zfbPay").choose();
            	}
                $("#accoutPay").unChoose();
            }

            $(".totalAmount").text(d.amount);
            $("#couponeMoney").text(0);
            $("#payMoney").text(0);
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
    this.payAmount = parseFloat(this.totalAmount - this.couponeMoney).toFixed(2);
    this.cashAmount = parseFloat($("#cashAmount").text()).toFixed(2);
    this.onlineMoney = parseFloat(this.payAmount).toFixed(2);
    this.accountDeduct = $("#accoutPay").hasClass("choose1");
    $("#payMoney").text(this.payAmount);
    if (this.accountDeduct) {
        this.onlineMoney = (this.onlineMoney - this.cashAmount).toFixed(2);
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

//去支付
function goPay() {
    var t = new total();
    if ($("#accoutPay").hasClass("choose1")) {
        //余额充足
        if (parseFloat(t.cashAmount) > parseFloat(t.payAmount)) {
            $("#accoutPay").choose();
            $("#wxPay").unChoose();
            $("#zfbPay").unChoose();
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
        onlinePayType: t.onlinePayType,
        accountDeduct: t.accountDeduct,
        type: getQueryString('q',1)
    };
    //alert($("#txtCoupons").val());
    $.postJson("1067", data, function (f, m, d) {
        if (f) {
            if ($.trim(d.url).length > 0) {
                location.href = d.url;
            } else {
                location.href = "orderlist.html?f=2";
            }
        }
    });
}