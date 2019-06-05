<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <title>创建工单</title>
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
                <span class="name">创建工单</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <form action="add.do" method="post" name="addForm">
                <div class="xjhy">
                    <!--高级配置-->
                    <ul class="hypz gjpz clearfix">

                        <input class="chang" name="busines" type="text" value="${BUSINES.id}" hidden>
                        <li class="clearfix">
                            <span class="title">来电人姓名：</span>
                            <div class="li_r">
                                <input class="chang" name="busname" type="text" value="${BUSINES.contact}">
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">来电人电话：</span>
                            <div class="li_r">
                                <input class="chang" name="busphone" type="text" value="${BUSINES.phone}">
                                <i>*</i>
                            </div>
                        </li>

                        <li class="clearfix">
                            <span class="title">来电人手机：</span>
                            <div class="li_r">
                                <input class="chang" name="bustelphone" type="text" value="${BUSINES.telPhone}">
                                <i>*</i>
                            </div>
                        </li>

                        <li class="clearfix">
                            <span class="title">企业名称：</span>
                            <div class="li_r">
                                <input class="chang" name="name" type="text" value="${BUSINES.name}">
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
                            <span class="title">问题描述：</span>
                            <div class="li_r">
                                <textarea class="chang" name="question" type="text">

                                </textarea>
                                <i>*</i>
                            </div>
                        </li>


                        <li class="clearfix">
                            <span class="title">处理方式：</span>
                            <div class="li_r">
                            <span class="radio">
                                <input checked="checked" name="mode" type="radio" value="自行解决">
                                <em>自行解决</em>
                            </span>
                                <span class="radio">
                                <input name="mode" type="radio" value="派发工单">
                                <em>派发工单</em>
                            </span>
                            </div>
                        </li>

                        <li class="clearfix">
                            <span class="title">是否需要回访：</span>
                            <div class="li_r">
                            <span class="radio">
                                <input checked="checked" name="info" type="radio" value="是">
                                <em>是</em>
                            </span>
                                <span class="radio">
                                <input name="info" type="radio" value="否">
                                <em>否</em>
                            </span>
                            </div>
                        </li>


                        <li class="clearfix">
                            <span class="title">所属部门：</span>
                            <div class="li_r">
                                <select name="department" id="sele">
                                    <c:forEach items="${DEPARTMENT}" var="dep">
                                        <option value="${dep.id}" selected="selected">${dep.name}</option>
                                    </c:forEach>

                                </select>
                                <i>*</i>
                            </div>
                        </li>


                        <li class="clearfix">
                            <span class="title">问题类别：</span>
                            <div class="li_r">
                                <select name="class" >

                                    <option value="网络">网络</option>
                                    <option value="硬件">硬件</option>
                                    <option value="软件">软件</option>
                                    <option value="财务">财务</option>
                                    <option value="服务">服务</option>
                                </select>
                                <i>*</i>
                            </div>
                        </li>


                        <li class="clearfix">
                            <span class="title">处理时长(小时）：</span>
                            <div class="li_r">
                                <input class="chang" name="time" type="text">

                                </input>
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

