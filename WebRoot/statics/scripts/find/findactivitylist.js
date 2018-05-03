
function showaddinfo() {
    var u = new UserInfo(1);
    $.postJson("1119", { customerId: u.id }, function (f, m, d) {
        if (f == 1) {
            if (d.isFindVip) {
                $("#login_div").show();

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
function hideaddinfo() {
    $("#login_div").hide();
}
function opendetails(t) {
    var aid = $(t).data("id");
    location.href = "findactivitydetail.html?aid=" + aid;
}

function signup() {
    var userinfo = new UserInfo(1);
    var title = $("#txtActivityName").val();
    var name = $("#txtName").val();
    var cellphone = $("#txtPhoneNum").val();
    var smsCode = $("#txtPhoneCode").val();
    if (!$.trim(title)) return layer.msg("请输入活动名称");
    if (title.length>20) return layer.msg("活动名称最多输入20个字");
    if (!$.trim(name)) return layer.msg("请输入姓名");
    if (name.length > 10) return layer.msg("姓名最多输入10个字");
    if (!$.trim(cellphone)) return layer.msg("请输入手机号码");
    if (!checkCellPhone(cellphone)) return layer.msg("请输入正确手机号码");
    if (!$.trim(smsCode)) return layer.msg("请输入验证码");
    var json = {
        "customerId": userinfo.id,
        "title": title,
        "name": name,
        "cellphone": cellphone,
        "smsCode": smsCode,
    };

    $.postSync("1102", json, function (flag, msg, data) {
        if (flag === 1) {
            if (data) { 
                layer.alert("申请成功，客服审核需1-3个工作日<br/>请耐心等待！");
                $("#login_div").hide();
            } else {
                layer.msg("申请失败");
            }
        } else {
            layer.msg(msg);
        }
    });
    return true;
}

//发送验证码
function getcode(dom) {
    var a = $(dom);
    if (a.text() == "获取验证码") {
        var phone = $("#txtPhoneNum").val();
        if (!$.trim(phone)) return layer.msg("请输入手机号码");
        if (!checkCellPhone($.trim(phone))) return layer.msg("请输入正确的手机号码");
        var time = 60;
        var t = setInterval(function () {
            time--;
            a.html(time + "秒后获取");
            a.css("background-color","#ccc");
            if (time == 0) {
                clearInterval(t);
                a.html("获取验证码");
                a.css("background-color", "#F59701");
            }
        }, 1000);
        $.postJson("1035", { cellphone: phone, type: 5 }, function (f, m, d) {
            layer.msg("获取成功");
        }, false);
    }
    return true;
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
    $.postSync("1101", json, function (flag, msg, datalist) {
        if (flag === 1) {
            if (pageIdx == 1) {
                if (!datalist.list || datalist.list == 0) {
                    $("#nodata").show();
                } else {
                    $("#nodata").hide();
                }
                $(".content").bindList(datalist.list, "tmp-model");
            } else {
                $(".content").bindListAppend(datalist.list, "tmp-model");
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