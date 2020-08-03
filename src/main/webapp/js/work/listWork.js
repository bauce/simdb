var fdata,userListData;
layui.use([ 'form','layer','jquery','table','laydate'], function() {
    var layer = layui.layer, $ = layui.jquery, form = layui.form,table=layui.table,laydate = layui.laydate;
    var nowTime = new Date().valueOf();
    var max = null;
    var curIndex;

    $("body").on('click','.layui-table-body tr ',function () {
        var data_index=$(this).attr('data-index');//得到当前的tr的index
        curIndex = data_index;
        $(".layui-table-body tr").attr({"style":"background:#FFFFFF"});//其他tr恢复颜色
        $(".layui-table-body tr[data-index="+data_index+"]").attr({"style":"background:#99ff99"});//改变当前tr颜色

    });

    active = {
        search : function(){

            var type = $('#type option:selected');
            var finished = $('#finished option:selected');
            var userId = $('#dp option:selected');


            table.reload('workList',{
                page : {
                    curr : $(".layui-laypage-em").next().html()
                },
                where : {
                    type : type.val(),
                    finished : finished.val(),
                    userId : userId.val()

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
        ,url: ctx+'/work/getAllWorkList'// 数据接口
        ,toolbar : true
        ,limit:10// 每页默认数
        ,limits:[10,20,30,40]
        ,cols: [[ // 表头
            {field:'no',title:'编号',align:'center',width:60},
            {field:'type',title:'类型',align:'center',templet : '#typeTpl',width:150},
            {field:'content',title:'督办内容',align:'center',width:200},
            {field:'origin',title:'督办依据',align:'center',width:150},
            {field:'dueTime',title:'截止时间',align:'center',templet : '#timeTpl',width:102},
            {field:'userId',title:'责任科室',align:'center',templet : '#userTpl',width:120},
            {field:'finished',title:'是否办结',align:'center',templet : '#doneTpl',width:87},
            {field: 'right', title: '操作', align: 'center', toolbar: "#barDemo",width:120}
        ]]
        ,page: true // 开启分页
        ,loading:true
        ,where: {timestamp: (new Date()).valueOf()}
    });


    table.on('tool(workList)', function (obj) {
        var data = obj.data;
        fdata = data;
        console.log(fdata);
        if (obj.event === 'delete') {
            layer.confirm('确定要删除么？', function (index) {
                $.ajax({
                    url : ctx + '/work/deleteWorkById',
                    type : "POST",
                    data: {"id": data.workId},
                    success : function(d) {
                        if (d.code == 0) {
                            layer.msg("删除成功！",{icon: 1});
                            obj.del();
                        } else {
                            layer.msg("权限不足，删除失败！", {
                                icon : 5
                            });
                        }
                    },
                    error:function(){
                        layer.msg("删除失败！网络错误！",{icon: 5});
                    }
                })
                layer.close(index);
            });
        } else if (obj.event === 'edit') {
            var editIndex = layer.open({
                type : 2,
                title : "编辑工作",
                area : [ '800px', '460px' ],
                content : ctx + "/work/editWork",
                success : function(layero, index) {
                    var body=layer.getChildFrame('body',index);
                },
                end : function () {
                    $(".layui-table-body tr[data-index="+curIndex+"]").attr({"style":"background:#99ff99"});//改变当前tr颜色
                }
            });
        }
    });

    $(".search_btn").click(function() {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    $(".addWork_btn").click(function() {
        var addIndex = layer.open({
            type : 2,
            title : "添加工作",
            area : [ '800px', '460px' ],
            content : ctx + "/work/addWork",
            success : function(layero, index) {

            }
        })
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
