function imgOnload(t,i){
	if(t.height>t.width){
		if(i%2 == 0){
			var height = t.width-0.5;
			
		}else{
			var height = t.width+0.5;
		}
	}else if(t.height<t.width){
		var height = t.width-0.5;
	}
	$(t).attr("height0",height)
	.css('height',height);
}
function changeShowType(t) {
    if ($("#hidshowtype").val() == 1) {
        $(t).addClass("search-much-list").removeClass("search-much");
        $("#hidshowtype").val(0);
        loadjscssfile("/statics/style/productsearch.css", "css");
        $("img[height0]").each(function(){
        	$(this).css('height',$(this).attr("height0"));
        });
    } else {
        $("#hidshowtype").val(1);
        $(t).addClass("search-much").removeClass("search-much-list");
        removejscssfile("/statics/style/productsearch.css", "css");
        $("img[height0]").css("height","");
    }
}

function opendetails(t) {
    var pid = $(t).data("pid");
    location.href = "productdetail.html?pid=" + pid;
}

function Params() {
    this.id = getQueryString("mid", 0);
    this.title = getQueryString("title", "");
}

function loadlist() {
    var p = new Params();
    var json = {
        "id": p.id
    };
    if(p.title && p.title != '无'){
    	$("#activitytitle").text(p.title);
    }else{
    	$("#activitytitle").text("活动商品");
    }
    $.postSync("1055", json, function (flag, msg, datalist) {
        if (flag === 1) {
            $("#list_products").bindList(datalist, "tmp-list-products");
        } else {
            layer.msg(msg);
        }
    });
}


$(function () {
    loadlist();
});