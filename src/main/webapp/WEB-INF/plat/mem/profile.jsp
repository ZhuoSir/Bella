<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>

    <jsp:include page="../commoncss.jsp"/>
</head>
<body>

<div class="panel panel-default">
    <%--<div class="panel-heading hidden-print">${title}</div>--%>
    <div class="panel-body">

        <section class="invoice-env">

            <!-- Invoice header -->
            <div class="invoice-header">

                <!-- Invoice Options Buttons -->
                <div class="invoice-options hidden-print">

                    <a href="#" class="btn btn-block btn-purple btn-icon btn-icon-standalone btn-icon-standalone-right text-left">
                        <i class="fa-at"></i>
                        <span>添加好友</span>
                    </a>

                    <a href="#" class="btn btn-block btn-gray btn-icon btn-icon-standalone btn-icon-standalone-right text-left">
                        <i class="fa-envelope-o"></i>
                        <span>发送邮件</span>
                    </a>

                </div>

                <!-- Invoice Data Header -->
                <div class="invoice-logo">

                    <a class="logo">
                        <c:if test="${member.headPicFileURL==null || member.headPicFileURL == ''}">
                            <img src="${ctx}/pic/defaulthead.png" style="width: 150px;" class="img-responsive">
                        </c:if>
                        <c:if test="${member.headPicFileURL!=null && member.headPicFileURL != ''}">
                            <img src="${ctx}/${member.headPicFileURL}" style="width: 150px;" class="img-responsive">
                        </c:if>

                    </a>

                    <ul class="list-unstyled">
                        <li class="upper">会员序号 <strong>#${member.ID}</strong></li>
                        <li>账户名:${member.accountName}</li>
                        <li>昵称:${member.nickName}</li>
                    </ul>

                </div>

            </div>


            <!-- Client and Payment Details -->
            <div class="invoice-details">

                <div class="invoice-client-info">
                    <strong>详细信息</strong>

                    <ul class="list-unstyled">
                        <li>手机号码 #: <strong>${member.mobilePhone}</strong></li>
                        <li>电子邮件: <strong>${member.email}</strong> </li>
                    </ul>
                </div>

                <div class="invoice-payment-info">
                    <ul class="list-unstyled">
                        <li>性别: <strong><c:if test="${memberInfo.sex == 0}">男</c:if><c:if test="${memberInfo.sex == 1}">女</c:if></strong></li>
                        <li>用户职业: <strong>${memberInfo.memberProfile}</strong> </li>
                        <li>个人主页: <strong><a>${memberInfo.memberWebUrl}</a></strong></li>
                        <li>出生日期: <strong><fmt:formatDate value="${memberInfo.memberBirthDay}"/></strong></li>
                    </ul>
                </div>


            </div>
            

        </section>

    </div>
</div>



<!-- Bottom Scripts -->
<jsp:include page="../commonjs.jsp"/>
<link rel="stylesheet" href="${ctx}/assets/js/datatables/dataTables.bootstrap.css">
<script src="${ctx}/assets/js/bootstrap.min.js"></script>
<script src="${ctx}/assets/js/datatables/js/jquery.dataTables.min.js"></script>
<script src="${ctx}/assets/js/TweenMax.min.js"></script>
<script src="${ctx}/assets/js/resizeable.js"></script>
<script src="${ctx}/assets/js/joinable.js"></script>
<script src="${ctx}/assets/js/xenon-api.js"></script>
<script src="${ctx}/assets/js/xenon-toggles.js"></script>


<!-- JavaScripts initializations and stuff -->
<script src="${ctx}/assets/js/xenon-custom.js"></script>
<script src="${ctx}/assets/js/common-toast.js"></script>

</body>
</html>
