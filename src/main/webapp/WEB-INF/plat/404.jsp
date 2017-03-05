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
<body style="font-family: 微软雅黑">


        <!-- User Info, Notifications and Menu Bar -->
        <%--<jsp:include page="navigation.jsp"/>--%>

        <div class="page-error centered">

            <div class="error-symbol">
                <i class="fa-warning"></i>
            </div>

            <h2>
                Error 404
                <small>Page not found!</small>
            </h2>

            <p>We did not find the page you were looking for!</p>
            <p>You can search again or contact one of our agents to help you!</p>

        </div>

        <div class="page-error-search centered">
            <form class="form-half" method="get" action="" enctype="application/x-www-form-urlencoded">
                <input type="text" class="form-control" placeholder="Search...">

                <button type="submit" class="btn-unstyled">
                    <i class="linecons-search"></i>
                </button>
            </form>

            <a href="#" class="go-back">
                <i class="fa-angle-left"></i>
                Go Back
            </a>
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
