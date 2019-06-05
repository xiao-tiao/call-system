<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>功能列表</title>
    <link rel="stylesheet" type="text/css" href="../../css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/thems.css">
    <script type="text/javascript" src="../../js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function(){
            //自适应屏幕宽度
            window.onresize=function(){ location=location };

            var main_h = $(window).height();
            $('.hy_list').css('height',main_h-45+'px');

            var search_w = $(window).width()-40;
            $('.search').css('width',search_w+'px');
            //$('.list_hy').css('width',search_w+'px');
        });
    </script>
    <!--框架高度设置-->
</head>

<body onLoad="Resize();">
<div id="right_ctn">
    <div class="right_m">
        <div class="hy_list">
            <div class="box_t">
                <span class="name">${NAME}功能列表</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <!--列表-->
            <table cellpadding="0" cellspacing="0" class="list_hy">
                <tr>

                    <th scope="col">功能名称</th>
                    <th scope="col">访问路径</th>
                    <th scope="col">备注</th>
                    <th scope="col">操作</th>

                </tr>
                <c:if test="${ROOT.size()==0}">
                    <td colspan="3">暂无信息</td>
                   <td> <a href="javascript:history.go(-1);" class="btn">返回</a></td>

                </c:if>
                <c:forEach var="root" items="${ROOT}">
                    <tr>
                        <td>${root.name}</td>
                        <td>${root.url}</td>
                        <td> ${root.info}</td>
                        <td>
                            <a href="toUpdate.do?id=${root.id}" class="btn">编辑</a>
                            <a href="delete.do?id=${root.id}" class="btn">删除</a>
                            <a href="query.do?id=${root.id}" class="btn">查询</a>
                            <a href="toAdd.do?id=${root.id}&accordion=${root.accordion}" class="btn">添加</a>
                            <a href="javascript:history.go(-1);" class="btn">返回</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
            <!--列表-->
            <div class="r_foot">
                <div class="r_foot_m">
                    <a href="toAddRoot.do" class="btn">添加</a>
                </div>
            </div>
            <!--右边底部-->
        </div>
        <!--会议列表-->

    </div>
</div>
</body>
</html>

