var u = new UserInfo(1);
var param = {
    activityId: getQueryString("a"),
    productId: getQueryString("p"),
    productPriceId: getQueryString("priceid"),
    productNumber: getQueryString("n"),
    customerId: u.id,
    shopId: u.loginShopId,
    activityType: 1,
    sku: encodeURIComponent(getQueryString("sku"))
};

var cashAmount = 0;

$(function () {
    bind();
});

//数据初始化
function bind() {
    $.postJson("1071", param, function (f, m, d) {
        if (f === 1) {
            if (d.accountDeduct) {
                $("#accountDeduct").show();
                if (d.cashAmount <= 0) {
                    $("#accoutPay").unChoose();
                }
            }
            else {
                $("#accoutPay").unChoose();
            }
            if (d.address) $("#address").bindModel(d.address, 'tmp-address');
            $("#totalAmount").text(parseFloat(d.totalAmount).toFixed(2));
            $("#couponeMoney").text(parseFloat(d.discountAmount).toFixed(2));
            $("#product-detail").bindModel(d.productInfo, 'tmp-product-detail');
            $("#cashAmount").text(parseFloat(d.cashAmount).toFixed(2));
            total();
            //判断是否需要实名制
            if (d.isRealyname) {
                $("#cusinfo").show();
                $("#isRealyname").val(1);
            }
            //是否需要填写座位号
            if (d.isSeat) {
                $("#seatNumberInfo").show();
            } else {
                $("#seatNumber").val("0");
            }
        } else {
            layer.msg(m);
        }
    });
}

//更改地址
function addressList(dom) {
    $.postJson("1015", { customerId: u.id, currentPage: 1, limit: 1000 }, function (f, m, d) {
        var id = $(dom).data("id");

        $("#addressList").bindList(d.list, "tmp-addressList");
        layer.open({
            title: false,
            type: 1,
            area: ["100%", "100%"],
            skin: 'layui-layer-demo', //样式类名
            shift: 2,
            closeBtn: false,
            shadeClose: true, //开启遮罩关闭
            content: $("#addressPopo")
        });
        $("#addressPopo").show();
    });
}

//选择地址
function choose(id) {
    layer.closeAll();
    if (id > 0) {
        $.postJson("1056", { id: id }, function (f, m, d) {
            layer.closeAll();
            $("#address").bindModel(d, "tmp-address");
        });
    }
}

//新增地址
function addAddress() {
    layerIdx = layer.open({
        type: 2,
        title: false,
        shadeClose: false,
        shift: 2,
        closeBtn: false,
        area: ["100%", '100%'],
        content: 'address.html?v2&flag=' + 1
    });
}

//去选优惠券
function chooseCoupon() {
    if ($("#coupon-number").text() == "暂无优惠券") return;
    layer.open({
        title: false,
        type: 1,
        area: ["100%", "100%"],
        skin: 'layui-layer-demo', //样式类名
        shift: 2,
        closeBtn: false,
        shadeClose: true, //开启遮罩关闭
        content: $("#couponPopo")
    });
    $("#couponPopo").show();
}

//选中优惠券
function selectCoupon(dom) {
    var shop = $(dom).parents(".coupon-shop-item");
    shop.find(".coupon-selected-ico").not(".coupon-ico").removeClass("coupon-selected-ico");
    $(dom).find(".coupon-ico").toggleClass("coupon-selected-ico");
    getCoupon();
}

//设置并返回已选优惠券
function getCoupon() {
    var coupons = new Array();
    var shopIds = eval("(" + $("#txtCoupons").val() + ")");
    $(".coupon-selected-ico").parents(".coupon-item").each(function () {
        coupons.push($(this).data("code"));
        for (var i = 0; i < shopIds.length; i++) {
            if (shopIds[i].shopId == $(this).data("shopid")) shopIds[i].couponCode = $(this).data("code");
        }
        couponMoney += parseFloat($(this).data("couponmoney"));
    });
    $("#txtCoupons").val($.jsonToString(shopIds));
    $("#coupon-number").text(coupons.length > 0 ? "已选" + coupons.length + "张" : "未选择");
    total();
    return coupons;
}

