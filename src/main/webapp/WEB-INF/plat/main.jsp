<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <jsp:include page="commoncss.jsp"/>
    <link rel="stylesheet" href="${ctx}/assets/js/datatables/dataTables.bootstrap.css">
    <title>首页</title>

</head>
<body class="page-body">

<jsp:include page="headset.jsp"/>

<div class="page-container">

    <jsp:include page="sidebar.jsp"/>

    <div class="main-content">

        <!-- User Info, Notifications and Menu Bar -->
        <jsp:include page="navigation.jsp"/>

        <div class="page-title">
            <div class="title-env">
                <h1 class="title">${title}</h1>
                <p class="description"></p>
            </div>
            <div class="breadcrumb-env">
                <ol class="breadcrumb bc-1">
                    <li>
                        <a href="/PPM/Main.do"><i class="fa-home"></i>主页</a>
                    </li>
                    <li class="active">
                        <strong>${title}</strong>
                    </li>
                </ol>
            </div>
        </div>

        <iframe src="${ctx}/main/404.do" style="width: 100%; height: 70%;" frameborder="0" scrolling="no">
            <p>浏览器不支持iframe</p>
        </iframe>

        <!-- Main Footer -->
        <jsp:include page="footer.jsp"/>
    </div>

    <!--  Chat Section -->
    <jsp:include page="chat.jsp"/>

</div>


<!-- Bottom Scripts -->
<jsp:include page="commonjs.jsp"/>
</body>


<script>

</script>
</html>