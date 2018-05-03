$(document).ready(function () {
    loadInfo();
    
    if(getCookie("customerId")){
    	var flag = getCookie("flag_first");
    	if(!flag){
    		huodong();
    		var exp = new Date();
    		exp.setTime(exp.getTime());
    		document.cookie = 'flag_first=1;expires=' + exp.toGMTString() + ";path=/";
    		setCookie("flag_first", "true", "d300");
    	}
    }
});
var user = new UserInfo();
//获取推广信息
function loadInfo() {
    $.postJson("1045", { customerId: 0 }, function (flag, msg, data) {
        if (flag === 1) {
            $("#friendlist").bindListAppend(data.list, "friend-list");
            $("#code").empty();
            $('#code').qrcode({
                render: 'canvas',
                text: toUtf8(data.url),
                height: 256,
                width: 256,
                //logo图片地址
                src: data.headSculpture
            });
            //wxshare(title, description, imgurl, locationurl) {
            var t = "邀请好友";
            var description = "我是" + user.nickname + "，现在邀请您加入舜凯云商享优惠咯，一般的小伙伴我还不告诉他呢！";
            var url = "http://wap.51shunkai.com/pages/1/share?c=" + user.id;
            var img = user.headSculpture || "http://wap.51shunkai.com/statics/img/image/logo.png";
            wxshare(t, description, img, url);
        } else {
            layer.msg(msg, {
                icon: 2,
                time: 2000
            });
        }
    });
}

function huodong() {
    layer.open({
        title: false,
        type: 1,
        area: ["86.6%"],
        skin: 'layui-layer-demo', //样式类名
        shift: 2,
        closeBtn: true,
        shadeClose: true, //开启遮罩关闭
        content: '<img id="huodong" onclick="goshare()" src="/statics/img/icon/huodong.png" width="100%" />'
    });
}

function goshare() {
	layer.closeAll();
    $("#J-guide").show();
}
function closeshare() {
    $("#J-guide").hide();
}