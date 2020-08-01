var fdata,userListData;
layui.use([ 'form','layer','jquery','table','laydate'], function() {
    var layer = layui.layer, $ = layui.jquery, form = layui.form,table=layui.table,laydate = layui.laydate;


    $("body").on('click','.layui-table-body tr ',function () {
        var data_index=$(this).attr('data-index');//得到当前的tr的index
        $(".layui-table-body tr").attr({"style":"background:#FFFFFF"});//其他tr恢复颜色
        $(".layui-table-body tr[data-index="+data_index+"]").attr({"style":"background:#99ff99"});//改变当前tr颜色

    });

    active = {
        search : function(){
            var type = $('#type option:selected').val();
            var finished = $('#finished option:selected').val();
            var status = $('.status option:selected').val();
            var userId = $('#dp option:selected').val();


            table.reload('workList',{
                page : {
                    curr : 1
                },
                where : {
                    type : type,
                    finished : finished,
                    status: status,
                    userId: userId
                    /*username : username.val(),*/

                }
            });
        }
    };


    //获取用户名和id，装入下拉菜单，并存入全局变量
    $.ajax({
        type: "post",
        url: ctx+"/user/getUserList",
        async:false,
        dataType:"json",
        success:function(d){
            if(0==d.code){
                userListData = d.data;
                $.each(d.data, function(index, item) {
                    $('#dp').append(new Option(item.username, item.userId));
                    $('#dp').removeAttr("disabled");
                });
                form.render("select");
            }else {
                layer.msg(d.message);
            }
        }}
    );


    table.render({
        id:'workList'
        ,elem: '#workList'
        ,url: ctx+'/work/getWorkWithLastInfo'// 数据接口
        ,toolbar : true
        ,limit:10// 每页默认数
        ,limits:[10,20,30,40]
        ,cols: [[ // 表头
            {field:'no',title:'编号',align:'center',templet : '<div>{{ d.no}}</div>',hide:true,width:60},
            /*{field:'workInfoId',title:'编号',align:'center',templet : '<div>{{ d.info.workInfoId}}</div>',hide:true,width:60},*/
            {field:'type',title:'类型',align:'center',templet : '#typeTpl',width:150},
            {field:'content',title:'督办内容',align:'center',width:250},
            {field:'origin',title:'督办依据',align:'center',width:150},
            {field:'userId',title:'责任科室',align:'center',templet : '#userTpl',width:120},
            {field:'dueTime',title:'截止时间',align:'center',templet : '#timeTpl',width:102},
            {field:'finished',title:'是否办结',align:'center',templet : '#doneTpl',width:87},
            {field:'info',title:'最新进度',align:'center',templet : '#infoTpl',width:87},
            {field:'status',title:'审核状态',align:'center',templet : '#statusTpl',width:87},
            {field: 'progress', title: '审核进度', align: 'center', toolbar: "#barDemo",width:150}
        ]]
        ,page: true // 开启分页
        ,loading:true
        ,where: {timestamp: (new Date()).valueOf()}
    });


    table.on('tool(workList)', function (obj) {
        var data = obj.data;
        console.log(data);
        if (obj.event === 'review') {
            layer.msg('审核通过？', {
                time: 0
                , btn: ['通过', '不通过','取消']
                , yes: function (index) {
                    $.ajax({
                        type: "post"
                        ,url: ctx + "/info/reviewInfo"
                        ,data:{
                            workInfoId:data.info.workInfoId,
                            status:4
                        },
                        success:function (d) {
                            if (d.code == 0) {
                                layer.msg("审核成功！",{icon: 1});
                                $(obj.tr).children('td').eq(9).html('已通过通过');
                                $(obj.tr).children('td').eq(10).html('请等待');
                                obj.update({
                                    status:4
                                });
                            } else {
                                layer.msg("审核失败！", {
                                    icon : 5
                                });
                            }
                        }
                    })
                }, btn2: function (index) {
                    $.ajax({
                        type: "post"
                        ,url: ctx + "/info/reviewInfo"
                        ,data:{
                            workInfoId:data.info.workInfoId,
                            status:3
                        },
                        success:function (d) {
                            if (d.code == 0) {
                                layer.msg("审核成功！",{icon: 1});
                                $(obj.tr).children('td').eq(9).html('未通过');
                                $(obj.tr).children('td').eq(10).html('请等待');
                                obj.update({
                                    status:3
                                });
                            } else {
                                layer.msg("审核失败！", {
                                    icon : 5
                                });
                            }
                            parent.layui.table.reload('workList',{page:{curr:$(".layui-laypage-em").next().html()}});
                        }
                    })
                }, btn3: function (index) {
                    close(index);
                }
            });
            /*var editIndex = layer.open({
                type : 2,
                title : "填写进度",
                area : [ '450px', '500px' ],
                content : ctx + "/info/addInfo",
                success : function(layero, index) {
                    var body=layer.getChildFrame('body',index);
                }
            });*/
        }
    });

    $(".search_btn").click(function() {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

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