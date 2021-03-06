<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <title>更新员工信息</title>
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
                <span class="name">更新员工信息</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <form action="update.do" method="post" name="addForm">
                <div class="xjhy">
                    <!--高级配置-->
                    <ul class="hypz gjpz clearfix">
                        <input class="chang" name="id" type="text" value="${STAFF.id}" hidden>

                        <li class="clearfix">
                            <span class="title">账号：</span>
                            <div class="li_r">
                                <input class="chang" name="account" type="text" value="${STAFF.account}" readonly>
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">密码：</span>
                            <div class="li_r">
                                <input class="chang" name="password" type="password" value="${STAFF.password}" >
                                <i>*</i>
                            </div>
                        </li>

                        <li class="clearfix">
                            <span class="title">姓名：</span>
                            <div class="li_r">
                                <input class="chang" name="name" type="text" value="${STAFF.name}">
                                <i>*</i>
                            </div>
                        </li>

                        <li class="clearfix">
                            <span class="title">性别：</span>
                            <div class="li_r">
                                <c:if test="${STAFF.sex=='男'}">
                             <span class="radio">
                                <input checked="checked" name="sex" type="radio" value="男">
                                <em>男</em>
                                </span>
                                    <span class="radio">
                                <input name="sex" type="radio" value="女">
                                <em>女</em>
                            </span>
                                </c:if>
                                <c:if test="${STAFF.sex=='女'}">
                             <span class="radio">
                                <input  name="sex" type="radio" value="男">
                                <em>男</em>
                                </span>
                                    <span class="radio">
                                <input name="sex" type="radio" value="女" checked="checked">
                                <em>女</em>
                            </span>
                                </c:if>


                            </div>
                        </li>



                        <li class="clearfix">
                            <span class="title">出生日期：</span>
                            <div class="li_r">
                                <input class="chang" name="bornDate" type="date" value="
                                 <fmt:formatDate value="${STAFF.bornDate}" pattern="yyyy-MM-dd" />">
                                <i>*</i>
                            </div>
                        </li>



                        <li class="clearfix">
                            <span class="title">所属部门：</span>
                            <div class="li_r">
                                <span class="radio">
                                      <c:forEach items="${DEP}" var="dep">
                                          <c:set var="eq_d" value="false"></c:set>
                                         <c:forEach items="${STAFF.post}" var="post">
                                             <c:if test="${post.department.id==dep.id}">
                                                <c:set var="eq_d" value="true"></c:set>
                                            </c:if>
                                        </c:forEach>
                                          <input class="chang" name="dep" type="checkbox"
                                                 <c:if test="${eq_d=='true'}">checked="checked"</c:if>
                                                 value="${dep.id}">${dep.name}
                                    </c:forEach>
                                </span>

                                <i>*</i>
                            </div>
                        </li>

                        <li class="clearfix">
                            <span class="title">工号：</span>
                            <div class="li_r">
                                <input class="chang" name="idNumber" type="text" value="${STAFF.idNumber}">
                                <i>*</i>
                            </div>
                        </li>

                        <li class="clearfix">
                            <span class="title">状态：</span>
                            <div class="li_r">
                                <input class="chang" name="status" type="text" value="${STAFF.status}">
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">入职日期：</span>
                            <div class="li_r">
                                <input class="chang" name="workTime" type="date" value="
                                 <fmt:formatDate value="${STAFF.workTime}" pattern="yyyy-MM-dd" />">
                                <i>*</i>
                            </div>
                        </li>


                        <li class="clearfix">
                            <span class="title">离职日期：</span>
                            <div class="li_r">
                                <input class="chang" name="leaveTime" type="date" value="
                                       <fmt:formatDate value="${STAFF.leaveTime}" pattern="yyyy-MM-dd" />"/>
                                <i>*</i>
                            </div>
                        </li>

                        <li class="clearfix">
                            <span class="title">备注：</span>
                            <div class="li_r">
                                <input class="chang" name="info" type="text" value="${STAFF.info}">
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

