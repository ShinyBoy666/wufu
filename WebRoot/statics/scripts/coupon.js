$(document).ready(function () {
    loadInfo(1);
});
var pageIdx = 1;
var totalpages = 1;
var ishave = true;
//首页定位头部
$(function () {
    //获取要定位元素距离浏览器顶部的距离
    //滚动条事件
    $(window).scroll(function () {
        //滚动条到网页头部的 高度，兼容ie,ff,chrome
        var top = document.documentElement.scrollTop + document.body.scrollTop;
        //网页的高度
        var textheight = $(document).height();
        // 网页高度-top-当前窗口高度
        if (textheight - top - $(window).height() <= 10) {
            if (pageIdx > totalpages) {
                return;
            }
            if (ishave)
                loadInfo(pageIdx);
        }
    });
});

var user = new UserInfo();
//获取优惠券列表
function loadInfo(num) {
    ishave = false;
    $.postJson("1031", { couponState: 0, currentPage: num, customerId: 0, id: 0, limit: 10, shopId: user.loginShopId }, function (flag, msg, data) {
        if (flag === 1) {
            pageIdx++;
            totalpages = data.totalPage;
            if (data.totalPage == 0) {
                $("#nodata").show();
            }
            $(".conpon-list").bindListAppend(data.list, "tmp-list");
        } else {
            layer.msg(msg, {
                icon: 2,
                time: 2000
            });
        }
        ishave = true;
    });
}

function CloseForm() {
    layer.closeAll();
}
function exchange() {
    var code = $("#couponcode").val();
    if ($.trim(code) === "") {
        layer.msg("请输入优惠券码！", {
            icon: 2,
            time: 2000
        });
        return;
    }
    $.postJson("1053", { couponCode: code, customerId: 0, shopId: user.loginShopId }, function (flag, msg, data) {
        if (flag === 1) {
            var content = "您已成功换一张" + data.couponMoney + "元优惠券,有效期至" + formatDate(data.endTime);
            $("#licontent").html(content);
            layer.open({
                type: 1,
                title: false,
                closeBtn: 0,
                shadeClose: true,
                area: ['100%', '100%'], //宽高
                skin: 'layui-layer-rim',
                content: $("#coupontip")
            });
            loadInfo(1);
        } else {
            layer.msg(msg, {
                icon: 2,
                time: 2000
            });
        }
    });
}