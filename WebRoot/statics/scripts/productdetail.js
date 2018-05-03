var myswiper;
var dt;
function goshare() {
    $("#J-guide").show();
}
function closeshare() {
    $("#J-guide").hide();
}
function showsku() {
    var h = $('#J-panel-cm').height();
    $('#J-panel-cm').css("bottom", -h);
    $('#J-panel-cm').animate({ bottom: 0 });
    $('#J-panel-cm').show();
    $("#mask").fadeIn();
}
function closesku() {
    $("#mask").fadeOut();
    var h = $('#J-panel-cm').height();
    $('#J-panel-cm').animate({ bottom: -h });
}
function changeaddnum() {
    var num = $("#buynum").text();
    var maxnum = $("#J-last-num").text();
    if (1 + parseInt(num) > maxnum) {
        $("#buynum").text(maxnum);
        $(".btn-add").addClass("disabled");
    } else {
        $("#buynum").text(1 + parseInt(num));
    }
    num = $("#buynum").text();
    if (num == 1) {
        $(".btn-minus").addClass("disabled");
    } else {
        $(".btn-minus").removeClass("disabled");
    }
    if (num == maxnum) {
        $(".btn-add").addClass("disabled");
    } else {
        $(".btn-add").removeClass("disabled");
    }
}
function changeminusnum() {
    var num = $("#buynum").text();
    var maxnum = $("#J-last-num").text();

    if (parseInt(num) - 1 < 1) {
        $("#buynum").text(1);
        $(".btn-minus").addClass("disabled");
    } else {
        $("#buynum").text(parseInt(num) - 1);
    }
    num = $("#buynum").text();
    if (num == 1) {
        $(".btn-minus").addClass("disabled");
    } else {
        $(".btn-minus").removeClass("disabled");
    }
    if (num == maxnum) {
        $(".btn-add").addClass("disabled");
    } else {
        $(".btn-add").removeClass("disabled");
    }
}

function changesku(t) {
    var quantity = $(t).data("quantity");
    var id = $(t).data("id");
    var retailprice = $(t).data("retail_price");
    var profitfirst = $(t).data("profitfirst");
    var marketprice = $(t).data("marketprice");
    $("#J-last-num").text(quantity);
    $("#J-sku-price").text(retailprice.toFixed(2));
    $("#J-sku-vip-price").text(profitfirst.toFixed(2));
    $("#J-sku-market-price").text(marketprice.toFixed(2));
    $("#buynum").text(1);
    $(t).addClass("sel").siblings().removeClass("sel");
    var imageurl = "";
    for (var i = 0; i < dt.productPriceList.length; i++) {
        if (dt.productPriceList[i].id == id) {
            imageurl = dt.productPriceList[i].imageUrlList[0];
        }
    }
    $("#smallimage").attr("src", imageurl + "?160_160");
}
function productcollection(t) {
    var pid = getQueryString("pid", 0);
    $.postJson("1041", { objectId: pid, objectType: 1 }, function (flag, msg, data) {
        if (flag === 1) {
            layer.msg("收藏成功");
            var iscollection = $("#hidcollection").val();
            if (iscollection == "0") {
                layer.msg("收藏成功");
                $("i", $(t)).addClass("collect-active").removeClass("collect");
                $("#hidcollection").val(1);
            } else {
                layer.msg("取消成功");
                $("i", $(t)).removeClass("collect-active").addClass("collect");
                $("#hidcollection").val(0);
            }
        } else {
            layer.msg("收藏失败");
        }
    });
}

