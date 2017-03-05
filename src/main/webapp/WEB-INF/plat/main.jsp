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

        <iframe id="page" src="${ctx}/Admin/main/welcome.do" onload="changeFrameHeight()" style="width: 100%;" frameborder="0" scrolling="no">
            <p>浏览器不支持iframe</p>
        </iframe>

        <!-- Main Footer -->
        <%--<jsp:include page="footer.jsp"/>--%>
    </div>

    <!--  Chat Section -->
    <jsp:include page="chat.jsp"/>

</div>

<!-- Bottom Scripts -->
<jsp:include page="commonjs.jsp"/>
</body>

<script>

    function redirect(url) {
        document.getElementById("page").src = url;
    }

    function changeFrameHeight(){
        var ifm = document.getElementById("page");
        ifm.height = 0;
        ifm.height = ifm.contentDocument.body.scrollHeight;
    }

</script>
</html>