
var u = new UserInfo(1);
$(function () {
    bind();
});
//绑定数据
function bind() {
    $.postJson("1015", { customerId: u.id, currentPage: 1, limit: 1000 }, function (f, m, d) {
        $("#list").bindList(d.list, 'tmp-list');
        if (d.list.length==0) {
            $("#nodata").show();
        }
    });
}
//设置默认
function setDefault(id) {
    $.postJson("1016", { customerId: u.id, id:id }, function (f, m, d) {
        if (f == 1) {
            bind();
        }
        layer.msg(m);
    });
}
//编辑
function edit(id) {
    location.href = "address.html?id="+id;
}
//删除
function del(id) {
    layer.msg("确定删除？", {
        time: 0, //不自动关闭
        btn: ['删除', '再考虑'],
        yes: function (idx) {
            $.postJson("1017", { customerId: u.id, id: id }, function (f, m, d) {
                layer.msg(m);
                setTimeout(function () {
                    bind();
                }, 1000);
            });
        }
    });
}
//添加
function add() {
    location.href = "address.html";
}