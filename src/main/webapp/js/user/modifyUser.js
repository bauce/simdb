layui.use([ 'form', 'layer' ], function() {
    var layer = layui.layer, $ = layui.jquery, form = layui.form;


    form.verify({
        password2: function (value) {
            var repassvalue = $('#password').val();
            if(null != repassvalue && ''!=repassvalue){
                if (value != repassvalue) {
                    return '两次输入的密码不一致!';
                }
            }

        }
    });

    form.on("submit(modifyUser)", function (data) {
        var index = layer.load(1, {
            shade: [0.5, '#000']
        });
        $.ajax({
            url: ctx + "/user/updateUser",
            type: "post",
            data: data.field,
            dataType: "json",
            success: function (data) {
                if (data.code == 0) {
                    layer.close(index);
                    layer.msg("修改成功!");
                } else {
                    layer.close(index);
                    layer.msg("修改失败，请重试！");
                }
            }
        });
        setTimeout(function () {
            //top.layer.closeAll("iframe");
            location.reload();
        }, 1000);
        return false;
    });

})