<%--
  Created by IntelliJ IDEA.
  User: bauce
  Date: 2020/7/6 0006
  Time: 21:41
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
    <form class="layui-form" style="width: 94%;margin: 0px auto" id="auf">
        <div class="layui-form-item">
            <label class="layui-form-label">编号</label>
            <div class="layui-input-inline">
                <input type="text" name="no" id="no" class="layui-input"
                       placeholder="编号(供工作要点填写)" value="">
            </div>
            <label class="layui-form-label">工作类型</label>
            <div class="layui-input-inline">
                <select name="type" id="type">
                    <option value="" disabled selected hidden>类型</option>
                    <option value="1">工作要点</option>
                    <option value="2">领导批示</option>
                    <option value="3">常委会议定</option>
                    <option value="4">上级工作</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">工作由来</label>
            <div class="layui-input-inline">
                <input type="text" name="origin"  class="layui-input"
                       placeholder="请输入工作由来" value="">
            </div>
            <label class="layui-form-label">责任科室</label>
            <div class="layui-input-inline">
                    <%--<div class="layui-input-inline" id="demo1"></div>--%>
                    <select  id="dp" name="userId" lay-filter="dp" disabled="disabled">
                        <option value="" disabled selected hidden>责任科室</option>
                    </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">工作内容</label>
            <div class="layui-input-block">
                <textarea name="content" class="layui-textarea" placeholder="请输入工作内容"></textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">办结时间<br>类型</label>
            <div class=layui-input-inline">
                <input type="radio" name="time" value="1" title="确定" checked lay-filter="time">
                <input type="radio" name="time" value="0" title="不确定" lay-filter="time">
            </div>
        </div>

        <div class="layui-form-item selectTime">
            <label class="layui-form-label">办结时限</label>
            <div class="layui-input-inline">
                <input type="text" name="dueTime" class="layui-input dueTime" autocomplete="off"
                       placeholder="请选择报办结时限">
                <input type="text"  name="dueTimeAlt" class="layui-input dueTimeAlt" autocomplete="off"
                       placeholder="请输入办结时限" value="" style="display:none">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="addWork">立即提交</button>
            </div>
        </div>

    </form>
    <script type="text/javascript" src="${ctx }/layui/layui.js"></script>
    <script type="text/javascript" src="${ctx }/js/work/addWork.js"></script>
</body>
</html>
