<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<meta name="format-detection"  content="telephone=no">
	<meta name="keywords" content="${(product.metaKeywords)!''}">
    <meta name="description" content="${(product.productIntroduction)!''}">
	<title>${(product.productName)!''}</title>
	<link type="text/css" rel="stylesheet" href="${rc.contextPath}/asset/css/style.css">
	<style type="text/css">
       img{vertical-align: middle;}
    </style>
  </head>
  <body>
	    <div class="wrap">
			<div class="article-container" style="padding:0;">
				${(productDetatil.description)!''}
			</div>
		</div>
  </body>
</html>