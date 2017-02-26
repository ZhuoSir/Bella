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
					<!-- add class "multiple-expanded" to allow multiple submenus to open -->
					<!-- class "auto-inherit-active-class" will automatically add "active" class for parent elements who are marked already with class "active" -->
					<c:forEach var="Amenu" items="${platMenus}">
						<li>
							<a href="">
								<i class="${Amenu.getPlatfunction().iconurl}"></i>
								<span class="title">${Amenu.getPlatfunction().title}</span>
								<!-- <span class="label label-purple pull-right hidden-collapsed">New Items</span> -->
							</a>
							<c:if test="${Amenu.getChildMenu().size()!=0}">
								<ul>
									<c:forEach var="Bmenu" items="${Amenu.getChildMenu()}">
										<li>
											<a href="${Bmenu.getPlatfunction().url}">
												<i class="${Bmenu.getPlatfunction().iconurl}"></i>
												<span class="title">${Bmenu.getPlatfunction().title}</span>
											</a>
											<c:if test="${Bmenu.getChildMenu().size()!=0}">
												<ul>
													<c:forEach var="Cmenu" items="${Bmenu.getChildMenu()}">
														<li>
															<a href="${Cmenu.getPlatfunction().url}">
																<i class="${Cmenu.getPlatfunction().iconurl}"></i>
																<span class="title">${Cmenu.getPlatfunction().title}</span>
															</a>
														</li>
													</c:forEach>
												</ul>
											</c:if>
										</li>
									</c:forEach>
								</ul>
							</c:if>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
  </body>
  <script type="text/javascript" charset="UTF-8" src="${ctx}/assets/js/jquery-1.11.1.min.js"></script>
  <script>
	  <%--var platMenus = JSON.parse(${platMenus});--%>
//	  init();
//	  function init() {
//		  for (var i=0;i<platMenus.length;i++){
//			  $("main-menu").append('<li>'
//					  			+		'<a href="">'
//			  					+			'<i class="'+ platMenus[i].platfunction.iconurl + '"></i>'
//							  	+			'<span class="title">' + platMenus[i].platfunction.title + '</span>'
//			  					+		'<a>'
//			  					+	'<li>');
////			  var classAMenu = platMenus[i];
////			  var Achilds = classAMenu.childMenu;
////			  if (Achilds.length>0){
////
////			  }
//		  }
//	  }

  </script>
</html>
