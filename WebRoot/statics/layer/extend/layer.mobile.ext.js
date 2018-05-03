layer.msg= function(msg) {
    //layer.open({
    //    content: msg,
    //    style: 'background-color:#fff; color:#fff; border:none;'
    //});
    layer.open({
        title: [
          '我是标题',
          'background-color:#8DCE16; color:#fff;'
        ],
        content: '标题风格任你定义。。'

    });
    return false;
}