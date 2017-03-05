<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="platMenus" value="${pageContext.session.getAttribute('PlatMenus')}" />
<!DOCTYPE html>
<html>
  
  <body>
  
  	<div class="sidebar-menu toggle-others fixed">
			
			<div class="sidebar-menu-inner">	
				
				<header class="logo-env">
					
					<!-- logo -->
					<div class="logo">
						<a href="${ctx}/Main.do" class="logo-expanded">
							<img src="${ctx}/assets/images/logo@2x.png" width="80" alt="" />
						</a>
						
						<a href="" class="logo-collapsed">
							<img src="${ctx}/assets/images/logo-collapsed@2x.png" width="40" alt="" />
						</a>
					</div>
					
					<!-- This will toggle the mobile menu and will be visible only on mobile devices -->
					<div class="mobile-menu-toggle visible-xs">
						<a href="#" data-toggle="user-info-menu">
							<i class="fa-bell-o"></i>
							<span class="badge badge-success">7</span>
						</a>
						
						<a href="#" data-toggle="mobile-menu">
							<i class="fa-bars"></i>
						</a>
					</div>
					
					<!-- This will open the popup with user profile settings, you can use for any purpose, just be creative -->
					<div class="settings-icon">
						<a href="#" data-toggle="settings-pane" data-animate="true">
							<i class="linecons-cog"></i>
						</a>
					</div>
								
				</header>
						
				<ul id="main-menu" class="main-menu">
					<li>
						<a href="">
							<i class="linecons-cog"></i>
							<span class="title">项目管理</span>
						</a>
						<ul>
							<li>
								<a href="javascript:void(0)" onclick="redirect('${ctx}/Admin/main/test.do')">
									<i class=""></i>
									<span class="title">项目列表</span>
								</a>
							</li>
							<li>
								<a href="javascript:void(0)" onclick="redirect('${ctx}/Admin/main/404.do')">
									<i class=""></i>
									<span class="title">404</span>
								</a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
  </body>
  <script type="text/javascript" charset="UTF-8" src="${ctx}/assets/js/jquery-1.11.1.min.js"></script>

  <script>

  </script>
</html>
