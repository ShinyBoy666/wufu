
var p = new GetData();
var u = new UserInfo(1);
$(function () {
    if (p.isLayerOpen) {//作为layer.open()打开
        layerOpenBind();
    } else {
        bind();
    }
});

//绑定数据
function bind() {
    $("#id").val(p.id);
    if (p.id > 0) {
        $("#title").text("修改收货人");
        $("#btnDelete").show();
        $.postJson("1056", { id: p.id }, function (f, m, d) {
            $("#address").val(d.recipientAddress);
            $("#name").val(d.recipientName);
            $("#phone").val(d.recipientPhone);
            $("#province").data("val", d.provinceId);
            $("#city").data("val", d.cityId);
            $("#district").data("val", d.districtId);
            if (d.isDefault == 1) setDefault();
            //if (d.addressType === 1) {
            //    $("#jia").prop("checked", true);
            //} else {
            //    $("#gongsi").prop("checked", true);
            //}
            getSelect(1, 0, $("#province").data("val"), true);
        });
    } else {
        $("#btnDelete").hide();
        $("#title").text("新增收货人");
        getSelect(1, 0, $("#province").data("val"), true);
    }
}

//作为layer.open() 的绑定方法
function layerOpenBind() {
    $("#btnClose").show();
    $("#title").text("新增地址");
    getSelect(1, 0, $("#province").data("val"), true);
}

//layer.open()的子窗体关闭时
function winClose() {
    window.parent.choose(0);
}

//设置默认地址
function setDefault() {
    $("#btnSetDefault").toggleClass("setdown").toggleClass("setdown-icon").toggleClass("setup").toggleClass("setup-icon");
    $("#tip").toggleClass("red");
}
//获取基本数据
function GetData() {
    var flag = getQueryString("flag") || 0;
    this.id = getQueryString("id") || 0;
    this.isLayerOpen = parseInt(flag) > 0;
}
//选中行政区域
function getSelect(level, parentId, sid, isFirst) {
    if (level <= 2) $("#city option:gt(0)").remove();
    if (level <= 3) $("#district option:gt(0)").remove();
    parentId = parentId == undefined ? -1 : parentId;
    if (parseInt(parentId) === -1) return;

    sid = sid || -1;

    $.postJson("1057", { id: parentId }, function (f, m, d) {
        if (f === 1) {
            var province, city, district;
            if (isFirst) {
                province = $("#province").data("val");
                city = $("#city").data("val");
                district = $("#district").data("val");
            }
            if (level === 1) {
                d.unshift({ id: -1, regionName: "省份", selected: false });
                $("#province").bindSyncList(d, "tmp-province");
                $("#province option[value='" + sid + "']").prop("selected", true);
                getSelect(2, province || $("#province option:selected").val(), city || $("#city option:selected").val(), isFirst);

            } else if (level === 2) {
                if ($("#city option[value='-1']").length===0) d.unshift({ id: -1, regionName: "城市", selected: false });
                $("#city").bindSyncList(d, "tmp-city");
                $("#city option[value='" + sid + "']").prop("selected", true);
                getSelect(3, city || $("#city option:selected").val(), district || $("#district option:selected").val(), isFirst);
            } else if (level === 3) {
                if ($("#district option[value='-1']").length === 0) d.unshift({ id: -1, regionName: "区县", selected: false });
                $("#district").bindList(d, "tmp-district");
                $("#district option[value='" + sid + "']").prop("selected", true);
            }
            $("select").each(function () {
                if ($(this).find("option").length <= 0) $(this).hide();
                else $(this).show();
            });
        } else {
            layer.msg(m);
        }
    });
}
//保存
function save() {
    var json = $("#form1").serializeJson();
    if (!$.trim(json.recipientName)) return layer.msg("请输入联系人姓名");
    if (!$.trim(json.recipientPhone)) return layer.msg("请输入联系人手机号码");
    if (json.districtId <= 0) return layer.msg("请选择地址信息");
    if (!$.trim(json.recipientAddress)) return layer.msg("请输入地址信息");
    //if (!$.trim(json.addressType)) return layer.msg("请选择地址类型");
    if (!checkCellPhone(json.recipientPhone)) return layer.msg("手机号码格式不准确");
    json.customerId = u.id;
    json.isDefault = $("#btnSetDefault").hasClass("setup") ? 1 : 0;
    json.addressType = 1;
    json.id = p.id;
    var serviceCode = p.id > 0 ? 1014 : 1060;
    $.postJson(serviceCode, json, function (f, m, d) {
        layer.msg(m);
        setTimeout(function () {
            if (p.isLayerOpen) {
                window.parent.choose(d);
            } else {
                location.href = "addresslist.html";
            }
        }, 1000);
    });
}
//返回
function goBack() {
    if (p.isLayerOpen) {//作为layer.open()打开
        winClose();
    } else {
        location.href = "addresslist.html";
    }
}
//删除
function del() {
    layer.msg("确定删除？", {
        time: 0, //不自动关闭
        btn: ['删除', '再考虑'],
        yes: function (idx) {
            $.postJson("1017", { customerId: u.id, id: p.id }, function (f, m, d) {
                layer.msg(m);
                setTimeout(function () { location.href = "addresslist.html"; }, 1000);
            });
        }
    });
}