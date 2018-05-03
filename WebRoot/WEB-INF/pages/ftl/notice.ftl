<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<meta name="format-detection"  content="telephone=no">
	<title>${(notice.title)!''}</title>
	<link type="text/css" rel="stylesheet" href="${rc.contextPath}/asset/css/style.css">
	<#if flag>
		<style>
			.com-head {
			    background: #fff none repeat scroll 0 0;
			    border-bottom: 1px solid #ccc;
			    height: 45px;
			    left: 0;
			    line-height: 45px;
			    overflow: hidden;
			    position: fixed;
			    right: 0;
			    top: 0;
			    width: 100%;
			    z-index: 5;
			}
			.com-title-over {
			    width: 20%;
			}
			.display-box {
			    box-sizing: border-box;
			}
			.fl {
			    float: left;
			}
			.com-title-center {
			    width: 55%;
			}
			.ct {
			    text-align: center;
			}
			.rg {
			    text-align: right;
			}
			.fr {
			    float: right;
			}
			.com-head-left {
			    margin-left: 15px;
			}
			.com-head-title {
			    background: #fff none repeat scroll 0 0;
			}
			.code-ret {
			    background: rgba(0, 0, 0, 0) url("/statics/img/icon/return-icon.png") no-repeat scroll center center;
			    display: inline-block;
			}
			.code-ret-icon {
			    background-size: 10px 18px;
			    cursor: pointer;
			    height: 18px;
			    padding-top: 0;
			    vertical-align: middle;
			    width: 14px;
			}
			#head div ul li a {
			    font-size: 16px;
			}
			.com-head-right {
			    margin-right: 15px;
			}
			a, img, button, input, textarea, li, select, option {
			    border: medium none;
			    outline: medium none;
			}
			a, li {
			    list-style: outside none none;
			    text-decoration: none;
			}
			a, button {
			    color: #252525;
			    font-family: PingFangSC-Regular,Helvetica,"Droid Sans",Arial,sans-serif;
			}
			.article-container-padding {
			    padding-top:45px;
			}
			
		</style>
	</#if>
  </head>
  <body>
		<#if flag>
	  		<div class="com-fixed com-head" id="head">
				<div>
					<ul>
						<li onclick="history.back();" class="display-box fl com-title-over">
							<div class="com-head-left">
								<button class="com-head-title" type="button">
									<i class="code-ret code-ret-icon"></i>
								</button>
						    </div>
						</li>
						<li class="display-box fl com-title-center ct">
							<a class="com-head-title"><span>${(notice.title)!'消息详情'}</span></a>
						</li>
						<li class="display-box fr com-title-over rg">
							<span id="house-rule" class="com-head-right">
								<button class="com-head-title" type="button">
									<!--<span class="com-font-size-16" style="font-weight: 400;">确定</span>-->
								</button>
						    </span>
						</li>
					</ul>
				</div>
			</div>
	    </#if>
		<#--<header>
			<div class="article-title">${(video.title)!''}</div>
			<p class="article-date"><i></i><span><#if (notice.createTime)??>${notice.createTime?string("yyyy-MM-dd")}</#if></span></p>
		</header>-->
		<div class="article-container<#if flag> article-container-padding</#if>">
			${(notice.content)!''}
		</div>
  </body>
  <script src="${rc.contextPath}/statics/jquery/jquery-2.1.0.min.js"></script>
  <script>
  	//判断是否是微信
	function is_weixn() {
	    var ua = navigator.userAgent.toLowerCase();
	    if (ua.match(/MicroMessenger/i) == "micromessenger") {
	        return true;
	    } else {
	        return false;
	    }
	}
	//首页定位头部
	$(function () {
		if(is_weixn()){
			$("#head").hide().next().removeClass("article-container-padding");	
		}
	});
  </script>
</html>