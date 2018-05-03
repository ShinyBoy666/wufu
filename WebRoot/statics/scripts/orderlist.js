var u = new UserInfo(1);
$(function () {
    s = get("f", 1);
    bind(s);
});

//绑定初始化
function bind(state) {
    $(".product-page .selecter").removeClass("selecter");
    if (state == 1) $(".product-page .star:eq(0)").addClass("selecter");//待支付
    else if (state == 2) $(".product-page .star:eq(1)").addClass("selecter");//进行中
    else if (state == 3) $(".product-page .star:eq(2)").addClass("selecter");//已完成

    $.postPager("1018", { customerId: u.id, shopId: u.loginShopId, orderState: state }, function (f, m, d,p) {
        if (f === 1) {
            if (p === 1) {
                if (!d.list || d.list.length === 0) {
                    $("#nodata").show();
                } else {
                    $("#nodata").hide();
                }
                $("#list").bindList(d.list, "tmp-list");
            } else {
                $("#list").bindListAppend(d.list, "tmp-list");
            }
        } else {
            layer.msg(m);
        }
    });
}
//去支付
function pay(dom) {
    var o = new OrderDetail(dom);
    location.href = "repay.html?cid=" + o.childOrderId + "&pid=" + o.parentOrderId;
}
//订单取消
function cancel(dom) {
    var o = new OrderDetail(dom);
    $.postJson("1020", { customerId: u.id, childOrderId: o.childOrderId, parentOrderId: o.parentOrderId, state: 2 }, function (f, m, d) {
        if (f) {
            layer.msg(m);
            setTimeout(function () { o.order.remove(); }, 1000);
        }
    });
}
//确认收货
function receipt(dom) {
    var o = new OrderDetail(dom);
    $.postJson("1020", { customerId: u.id, childOrderId: o.childOrderId, parentOrderId: o.parentOrderId, state: 1 }, function (f, m, d) {
        if (f) {
            layer.msg(m);
            setTimeout(function () { o.order.remove(); }, 1000);
        }
    });
}

function detail(dom) {
    var o = new OrderDetail(dom);
    var f = $(".product-page .selecter").index() + 1;
    location.href = "orderdetail.html?cid=" + o.childOrderId + "&pid=" + o.parentOrderId + "&f=" + f;
}

function OrderDetail(dom) {
    var o = $(dom).parents(".order-item");
    this.order = o;
    this.childOrderId = o.data("childorderid");
    this.parentOrderId = o.data("parentorderid");
}