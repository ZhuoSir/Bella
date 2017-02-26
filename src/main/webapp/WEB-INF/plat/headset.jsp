<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="user" value="${pageContext.session.getAttribute('admin')}" />
<jsp:include page="commoncss.jsp"/>
<!DOCTYPE html>
<html>
<body>
<div class="settings-pane">

    <a href="#" data-toggle="settings-pane" data-animate="true">
        &times;
    </a>

    <div class="settings-pane-inner">

        <div class="row">

            <div class="col-md-4">

                <div class="user-info">

                    <div class="user-image">
                        <a href="${ctx}/admin/profile.do">
                            <c:if test="${user.headPicUrl==null || user.headPicUrl == '' }">
                                <img src="${ctx}/pic/defaulthead.png" class="img-responsive img-circle" />
                            </c:if>
                            <c:if test="${user.headPicUrl!=null && user.headPicUrl != ''}">
                                <img src="${ctx}/${user.headPicUrl}" class="img-responsive img-circle" />
                            </c:if>
                        </a>
                    </div>

                    <div class="user-details">

                        <h3>
                            <a href="${ctx}/admin/profile.do">${user.nick}</a>

                            <!-- Available statuses: is-online, is-idle, is-busy and is-offline -->
                            <c:if test="${user.availableStatus == 0}">
                                <span class="user-status is-offline"></span>
                            </c:if>
                            <c:if test="${user.availableStatus == 1}">
                                <span class="user-status is-online"></span>
                            </c:if>
                            <c:if test="${user.availableStatus == 2}">
                                <span class="user-status is-busy"></span>
                            </c:if>
                            <c:if test="${user.availableStatus == 3}">
                                <span class="user-status is-idle"></span>
                            </c:if>
                        </h3>

                        <c:if test="${user.level == 0}">
                            <p class="user-title">超级管理员</p>
                        </c:if>

                        <c:if test="${user.level == 1}">
                            <p class="user-title">普通用户</p>
                        </c:if>

                        <div class="user-links">
                            <a href="${ctx}/admin/profile.do" class="btn btn-primary">编辑个人信息</a>
                            <a href="" class="btn btn-success">个人空间</a>
                        </div>

                    </div>

                </div>

            </div>

            <div class="col-md-8 link-blocks-env">

                <div class="links-block left-sep">
                    <h4>
                        <span>消息通知</span>
                    </h4>

                    <ul class="list-unstyled">
                        <li>
                            <input type="checkbox" class="cbr cbr-primary" checked="checked" id="sp-chk1" />
                            <label for="sp-chk1">信息</label>
                        </li>
                        <li>
                            <input type="checkbox" class="cbr cbr-primary" checked="checked" id="sp-chk2" />
                            <label for="sp-chk2">事件</label>
                        </li>
                        <li>
                            <input type="checkbox" class="cbr cbr-primary" checked="checked" id="sp-chk3" />
                            <label for="sp-chk3">更新</label>
                        </li>
                        <li>
                            <input type="checkbox" class="cbr cbr-primary" checked="checked" id="sp-chk4" />
                            <label for="sp-chk4">服务器时间</label>
                        </li>
                    </ul>
                </div>

                <%--<div class="links-block left-sep">--%>
                <%--<h4>--%>
                <%--<a href="#">--%>
                <%--<span>Help Desk</span>--%>
                <%--</a>--%>
                <%--</h4>--%>
                <%----%>
                <%--<ul class="list-unstyled">--%>
                <%--<li>--%>
                <%--<a href="#">--%>
                <%--<i class="fa-angle-right"></i>--%>
                <%--Support Center--%>
                <%--</a>--%>
                <%--</li>--%>
                <%--<li>--%>
                <%--<a href="#">--%>
                <%--<i class="fa-angle-right"></i>--%>
                <%--Submit a Ticket--%>
                <%--</a>--%>
                <%--</li>--%>
                <%--<li>--%>
                <%--<a href="#">--%>
                <%--<i class="fa-angle-right"></i>--%>
                <%--Domains Protocol--%>
                <%--</a>--%>
                <%--</li>--%>
                <%--<li>--%>
                <%--<a href="#">--%>
                <%--<i class="fa-angle-right"></i>--%>
                <%--Terms of Service--%>
                <%--</a>--%>
                <%--</li>--%>
                <%--</ul>--%>
                <%--</div>--%>
            </div>
        </div>
    </div>
</div>
</body>
</html>