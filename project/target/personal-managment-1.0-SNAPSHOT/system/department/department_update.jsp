<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <title>部门信息修改</title>
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
                <span class="name">部门信息修改</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <form action="update.do" method="post" name="addForm">
                <div class="xjhy">
                    <!--高级配置-->
                                <input hidden name="id"  value="${DEP.id}" readonly>

                        </li>
                        <ul class="hypz gjpz clearfix">
                            <li class="clearfix">
                                <span class="title">部门名称：</span>
                                <div class="li_r">
                                    <input class="chang" name="name" type="text" value="${DEP.name}">
                                    <i>*</i>
                                </div>
                            </li>
                            <ul class="hypz gjpz clearfix">
                                <li class="clearfix">
                                    <span class="title">部门地址：</span>
                                    <div class="li_r">
                                        <input class="chang" name="address" type="text" value="${DEP.address}">
                                        <i>*</i>
                                    </div>
                                </li>

                        <li class="tj_btn">
                            <a href="javascript:history.go(-1);" class="back">返回</a>
                            <a href="javascript:addForm.submit();">保存</a>
                        </li>

                    <!--高级配置-->
                            </ul>
                        </ul>
                    </ul>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
