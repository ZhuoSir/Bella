<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="title" value="${page.title}"/>
<c:set var="Msg" value="${page.msg}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <jsp:include page="commoncss.jsp"/>

    <title>${title}</title>

</head>
<body class="page-body" style="font-family: 微软雅黑">

<%--&lt;%&ndash;<jsp:include page="headset.jsp"/>&ndash;%&gt;--%>

<%--<div class="page-container">--%>

    <%--&lt;%&ndash;<jsp:include page="sidebar.jsp"/>&ndash;%&gt;--%>

    <%--<div class="main-content">--%>

        <%--<!-- User Info, Notifications and Menu Bar -->--%>
        <%--&lt;%&ndash;<jsp:include page="navigation.jsp"/>&ndash;%&gt;--%>

        <%--<div class="page-error centered">--%>

            <%--<div class="error-symbol">--%>
                <%--<i class="fa-warning"></i>--%>
            <%--</div>--%>

            <%--<h2>--%>
                <%--Error 404--%>
                <%--<small>Page not found!</small>--%>
            <%--</h2>--%>

            <%--<p>We did not find the page you were looking for!</p>--%>
            <%--<p>You can search again or contact one of our agents to help you!</p>--%>

        <%--</div>--%>

        <%--<div class="page-error-search centered">--%>
            <%--<form class="form-half" method="get" action="" enctype="application/x-www-form-urlencoded">--%>
                <%--<input type="text" class="form-control" placeholder="Search...">--%>

                <%--<button type="submit" class="btn-unstyled">--%>
                    <%--<i class="linecons-search"></i>--%>
                <%--</button>--%>
            <%--</form>--%>

            <%--<a href="#" class="go-back">--%>
                <%--<i class="fa-angle-left"></i>--%>
                <%--Go Back--%>
            <%--</a>--%>
        <%--</div>--%>


        <%--<!-- Main Footer -->--%>
        <%--&lt;%&ndash;<jsp:include page="footer.jsp"/>&ndash;%&gt;--%>
    <%--</div>--%>

    <%--<!--  Chat Section -->--%>
    <%--&lt;%&ndash;<jsp:include page="chat.jsp"/>&ndash;%&gt;--%>

<%--</div>--%>

<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">会员列表</h3>

        <div class="panel-options">
            <a href="#" data-toggle="panel">
                <span class="collapse-icon">&ndash;</span>
                <span class="expand-icon">+</span>
            </a>
            <a href="#" data-toggle="remove">
                &times;
            </a>
        </div>
    </div>
    <div class="panel-body">

        <script type="text/javascript">
            jQuery(document).ready(function($)
            {
                $("#example-1").dataTable({
                    aLengthMenu: [
                        [10, 25, 50, 100, -1], [10, 25, 50, 100, "All"]
                    ]
                });
            });
        </script>

        <table id="example-1" class="table table-striped table-bordered" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th hidden="hidden">ID</th>
                <th>账户姓名</th>
                <th>昵称</th>
                <th>邮件</th>
                <th>用户类型</th>
                <th>登录IP</th>
                <th>电话号码</th>
                <th>账户状态</th>
                <th>在线状态</th>
                <th>创建时间</th>
                <th>修改时间</th>
            </tr>
            </thead>

            <tfoot>
            <tr>
                <th hidden="hidden">ID</th>
                <th>Name</th>
                <th>Nick</th>
                <th>Email</th>
                <th>Level</th>
                <th>LoginIP</th>
                <th>MobilePhone</th>
                <th>IsBlocked</th>
                <th>AvaliableStatus</th>
                <th>CreateTime</th>
                <th>ModifyTime</th>
            </tr>
            </tfoot>

            <tbody>

            <c:forEach var="admin" items="${admins}">
                <tr>
                    <td hidden="hidden">${admin.id}</td>
                    <td>${admin.name}</td>
                    <td>
                        <a href="${ctx}/admin/other.do?aid=${admin.id}">${admin.nick}</a>
                    </td>
                    <td>${admin.email}</td>
                    <td>
                        <c:if test="${admin.level==0}">
                            <div class="label label-blue">超级管理员</div>
                        </c:if>
                        <c:if test="${admin.level==1}">
                            <div class="label label-red">普通用户</div>
                        </c:if>
                        <c:if test="${admin.level==2}">
                            <div class="label label-yellow">游客</div>
                        </c:if>

                    </td>
                    <td>${admin.loginIp}</td>
                    <td>${admin.mobilePhone}</td>
                    <td>
                        <c:if test="${admin.isblocked==0}">
                            <div class="label label-success">生效</div>
                        </c:if>
                        <c:if test="${admin.isblocked==1}">
                            <div class="label label-warning">禁用</div>
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${admin.availableStatus==0}">
                            <div class="label label-black">下线</div>
                        </c:if>
                        <c:if test="${admin.availableStatus==1}">
                            <div class="label label-orange">上线</div>
                        </c:if>
                        <c:if test="${admin.availableStatus==2}">
                            <div class="label label-default">忙碌</div>
                        </c:if>
                        <c:if test="${admin.availableStatus==3}">
                            <div class="label label-danger">空闲</div>
                        </c:if>
                    </td>

                    <td><fmt:parseDate value="${admin.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td><fmt:parseDate value="${admin.modifyDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                </tr>
            </c:forEach>

            </tbody>
        </table>

    </div>
</div>



<!-- Bottom Scripts -->
<jsp:include page="commonjs.jsp"/>
<link rel="stylesheet" href="${ctx}/assets/js/datatables/dataTables.bootstrap.css">
<script src="${ctx}/assets/js/datatables/js/jquery.dataTables.min.js"></script>

<!-- Imported scripts on this page -->
<script src="${ctx}/assets/js/datatables/dataTables.bootstrap.js"></script>
<script src="${ctx}/assets/js/datatables/yadcf/jquery.dataTables.yadcf.js"></script>
<script src="${ctx}/assets/js/datatables/tabletools/dataTables.tableTools.min.js"></script>

<!-- JavaScripts initializations and stuff -->
<script src="${ctx}/assets/js/xenon-custom.js"></script>
<script src="${ctx}/assets/js/common-toast.js"></script>
</body>
<script>
    var type = "${Msg.getType()}";
    var content = "${Msg.getContent()}";
    ShowNotification(type, content);
</script>

</html>
