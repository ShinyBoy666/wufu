var u = new UserInfo(1);
var cashAmount = 0;
var data = eval("(" + decodeURIComponent(get("data")) + ")");

$(function () {
    bind();
});

//数据初始化
function bind() {
    //$("#list").bindList(data.proArr, "tmp-list");
    var u = new UserInfo(1);
    $.postJson("1058", { cartIds: data, shopId: u.loginShopId, customerId: u.id }, function (f, m, d) {
        if (f === 1) {
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
            if (!d.isDelivery) {
                $("#address").hide();
            }
            $("#isDelivery").val(d.isDelivery);

            if (d.address) $("#address").bindModel(d.address, 'tmp-address');
            $("#coupon-choose").bindList(d.shopCoupons, 'tmp-coupon-choose');
            $("#coupon-number").text(d.shopCoupons.length > 0 ? "未选择" : "暂无优惠券");
            $("#totalAmount").text(parseFloat(d.totalAmount).toFixed(2));
            $("#totalPostage").text(parseFloat(d.totalPostage).toFixed(2));
            $("#postageFree").val(d.postageFree);
            $("#list").bindList(d.shopCarts, 'tmp-list');
            $("#cashAmount").text(parseFloat(d.cashAmount).toFixed(2));
            var shopIds = new Array();
            for (var i = 0; i < d.shopCarts.length; i++) {
                var dd = d.shopCarts[i];
                var ext = false;
                for (var j = 0; j < shopIds.length; j++) {
                    if (shopIds[j].shopId == dd.shopId) {
                        shopIds[j].couponCode = "";
                        shopIds[j].cartIds.push(dd.id);
                        ext = true;
                    }
                }
                if (!ext) {
                    shopIds.push({ shopId: dd.shopId, couponCode: "", cartIds: [dd.id] });
                }
            }
            $("#txtCoupons").val($.jsonToString(shopIds));
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
			$("#totalPostage").text(d.postage.toFixed(2));
            $("#postageFree").val(d.postageFree);
            total();
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
    shop.find(".coupon-selected-ico").not($(dom).find(".coupon-ico")).removeClass("coupon-selected-ico");
    $(dom).find(".coupon-ico").toggleClass("coupon-selected-ico");
    getCoupon();
}

function selectCouponNew(dom){
	var coupons = new Array();
    var couponMoney = 0;
    var shopIds = eval("(" + $("#txtCoupons").val() + ")");
        coupons.push($(dom).data("code"));
        for (var i = 0; i < shopIds.length; i++) {
            if (shopIds[i].shopId == $(dom).data("shopid")) shopIds[i].couponCode = $(dom).data("code");
        }
        couponMoney += parseFloat($(dom).data("couponmoney")).toFixed(2);
    $("#couponeMoney").text(parseFloat(couponMoney).toFixed(2));
    $("#txtCoupons").val($.jsonToString(shopIds));
    $("#coupon-number").text(coupons.length > 0 ? "已选" : "未选择");
    total();
    layer.closeAll();
}

//设置并返回已选优惠券
function getCoupon() {
    var coupons = new Array();
    var couponMoney = 0;
    var shopIds = eval("(" + $("#txtCoupons").val() + ")");
    $(".coupon-selected-ico").parents(".coupon").each(function () {
        coupons.push($(this).data("code"));
        for (var i = 0; i < shopIds.length; i++) {
            if (shopIds[i].shopId == $(this).data("shopid")) shopIds[i].couponCode = $(this).data("code");
        }
        couponMoney += parseFloat($(this).data("couponmoney")).toFixed(2);
    });
    $("#couponeMoney").text(parseFloat(couponMoney).toFixed(2));
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

//不使用优惠券
function clearCouponNew(dom) {
	var coupons = new Array();
    var couponMoney = 0;
    var shopIds = eval("(" + $("#txtCoupons").val() + ")");
    for (var i = 0; i < shopIds.length; i++) {
        shopIds[i].couponCode = "";
    }
    $("#couponeMoney").text("0.00");
    $("#txtCoupons").val($.jsonToString(shopIds));
    $("#coupon-number").text("未选择");
    total();
    layer.closeAll();
}

//计算页面数据
function total() {
    this.realName = $("#txtRealName").val();
    this.idCard = $("#txtIdCard").val();
    this.totalAmount = parseFloat($("#totalAmount").text()).toFixed(2);
    this.postage = parseFloat($("#totalPostage").text());
    this.couponeMoney = parseFloat($("#couponeMoney").text()).toFixed(2);
    this.payAmount = parseFloat(this.totalAmount - this.couponeMoney);
    this.cashAmount = parseFloat($("#cashAmount").text()).toFixed(2);
    this.addressId = $("#addressId").data("id") || 0;
    this.accountDeduct = $("#accoutPay").hasClass("choose1");
    this.isDelivery = $("#isDelivery").val();
    if(!this.isDelivery || $("#postageFree").val() <= this.payAmount){
    	this.postage = 0;
    	$("#totalPostage").text("0.00");
    }
    //加邮费
    this.payAmount = (this.payAmount + this.postage) < 0 ? 0 : (this.payAmount + this.postage);
    this.onlineMoney = this.payAmount;
    $("#payMoney").text(this.payAmount.toFixed(2));
    if (this.accountDeduct) {
        this.onlineMoney = (this.onlineMoney - this.cashAmount);
    }
    this.onlineMoney = this.onlineMoney < 0 ? 0 : this.onlineMoney;
    $("#onlineMoney").text(this.onlineMoney.toFixed(2));
    if (this.onlineMoney == 0) {
        $("#btnGoPay").text("立即下单");
        $("#wxPay").unChoose();
        $("#zfbPay").unChoose();
    } else {
        $("#btnGoPay").text("去付款");
    }

    this.onlinePayType = $("#wxPay").hasClass("choose1") ? 2 : 1;
}

//确定下单
function goPay() {
    var text = $("#btnGoPay").data("state");
    if (text == 1) {
        var u = new UserInfo(1);
        var t = new total();
        if ($("#isRealyname").val() == 1) {
            if (t.realName == "" || t.idCard == "") return layer.msg("请填写身份信息");
            if (!isCardNo(t.idCard)) return layer.msg("身份证号码不准确");
        }
        if (t.isDelivery == "true" && t.addressId <= 0) return layer.msg("请选择收货地址");
        if ($("#seatNumber").val().length === 0) {
            return layer.msg("请填写座位号");
        }
        if ($("#accoutPay").hasClass("choose1")) {
            //余额充足
            if (t.onlineMoney==0) {
                $("#accoutPay").choose();
            } else if ($("#wxPay").hasClass("choose1")) {//余额不足，微信支付
                $("#zfbPay").unChoose();
            } else if ($("#zfbPay").hasClass("choose1")) {//余额不足，支付宝支付
                $("#wxPay").unChoose();
            } else {
                layer.msg("请选择支付方式");
                return;
            }
        }
        t = new total();
        var data = {
            customerId: u.id,
            orderFrom: 3,
            addressId: t.addressId,
            onlinePayType: t.onlinePayType,
            accountDeduct: t.accountDeduct,
            shopCarts: eval("(" + $("#txtCoupons").val() + ")"),
            realyname: t.realName,
            recipientIdentityCard: t.idCard,
            seatNumber: $("#seatNumber").val()
        };
        //alert($("#txtCoupons").val());
        $("#btnGoPay").data("state", 0);
        $.postJson("1021", data, function (f, m, d) {
            if (f == 1) {
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
}

function productDetail(id) {
    location.href = "productdetail.html?pid=" + id;
}

function isCardNo(card) {
    // 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X  
    var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
    if (reg.test(card) === false) {
        alert("身份证输入不合法");
        return false;
    }
    return true;
}
//选择支付方式f=1账户支付，f=2微信支付，f=3支付宝支付
function payType(f) {
    var t = new total();
    if (f == 1 && t.cashAmount > 0) {
        $("#accoutPay").choose();
    }
    else if (f == 2) {
        if (!is_weixn()) {
            layer.msg("微信支付目前仅支持在微信浏览器中使用");
            return;
        }
        if (parseFloat(t.cashAmount) > parseFloat(t.payAmount)) { $("#accoutPay").unChoose() }
        $("#wxPay").choose();
        $("#zfbPay").unChoose();
    }
    else if (f == 3) {
        if (parseFloat(t.cashAmount) > parseFloat(t.payAmount)) { $("#accoutPay").unChoose() }
        $("#zfbPay").choose();
        $("#wxPay").unChoose();
    }
    if ($("#accoutPay").hasClass("choose1")) {
        //余额充足
        if (parseFloat(t.cashAmount) > parseFloat(t.payAmount)) {
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
