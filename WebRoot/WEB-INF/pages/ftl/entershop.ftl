<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<meta name="format-detection" content="telephone=no">
	<link href="/statics/style/download.css" rel="stylesheet" />
</head>
<body>
	<div class="jph">
	<section id='main'>
    </section>
    <div id="logo">
    
	    <div class="quickpay-shop">
		<div id="nameCopy"style ="height:60px"><span id="shopname" >${(shopInfo.shopName)!!}</span></div>
	        <div class="quickpay-image">
	            <img id="shopImage" style ="width: 200px;" src="${(shopInfo.shopBossImage)!!}"/>
	        </div>
	        <div id="nameDesc">${(shopInfo.shopDescription)!!}</div>
	    <div id="buttonBtnAndroid" class="buttonBtn">
	        <a id="shopurl"  style="align:center;" href="http://wap.51shunkai.com/pages/${(shopInfo.id)!!}/homepage.html">
	            进入店铺
	        </a>
	    </div>
	
	    <div id="copy">上海舜凯信息科技有限公司<br /><span style='font-size:12px;'>&copy;版权所有</span></div>
    </div>
	</div>
</body>
</div>
</html>
