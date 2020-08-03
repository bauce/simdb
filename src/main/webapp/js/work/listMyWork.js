var fdata,userListData;
layui.use([ 'form','layer','jquery','table','laydate'], function() {
    var layer = layui.layer, $ = layui.jquery, form = layui.form,table=layui.table,laydate = layui.laydate;
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
            var userId = sessionStorage.getItem("userId");
            var status = $('.status option:selected').val();

            table.reload('workList',{
                page : {
                    curr : 1
                },
                where : {
                    type : type.val(),
                    finished : finished.val(),
                    userId : sessionStorage.getItem("userId"),
                    status : status
                    /*username : username.val(),*/

                }
            });
        }
    };

    //获取用户名和id，装入下拉菜单，并存入全局变量
    /*$.ajax({
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
    );*/


    table.render({
        id:'workList'
        ,elem: '#workList'
        ,url: ctx+'/work/getWorkWithLastInfo?userId='+sessionStorage.getItem("userId")// 数据接口
        ,toolbar : true
        ,limit:10// 每页默认数
        ,limits:[10,20,30,40]
        ,cols: [[ // 表头
            {field:'no',title:'编号',align:'center',width:60},
            {field:'type',title:'类型',align:'center',templet : '#typeTpl',width:150},
            {field:'content',title:'督办内容',align:'center',width:200},
            {field:'origin',title:'督办依据',align:'center',width:150},
            {field:'dueTime',title:'截止时间',align:'center',templet : '#timeTpl',width:102},
            {field:'finished',title:'是否办结',align:'center',templet : '#doneTpl',width:87},
            {field:'status',title:'审核状态',align:'center',templet : '#statusTpl',width:87},
            {field: 'progress', title: '填报进度', align: 'center', toolbar: "#barDemo",width:87}
        ]]
        ,page: true // 开启分页
        ,loading:true
        ,where: {timestamp: (new Date()).valueOf()}
    });


    table.on('tool(workList)', function (obj) {
        var data = obj.data;
        fdata = data;
        console.log(obj);
        if (obj.event === 'edit') {
            var editIndex = layer.open({
                type : 2,
                title : "填写进度",
                area : [ '450px', '500px' ],
                content : ctx + "/info/addInfo",
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
