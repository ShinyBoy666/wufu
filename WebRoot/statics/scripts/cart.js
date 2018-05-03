
$(function () {
    bind(1);
});
//绑定数据
function bind(idx) {
    var u = new UserInfo(1);
    $.postJson("1011", { customerId: u.id, currentPage: 1, limit: 10000 }, function (f, m, d) {
        if (f === 1) {
            if (d.list.length > 0) {
                $("#list").bindList(d.list, "tmp-list");
                $("#no-data").hide();
                $("#detail-info").show();
                calcCartCount();
            } else {
                $("#no-data").show();
                $("#detail-info").hide();
            }
        }
        total();
    });
}
//数量+1
function plus(dom) {
    var s = new CartItem(dom);
    if (s.num >= s.data.quantity) { layer.msg("购买量最多为 " + s.data.quantity + " 个"); return; }
    var newNum = s.num + 1;
    $.postJson("1009", { id: s.data.id, productNumber: newNum }, function (f, m, d) {
        if (f === 1) {
            s.numDom.val(newNum);
            calcCartCount();
        } else { layer.msg(m); }
        total();
    }, false);
}
//数量-1
function dec(dom) {
    var s = new CartItem(dom);
    if (s.num <= 1) { layer.msg("购买量至少为 1 个"); return; }
    var newNum = s.num - 1;
    $.postJson("1009", { id: s.data.id, productNumber: newNum }, function (f, m, d) {
        if (f === 1) {
            s.numDom.val(newNum);
            calcCartCount();
        } else { layer.msg(m); }
        total();
    }, false);
}
//选中商品
function shoose(dom) {
    var s = new CartItem(dom);
    if (s.data.productState == 1) {
        var radio = s.pro.find(".proRadio");
        radio.toggleClass("choose1").toggleClass("setting");
        if (s.shop.find(".setting").not(".shopRadio,.nogoods").length == 0) {
            s.shop.find(".shopRadio").removeClass("setting").addClass("choose1");
        } else {
            s.shop.find(".shopRadio").removeClass("choose1").addClass("setting");
        }
        total();
    } else {
        var sp = $("#btnEdit");
        if (sp.text() == "完成") {
            var radio = s.pro.find(".proRadio");
            if (radio.hasClass("choose1") || radio.hasClass("setting")) {
                radio.toggleClass("choose1").toggleClass("setting");
            } else {
                radio.addClass("choose1");
            }
        }
    }
}
//选中该店铺的商品
function shooseShop(dom) {
    var s = $(dom).parents(".shop");
    var radio = s.find(".shopRadio");
    radio.toggleClass("choose1").toggleClass("setting");
    if (radio.hasClass("choose1")) {
        s.find(".proRadio").removeClass("setting").addClass("choose1");
    } else {
        s.find(".proRadio").removeClass("choose1").addClass("setting");
    }
    total();
}

//选中所有商品
function shooseAll(dom) {
    var radio = $(dom).find("i");
    radio.toggleClass("choose").toggleClass("choose1").toggleClass("choose1-icon").toggleClass("choose-icon");

    if (radio.hasClass("choose1")) {
        $(".proRadio,.shopRadio").removeClass("setting").addClass("choose1");
    } else {
        $(".proRadio,.shopRadio").removeClass("choose1").addClass("setting");
    }
    total();
}

//统计
function total() {

    if ($("#list .setting").not(".nogoods").length == 0) {
        $(".all-choose").removeClass("choose-icon").removeClass("choose").addClass("choose1").addClass("choose1-icon");
    } else {
        $(".all-choose").addClass("choose-icon").addClass("choose").removeClass("choose1").removeClass("choose1-icon");
    }

    var count = 0, amount = 0.00;
    $(".proRadio.choose1").not(".nogoods").each(function (i, o) {
        var pro = new CartItem(o);
        count += 1;
        amount += pro.num * pro.price;
    });

    $("#proCount").text(count);
    $("#proTotalAmount").text(parseFloat(amount).toFixed(2));

    if ($(".setting-buton-chose").hasClass("choose")) {
        $("#btnSelectAll").text("全选");
    } else {
        $("#btnSelectAll").text("反选");
    }
}
//删除
function del(id) {
    var u = new UserInfo(1);
    var arrayObj = new Array();
    if(id){
    	  arrayObj.push(id);
    }else{
    	$(".proRadio.choose1").each(function (i, o) {
	        var pro = new CartItem(o);
	        arrayObj.push(pro.id);
	    });
    }
    if (arrayObj.length < 1) { layer.msg("请选择需要移除购物车的商品"); return; }

    $.postJson("1010", { cartIds: arrayObj, customerId: u.id }, function (f, m, d) {
        if (f === 1) {
            bind();
//            edit();
        } else { layer.msg(m); }
    }, false);
}
//编辑
function edit() {
    var sp = $("#btnEdit");
    if (sp.text() == "编辑") {
        $("body,.near-bg-cener").css("background", "#aaa");
        $(".shop>div").not(".near-bg-cener").css("margin-left", "10px");
        sp.text("完成");
        $("#btnPay").hide();
        $("#btnDelete").show();
        $(".product .nogoods").removeClass("nogoods").addClass("setting");
    } else {
        $("body,.near-bg-cener").css("background", "#f2f2f2");
        $(".shop>div").not(".near-bg-cener").css("margin-left", "0px");
        sp.text("编辑");
        $("#btnPay").show();
        $("#btnDelete").hide();
        $(".product .coord-icon").removeClass("setting").removeClass("choose1").addClass(function () { return $(this).data("default") });
    }
    $(".proRadio,.shopRadio").removeClass("choose1").addClass("setting");
}

//去结算
function pay() {
    var proArr = new Array();
    $(".proRadio.choose1").not(".nogoods").each(function (i, o) {
        var pro = new CartItem(o);
        if (pro.data.quantity < this.num) {
            return layer.msg("商品库存不足");
        }
        proArr.push(pro.data.id);
    });
    if (proArr.length < 1) { layer.msg("您还没选购买的商品哦"); return; }
    location.href = "orderconfim.html?data=" + encodeURIComponent($.jsonToString(proArr));
}

//商品详情
function goDetail(dom) {
    var pro = new CartItem(dom);
    location.href = 'productdetail.html?pid=' + pro.proId
}

//获取商品
function CartItem(dom) {
    var p = $(dom).parents(".product");
    this.shop = $(dom).parents(".shop");
    this.pro = p;
    this.numDom = p.find(".setting-number");
    this.num = parseInt(this.numDom.val()) || 0;
    this.data = p.data("json");
    this.price = parseFloat(this.data.retailPrice);
    this.id = parseFloat(this.data.id);
    this.proId = parseFloat(this.data.productId);
}

function inputNum(dom) {
    var c = new CartItem(dom);
    if (c.data.quantity < c.num)
        c.numDom.val(c.data.quantity);
    else if (c.num <= 0)
        c.numDom.val(0);
    else
        c.numDom.val(c.num);

    $.postJson("1009", { id: c.data.id, productNumber: c.num }, function (f, m, d) {
        if (f === 1) {
        } else { layer.msg(m); }
        total();
    }, false);

}

function calcCartCount(){
	var cartCount = 0;
    $(".setting-number").each(function(){
    	cartCount += parseInt(this.value);
    });
    if(cartCount > 0){
    	 $("#cartTotalItemNum").text(cartCount);
    }else{
    	$("#cartTotalItemNum").hide();
    }
}