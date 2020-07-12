<%--
  Created by IntelliJ IDEA.
  User: bauce
  Date: 2020/7/9 0009
  Time: 1:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${ctx}/layui/css/layui.css">
    <script>
        var ctx = "${ctx}";
    </script>
</head>
<body>
    <br>
    <form class="layui-form" style="width: 80%;height: auto;" id="auf">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-inline">
                <input type="text" name="username" id="username" class="layui-input"
                       lay-verify="required" placeholder="请输入用户名" value="">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
                <input type="password" id="password" class="layui-input"
                       lay-verify="pass" placeholder="请输入密码" name="password" value="">
            </div>
            <label class="layui-form-label">确认密码</label>
            <div class="layui-input-inline">
                <input type="password" class="layui-input" lay-verify="repass"
                       placeholder="请确认密码" value="">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">角色</label>
            <div class="layui-input-inline">
                <select name="roleId">
                    <option value="">请选择</option>
                    <option value="1">管理员</option>
                    <option value="2">业务科室</option>
                    <option value="3">派驻纪检监察组</option>
                    <option value="4">镇（街道）纪（工）委</option>
                    <option value="5">委领导</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">手机号</label>
            <div class="layui-input-inline">
                <input type="text" name="phone" class="layui-input"
                       lay-verify="phone" placeholder="请输入手机号" value="">
            </div>
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-inline">
                <input type="text" id="email" name="email" class="layui-input"
                       lay-verify="email" placeholder="请输入邮箱" value="">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="addUser">立即提交</button>
            </div>
        </div>
    </form>
    <script type="text/javascript" src="${ctx }/layui/layui.js"></script>
    <script type="text/javascript" src="${ctx }/js/user/addUser.js"></script>
</body>
</html>
