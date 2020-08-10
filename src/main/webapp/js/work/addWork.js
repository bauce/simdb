layui.config({
    base: '../js/'
}).extend({
    xmSelect: 'xm-select'
}).use([ 'form','layer','jquery','laydate','xmSelect'], function() {
    var layer = parent.layer === undefined ? layui.layer : parent.layer,
        laypage = layui.laypage,laydate = layui.laydate,xmSelect = layui.xmSelect;
        $ = layui.jquery,
        form = layui.form;

    form.on("radio(time)",function(data){
        $(".dueTime").toggle();
        $(".dueTimeAlt").toggle();
        $(".dueTime").val('');
        $(".dueTimeAlt").val('');
    })

    laydate.render({
        elem : '.dueTime',
        type : 'date',
        trigger: 'click'/*,
        done : function(value, date) {
            console.log(value);
        }*/
    })

    $.each(parent.userListData, function(index, item) {
        $('#dp').append(new Option(item.username, item.userId));
        $('#dp').removeAttr("disabled");
    });
    form.render("select");

    /*$.ajax({
        type: "post",
        url: ctx+"/user/getUserList",
        async:false,
        dataType:"json",
        success:function(d){
            if(0==d.code){
                $.each(d.data, function(index, item) {
                    $('#dp').append(new Option(item.username, item.id));
                    $('#dp').removeAttr("disabled");
                });
                form.render("select");
            }else {
                layer.msg(d.message);
            }
        }}
    );*/



    form.on("submit(addWork)",function(data){

        var type = $("select[name='type']").val();
        var origin = $('.origin').val()
        var userId = $("select[name='userId']").val();
        var content = $.trim($("textarea[name='content']").val());
        var dueTime = $('.dueTime').val();
        var dueTimeAlt = $('.dueTimeAlt').val();

        if("" == type || null == type){
            layer.alert("工作类型不能为空！");
            return false;
        }else if("" == origin || null == origin){
            layer.alert("工作由来不能为空！");
            return false;
        }else if("" == userId || null == userId){
            layer.alert("责任单位不能为空！");
            return false;
        }else if("" == content || null == content){
            layer.alert("内容不能为空！");
            return false;
        }else if(("" == dueTime || null == dueTime)&&("" == dueTimeAlt || null == dueTimeAlt)){
            $("input[name=time][value=0]").attr("checked","true");
            $(".dueTimeAlt").toggle();
            $('.dueTimeAlt').val('时间未明确');
            return false;
    }



        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.2});
        var index1 = parent.layer.getFrameIndex(window.name);
        var msg,flag=false;
        $.ajax({
            type: "post",
            url: ctx+"/work/insertWork",
            async:false,
            data:data.field,
            dataType:"json",
            success:function(d){
                if(d.code==0){
                    msg="工作添加成功！";
                    flag=true;
                    $("#auf")[0].reset();
                }else{
                    msg=d.msg;
                }
            },
            error:function(){
                layer.msg("用户信息更新失败！",{icon:2});
                layer.closeAll();
                return false;
            }

        });
        setTimeout(function () {
            parent.layui.table.reload('workList',{page:{curr:$(".layui-laypage-em").next().html()}});
            top.layer.close(index);
            if(flag){
                top.layer.msg(msg,{icon: 1});
            }else{
                top.layer.msg(msg,{icon: 5});
            }
            /*parent.location.reload();*/
            parent.layui.table.reload('workList',{page:{curr:$(".layui-laypage-em").next().html()}});
        },1000);
        return false;
    });

    /*var demo1 = xmSelect.render({
        el: '#demo1',
        language: 'zn',
        data: [
            {name: '张三', value: 1},
            {name: '李四', value: 2},
            {name: '王五', value: 3},
        ]
    })*/

});
