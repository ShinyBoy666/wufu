var longitude = 0;
var latitude = 0;

$(document).ready(function () {
    $(".near-return-width a").click(function () {
        if ($("#search-box:visible").length > 0) {
            $("#search-box").hide();
        } else {
            location.href = "homepage.html";
        }
    });
    var keys = getCookie("searchkeys");
    if (keys) {
        keys = decodeURIComponent(keys);
        var json = $.parseJSON(keys);
        $("#keys").bindList(json, "tmp-keys");
        $("#history-seach").show();
    } else {
        $("#history-seach").hide();
    }
    $("#clearHistory").click(function() {
        delCookie("searchkeys");
        $("#history-seach").hide();
    });
    $(".search-key").on("click", "span", function () {
        $("#shopId").val($(this).text());
        $("#btnSearch").click();
    });
    $("#shopId").focus(function () {
        $("#search-box").show();
    });
    // 百度地图API功能
    var geolocation = new BMap.Geolocation();
    geolocation.getCurrentPosition(function (r) {
        if (this.getStatus() === BMAP_STATUS_SUCCESS) {
            //layer.msg('您的位置：' + r.point.lng + ',' + r.point.lat);
            longitude = r.point.lng;
            latitude = r.point.lat;
            loadInfo();
        } else {
            layer.msg('获取当前位置失败。' + this.getStatus());
        }
    }, { enableHighAccuracy: true });

    $(".nearBar li").click(function () {
        var sortType = $(this).index() + 1;
        loadInfo(sortType);
    });
});

//获取附近的店铺
function loadInfo(sortType) {
    sortType = sortType ? sortType : 1;
    var shopName = $.trim($("#shopId").val());
    $.postPager("1036", { limit: 10, longitude: longitude, latitude: latitude, shopName: shopName, sortType: sortType }, function (flag, msg, data, pageindex) {
        $("#search-box").hide();
        if (flag === 1) {
            if (pageindex > 1) {
                $("#shoplist").bindListAppend(data.list, "tmp-shoplist");
            } else {
                $("#shoplist").bindList(data.list, "tmp-shoplist");

                if (data.list.length > 0) {
                    if (shopName) {
                        var arr;
                        var keys = getCookie("searchkeys");
                        if (keys) {
                            keys = decodeURIComponent(keys);
                            arr = $.parseJSON(keys);
                        } else {
                            arr = [];
                        }
                        if (arr.indexOf(shopName)<0) {
                            arr.unshift(shopName);
                            keys = encodeURIComponent($.jsonToString(arr));
                            setCookie("searchkeys", keys, "d100");
                        }
                    }
                }
            }
            var swiper = new Swiper(".swiper-container", {
                slidesPerView: 5,
                spaceBetween: 10
            });
        } else {
            layer.msg(msg);
        }
    });
}
