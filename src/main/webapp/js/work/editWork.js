layui.use([ 'form','layer','jquery','table','laydate'], function() {
    var layer = layui.layer, $ = layui.jquery, form = layui.form, table = layui.table, laydate = layui.laydate;
    $(".workId").val(parent.fdata.workId);
    $(".no").val(parent.fdata.no);
    $(".type").val(parent.fdata.type);
    $(".origin").val(parent.fdata.origin);
    $(".content").val(parent.fdata.content);
    $(".userId").val(parent.fdata.userId);
    $(".finished").val(parent.fdata.finished);

    if(null != parent.fdata.dueTimeAlt && '' !== parent.fdata.dueTimeAlt){
        $("input[name=time][value=0]").attr("checked","true");
        $(".dueTimeAlt").val(parent.fdata.dueTimeAlt);
        $(".dueTimeAlt").toggle();
        // form.render("radio");
    } else if (null != parent.fdata.dueTime && '' !== parent.fdata.dueTime){
        $("input[name=time][value=1]").attr("checked","true");
        $(".dueTime").val(formatTime(parent.fdata.dueTime,"yyyy-MM-dd"));
        $(".dueTime").toggle();
        // form.render("radio");
    }



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
    });
    $('#dp').removeAttr("disabled");
    $('#dp').val(parent.fdata.userId);
    // form.render('select');

    form.render();

    form.on("submit(updateWork)",function (data) {


        var type = $("select[name='type']").val();
        var origin = $.trim($(".origin").val());
        console.log(origin);
        var userId = $("select[name='userId']").val();
        var content = $.trim($("textarea[name='content']").val());
        var dueTime = $(".dueTime").val();
        var dueTimeAlt = $.trim($(".dueTimeAlt").val());

        console.log(dueTime,dueTimeAlt);

        if("" == type || null == type){
            layer.alert("工作类型不能为空！");
            return false;
        }else if("" == origin || null == origin){
            layer.alert("工作来源不能为空！");
            return false;
        }else if("" == userId || null == userId){
            layer.alert("责任单位不能为空！");
            return false;
        }else if("" == content || null == content){
            layer.alert("内容不能为空！");
            return false;
        }else if(("" == dueTime || null == dueTime)&&("" == dueTimeAlt || null == dueTimeAlt)){
            layer.alert("办结时限不能为空！");
            return false;
        }

        var index = top.layer.msg("数据提交中，请稍候",{icon: 16,time:false,shade:0.2});
        var  index1 = parent.layer.getFrameIndex(window.name);
        var msg,flag=false;

        $.ajax({
            type: "post",
            async: false,
            url: ctx+"/work/updateWork",
            data:data.field,
            dataType:"json",
            success:function(d) {
                if(d.code==0){
                    msg="更新工作成功！";
                    flag=true;
                }else {
                    msg = "更新工作失败！";
                }
            },
            error:function () {
                layer.msg("用户信息更新失败！",{icon:2});
                layer.closeAll();
                return false;
            }
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
        }, 2000);
        return false;
    })

});

// 格式化时间
function formatTime(datetime, fmt) {
    if (datetime == null || datetime == 0) {
        return "";
    }
    if (parseInt(datetime) == datetime) {
        if (datetime.length == 10) {
            datetime = parseInt(datetime) * 1000;
        } else if (datetime.length == 13) {
            datetime = parseInt(datetime);
        }
    }
    datetime = new Date(datetime);
    var o = {
        "M+" : datetime.getMonth() + 1, // 月份
        "d+" : datetime.getDate(), // 日
        "h+" : datetime.getHours(), // 小时
        "m+" : datetime.getMinutes(), // 分
        "s+" : datetime.getSeconds(), // 秒
        "q+" : Math.floor((datetime.getMonth() + 3) / 3), // 季度
        "S" : datetime.getMilliseconds()
        // 毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (datetime.getFullYear() + "")
            .substr(4 - RegExp.$1.length));
    for ( var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1,
                (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k])
                    .substr(("" + o[k]).length)));
    return fmt;
}

