$(function () {
    $("#groupName").text(getQueryString("n"));
    $(".imgs img").load(function () {
        var idx = $(this).parents(".item").index() + 1;
        var src = $(this).upImg();
        $("#img" + idx).val(src);
    });
    var u = new UserInfo(1);
    $(".add").click(function () {
        var json = $("#form1").serializeJson();
        json.groupId = getQueryString("id");
        json.customerId = u.id;
        if (json.content.length <= 0) return layer.msg("请填写动态内容");
        if (json.content.length > 500) return layer.msg("动态内容小于500个字符");
        $.postJson("1111", json, function (f, m, d) {
            if (f === 1) {
                layer.msg("您的动态内容正在审核中");
                setTimeout(function () {
                    layer.closeAll();
                    location.href = "msglist.html?id=" + getQueryString("id") + "&n=" + getQueryString("n")+"&c="+getQueryString("c");
                }, 1000);
            } else {
                layer.msg(m);
            }
        });
    });
    $("#goback").click(function () {
        history.back();
    });
});