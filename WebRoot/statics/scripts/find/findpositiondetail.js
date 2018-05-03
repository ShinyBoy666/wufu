function Params() {
    this.id = getQueryString("id", 0);
}
function loadInfo() {
    var info = new Params();
    $.postSync("1107", { id: info.id }, function (flag, msg, data) {
        if (flag === 1) {
            $(".content").bindModel(data, "tmp-model");
        } else {
            layer.msg(msg);
        }
    });
}

$(function () {
    loadInfo();
});