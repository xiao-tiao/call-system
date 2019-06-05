<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <title>左边导航</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <!--框架高度设置-->
    <script type="text/javascript">
        $(function(){
            $('.sidenav li').click(function(){
                $(this).siblings('li').removeClass('now');
                $(this).addClass('now');
            });

            $('.erji li').click(function(){
                $(this).siblings('li').removeClass('now_li');
                $(this).addClass('now_li');
            });

            var main_h = $(window).height();
            $('.sidenav').css('height',main_h+'px');
        })
    </script>
    <!--框架高度设置-->
</head>

<body>
<div id="left_ctn">


    <ul class="sidenav">

        <c:forEach  var="tree" items="${SORT}">
            <li>
                <div class="nav_m">
                    <span><a>${tree.name}</a></span>
                    <i>&nbsp;</i>
                </div>
                <ul class="erji">
            <c:forEach var="node" items="${TREE.get(tree)}">
                    <li>
                        <span><a href=${tree.url}${node.url} target="main">${node.name}</a></span>
                    </li>
            </c:forEach>
                </ul>
            </li>

        </c:forEach>
        <li>
            <div class="nav_m">
                <span><a href="logout.do" target="_top">退出系统</a></span>
            </div>
        </li>
    </ul>
</div>
</body>
</html>
