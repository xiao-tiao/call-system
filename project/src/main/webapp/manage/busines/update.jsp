<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <title>企业详情</title>
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
                <span class="name">企业详情</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <form action="update.do" method="post" name="addForm">
                <div class="xjhy">
                    <!--高级配置-->
                    <ul class="hypz gjpz clearfix">

                        <input class="chang" name="id" type="text" value="${BUSINES.id}" hidden>
                        <li class="clearfix">
                            <span class="title">名称：</span>
                            <div class="li_r">
                                <input class="chang" name="name" type="text" value="${BUSINES.name}">
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">联系人：</span>
                            <div class="li_r">
                                <input class="chang" name="contact" type="text" value="${BUSINES.contact}">
                                <i>*</i>
                            </div>
                        </li>

                        <li class="clearfix">
                            <span class="title">固话：</span>
                            <div class="li_r">
                                <input class="chang" name="phone" type="text" value="${BUSINES.phone}">
                                <i>*</i>
                            </div>
                        </li>

                        <li class="clearfix">
                            <span class="title">手机：</span>
                            <div class="li_r">
                                <input class="chang" name="telphone" type="text" value="${BUSINES.telPhone}">
                                <i>*</i>
                            </div>
                        </li>


                        <li class="clearfix">
                            <span class="title">许可证号：</span>
                            <div class="li_r">
                                <input class="chang" name="licence" type="text" value="${BUSINES.licence}">
                                <i>*</i>
                            </div>
                        </li>


                        <li class="clearfix">
                            <span class="title">备注：</span>
                            <div class="li_r">
                                <input class="chang" name="info" type="text" value="${BUSINES.info}">
                                <i>*</i>
                            </div>
                        </li>


                        <li class="clearfix">
                            <span class="title">地址：</span>
                            <div class="li_r">
                                <input class="chang" name="address" type="text" value="${BUSINES.address}">
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

