<%--
  Created by IntelliJ IDEA.
  User: bauce
  Date: 2020/7/5 0005
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${ctx}/layui/css/layui.css">
    <link rel="stylesheet" href="${ctx }/css/list.css" media="all" />
    <link rel="stylesheet" href="${ctx }/css/font_eolqem241z66flxr.css"
          media="all" />
    <script>
        var ctx = "${ctx}";
    </script>
</head>
<body class="childrenBody">
    <blockquote class="layui-elem-quote news_search">
        <form class="layui-form">
            <div class="layui-inline">
                <div class="layui-input-inline">
                    <select name="type" id="type">
                        <option value="-1">请选择</option>
                        <option value="1">工作要点</option>
                        <option value="2">领导批示</option>
                        <option value="3">常委会议定</option>
                        <option value="4">上级工作</option>
                    </select>
                </div>
                <div class="layui-input-inline">
                    <select name="status" id="status">
                        <option value="0">未审核通过</option>
                        <option value="1">已审核通过</option>
                    </select>
                </div>
                <a style="margin-left: 10px" class="layui-btn search_btn" datatype="search" lay-filter="search">查询</a>
                <div class="layui-inline" style="margin-left: 10px">
                    <a class="layui-btn layui-btn-normal">添加工作</a>
                </div>
            </div>
        </form>
    </blockquote>
    <div class="layui-form">
        <table id="allWorkList" lay-filter="allWorkList"></table>
    </div>
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
    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-sm" lay-event="edit">
            <i class="layui-icon">&#xe642;</i>
        </a>
        <a class="layui-btn layui-btn-sm layui-btn-danger" lay-event="delete">
            <i class="layui-icon">&#xe640;</i>
        </a>
    </script>
    <script type="text/javascript" src="${ctx }/layui/layui.js"></script>
    <script type="text/javascript" src="${ctx }/js/work/allWorkList.js"></script>

</body>
</html>
