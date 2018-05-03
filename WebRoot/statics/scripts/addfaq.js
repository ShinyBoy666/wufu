var user = new UserInfo(1);
function sumbitquestion() {
    var question = $("#txtquestion").val();
    if ($.trim(question) === "") {
        layer.msg("请输入反馈内容！");
        return;
    } else if ($.trim(question).length > 100) {
        layer.msg("最多输入100字！");
        return;
    } else {
        $.postJson("1122", { question: question, customerId: user.id }, function (flag, msg, data) {
            if (flag === 1) {
                layer.msg("提交成功，稍后会有工作人员帮您解答！");
                setTimeout(function () { location.href = "faqs.html" }, 1000);
            } else {
                layer.msg(msg);
            }
        });
    }
}