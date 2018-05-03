$(function () {
    var pageIdx = 1;
    var totalpages = 1;
    var ishave = true;
    var u = new UserInfo();
    var id = getQueryString("id");
    var cid = getQueryString("cid");
    bind(1);
    location.href = "#bottom";
    //更多消息
    $(".more").click(function () {
        if (pageIdx > totalpages) {
            $(".more").text("没有更多记录了");
            return;
        }
        if (ishave)
            bind(pageIdx);
    });

    //发送消息
    $(".btn-send").click(function () {
        var json = {
            customerId: u.id,
            content: $(".input-content").text(),
            id: id,
            toCustomerId:cid
        };
        if (json.content.length <= 0)return;
        $.postJson("1115", json, function (f, m, d) {
            if (f === 1) {
                var tpl = $("#tmp-list").html();
                $(".input-content").text("");
                var model =
                {
                    content: json.content,
                    createTime:new Date().getTime(),
                    headSculpture:u.headSculpture,
                    nickname:u.nickname,
                    customerId: u.id,
                    id: id,
                    'class':"send",
                    showTime:formatDate(new Date().getTime(), 2) != $.trim($(".time:last").text())
                }
                laytpl(tpl).render(model, function (render) {
                    $("#list").append(render);
                    location.href = "#bottom";
                });
            } else {
                layer.msg(m);
            }
        },0);
    });
    $("#goback").click(function() {
        history.back();
    });

    function bind(p) {
        ishave = false;
        pageIdx = p;
        $("#name,title").text(getQueryString('n', '聊天记录'));
        $.postJson("1114", { id: getQueryString("id"), toCustomerId: cid, customerId: u.id, currentPage: p, limit: 20 }, function (f, m, d) {
            if (f === 1) {
                totalpages = d.totalPage;
                for (var i = 0; i < d.list.length; i++) {
                    if (d.list[i].customerId == u.id) {
                        d.list[i].class = "send";
                    } else {
                        d.list[i].class = "receive";
                    }
                    d.list[i].showTime = formatDate(d.list[i].createTime, 2) != $.trim($(".time:first").text());
                        
                    if (i+1 < d.list.length) d.list[i].showTime = d.list[i].showTime && formatDate(d.list[i].createTime, 2) != formatDate(d.list[i + 1].createTime, 2);
                }
                if (pageIdx === 1) {
                    if (!d.list || d.list.length === 0) {
                        $("#nodata").show();
                    } else {
                        $("#nodata").hide();
                    }
                    $("#list > li").remove();
                    bindListPrepend(d.list, "tmp-list");
                } else {
                    bindListPrepend(d.list, "tmp-list");
                }
                pageIdx++;
            } else {
                layer.msg(m);
            }
            ishave = true;
        });
    }
});

function bindListPrepend(list, template) {
    if (!$.isArray(list)) return;
    var container = $("#list");
    var tpl = $("#" + template).html();
    for (var i = 0; i < list.length ; i++) {
        var d = list[i];
        d.$index = i;
        d.$length = list.length;
        laytpl(tpl).render(d, function (render) {
            container.prepend(render);
        });
    }
};