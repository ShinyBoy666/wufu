var user = new UserInfo(1);
function exchange() {
    var feedback = $("#txtFeedback").val();
    if ($.trim(feedback) === "") {
        layer.msg("请输入反馈内容！");
        return;
    } else if ($.trim(feedback).length > 100) {
        layer.msg("最多输入100字！");
        return;
    } else {
        $.postJson("1059", { replyContent: feedback, fromType: 4, customerId: user.id }, function (flag, msg, data) {
            if (flag === 1) {
                layer.msg("感谢您的反馈！");
                setTimeout(function() {location.href='mypage.html' }, 1000);
            } else {
                layer.msg(msg);
            }
        });
    }
}