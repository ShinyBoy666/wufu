
function add() {
    var userinfo = new UserInfo(1);
    var title = $("#txtTitle").val();
    var description = $("#txtDescription").val();
    var smallMoney = $("#txtSmallMoney").val();
    var maxMoney = $("#txtMaxMoney").val();
    var linkName = $("#txtLinkName").val();
    var linkPosition = $("#txtLinkPosition").val();
    var linkPhone = $("#txtLinkPhone").val();
    var positioncategory = $("#hidpositioncategory").val();
    if (!$.trim(title)) return layer.msg("请输入标题");
    if (title.length > 20) return layer.msg("标题最多输入10个字");
    if (!$.trim(description)) return layer.msg("请输入描述");
    if (!$.trim(smallMoney)) return layer.msg("请输入最小金额");
    if (!$.trim(maxMoney)) return layer.msg("请输入最大金额");
    if (parseInt(smallMoney) > parseInt(maxMoney)) return layer.msg("最小金额不能大于最大金额");

    if (!$.trim(linkName)) return layer.msg("请输入联系人姓名");
    if (!$.trim(linkPosition)) return layer.msg("请输入联系人信息");
    if (!$.trim(linkPhone)) return layer.msg("请输入联系手机号");
    if (positioncategory == 0) return layer.msg("请选择信息类别");
    if (!checkCellPhone(linkPhone)) return layer.msg("请输入正确手机号");
    $("#hidimg1").val($("#img1").upImg());
    $("#hidimg2").val($("#img2").upImg());
    var img1 = $("#hidimg1").val();
    var img2 = $("#hidimg2").val();
    if (!$.trim(img1)) return layer.msg("请上传封面图");
    if (!$.trim(img2)) return layer.msg("请上传详情图");
    var json = {
        customerId: userinfo.id,
        categoryId: positioncategory,
        contactCellphone: linkPhone,
        contactName: linkName,
        contactPosition: linkPosition,
        description: description,
        maxSalary: maxMoney,
        minSalary: smallMoney,
        title: title,
        listImg: img1,
        detailsImg: img2
    };
    $.postSync("1106", json, function (flag, msg, data) {
        if (flag === 1) {
            if (data) {
                layer.alert('申请成功，客服审核需1-3个工作日<br/>请耐心等待！', function (index) {
                    location.href = "findpositionlist.html";
                    layer.close(index);
                });
            } else {
                layer.msg(msg);
            }
        } else {
            layer.msg(msg);
        }
    });
    return true;
}

function searchType(i) {
    if (i == 1) {
        $("#hidpositiontype").val(1);
        $(".search_icon").each(function () {
            $(this).removeClass("search_active_icon");
        });
        $("#positiontype_1").addClass("search_active_icon");
    } else {
        $("#hidpositiontype").val(2);
        $(".search_icon").each(function () {
            $(this).removeClass("search_active_icon");
        });
        $("#positiontype_2").addClass("search_active_icon");
    }
    loadtypes();
    $("#hidpositioncategory").val(0);
}

function searchCategory(i) {
    $(".positioncategory").each(function () {
        $(this).removeClass("search_active_icon");
    });
    $("#positioncategory_" + i).addClass("search_active_icon");

    $("#hidpositioncategory").val(i);
}

function Params() {
    this.type = $("#hidpositiontype").val();
    this.category = $("#hidpositioncategory").val();
    this.img1 = $("#hidimg1").val();
    this.img2 = $("#hidimg1").val();
}
function loadtypes() {
    var info = new Params();
    $.postSync("1116", { id: info.type }, function (flag, msg, data) {
        if (flag === 1) {
            $("#positiontypes").bindList(data, "tmp-model");
        } else {
            layer.msg(msg);
        }
    });
}

$(function () {
    
     
    loadtypes();
});