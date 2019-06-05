<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>企业列表</title>
    <link rel="stylesheet" type="text/css" href="../../css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/thems.css">
    <script type="text/javascript" src="../../js/jquery-1.8.3.min.js"></script>
    <style type="text/css">
        .mouseOver
        {
            background: #708090;
            color: #FFFAFA;
        }
        .mouseOut
        {
            background: #FFFAFA;
            color: #000000;
        }
    </style>
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

    <script type="text/javascript">
        var  xmlHttp;
        function getMoreContents() {

            var keyWord=document.getElementById("phone");
            if(keyWord.value==null)
            {
                clearContent();
                return;
            }

          xmlHttp=getXmlHttp();
            var url="getContent.do?keyWord="+escape(keyWord.value);
            xmlHttp.open("GET",url,true);
            xmlHttp.onreadystatechange=callback;
            xmlHttp.send(null);
        }
        function getXmlHttp() {
            var xmlHttp;
            if(window.XMLHttpRequest)
            {

                xmlHttp=new XMLHttpRequest();

            }
            if(window.ActiveXObject)
            {
                xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
                if(!xmlHttp)
                {
                    xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
                }
            }

            return xmlHttp;


        }
        
        function callback() {

            if(xmlHttp.readyState==4)
            {
                if(xmlHttp.status==200)
                {
                    var result=xmlHttp.responseText;
                    var json=eval("("+result+")");
                    setContent(json);

                }
            }
        }
        
        function  setContent(contents) {
            clearContent();
          /*  setLocation();*/
            var size=contents.length;
            for(var i=0;i<size;i++)
            {
                var nextNode=contents[i];
                var tr=document.createElement("tr");
                var td=document.createElement("td");
                td.setAttribute("border",0);
                td.setAttribute("bgcolor","#FFFAFA")
                td.onmouseover=function () {
                    this.className="mouseOver";
                }
                td.onmouseout=function () {
                    this.className="mouseOut";
                }
                td.onclick=function () {

                }
                var text=document.createTextNode(nextNode);
                td.appendChild(text);
                tr.appendChild(td);
                document.getElementById("content_table_body").appendChild(tr);

            }
        }
        
        function clearContent() {
            var content=document.getElementById("content_table_body");
            var size=content.childNodes.length;
            for(i=size-1;i>=0;i--)
            {
                content.removeChild(content.childNodes[i]);
            }
            document.getElementById("popDiv").style.border="none";
        }
        
        function keyWordBlur() {
            clearContent();
        }

        function setLocation() {
            var input=document.getElementById("phone");
            var width=input.offsetWidth;
            var left=content["offsetLeft"];
            var top=content["offsetTop"]+content.offsetHeight;
            var  popDiv=document.getElementById("popDiv");
            popDiv.style.border="black 1px solid";
            popDiv.style.left=left+"px";
            popDiv.style.top=top+"px";
            popDiv.style.width=width+"px";
            document.getElementById("content_table").style.width=width+"px";


        }
    </script>
    <!--框架高度设置-->
</head>

<body onLoad="Resize();">
<div id="right_ctn">
    <div class="right_m">
        <div class="hy_list">
            <div class="box_t">
                <span class="name">企业列表</span>
            </div>
            <div class="space_hx">&nbsp;</div>

            <form action="query.do" method="post" name="addForm">
                <div class="xjhy">

                    <!--高级配置-->
                    <ul class="hypz gjpz clearfix">

                        <li class="clearfix">
                            <span class="title">固话：</span>
                            <div class="li_r">
                                <input class="chang" name="phone" type="text" <%--onkeyup="getMoreContents()"
                                   onblur="keyWordBlur()"  onfocus="getMoreContents()" id="phone"--%>>
                                <i>*</i>
                            </div>
                            <div id="popDiv">
                                <table id="content_table" bgcolor="#FFFAFA" border="0" cellspacing="0" cellpadding="0">
                                    <tbody id="content_table_body">
                                    </tbody>
                                </table>
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
                <c:forEach var="bus" items="${BUSINES}">
                    <tr>

                        <td>${bus.name}</td>
                        <td>${bus.contact}</td>
                        <td>${bus.phone}</td>
                        <td>${bus.telPhone}</td>
                        <td>${bus.address}</td>

                        <td>
                            <a href="toUpdate.do?id=${bus.id}" class="btn">详情</a>
                            <a href="delete.do?id=${bus.id}" class="btn">删除</a>
                            <a href="../workOrder/toAdd.do?id=${bus.id}" class="btn">创建工单</a>
                        </td>
                    </tr>
                </c:forEach>
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

