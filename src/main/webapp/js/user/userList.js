var fdata;
layui.use([ 'form','layer','jquery','table','laydate'], function() {
	var layer = layui.layer, $ = layui.jquery, form = layui.form,table=layui.table,laydate = layui.laydate;

	$("body").on('click','.layui-table-body tr ',function () {
		console.log(this);
		var data_index=$(this).attr('data-index');//得到当前的tr的index
		console.log($(this).attr('data-index'));
		$(".layui-table-body tr").attr({"style":"background:#FFFFFF"});//其他tr恢复颜色
		$(".layui-table-body tr[data-index="+data_index+"]").attr({"style":"background:#99ff99"});//改变当前tr颜色

	});

	active = {
			search : function(){
			var username = $('#username');
				var roleId = $('#roleId option:selected');

				table.reload('userList',{
					page : {
						curr : 1
					},
					where : {
						username : username.val(),
						roleId : roleId.val()
					}
				});
			}
	};
	
	table.render({
		id:'userList'
	    ,elem: '#userList'
	    ,url: ctx+'/user/getAllUser'// 数据接口
	    ,limit:10// 每页默认数
	    ,limits:[10,20,30,40]
		,toolbar : true
	    ,cols: [[ // 表头
	      {field:'username', title: '登录名', align: 'center',width:110}
	      ,{field:'roleId', title: '角色', align: 'center',templet : '#userTpl',width:100}
          ,{field:'phone', title: '电话', align: 'center' ,width:120}
          ,{field:'email', title: 'E-mail' , align: 'center',width:180}
          , {fixed: 'right', title: '操作', align: 'center', toolbar: "#barDemo",width:150}
	    ]]
			,page: true // 开启分页
			,loading:true
			,where: {timestamp: (new Date()).valueOf()}
	  });

																																																																																																								
	table.on('tool(userList)', function (obj) {
	    var data = obj.data;
	    fdata =data;
	    if (obj.event === 'delete') {
	        layer.confirm('确定要删除 '+data.username+' 么？', function (index) {
	        	$.ajax({
					url : ctx + '/user/deleteUserById',
					type : "POST",
					data: {"id": data.userId},
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
				title : "编辑用户",
				area : [ '450px', '500px' ],
				content : ctx + "/user/editUser/" + data.userId,
				success : function(layero, index) {
					var body = layui.layer.getChildFrame('body', index);
				}
	    	});
	    }	
	});



	$(".search_btn").click(function() {
		var type = $(this).data('type');
		console.log(type);
		active[type] ? active[type].call(this) : '';
	});


	$(".userAdd_btn").click(function() {
		var addIndex = layer.open({
			title : "添加用户",
			type : 2,
			area : [ '800px', '380px' ],
			content : ctx + "/user/addUser",
			success : function(layero, index) {
			}
		})
	})
});

