$(function () {
	loadcontribute();
});

//获取贡献
function loadcontribute() {
	$.postJson("1121", {}, function (flag, msg, data) {
		$("#list").bindList("tmp-list");
    });
}