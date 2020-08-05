var $,tab;
layui.config({
    base: '../js/' //你存放新模块的目录，注意，不是layui的模块目录
}).use(['bodyTab', 'form', 'element', 'layer', 'jquery' ,'laytpl'], function() {
    $ = layui.jquery;
    var element = layui.element;
    var layer = layui.layer;
    var form = layui.form;
    var laytpl = layui.laytpl;


    var data = parent.fdata;
    $(".content").val(data.content);

    if (null != data.info){
        $(".info").val(data.info.info);
        $(".finished").val(data.info.finished);
        $('.workInfoId').val(data.info.workInfoId);
        form.render('select');
    }


    laytpl($("#typeTpl").html()).render({
        type: data.type
    }, function(string){
        $(".type").val(string);
    });

    /*$.ajax({
        type: "post",
        url: ctx+'/info/getLastInfoByWorkId',
        data: {
            wid : data.workId
        },
        async:false,
        dataType:"json",
        success:function(d) {
            if (0 == d.code){
                infoData = d.data;
                if(d.data.length != 0){
                    $(".info").val(d.data[0].info);
                    $(".finished").val(d.data[0].finished);
                    $('.workInfoId').val(d.data[0].workInfoId);
                    form.render('select');
                }
            }
        }
    });*/




    form.on("submit(noPass)",function (obj) {
        if("" == $('.finished').val() || null == $('.finished').val()){
            layer.alert("是否办结不能为空！");
            return false;
        }else if("" == $.trim($('.info').val()) || null == $.trim($('.info').val())){
            layer.alert("推进情况不能为空！");
            return false;
        }

        var index = top.layer.msg("数据提交中，请稍候",{icon: 16,time:false,shade:0.2});
        var  index1 = parent.layer.getFrameIndex(window.name);

        var msg,flag=false;
        $.ajax({
            type: "post",
            url: ctx + "/info/updateInfo",
            async: false,
            dataType: "json",
            data:{
                workInfoId:$('.workInfoId').val(),
                finished:$('.finished').val(),
                info:$('.info').val(),
                status:3 /*不通过*/
            },
            success:function (result) {
                if(result.code == 0) {
                    msg = "审核成功";
                    flag = true;
                    /*$(obj.tr).children('td').eq(7).html('暂存');*/
                }else {
                    msg = "审核失败！";
                }
            },
            error:function () {
                layer.msg("提交失败")
                layer.closeAll();
                return false;
            }/*,
            end:function () {
                parent.layui.table.reload('workList',{page:{curr:$(".layui-laypage-em").next().html()}});
            }*/
        });
        setTimeout(function () {
            parent.layui.table.reload('workList',{page:{curr:$(".layui-laypage-em").next().html()}});
            parent.layer.close(index1);
            top.layer.close(index);
            if(flag){
                top.layer.msg(msg,{icon: 1});
            }else{
                top.layer.msg(msg,{icon: 5});
            }
            /*parent.location.reload();*/
        }, 1000);
        return false;
    });

    form.on("submit(pass)",function (obj) {
        if("" == $('.finished').val() || null == $('.finished').val()){
            layer.alert("是否办结不能为空！");
            return false;
        }else if("" == $.trim($('.info').val()) || null == $.trim($('.info').val())){
            layer.alert("推进情况不能为空！");
            return false;
        }

        var index = top.layer.msg("数据提交中，请稍候",{icon: 16,time:false,shade:0.2});
        var  index1 = parent.layer.getFrameIndex(window.name);

        var msg,flag=false;
        $.ajax({
            type: "post",
            url: ctx + "/info/updateInfo",
            async: false,
            dataType: "json",
            data:{
                workInfoId:$('.workInfoId').val(),
                finished:$('.finished').val(),
                info:$('.info').val(),
                status:4 /*通过*/
            },
            success:function (result) {
                if(result.code == 0) {
                    msg = "审核成功!";
                    flag = true;
                    /*$(obj.tr).children('td').eq(7).html('暂存');*/
                }else {
                    msg = "审核失败！";
                }
            },
            error:function () {
                layer.msg("提交失败")
                layer.closeAll();
                return false;
            }/*,
            end:function () {
                parent.layui.table.reload('workList',{page:{curr:$(".layui-laypage-em").next().html()}});
            }*/
        });
        setTimeout(function () {
            parent.layui.table.reload('workList',{page:{curr:$(".layui-laypage-em").next().html()}});
            parent.layer.close(index1);
            top.layer.close(index);
            if(flag){
                top.layer.msg(msg,{icon: 1});
            }else{
                top.layer.msg(msg,{icon: 5});
            }
            /*parent.location.reload();*/
        }, 1000);
        return false;
    });


    /*laytpl($("#doneTpl").html()).render({
        finished: data.finished
    }, function(string){
        $(".finished").val(string);
    });*/
    function show_wait(){
        return layer.load(1, {shade: [0.5,'#000']});
    };

    function close_wait(index){
        layer.close(index);
    }


});
