<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>部门列表</title>
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
                <span class="name">${DEP.name}部门授权信息</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <!--列表-->
            <form action="addAuth.do" method="post" name="addForm">
                <div class="xjhy">
                    <!--高级配置-->
                    <input name="dep" type="text" value="${DEP.id}" hidden>

                    <ul class="hypz gjpz clearfix">
                        <c:forEach  var="tree" items="${TREE.keySet()}">
                            <li class="clearfix">
                        <span class="radio">



                            <c:set var="test" value="false"></c:set>
                                <c:forEach var="auth" items="${DEP.getAuth()}">
                                <c:if test="${auth.getFunction().getId()==tree.id}">
                                    <c:set var="test" value="true"></c:set>
                                    </c:if>
                                 </c:forEach>

                                <input name="auth" type="checkbox" value="${tree.id}"
                                    <c:if test="${test=='true'}">checked="checked"</c:if>
                                >${tree.name}::


                                <c:forEach var="node" items="${TREE.get(tree)}">

                                         <c:set var="test1" value="false"></c:set>
                                <c:forEach var="auth1" items="${DEP.getAuth()}">
                                <c:if test="${auth1.getFunction().getId()==node.id}">
                                    <c:set var="test1" value="true"></c:set>
                                    </c:if>
                                 </c:forEach>


                                        <input name="auth" type="checkbox" value="${node.id}"
                                            <c:if test="${test1=='true'}">checked="checked"</c:if>
                                        >${node.name}

                                    </c:forEach>


                                <br>

                        </li>

                        </c:forEach>

                        <li class="tj_btn">
                            <a href="javascript:history.go(-1);" class="back">返回</a>
                            <a href="javascript:addForm.submit();">保存</a>
                        </li>
                    </ul>
                    <!--高级配置-->
                </div>
            </form>



            <!--右边底部-->
            <!--右边底部-->
        </div>
        <!--会议列表-->
    </div>
</div>
</body>
</html>
