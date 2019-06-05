<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <title>办理工单</title>
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
                <span class="name">办理工单</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <form action="transact.do" method="post" name="addForm">
                <div class="xjhy">
                    <!--高级配置-->
                    <ul class="hypz gjpz clearfix">
                        <input class="chang" name="id" type="text" value="${ORDER.id}" readonly hidden>
                        <li class="clearfix">
                            <span class="title">企业名称：</span>
                            <div class="li_r">
                                <input class="chang" name="name" type="text" value="${ORDER.busines.name}" readonly>
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">问题描述：</span>
                            <div class="li_r">
                                <textarea class="chang" name="question" type="text" >
                                    ${ORDER.question}
                                </textarea>
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">办理部门：</span>
                            <div class="li_r">
                                <input class="chang" name="dep" type="text" value="${ORDER.department.name}" readonly>
                                <i>*</i>
                            </div>
                        </li>

                        <li class="clearfix">
                            <span class="title">办理人员：</span>
                            <div class="li_r">
                                <input class="chang" name="satff" type="text" value="${ORDER.staff.name}" readonly>
                                <i>*</i>
                            </div>
                        </li>

                        <li class="clearfix">
                            <span class="title">答复意见：</span>
                            <div class="li_r">
                                <textarea class="chang" name="resolve" type="text" >

                                </textarea>
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

