<%--
  Created by IntelliJ IDEA.
  User: bauce
  Date: 2020/7/1 0001
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>都纪督查</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${ctx }/layui/css/layui.css">
    <link rel="stylesheet" href="${ctx }/css/login.css">
    <script>
        var ctx = "${ctx}";
    </script>
    <title>登录</title>
</head>
    <body>
        <form class="box layui-form" lay-filter="login">
            <h1>都江堰市纪委监委<br>督查督办系统</h1>
            <input type="text" id="username" placeholder="用户名">
            <input type="password" id="password" placeholder="密码">
            <button id="loginBt" class="login-btn layui-btn">登录</button>
        </form>
        <script type="text/javascript" src="${ctx }/layui/layui.js"></script>
        <script type="text/javascript" src="${ctx }/js/login.js"></script>
    </body>
</html>
