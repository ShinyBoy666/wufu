<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="format-detection" content="telephone=no">
    <title>邀请好友</title>
    <link type="text/css" rel="stylesheet" href="${rc.contextPath}/asset/css/auto_combine_ff48f_6a9bfef.css">
</head>
<body no-copyright="1" style="background-color: #f1f1f1;">
<div class="jph">
    <div class="wrap">
    	<section style="height:50px;"></section>
        <#--<section class="logo">
            <div class="logo-des" <#if (shop.shopLogo)?? && shop.shopLogo != ''>style="background-image: url('${shop.shopLogo}');"</#if>></div>
        </section>-->
        <section class="share-user">
            <div class="img-container">
                <div class="img-wrap" style="background-image: url('${(user.headSculpture)!"http://wap.51shunkai.com/statics/images/jph001.jpg"}');"></div>
            </div>
            <p class="user-name">${(user.nickname)!!}</p>
            <p class="user-name"><#if (user.cellphone)??>（<#list 1 .. user.cellphone?length as item><#if item gt 3 && item lt 8>*<#else>${user.cellphone?substring(item-1,item)}</#if></#list>）</#if></p>
            <p class="share-des">邀请您加入${(shop.shopName)!!}</p>
        </section>
        <section class="phone-panel">
            <div class="input-wrap">
                <label style="background-image: url('${rc.contextPath}/statics/img/icon/phone.png');"></label>
                <input id="cellphone" type="tel" placeholder=" 请输入您的手机号码" />
                <input id="recommendCode" type="hidden" value="${(user.recommendCode)!!}" />
                <button id="phonecode" style="border-radius:60px;padding:2px 6px;background-color:#a3a3a3;color:#fff;" type="button" onclick="GetVerificationCode()">获取验证码</button>
            </div>
            <div class="input-wrap">
                <label style="background-image: url('${rc.contextPath}/statics/img/icon/yanzhengma.png');"></label>
                <input id="verificationcode" type="number" placeholder=" 请输入验证码" />
            </div>
            <div>
                <button id="registerSubmit" class="btnl" onclick="URegister();">确认</button>
            </div>
        </section>
    </div>
    </div>
</body>
<script src="${rc.contextPath}/statics/jquery/jquery-2.1.0.min.js"></script>
<script src="${rc.contextPath}/statics/layer/layer.js"></script>
<script src="${rc.contextPath}/statics/jquery/extend/jquery-extend.js"></script>
<script src="${rc.contextPath}/statics/scripts/common.js"></script>
<#--<script src="${rc.contextPath}/statics/scripts/register.js"></script>-->
<script>
var validCode = true;
function GetVerificationCode() {
    var m = $("#cellphone").val();
    if ($.trim(m) == "") {
        layer.msg("请输入手机号码！", {
            icon: 2,
            time: 2000
        });
        return;
    }
    if (!m.match(/^13[0-9]{9}$|14[0-9]{9}|17[0-9]{9}|15[0-9]{9}$|18[0-9]{9}$/)) {
        layer.msg("手机号不正确！", {
            icon: 2,
            time: 2000
        });
        return;
    }
    GetSmsCode(m);
    var time = 60;
    var btn = $("#phonecode");
    if (validCode) {
        validCode = false;
        btn.prop("disabled", "disabled");
        var t = setInterval(function () {
            time--;
            btn.html(time + "秒后重新获取");
            if (time == 0) {
                clearInterval(t);
                btn.html("重新获取");
                validCode = true;
                btn.removeAttr("disabled");
            }
        }, 1000);
    }
}
function GetSmsCode(m) {
	var url = window.location.pathname.replace("/pages/", "");
    var shopId = url.substring(0, url.indexOf('/'));
    $.postJson("1043", { cellphone: m, shopId: shopId }, function (flag, msg, data) {
        if (flag == 1) {
            if (data) {
                layer.msg("已发送", {
                    icon: 1,
                    time: 2000
                });

            } else {
                layer.msg(msg, {
                    icon: 2,
                    time: 2000
                });
            }
        } else {
            layer.msg(msg, {
                icon: 2,
                time: 2000
            });
        }
    });
}

function URegister() {
    var m = $("#cellphone").val();
    if ($.trim(m) == "") {
        layer.alert("请输入手机号码！");
        return;
    }
    if (!m.match(/^13[0-9]{9}$|14[0-9]{9}|17[0-9]{9}|15[0-9]{9}$|18[0-9]{9}$/)) {
        layer.alert("手机号不正确");
        return;
    }
    var c = $("#verificationcode").val();
    if ($.trim(c) == "") {
        layer.alert("请输入验证码！");
        return;
    }
    var url = window.location.pathname.replace("/pages/", "");
    var shopId = url.substring(0, url.indexOf('/'));
    layer.load(2);
    $.ajax({
        url: "${rc.contextPath}/register.htm",
        type: "post",
        dataType: "json",
        async: true,
        data: {"inviteCode": $("#recommendCode").val(), "loginName": m, "shopId": shopId, "smsCode": c },
        success: function (rst) {
//        	var downloadurl = "http://wap.51shunkai.com/pages/"+shopId+"/download.html";
//        	var downloadurl = "http://wap.51shunkai.com/pages/"+shopId+"/entershop.html";
        	var downloadurl = "${rc.contextPath}/entershop?id="+shopId;
        	if(rst){
        		var message = rst.message || '';
        		if(rst.success == 1){
        			var user = rst.user;
        			if(user){
	        			setCookie("UserInfo", $.jsonToString(user), "d100");
	        			if(user.token){
	            			setCookie("token", user.token, "d100");
	        			}
        			}
	        		layer.msg('登录成功', {
		                icon: 1,
		                time: 1000
		            }, function () {
		                location.href = downloadurl;
		            });
        		}else if(rst.success == 2){
        			layer.alert(message,{
						title:"邀请失败",
						skin: 'layui-layer-lan',
						shift: parseInt(Math.random()*7+0),
				  		closeBtn: 0
					}, function(){
						location.href = downloadurl;
					});
        		}else{
    				layer.msg(message, {
		                icon: 2,
		                time: 2000
		            });
        		}
        	}
        	layer.closeAll('loading');
        },
        error: function (msg) {
            layer.msg("请求出错，请检查网络" + JSON.stringify(msg));
            layer.closeAll('loading');
        }
    });
}
</script>
</div>
</html>
