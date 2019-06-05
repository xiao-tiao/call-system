<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <title>详情</title>
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
                <span class="name">详情</span>
            </div>
            <div class="space_hx">&nbsp;</div>
                <div class="xjhy">
                    <!--高级配置-->
                    <ul class="hypz gjpz clearfix">
                        <li class="clearfix">
                            <span class="title">企业名称：</span>
                            <div class="li_r">${ORDER.busines.name}</div>
                        </li>
                        <li class="clearfix">
                            <span class="title">问题描述：</span>
                            <div class="li_r">${ORDER.question}</div>
                        </li>
                        <li class="clearfix">
                            <span class="title">问题类型：</span>
                            <div class="li_r">${ORDER.clas}</div>
                        </li>
                        <li class="clearfix">
                            <span class="title">工单状态：</span>
                            <div class="li_r">${ORDER.status}</div>
                        </li>
                        <li class="clearfix">
                            <span class="title">所属部门：</span>
                            <div class="li_r">${ORDER.department.name}</div>
                        </li>
                        <li class="clearfix">
                            <span class="title">处理人员：</span>
                            <div class="li_r">${ORDER.staff.name}</div>
                        </li>
                        <li class="clearfix">
                            <span class="title">创建时间：</span>
                            <div class="li_r">
                                <fmt:formatDate value="${ORDER.createTime}" pattern="yyyy-MM-dd"/>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">办理时限：</span>
                            <div class="li_r">${ORDER.time}小时</div>
                        </li>
                        <li class="clearfix">
                            <span class="title">办理时间：</span>
                            <div class="li_r">
                                <fmt:formatDate value="${ORDER.handTime}" pattern="yyyy-MM-dd hh:mm"/>
                            </div>
                        </li>

                        <li class="clearfix">
                            <span class="title">超时时间：</span>
                            <div class="li_r">${ORDER.timeOut}</div>
                        </li>

                        <li class="clearfix">
                            <span class="title">解决方案：</span>
                            <div class="li_r">${ORDER.resolve}</div>
                        </li>

                        <li class="clearfix">
                            <span class="title">解决方式：</span>
                            <div class="li_r">${ORDER.mode}</div>
                        </li>
                        <li class="clearfix">
                            <span class="title">是否回访：</span>
                            <div class="li_r">${ORDER.info}</div>
                        </li>

                        <li class="tj_btn">
                            <a href="javascript:history.go(-1);" class="back">返回</a>
                        </li>
                    </ul>
                    <!--高级配置-->
                </div>
        </div>
    </div>
</div>
</body>
</html>
