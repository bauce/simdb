layui.use([ 'element', 'layer'], function(exports) {
    var $ = layui.jquery;
    var element = layui.element;
    var layer = layui.layer;


    $(function() {
        $('#loginBt').on('click', function() {
            var code = $('#code').val();
            var username = $('#username').val();
            console.log(username);
            var password = $('#password').val();

            if ("" == username) {
                layer.alert("请输入用户名！");
                return false;
            } else if ("" == password) {
                layer.alert("请输入密码！");
                return false;
            }

                var i;
                $.ajax({
                    type:"post",
                    url:ctx+"/user/login",
                    data:{
                        username:username,
                        password:password
                    },
                    beforeSend:function(){
                        i=show_wait();
                    },
                    success:function(result){
                        if(result.code == 0){
                            console.log(result);
                            parent.location.href = ctx+'/user/index';
                            window.sessionStorage.setItem("userId",result.data);
                            close_wait(i);
                        }else if(result.code != 0){
                            layer.msg('用户名或密码错误', {icon:5, shade:[0.5, '#000000'], shadeClose:true});
                            close_wait(i);
                        }
                    },
                    error:function(){
                        layer.alert("获取数据失败！");
                    }
                });
                $("#username").val('');
                $("#password").val('');
                return false;

        });

    });

    function show_wait(){
        return layer.load(1, {shade: [0.5,'#000']});
    };

    function close_wait(index){
        layer.close(index);
    }


});
