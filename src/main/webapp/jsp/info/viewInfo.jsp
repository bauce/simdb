<%--
  Created by Idea
  User: bauce
  Date: 2020/7/26 0026
  Time: 17:29
  Email:bauce@qq.com
  tg/wechat: yyplu5
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
    <form class="layui-form" style="width: 90%" id="auf">
        <input type="hidden" name="workInfoId" class="workInfoId"/>
        <div class="layui-form-item">
            <label class="layui-form-label">工作类别</label>
            <div class="layui-input-block" style="align-items:center; display: -webkit-flex;">
                <input type="text" class="layui-input type" disabled="disabled">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">督办内容</label>
            <div class="layui-input-block" style="align-items:center; display: -webkit-flex;">
                <textarea name="content" class="layui-textarea content" disabled="disabled"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">是否办结</label>
            <div class="layui-input-block" style="align-items:center; display: -webkit-flex;">
                <select class="finished" disabled="disabled">
                    <option value="" disabled selected hidden >状态</option>
                    <option value="0">未办结</option>
                    <option value="1">已办结</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">推进情况</label>
            <div class="layui-input-block" style="align-items:center; display: -webkit-flex;">
                <textarea name="info" class="layui-textarea info" disabled="disabled" ></textarea>
            </div>
        </div>


    </form>
    <script type="text/javascript" src="${ctx }/layui/layui.js"></script>
    <script type="text/javascript" src="${ctx }/js/info/viewInfo.js"></script>
    <script type="text/html" id="typeTpl">
        {{#  if(d.type == 1){}} 工作要点
        {{#  } else if(d.type == 2){}} 领导批示
        {{#  } else if(d.type == 3){}} 常委会议定
        {{#  } else if(d.type == 4){}} 上级工作
        {{#  } }}
    </script>
    <script type="text/html" id="doneTpl">
        {{#  if(d.finished == 0){}} 否
        {{#  } else if(d.finished == 1){}} 是
        {{#  } }}
    </script>
    </body>