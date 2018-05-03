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

 

function opendetails(t) {
    var id = $(t).data("id");
    location.href = "findpositiondetail.html?id=" + id;
   
}

function Params() {
    this.currentPage = pageIdx;
    this.limit = 10;
}
function loadlist() {
    var p = new Params();
    var json = {
        "currentPage": p.currentPage,
        "limit": p.limit
    };
    ishave = false;
    $.postSync("1105", json, function (flag, msg, datalist) {
        if (flag === 1) {
            if (!datalist.list || datalist.list == 0) {
                $("#nodata").show();
            } else {
                $("#nodata").hide();
            }
            if (pageIdx == 1) {
                $("#positionlist").bindList(datalist.list, "tmp-model");
            } else {
                $("#positionlist").bindListAppend(datalist.list, "tmp-model");
            }
            pageIdx++;
            totalpages = datalist.totalPage;
        } else {
            layer.msg(msg);
        }
        ishave = true;
    });
}
var pageIdx = 1;
var totalpages = 1;
var ishave = true;
//首页定位头部
$(function () {
    //获取要定位元素距离浏览器顶部的距离
    //滚动条事件
    $(window).scroll(function () {
        setTimeout(onScroll, 300);

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
                loadlist(pageIdx);
        }
    });
});

var scrollTimer = null;
function onScroll() {//滚动加载
    clearTimeout(scrollTimer);
    scrollTimer = setTimeout(function () {
        //返回顶部
        if ($(window).scrollTop() > 100) {
            $("#back-to-top").fadeIn(500);
        }
        else {
            $("#back-to-top").fadeOut(500);
        }

    }, 100);
}
$(function () {
    loadlist();
});