function confirmsku() {
    var id = $(".sel").data("id");
    if (id != undefined && id != '') {
        var sku = $(".sel").data("sku");
        var retailprice = $(".sel").data("retail_price");
        var profitFirst = $(".sel").data("profitfirst");
        var marketprice = $(".sel").data("marketprice");
        var num = $("#buynum").text();
        $("#selectedprice").text(retailprice.toFixed(2));
        $("#selectedprofitFirst").text(profitFirst.toFixed(2));
        $("#selectedmarketprice").text(marketprice.toFixed(2));
        $("#selectedsku").text("已选  " + sku + "、" + num + "件");
        $("#hidselectvalue").val(sku + "|" + num);
        var html = "";
        for (var i = 0; i < dt.productPriceList.length; i++) {
            if (dt.productPriceList[i].id == id) {
                for (var j = 0; j < dt.productPriceList[i].imageUrlList.length; j++) {
                    if (j == 0) {
                        $("#hidselectimg").val(dt.productPriceList[i].imageUrlList[0]);
                    }
                    html += "<div class=\"swiper-slide\"><img src=\"" + dt.productPriceList[i].imageUrlList[j] + "?640_640\" style=\"width: 100%;\"></div>";
                }
            }
        }
        //轮播图lunbojs方法
        if (html.length > 0) {
            html = html.substring(0, html.length - 1);
        }
        if (myswiper) {
            myswiper.removeAllSlides();
        }
        myswiper.appendSlide(html);
    }
    closesku();
}
function addcart() {
    var datainfo = $("#hidselectvalue").val();
    var arrlist = datainfo.split('|');
    if (arrlist[0] == "" || arrlist[1]==0) {
        layer.msg("商品已售完");
        return false;
    }
    var productid = getQueryString("pid", 0);
    if (productid == "") {
        layer.msg("商品已售完");
        return false;
    }
    $.postJson("1008", { productId: productid, sku: arrlist[0], productNumber: parseInt(arrlist[1]) }, function (flag, msg, data) {
        if (flag === 1) {

            var img = "/statics/img/image/banner.jpg";
            if ($("#hidselectimg").val() != "") {
                img = $("#hidselectimg").val();
            }
            var offset = $("#cartTotalItemNum").offset();
            var flyer = $('<img style="width:40px;height:40px;" class="u-flyer" src="' + img + '">');
            flyer.fly({
                start: {
                    //left: event.pageX,
                    //top: event.pageY
                    left: 0,
                    top: 0
                },
                end: {
                    left: $(window).width() * 0.7,
                    top: $(window).height(),
                    width: 0,
                    height: 0
                },
                onEnd: function () {
                    //$("#msg").show().animate({ width: '250px' }, 200).fadeOut(1000);
                    var num = parseInt($("#cartTotalItemNum").text()) + parseInt(arrlist[1]);
                    $("#cartTotalItemNum").css("display", "inline-block");
                    $("#cartTotalItemNum").text(num);
                    this.destory();
                }
            });

        } else {
            layer.msg(msg);
        }
    });
    return true;
}
function showmore() {
    $("#divmore").hide();
    $("#productdetail").fadeIn("slow");
    var doc = $(document).find("html,body");
    if (doc.filter(":animated").size()) {
        doc.stop();
    }
    doc.animate({
        scrollTop: $("#productdetail").offset().top
    },
    800);
    return false;
}

function Params() {
    this.pid = getQueryString("pid", 0);
    this.recommendcode = getQueryString("r", "");
}

function loadInfo() {
    var info = new Params();
    var pid = info.pid;
    setCookie('inviteCode', info.recommendcode, 'd100');
    $.postSync("1007", { productId: pid }, function (flag, msg, data) {
        if (flag === 1) {
            dt = data;
            $("#content").bindSyncModel(data, "tmp-model");
            if (data.productPriceList.length > 0) {
                if (data.productPriceList[0].quantity>0) {
                    $("#hidselectvalue").val(data.productPriceList[0].sku + "|1");
                } else {
                    $("#hidselectvalue").val(data.productPriceList[0].sku + "|0");
                }
                
                if (dt.productPriceList[0].imageUrlList.length > 0) {
                    $("#hidselectimg").val(dt.productPriceList[0].imageUrlList[0]);
                }
            }
            $("#hidcollection").val(dt.isCollection ? 1 : 0);
            if (dt.isCollection) {
                $("i", $("#div_collection")).addClass("collect-active").removeClass("collect");
            }
            if (data.cartCount == 0 || data.cartCount == undefined) {
                $("#cartTotalItemNum").hide();
            }
            $("#cartTotalItemNum").text(data.cartCount);
            if (data.productState == 3) {
                $("#cartAvailable").show();
                if (data.productPriceList.length > 0) {
                    if (data.productPriceList[0].quantity <= 0) {
                        $("#cartAvailable").hide();
                        $("#cartDisable").show();
                        $("#cartDisable button").show();
                        $("#cartDisable button").text("商品已售完");
                    } 
                }
            } else {
                $("#cartDisable").show();
                $("#cartDisable button").show();
            }
            var userinfo = new UserInfo();
            var locationurl = location.href.split('#')[0] + "&r=" + userinfo.recommendCode;
            var introduction = data.productIntroduction == "" ? data.productName: data.productIntroduction;
            //初始化分享参数
            $.wxShare.init(data.productName, introduction, locationurl, data.imageUrl);

            //轮播图lunbojs方法
            if (myswiper) {
                myswiper.destroy(false);
            }
            myswiper = new Swiper('.swiper-banner', {
                pagination: '.pagination-banner',
                paginationClickable: true,
                spaceBetween: 30,
                centeredSlides: true,
                autoplay: 4000,
                autoplayDisableOnInteraction: false
            });
        } else {
            layer.msg(msg);
        }
    });
}
loadInfo(); 
