

function openbanner(t) {
    var showtype = $(t).data("showtype");
    var objectid = $(t).data("objectid");
    var linkurl = $(t).data("linkurl");
    switch (showtype) {
        case 1:
            location.href = "../productdetail.html?pid=" + objectid;
            break;
        case 2:
            window.open(linkurl);
            break;
        default:
    }
}
function openactivitydetail(t) {
    var id = $(t).data("id");
    location.href = "findactivitydetail.html?aid=" + id;
}
function openpositiondetail(t) {
    var id = $(t).data("id");
    location.href = "findpositiondetail.html?id=" + id;
    
}

function showaddinfo() {
    var u = new UserInfo(1);
    $.postJson("1119", { customerId: u.id }, function (f, m, d) {
        if (f == 1) {
            if (d.isFindVip) {
                location.href = 'findpositionadd.html';
            } else {
                layer.confirm('您须开通发现会员！', {
                    btn: ['去开通', '不开通'] //按钮
                }, function () {
                    location.href = "../vipupgrade.html?q=2";
                });
            }
        } else {
            layer.msg(m);
        }
    });
}

function opengroupdetail(t) {
    var u = new UserInfo();
    if (u.isLogin) {
        var join = $(t).data("join");
        var isfindvip = $(t).data("isfindvip");
        var id = $(t).data("id");
        var customerId = $(t).data("customerid");
        var name = $(t).data("name");
        if (join) {
            location.href = 'msglist.html?id=' + id + '&n=' + name + '&c=' + customerId;
        } else {
            if (isfindvip) {
                layer.confirm('您确定要加入该小组！', {
                    btn: ['加入', '不加入'] //按钮
                }, function () {
                    $.postJson("1110", { customerId: u.id, groupId: id }, function (flag, msg, data) {
                        if (flag == 1) {
                            location.href = 'msglist.html?id=' + id + '&n=' + name + '&c=' + customerId;
                        } else {
                            layer.msg(msg);
                        }
                    });
                }, function () {
                    layer.closeAll();
                });

            } else {
                layer.confirm('您须开通发现会员！', {
                    btn: ['去开通', '不开通'] //按钮
                }, function () {
                    location.href = "../vipupgrade.html?q=2";
                });
            }
        }
    } else {
        layer.confirm('您还未登入！', {
            btn: ['去登入', '取消'] //按钮
        }, function () {
            location.href = "../login.html?url=" + encodeURIComponent(window.location.href);
        });
    }
}

function opennewdetail(t) {
    var u = new UserInfo();
    if (u.isLogin) {
        $.postJson("1119", { customerId: u.id }, function (f, m, d) {
            if (f == 1) {
                if (d.isFindVip) {
                    var cid = $(t).data("id");
                    location.href = 'chatmsg.html?cid=' + cid;
                } else {
                    layer.confirm('您须开通发现会员！', {
                        btn: ['去开通', '不开通'] //按钮
                    }, function () {
                        location.href = "../vipupgrade.html?q=2";
                    });
                }
            } else {
                layer.msg(m);
            }
        });
    } else {
        layer.confirm('您还未登入！', {
            btn: ['去登入', '取消'] //按钮
        }, function () {
            location.href = "../login.html?url=" + encodeURIComponent(window.location.href);
        });
    }

}


function loadInfo() {
    var userinfo = new UserInfo();
    $.postSync("1118", { "customerId": userinfo.id }, function (flag, msg, datalist) {
        var html = "";
        if (flag == 1) {
            var banners = datalist.bannerList;
            $("#bannercontent").bindSyncList(banners, "tmp-banner");
            $("#maincontent").bindModel(datalist, "tmp-model");
            var banner = new Swiper('.swiper-banner', {
                pagination: '.pagination-banner',
                paginationClickable: true,
                spaceBetween: 10,
                centeredSlides: true,
                autoplay: 4000,
                autoplayDisableOnInteraction: false
            });
            var swiper = new Swiper('.swiper-product', {
                pagination: '.product-pagination',
                slidesPerView: 3,
                paginationClickable: true,
                spaceBetween: 20,
                freeMode: true
            });

        } else {
            layer.msg(msg);
        }
    });
}

$(function () {
    loadInfo();
});