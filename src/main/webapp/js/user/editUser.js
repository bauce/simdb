﻿layui.use([ 'form','layer','jquery','table','laydate'], function() {
	var layer = layui.layer, $ = layui.jquery, form = layui.form,table=layui.table,laydate = layui.laydate;

	$(".phone").val(parent.fdata.phone);

	form.verify({
		repass: function (value) {
			var repassvalue = $('#password').val();
			if(null != repassvalue && ''!=repassvalue){
				if (value != repassvalue) {
					return '两次输入的密码不一致!';
				}
			}

		}
	});

	form.on("submit(updateUser)",function(data){
		var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.2});
		var index1 = parent.layer.getFrameIndex(window.name);
 		var msg,flag=false;
 		$.ajax({
    		type: "post",
    		async:false,
            url: ctx+"/user/updateUser",
            data:data.field,
			dataType:"json",
			success:function(d){
				if(d.code==0){  
					msg="用户信息更新成功！";
					flag=true;
				}else{
					msg="用户信息更新失败！";
				}
			},
			error:function(){
				layer.msg("用户信息更新失败！",{icon:2});
				layer.closeAll();
				return false;
			}
			
        });
 		setTimeout(function () {
 			parent.layer.close(index1);
 			top.layer.close(index);
 			if(flag){
 				top.layer.msg(msg,{icon: 1});
 			}else{
 				top.layer.msg(msg,{icon: 5});
 			}
 			parent.location.reload();
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
