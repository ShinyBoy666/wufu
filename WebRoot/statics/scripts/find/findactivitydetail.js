function Params() {
    this.aid = getQueryString("aid", 0);
}
function loadInfo() {
    var info = new Params();
    $.postSync("1103", { id: info.aid }, function (flag, msg, data) {
        if (flag === 1) {
            $(".content").bindModel(data, "tmp-model");
            $("#activitytitle").text(data.title);
        } else {
            layer.msg(msg);
        }
    });
}

function signup() {
    var userinfo = new UserInfo(1);
    var p = new Params();
    if (p.aid == 0) {
        layer.msg("活动无效");
        return false;
    }
    var json = {
        "customerId": userinfo.id,
        "activityId": p.aid,
    };
    $.postSync("1104", json, function (flag, msg, data) {
        if (flag === 1) {
            if (data) { 
                layer.alert('申请成功，客服会在1-3个工作日<br/>与您联系，请耐心等待！');
            } else {
                layer.msg("报名失败");
            }
        } else {
            layer.msg(msg);
        }
    });
}

$(function () {
    loadInfo();
});