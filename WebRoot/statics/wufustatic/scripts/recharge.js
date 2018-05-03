function change_pic() {
	var imgObj = document.getElementById("caocao_pic");
	var Flag = (imgObj.getAttribute("src", 2) == "/statics/wufustatic/images/0_1gouxuan.png")
	imgObj.src = Flag ? "/statics/wufustatic/images/0_2gouxuan_biankuang.png"
			: "/statics/wufustatic/images/0_1gouxuan.png";
}