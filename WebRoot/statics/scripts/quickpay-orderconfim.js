$(function () {
    var money = parseFloat(getQueryString("m"));
    bind();
    function bind() {
        var shop = ShopInfo();
        $("#imgLogo").attr("src", shop.shopLogo);
        $("#shopName").text(shop.shopName);
        $.postJson("1092", { shopId: shop.id, openId: shop.openId, orderMoney: money }, function (f, m, d) {
            if (f === 1) {
                $("#cashAmount").text(d.amount.toFixed(2));
                setLoginInfo(d.customer);
                var jo = { customerId: d.customerId, shopId: shop.id, openId: shop.openId };
                for (var j = 0; j < d.list.length; j++) {
                    var dd = d.list[j];
                    if (dd.type == 1) {
                        //随机立减
                        jo.randomMoney = getCookie("randomMoney");
                        if (!jo.randomMoney) {
                            //jo.randomMoney = dd.minMoney + Math.random() * (dd.maxMoney - dd.minMoney);
                            if (Math.random() >= 0.8) {
                                jo.randomMoney = Math.random() * 0.3 + 0.2;
                            } else {
                                jo.randomMoney = Math.random() * 0.2+0.01;
                            }
                            jo.randomMoney = jo.randomMoney < 0 ? 0.0 : jo.randomMoney;
                            jo.randomMoney = parseFloat(jo.randomMoney > money ? money : jo.randomMoney).toFixed(2);
                            setCookie("randomMoney", jo.randomMoney, "h1");
                        }
                        $(".conpon-type li:eq(1)").show();
                        if (money < 10) {
                            jo.randomMoney = 0;
                            $("#tiaojian").show();
                        }
                        if (dd.orderCount > 3) {
                            jo.randomMoney = 0;
                        }
                    } else if (dd.type == 2) {
                        //满减
                        jo.reduce = 0;
                        for (var i = 0; i < dd.fullMoneys.length; i++) {
                            if (money > parseFloat(dd.fullMoneys[i]))
                                jo.reduce = parseFloat(dd.reduceMoneys[i]);
                        }
                        jo.reduceMoney = parseFloat(jo.reduce).toFixed(2);
                        $(".conpon-type li:eq(2)").show();
                    } else if (dd.type == 3) {
                        //折扣立减
                        jo.saleMoney = parseFloat(money * (100 - dd.sale) / 100.0).toFixed(2);
                        $(".conpon-type li:eq(3)").show();
                    } else if (dd.type == 4) {
                        //优惠券买单
                        $(".conpon-type li:eq(4)").show();
                        $("#list").bindList(dd.list, "tmp-list");
                    }
                }

                $("#json").val($.jsonToString(jo));

                //if (d.amount > money) {
                //    $("#accoutPay").choose();
                //} else {
                //    if (is_weixn()) {
                //        $("#wxPay").choose();
                //    }
                //}
                $(".conpon-type li:visible:eq(1)").click();
            }
            else {
                layer.msg(m);
            }
        });
    }

    //选择优惠类别
    $(".conpon-type li:gt(0):lt(4)").click(function () {
        var json = $.parseJSON($("#json").val());

        if ($(this).hasClass("choose1")) return;
        $(".conpon-type li .choose1").unChoose();
        $(this).find(".choose").choose();
        var f = $(this).index();
        switch (f) {
            case 1://立减
                $("#conpon-list").slideUp(500);
                $("#conponAmount").text(json.randomMoney);
                $("#payAmount").text((money - json.randomMoney).toFixed(2));
                break;
            case 2://满额立减
                $("#conpon-list").slideUp(500);
                $("#conponAmount").text(json.reduceMoney);
                $("#payAmount").text((money - json.reduceMoney).toFixed(2));
                break;
            case 3://折扣
                $("#conpon-list").slideUp(500);
                $("#conponAmount").text(json.saleMoney);
                $("#payAmount").text((money - json.saleMoney).toFixed(2));
                break;
            case 4://优惠买单
                $("#conpon-list").slideDown(500);

                json.couponMoney = 0;
                $(".conpon-item.selected").each(function () {
                    json.couponMoney += $(this).data("json").couponMoney;
                });

                $("#conponAmount").text(json.couponMoney);
                if (money > json.couponMoney) {
                    $("#payAmount").text((money - json.couponMoney).toFixed(2));
                } else {
                    $("#payAmount").text("0.00");
                }
                break;
            default:
        }
    });
    //选择支付方式
    $(".paytype li:gt(0)").click(function () {
        $(".paytype li .choose1").unChoose();
        var cashAmount = parseFloat($("#cashAmount").text());
        var f = $(this).index();
        //账户支付
        if (f == 1) {
            if (cashAmount > money)
                $("#accoutPay").choose();
            else return;
        }
            //微信支付
        else if (f == 2) {
            if (!is_weixn()) {
                layer.msg("微信支付目前仅支持在微信浏览器中使用");
                return;
            }
            $("#wxPay").choose();
        }
            //支付宝支付
        else if (f == 3) {
            $("#zfbPay").choose();
        }
        if (!$("#wxPay").hasClass("choose1") && !$("#zfbPay").hasClass("choose1") && !$("#accoutPay").hasClass("choose1")) {
            layer.msg("请选择支付方式");
            return;
        }
    });
    //选择优惠券
    $("#list").on("click", ".conpon-item", function () {
        var json = $.parseJSON($("#json").val());

        var self = $(this);
        var selfData = self.data("json");
        $(".conpon-item").each(function () {
            if (selfData.couponApplyId != $(this).data("json").couponApplyId) {
                //不是同一批次
                $(this).addClass("disabled");
                $(this).removeClass("selected");
            } else {
                $(".conpon-item").removeClass("disabled");
            }
        });
        self.toggleClass("selected");
        if ($(".conpon-item.selected").length > selfData.maxUseNumber) {
            self.toggleClass("selected");
            layer.msg("该类优惠券，最多同时使用" + selfData.maxUseNumber + "张");
        }
        json.couponMoney = 0;
        $(".conpon-item.selected").each(function () {
            json.couponMoney += $(this).data("json").couponMoney;
        });

        $("#conponAmount").text(json.couponMoney);
        if (money > json.couponMoney) {
            $("#payAmount").text((money - json.couponMoney).toFixed(2));
        } else {
            $("#payAmount").text("0.00");
        }
    });

    $("#submit").click(function () {
        if ($(".conpon-type li .choose1").length == 0) return layer.msg("请选择优惠方式");
        var json = $.parseJSON($("#json").val());
        var couponCode = "";
        $(".conpon-item.selected").each(function () {
            couponCode += "|" + $(this).data("json").couponCode;
        });
        if (couponCode.length > 0) {
            couponCode = couponCode.substring(1);
        }
        var param = {
            orderType: $(".conpon-type li .choose1").parent().index(),
            couponCode: couponCode,
            totalAmount: money,
            discountAmount: $("#conponAmount").text(),
            orderFrom: 3,
            shopId: json.shopId,
            openId: json.openId,
            customerId: json.customerId
        };
        var id = $(".paytype .choose1").attr("id");
        switch (id) {
            case "wxPay":
                param.payType = 3;
                break;
            case "zfbPay":
                param.payType = 2;
                break;
            case "accoutPay":
                param.payType = 1;
                break;
            default:
                return layer.msg("请选择支付方式");
        }
        $.postJson("1093", param, function (f, m, d) {
            if (f === 1) {
                if (d.paymentAmount > 0) {
                    location.href = d.url;
                } else {
                    location.href = "quickpay-success.html?orderid=" + d.orderId + "&totalAmount=" + d.totalAmount;
                }
            } else {
                layer.msg(m);
            }
        });
    });
})