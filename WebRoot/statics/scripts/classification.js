function checkcategory(t) {
    var cid = $(t).data("id");
    $(".menu").removeClass("active");
    $(t).addClass("active");
    $(".div_category").hide();
    $("#div_" + cid).show(); 
    var index = $(".menu").index($(t));
    $("#FirstCategory").animate({
        scrollTop: index*51
    },
    800); 
}

function opensearch() {
    //var keyword = $("#search").val();
    location.href = "productsearch.html?k=";
}

function searchcategory(t) {
    var cid = $(t).data("category");
    location.href = "productsearch.html?cid=" + cid;

}
function loadInfo() {
    var shop= new UserInfo(false);
    var shopid = shop.loginShopId;
    $.postJson("1054", { "shopId": shopid }, function (flag, msg, totaldata) {
        if (flag === 1) {
            var data = totaldata.list;
            var productCategoryLevel = totaldata.productCategoryLevel;
            if(totaldata.cartCount && totaldata.cartCount > 0){
            	$("#cartTotalItemNum").text(totaldata.cartCount);
            }else{
            	$("#cartTotalItemNum").hide();
            }
            if (productCategoryLevel == 3) {
                if (data.length > 0) {
                    $("#hidCategory_id").val(data[0].id);
                }
                $("#FirstCategory").bindSyncList(data, "tmp-list");
                $("#SecondCategory").bindSyncModel(data[0], "tmp-list-detail");
                if (data.length > 0) {
                    $("#div_" + data[0].id).show();
                }
                $("#SecondCategory").bindListAppend(data, "tmp-list-detail"); 
                $("#FirstCategory").css("height", $(window).height() - 110);
                $(".div_category").css("height", $(window).height() - 110);
            } else if (productCategoryLevel == 2) {
                if (data.length > 0) {
                    $("#hidCategory_id").val(data[0].id);
                }
                $("#FirstCategory").bindSyncList(data, "tmp-list");
                $("#SecondCategory").bindSyncModel(data[0], "tmp-list-detail-2");
                if (data.length > 0) {
                    $("#div_" + data[0].id).show();
                }
                $("#SecondCategory").bindListAppend(data, "tmp-list-detail-2");

                $("#FirstCategory").css("height", $(window).height() - 110);
                $(".div_category").css("height", $(window).height() - 110);
            } else if (productCategoryLevel == 1) { 
                $("#first_div").hide();
                $("#SecondCategory").bindModel(data, "tmp-list-detail-1");
                
            }
        } else {
            layer.msg(msg);
        }
    });
}
$(function () {
    loadInfo();


});


$(function () {
    //$("#search").keypress(function (event) {
    //    var code = event.keyCode;
    //    if (13 == code) {
    //        opensearch();
    //    }
    //});
});