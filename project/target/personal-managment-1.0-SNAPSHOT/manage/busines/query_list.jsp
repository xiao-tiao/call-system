<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>企业查询</title>
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
                <span class="name">企业查询</span>
            </div>
            <div class="space_hx">&nbsp;</div>

            <form action="query.do" method="post" name="addForm">
                <div class="xjhy">
                    <!--高级配置-->
                    <ul class="hypz gjpz clearfix">
                        <li class="clearfix">
                            <span class="title">固话：</span>
                            <div class="li_r">
                                <input class="chang" name="phone" type="text">
                                <i>*</i>
                            </div>
                        </li>

                        <li class="clearfix">
                            <span class="title">手机：</span>
                            <div class="li_r">
                                <input class="chang" name="telphone" type="text">
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">企业名称：</span>
                            <div class="li_r">
                                <input class="chang" name="name" type="text">
                                <i>*</i>
                            </div>
                        </li>

                        <li class="tj_btn">
                            <a href="javascript:addForm.submit();">查询</a>
                        </li>
                    </ul>
                    <!--高级配置-->
                </div>
            </form>
            <!--列表-->
            <table cellpadding="0" cellspacing="0" class="list_hy">
                <tr>

                    <th scope="col">名称</th>
                    <th scope="col">联系人</th>
                    <th scope="col">固话</th>
                    <th scope="col">手机号</th>
                    <th scope="col">地址</th>
                    <th scope="col">操作</th>

                </tr>

                    <tr>

                        <td>${BUSINES.name}</td>
                        <td>${BUSINES.contact}</td>
                        <td>${BUSINES.phone}</td>
                        <td>${BUSINES.telPhone}</td>
                        <td>${BUSINES.address}</td>

                        <td>
                            <a href="toUpdate.do?id=${BUSINES.id}" class="btn">编辑</a>
                            <a href="delete.do?id=${BUSINES.id}" class="btn">删除</a>
                            <a href="../workOrder/toAdd.do?id=${BUSINES.id}" class="btn">创建工单</a>
                        </td>
                    </tr>

            </table>
            <!--列表-->
            <!--右边底部-->
            <div class="r_foot">
                <div class="r_foot_m">
                    <a href="toAdd.do" class="btn">添加</a>
                </div>
            </div>
            <!--右边底部-->
        </div>
        <!--会议列表-->
    </div>
</div>
</body>
</html>

