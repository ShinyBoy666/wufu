$(function () {
    var pageIdx = 1;
    var totalpages = 1;
    var ishave = true;
    var u = new UserInfo(0);

    $(function () {
        bind(1);
    });

    //首页定位头部
    //获取要定位元素距离浏览器顶部的距离
    //滚动条事件
    $(window).scroll(function () {
        //滚动条到网页头部的 高度，兼容ie,ff,chrome
        var top = document.documentElement.scrollTop + document.body.scrollTop;
        //网页的高度
        var textheight = $(document).height();
        // 网页高度-top-当前窗口高度
        if (textheight - top - $(window).height() <= 10) {
            if (pageIdx > totalpages) {
                return;
            }
            if (ishave)
                bind(pageIdx);
        }
    });

    //绑定初始化
    function bind(p) {
        ishave = false;
        pageIdx = p;
        $(".product-page .selecter").removeClass("selecter");
        $.postJson("1100", { customerId: u.id, currentPage: p, limit: 20 }, function (f, m, d) {
            if (f == 1) {
                totalpages = d.totalPage;
                if (pageIdx == 1) {
                    if (!d.list || d.list.length == 0) {
                        $("#nodata").show();
                    } else {
                        $("#nodata").hide();
                    }
                    $("#list").bindList(d.list, "tmp-list");
                } else {
                    $("#list").bindListAppend(d.list, "tmp-list");
                }
                pageIdx++;
            } else {
                layer.msg(m);
            }
            ishave = true;
        });
    }

    //取消添加小组
    $("#cancel").click(function () { layer.closeAll(); });

    //确定添加小组
    $("#submit").click(function () {
        var json = $("#addForm").serializeJson();
        if (json.name.length <= 0) return layer.msg("请填写小组名称");
        if (json.name.length > 20) return layer.msg("小组名称小于20个字符");
        if (json.description.length <= 0) return layer.msg("请填写小组介绍");
        if (json.description.length > 50) return layer.msg("小组介绍小于50个字符");
        var url = $("#img1").upImg();
        if (url) {
            json.icon = url;
            $.postJson("1108", json, function (f, m, d) {
                if (f == 1) {
                    layer.msg("创建小组成功");
                    layer.closeAll();
                    bind(1);
                } else {
                    layer.msg(m);
                }
            });
        } else {
            return layer.msg("请上传小组图片");
        }
    });

    //打开添加小组表单
    $(".add").click(function () {
        $.postJson("1119", { customerId: u.id, isGroup: true }, function (f, m, d) {
            if (f == 1) {
                if (d.isFindVip) {
                    if (d.surplusQuantity === 0) {
                        layer.confirm('您须购买创建小组的增值服务！', {
                            btn: ['去购买', '不购买'] //按钮
                        }, function () {
                            location.href = "../vipupgrade.html?q=3";
                        }, function () { });
                    } else {
                        layer.open({
                            title: false,
                            type: 1,
                            skin: 'layui-layer-demo', //样式类名
                            closeBtn: 0, //不显示关闭按钮
                            shift: 2,
                            area: ["90%", 'auto'],
                            content: $("#addPopo")
                        });
                    }
                } else {
                    layer.confirm('您须开通发现小组会员！', {
                        btn: ['去升级', '不升级'] //按钮
                    }, function () {
                        location.href = "../vipupgrade.html?q=2";
                    }, function () {
                        layer.closeAll();
                    });
                }
            } else {
                layer.msg(m);
            }
        });

    });
    $("#goback").click(function () {
        history.back();
    });

    $("#list").on("click", ".item", function () {
        var json = $(this).data("json");
        if (json.join) {
            location.href = 'msglist.html?id=' + json.id + '&n=' + json.name + '&c=' + json.customerId;
        }
        else {
            if (json.isFindVip) {
                layer.confirm('您确定要加入该小组！', {
                    btn: ['加入', '不加入'] //按钮
                }, function () {
                    $.postJson("1110", { customerId: u.id, groupId: json.id }, function (f, m, d) {
                        if (f == 1) {
                            location.href = 'msglist.html?id=' + json.id + '&n=' + json.name + '&c=' + json.customerId;
                        } else {
                            layer.msg(m);
                        }
                    });
                }, function () {
                    layer.closeAll();
                });
            } else {
                layer.confirm('您须开通发现小组会员！', {
                    btn: ['去升级', '不升级'] //按钮
                }, function () {
                    location.href = "../vipupgrade.html?q=2";
                }, function () {
                    layer.closeAll();
                });
            }
        }
    });
});