//不使用优惠券
function clearCoupon(dom) {
    var shop = $(dom).parents(".coupon-shop-item");
    shop.find(".coupon-selected-ico").removeClass("coupon-selected-ico");
    getCoupon();
}


//计算页面数据
function total() {
    this.realName = $("#txtRealName").val();
    this.idCard = $("#txtIdCard").val();
    this.totalAmount = $("#totalAmount").text();
    this.couponeMoney = $("#couponeMoney").text();
    this.payAmount = this.totalAmount - this.couponeMoney;
    this.cashAmount = $("#cashAmount").text();
    this.addressId = $("#addressId").data("id");
    this.onlineMoney = this.payAmount;
    this.accountDeduct = $("#accoutPay").hasClass("choose1");
    $("#payMoney").text(this.payAmount);
    if (this.accountDeduct) {
        this.onlineMoney = this.onlineMoney - this.cashAmount;
    }
    this.onlineMoney = this.onlineMoney < 0 ? 0 : this.onlineMoney;
    $("#onlineMoney").text(parseFloat(this.onlineMoney).toFixed(2));
    if (this.onlineMoney == 0) {
        $("#btnGoPay").text("立即支付");
        $("#wxPay").unChoose();
        $("#zfbPay").unChoose();
    } else {
        $("#btnGoPay").text("去付款");
    }

    this.onlinePayType = $("#wxPay").hasClass("choose1") ? 2 : $("#zfbPay").hasClass("choose1") ? 1 : 0;
}

//确定下单
function goPay() {
    var u = new UserInfo(1);
    var t = new total();
    if ($("#isRealyname").val() == 1) {
        if (t.realName == "" || t.idCard == "") return layer.msg("请填写身份信息");
    }
    if (t.addressId <= 0) return layer.msg("请选择收货地址");
    if ($("#seatNumber").val().length === 0) {
        return layer.msg("请填写座位号");
    }
    if ($("#accoutPay").hasClass("choose1")) {
        //余额充足
        if (t.onlineMoney == 0) {
            $("#accoutPay").choose();
            $("#wxPay").unChoose();
            $("#zfbPay").unChoose();
        } else if ($("#wxPay").hasClass("choose1")) { //余额不足，微信支付
            $("#zfbPay").unChoose();
        } else if ($("#zfbPay").hasClass("choose1")) { //余额不足，支付宝支付
            $("#wxPay").unChoose();
        } else {
            layer.msg("请选择支付方式");
            return false;
        }
    } else {
        if (t.onlinePayType === 0) return layer.msg("请选择支付方式");
    }
    t = new total();
    var data = {
        customerId: u.id,
        orderFrom: 3,
        addressId: t.addressId,
        onlinePayType: t.onlinePayType,
        accountDeduct: t.accountDeduct,
        shopId: u.loginShopId,
        couponCode: "",
        sku: param.sku,
        productId: param.productId,
        productNumber: param.productNumber,
        realyname: t.realName,
        recipientIdentityCard: t.idCard,
        activityId: param.activityId,
        activityType: param.activityType,
        productPriceId: param.productPriceId,
        seatNumber: $("#seatNumber").val()
    };
    $("#btnGoPay").data("state", 0);
    $.postJson("1022", data, function (f, m, d) {
        if (f) {
            if ($.trim(d.url).length > 0) {
                location.href = d.url;
            } else {
                location.href = "orderlist.html?f=2";
            }
        } else {
            layer.msg(m);
            $("#btnGoPay").data("state", 1);
        }
    });
}

//查看产品详情
function productDetail(id) {
    location.href = "productdetail.html?pid=" + id;
}

//返回
function goback() {
    location.href = "activityproductdetail.html?activityId=" + param.activityId + "&productId=" + param.productId
        + "&productPriceId=" + param.productPriceId;
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
    } else if (!$("#wxPay").hasClass("choose1") && !$("#zfbPay").hasClass("choose1")) {
        layer.msg("请选择支付方式");
        return;
    }
    total();
}