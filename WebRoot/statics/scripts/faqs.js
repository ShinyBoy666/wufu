$(document).ready(function () {
    var id = getQueryString("t");
    if (id == 1) {
        $("#head").hide();
        $("#overhead").hide();
        $("#divsearch").show();
        $("#qa").attr("style", "padding-top: 30px");
    } else {
        $("#divsearch").hide();
        $("#head").show();
        $("#overhead").show();

    }
    //$.postJson("1117", { id: 6 }, function (f, m, d) {
    //    if (f === 1) {
    //        $("#qa").html(d);
    //    } else {
    //        layer.msg(m);
    //    }

    //});
    bind(1);
});
var pageIdx = 1;
var totalpages = 1;
var ishave = true;
var u = new UserInfo();
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
                bind(pageIdx);
        }
    });
});
function bind(idx) {
    ishave = false;
    var id = getQueryString("t");
    var question;
    if (id == 1) {
        question = $("#txtkeyword2").val();
    } else {
        question = $("#txtkeyword").val();
    }
    $.postJson("1121", { currentPage: idx, limit: 10, question: question }, function (f, m, d) {
        totalpages = d.totalPage;
        if (d.totalPage == 0) {
            $("#nodata").show();
        } else {
            $("#nodata").hide();
        }
        if (pageIdx == 1) {
            $("#list").bindList(d.list, "tmp-list");
        }
        else {
            $("#list").bindListAppend(d.list, "tmp-list");
        }
        pageIdx++;
        ishave = true;
    });
}

function search() {
    var id = getQueryString("t");
    if (id == 1) {
        if ($.trim($("#txtkeyword2").val()) == "") {
            layer.msg("请输入内容");
            return;
        }
    } else {
        if ($.trim($("#txtkeyword").val()) == "") {
            layer.msg("请输入内容");
            return;
        }
    }
    pageIdx = 1;
    bind(1);
}