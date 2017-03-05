<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="user" value="${pageContext.session.getAttribute('admin')}"/>
<jsp:include page="commoncss.jsp"/>
<nav class="navbar user-info-navbar" role="navigation">

    <!-- Left links for user info navbar -->
    <ul class="user-info-menu left-links list-inline list-unstyled">

        <li class="hidden-sm hidden-xs">
            <a href="#" data-toggle="sidebar">
                <i class="fa-bars"></i>
            </a>
        </li>

        <li class="dropdown hover-line">
            <a href="#" data-toggle="dropdown">
                <i class="fa-envelope-o"></i>
                <span class="badge badge-green"></span>
            </a>

            <ul class="dropdown-menu messages">
                <li>
                    <ul class="dropdown-menu-list list-unstyled ps-scrollbar">
                    </ul>
                </li>

                <li class="external">
                    <a href="blank-sidebar.html">
                        <span>所有信息</span>
                        <i class="fa-link-ext"></i>
                    </a>
                </li>
            </ul>
        </li>

        <li class="dropdown hover-line">
            <a href="#" data-toggle="dropdown">
                <i class="fa-bell-o"></i>
                <span class="badge badge-purple"></span>
            </a>

            <ul class="dropdown-menu notifications">
                <li class="top">
                    <p class="small">
                        <a href="#" class="pull-right">标记所有</a>
                        <!-- You have <strong></strong> new notifications. -->
                    </p>
                </li>

                <li>
                    <ul class="dropdown-menu-list list-unstyled ps-scrollbar">
                    </ul>
                </li>

                <li class="external">
                    <a href="#">
                        <span>查看所有提示</span>
                        <i class="fa-link-ext"></i>
                    </a>
                </li>
            </ul>
        </li>

    </ul>


    <!-- Right links for user info navbar -->
    <ul class="user-info-menu right-links list-inline list-unstyled">

        <li class="search-form"><!-- You can add "always-visible" to show make the search input visible -->

            <form method="get" action="extra-search.html">
                <input type="text" name="s" class="form-control search-field" placeholder="Type to search..."/>

                <button type="submit" class="btn btn-link">
                    <i class="linecons-search"></i>
                </button>
            </form>

        </li>

        <li class="dropdown user-profile">
            <a href="#" data-toggle="dropdown">
                <c:if test="${user.headPicUrl==null || user.headPicUrl=='' }">
                    <img src="" alt="use" class="img-circle img-inline userpic-32"
                         width="28"/>
                </c:if>
                <c:if test="${user.headPicUrl!=null && user.headPicUrl != ''}">
                    <img src="" alt="use" class="img-circle img-inline userpic-32"
                         width="28"/>
                </c:if>
                <span>
								${user.nick}
								<i class="fa-angle-down"></i>
							</span>
            </a>

            <ul class="dropdown-menu user-profile-menu list-unstyled">
                <li>
                    <a href="#edit-profile">
                        <i class="fa-edit"></i>
                        发帖
                    </a>
                </li>
                <li>
                    <a href="#settings">
                        <i class="fa-wrench"></i>
                        设置
                    </a>
                </li>
                <li>
                    <a href="${ctx}/admin/mine.do">
                        <i class="fa-user"></i>
                        信息
                    </a>
                </li>
                <li>
                    <a href="#help">
                        <i class="fa-info"></i>
                        帮助
                    </a>
                </li>
                <li class="last">
                    <a href="${ctx}/Main/logout.do">
                        <i class="fa-lock"></i>
                        登出
                    </a>
                </li>
            </ul>
        </li>

        <li>
            <a href="#" data-toggle="chat">
                <i class="fa-comments-o"></i>
            </a>
        </li>

    </ul>

</nav>