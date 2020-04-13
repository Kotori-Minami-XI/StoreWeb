<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/adminModule/css/style.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/adminModule/css/amazeui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/adminModule/js/pageStyle.css">
    <script src="${pageContext.request.contextPath}/adminModule/js/jquery.min.js"></script>
</head>

<body>

<%-- Obtain all admins if user has already logged in --%>
<%
    if (null == session.getAttribute("username")){
        response.sendRedirect(request.getContextPath() + "/adminModule/admin_login.jsp");
    }
    else {
        if (null == request.getAttribute("adminList")){
            request.getRequestDispatcher("/AdminQueryServlet").forward(request,response);
        }
    }
%>

<div class="main_top">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">管理员列表</strong><small></small></div>
        <div align="right">欢迎!${sessionScope.username}</div>
    </div>
    <hr>
    <div class="am-g">
        <div class="am-u-sm-12 am-u-md-6">
            <div class="am-btn-toolbar">
                <div class="am-btn-group am-btn-group-xs">
                    <button id="add" class="am-btn am-btn-default">
                        <span class="am-icon-plus"></span> 添加管理员</button>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="goods_list" id="account_List">
    <ul class="title_ul">
        <li>序号</li>
        <li>管理员</li>
        <li>修改密码</li>
        <li>移除管理员</li>
    </ul>

    <c:forEach items="${adminList}" var="admin" varStatus="status">
        <ul class="list_goods_ul">
            <li>${status.index + 1}</li>
            <li>${admin.adminName}</li>
            <li>
                <a href="${pageContext.request.contextPath}/AdminUpdatePwdServlet">
                    <img class="img_icon" src="${pageContext.request.contextPath}/adminModule/images/edit_icon.png" alt="">
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/AdminRemoveServlet?aid=${admin.aid}">
                <img class="img_icon" src="${pageContext.request.contextPath}/adminModule/images/delete_icon.png" alt="">
                </a>
            </li>
        </ul>
    </c:forEach>

</div>

<div id="modal_view"></div>

<div id="modal_content_account">
    <div id="close"><img src="${pageContext.request.contextPath}/adminModule/images/delete_icon.png" alt=""></div>
    <div class="edit_content">

        <div class="item1">
            <div>
                <span>添加管理员：</span>
            </div>
        </div>

        <div class="item1" align="left">
            <div>
                <span>用户名：</span>
                <input type="text" class="am-form-field" id="adminName">&nbsp;&nbsp;
            </div>
        </div>

        <div class="item1">
            <div>
                <span>密 码：</span>
                <input type="text" class="am-form-field" id="pwd">&nbsp;&nbsp;
            </div>
        </div>

        <div class="item1">
           <button id="add_btn" class="am-btn am-btn-default" type="button">添加</button>

            <%-- TODO: Use post instead of get --%>
            <script>
                add_btn.onclick = function () {
                    var path =
                        "${pageContext.request.contextPath}/AdminAddServlet?" +
                        "adminName=" +
                        $('#adminName').val() +
                        "&pwd=" +
                        $('#pwd').val();
                    //alert(path);
                    window.location.href= path;
                }
            </script>
        </div>

    </div>
</div>

<script>
    $(function () {
        $('#add').click(function () {
            $("#modal_view").fadeIn();
            $("#modal_content_account").fadeIn();
        });

        $("#close").click(function () {
            $("#modal_view").fadeOut();
            $("#modal_content_account").fadeOut();
        });
    });

    function getAllAdmins(){
        if (${adminList == null}) {

            window.location.href = "${pageContext.request.contextPath}/AdminQueryServlet";
        }
    }

</script>

<script type="text/javascript">
    function getAllAdmins(){
        if (${adminList == null}) {
            window.location.href = "${pageContext.request.contextPath}/AdminQueryServlet";
        }
    }
</script>

<%-- Notify that Remove admin has succeeded --%>
<c:if test="${RemoveStatus != null}">
    <script type="text/javascript" language="javascript">
        alert("${RemoveStatus}");
        <% session.setAttribute("RemoveStatus", null); %>
    </script>
</c:if>

<%-- Notify that add admin has succeeded --%>
<c:if test="${AddStatus != null}">
    <script type="text/javascript" language="javascript">
        alert("${AddStatus}");
        <% session.setAttribute("AddStatus", null); %>
    </script>
</c:if>

<%-- Notify that update admin pwd has succeeded --%>
<c:if test="${UpdatePwdStatus != null}">
    <script type="text/javascript" language="javascript">
        alert("${UpdatePwdStatus}");
        <% session.setAttribute("UpdatePwdStatus", null); %>
    </script>
</c:if>


</body>
</html>