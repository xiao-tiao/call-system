<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <title>更新功能</title>
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

            var main_w = $(window).width();
            $('.xjhy').css('width',main_w-40+'px');

        });
    </script>
</head>

<body onLoad="Resize();">
<div id="right_ctn">
    <div class="right_m">
        <div class="hy_list">
            <div class="box_t">
                <span class="name">更新功能</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <form action="update.do" method="post" name="addForm">
                <div class="xjhy">
                    <!--高级配置-->
                    <ul class="hypz gjpz clearfix">

                        <input class="chang" name="id" type="text" value="${FUNCTION.id}" hidden>
                        <li class="clearfix">
                            <span class="title">功能名称：</span>
                            <div class="li_r">
                                <input class="chang" name="name" type="text" value="${FUNCTION.name}">
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">访问路径：</span>
                            <div class="li_r">
                                <input class="chang" name="url" type="text" value="${FUNCTION.url}">
                                <i>*</i>
                            </div>
                        </li>

                        <li class="clearfix">
                            <span class="title">父节点：</span>
                            <div class="li_r">
                                <input class="chang" name="parentId" type="text" value="${FUNCTION.parentId}" readonly>
                                <i>*</i>
                            </div>
                        </li>

                        <li class="clearfix">
                            <span class="title">是否根结点：</span>
                            <div class="li_r">
                                <c:if test="${FUNCTION.accordion==0}">
                            <span class="radio">
                                <input checked="checked" name="accordion" type="radio" value="0" readonly>
                                <em>是</em>
                            </span>
                                <span class="radio">
                                <input name="accordion" type="radio" value="1" readonly>
                                <em>否</em>
                            </span>
                                </c:if>
                                <c:if test="${FUNCTION.accordion==1}">
                            <span class="radio">
                                <input  name="accordion" type="radio" value="0" readonly>
                                <em>是</em>
                            </span>
                                    <span class="radio">
                                <input name="accordion" type="radio" value="1" checked="checked"  readonly>
                                <em>否</em>
                            </span>
                                </c:if>
                            </div>
                        </li>


                        <li class="clearfix">
                            <span class="title">序列号：</span>
                            <div class="li_r">
                                <input class="chang" name="serialNum" type="text" value="${FUNCTION.serialNum}">
                                <i>*</i>
                            </div>
                        </li>


                        <li class="clearfix">
                            <span class="title">备注：</span>
                            <div class="li_r">
                                <input class="chang" name="info" type="text" value="${FUNCTION.info}">
                                <i>*</i>
                            </div>
                        </li>


                        <li class="tj_btn">
                            <a href="javascript:history.go(-1);" class="back">返回</a>
                            <a href="javascript:addForm.submit();">保存</a>
                        </li>
                    </ul>
                    <!--高级配置-->
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

