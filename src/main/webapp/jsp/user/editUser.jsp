<%--
  Created by IntelliJ IDEA.
  User: bauce
  Date: 2020/7/9 0009
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<form class="layui-form" style="width: 80%;">

    <div class="layui-form-item">
        <label class="layui-form-label">用户编号</label>
        <div class="layui-input-block" style="align-items:center; display: -webkit-flex;">
            <input type="text" name="userId" id="id" class="layui-input userId" disabled="disabled">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block">
            <input type="text" id="username" class="layui-input" name="username" value="${user.username}">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">手机号</label>
        <div class="layui-input-block">
            <%--<input type="text" name="phone" value="${user.phone}" class="layui-input">--%>
            <input type="text" name="phone" class="layui-input phone">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-block">
            <input type="text" name="email" value="${user.email}" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">角色</label>
        <div class="layui-input-inline">
            <select>
                <option value="">请选择</option>
                <option value="1" <c:if test="${user.roleId==1}">selected</c:if>>管理员</option>
                <option value="2" <c:if test="${user.roleId==2}">selected</c:if>>业务科室</option>
                <option value="3" <c:if test="${user.roleId==3}">selected</c:if>>派驻纪检监察组</option>
                <option value="4" <c:if test="${user.roleId==4}">selected</c:if>>镇（街道）纪（工）委</option>
                <option value="5" <c:if test="${user.roleId==5}">selected</c:if>>委领导</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input type="password" id="password" class="layui-input"
                   lay-verify="pass" placeholder="留空则不更改密码" name="password" value="">
        </div>
        <label class="layui-form-label">确认密码</label>
        <div class="layui-input-inline">
            <input type="password" class="layui-input" lay-verify="repass"
                   placeholder="请再次确认密码" value="">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="updateUser">立即保存</button>
        </div>
    </div>

</form>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/user/editUser.js"></script>
</body>
</html>