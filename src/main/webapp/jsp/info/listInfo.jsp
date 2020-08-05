<%--
  Created by IntelliJ IDEA.
  User: bauce
  Date: 2020/7/5 0005
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${ctx}/layui/css/layui.css">
        <link rel="stylesheet" href="${ctx }/css/list.css" media="all" />
        <link rel="stylesheet" href="${ctx }/css/font_eolqem241z66flxr.css"
              media="all" />
        <link rel="stylesheet" href="${ctx}/css/common.css">
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
                            <option value="" disabled selected hidden>类型</option>
                            <option value="1">工作要点</option>
                            <option value="2">领导批示</option>
                            <option value="3">常委会议定</option>
                            <option value="4">上级工作</option>
                        </select>
                    </div>
                    <div class="layui-input-inline">
                        <select name="finished" id="finished">
                            <option value="" disabled selected hidden>状态</option>
                            <option value="0">未完成</option>
                            <option value="1">已完成</option>
                        </select>
                    </div>
                    <div class="layui-input-inline">
                        <select name="status" class="status">
                            <option value="" disabled selected hidden>审核状态</option>
                            <option value="0">待填报</option>
                            <option value="1">待审核</option>
                            <option value="2">已审核</option>
                        </select>
                    </div>
                    <div class="layui-input-inline">
                        <select name="userId" id="dp" disabled="disabled">
                            <<option value="" disabled selected hidden>责任科室</option>
                        </select>
                    </div>
                    <a style="margin-left: 10px" class="layui-btn search_btn" lay-submit="" data-type="search"
                       lay-filter="search">查询</a>
                </div>
            </form>
        </blockquote>
        <div class="layui-form">
            <table id="workList" lay-filter="workList"></table>
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
        <script type="text/html" id="statusTpl">
            {{#  if(null == d.info){}} 暂未填报
            {{#  } else if(d.info.status == 1){}} 暂存
            {{#  } else if(d.info.status == 2){}} 待审核
            {{#  } else if(d.info.status == 3){}} 未通过
            {{#  } else if(d.info.status == 4){}} 已通过
            {{#  } else if(d.info.status == 5){}} 上期已归档
            {{#  } }}
        </script>
        <script type="text/html" id="infoTpl">
            {{#  if(null == d.info){}} 从未填报过
            {{#  } else if(null == d.info.info){}} 上次填报的为空
            {{#  } else {}} <div>{{ d.info.info}}</div>
            {{#  } }}
        </script>
        <script type="text/html" id="timeTpl">
            {{#  if(null != d.dueTime){}} <div>{{ formatTime(d.dueTime,"yyyy-MM-dd")}}</div>
            {{#  } else {}} <div>{{ d.dueTimeAlt}}</div>
            {{#  } }}
        </script>
        <script type="text/html" id="userTpl">
            {{#  layui.each(userListData, function(index, item){ }}
            {{#  if(d.userId == item.userId){}} <div>{{  item.username}}</div>
            {{#  } }}
            {{#  }); }}
        </script>
        <script type="text/html" id="barDemo">
            {{#  if((d.finished == 0)&&(null != d.info)&&(d.info.status == 2)){ }}
            <a class="layui-btn layui-btn-sm" lay-event="review">
                <i class="layui-icon">&#xe642;</i>
            </a>
            {{#  } else {}}
            {{#  } }}
        </script>
        <script type="text/html" id="toolbar">
            <div class="layui-btn-container">
                <button class="layui-btn" id="export" lay-event="export">
                     导出（暂时无法正常使用）
                </button>
                <button class="layui-btn" id="arch" lay-event="arch">
                     归档
                </button>
            </div>
        </script>

        <script type="text/javascript" src="${ctx }/layui/layui.js"></script>
        <script type="text/javascript" src="${ctx }/js/info/listInfo.js"></script>

    </body>
</html>
