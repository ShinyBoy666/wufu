$(document).ready(function () {
    loadInfo();
});
//获取用户信息
function loadInfo() {
    var user = new UserInfo(1);

    $.postJson("1003", { searchCartCount: true, token: user.token }, function (flag, msg, data) {
        if (flag === 1) {
        	if(data.cartCount && data.cartCount > 0){
            	$("#cartTotalItemNum").text(data.cartCount);
        	}else{
            	$("#cartTotalItemNum").hide();
            }
            if (data.headSculpture !== "") {
                $("#headImg").attr("src", data.headSculpture);
            }
            $("#nickName").text(data.nickname);
            $("#serverPhone").attr("href", "tel:" + getCookie("serverPhone"));
//            if (data.customerCategory === "1") {
//                $("#upvip").show();
//                $("#vpn").hide();
//            } else {
//                $("#upvip").hide();
//                $("#vpn").show();
//            }
            var levelImg = "/statics/img/icon/dengji1.png";
            if (data.level) {
            	if(data.level > 1 && data.level < 5){
            		levelImg = "/statics/img/icon/dengji"+data.level+".png";
            	}else if(data.level >= 5){
            		levelImg = "/statics/img/icon/dengji5.png";
            	}
            }
            $("#vpn").attr("src",levelImg).show();
        } else {
            location.href = 'login.html';
        }
    });
}

//清除cookie
function clearCookie() {
    var keys = document.cookie.match(/[^ =;]+(?=\=)/g);
    if (keys) {
        var exp = new Date();
        exp.setTime(exp.getTime());
        for (var i = keys.length; i--;)
            document.cookie = keys[i] + '=0;expires=' + exp.toGMTString() + ";path=/";
    }
    layer.msg("成功退出");
    setTimeout(function () { location.href = "login.html"; }, 1500);
}