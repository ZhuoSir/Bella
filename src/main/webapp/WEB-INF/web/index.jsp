<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bella论坛</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- 移动设备 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- 引入 Bootstrap -->
    <link href="${ctx}/webAssets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${ctx}/webAssets/css/nav.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/webAssets/css/base.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/webAssets/css/color.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/webAssets/css/post.css">

    <!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
    <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body class="body">

    <div class="nav">

        <div class="nav-logo">
            <a href="">
                <img src="${ctx}/webAssets/img/logo.svg" alt="logo" style="width:100%;height:100%;">
            </a>
        </div>

        <div class="nav-tabs">

            <c:forEach var="item" items="${webNavis}" varStatus="status">
                <a href="" class="nav-tabs-a <c:if test="${status.count == 1}">selected</c:if>">${item.title}</a>
            </c:forEach>
            <%--<a href="" class="nav-tabs-a selected">新闻</a>--%>
            <%--<a href="" class="nav-tabs-a">生活</a>--%>
            <%--<a href="" class="nav-tabs-a">社会</a>--%>
            <%--<a href="" class="nav-tabs-a">科技</a>--%>
            <%--<a href="" class="nav-tabs-a">军事</a>--%>
            <%--<a href="" class="nav-tabs-a">体育</a>--%>
            <%--<a href="" class="nav-tabs-a">视频</a>--%>
            <%--<a href="" class="nav-tabs-a">娱乐</a>--%>
            <%--<a href="" class="nav-tabs-a">搞笑</a>--%>

        </div>

        <form class="nav-search">
            <input type="input" class="nav-search-fmt" placeholder="Search Content">
        </form>

        <div class="user-nav">
            <div class="msg-div" style="float:left;">
                <a href="" id="aNotifications" class="msg color-red">5</a>
                <div class="anotifi-tip">
                    <a href="">消息7条</a>
                </div>
            </div>
            <div class="msg-div" style="float:left;">
                <a href="" style="padding-left: 0px;" class="msg">
                    <img src="${ctx}/webAssets/img/activity.svg" class="full">
                </a>
            </div>
            <div class="msg-div" style="float:right;">
                <a href="" style="padding-left: 0px;" class="msg">
                    <img src="${ctx}/webAssets/img/user.svg" class="full">
                </a>
                <div class="anotifi-tip2">
                    <a href="">个人主页</a>
                    <a href="">设置</a>
                    <a href="">帮助</a>
                    <a href="">登出</a>
                </div>
            </div>
        </div>
    </div>

    <div class="main">

        <div class="wrapper">
            <div class="content">
                <div class="module">
                    <div class="tabs-sub">
                        <a href="tag.html">Java</a>
                        <a href="">Spring</a>
                        <a href="">Hibernate</a>
                        <a href="">MySQL</a>
                        <a href="">Android</a>
                        <a href="">IDEA</a>
                        <a href="">Eclipse</a>
                        <a href="">Dubbo</a>
                        <a href="">Hadoop</a>
                    </div>
                    <div class="artical-list list">
                        <ul>
                            <li>
                                <div class="list-ft">
                                                      <span class="fn-left">
                                                            <a href="">JDK</a>&nbsp&nbsp
                                                            <a href="">Oracle</a>&nbsp&nbsp
                                                            <a href="">JNI</a>&nbsp&nbsp
                                                            <a href="">Netty</a>&nbsp&nbsp
                                                      </span>
                                    <span class="fn-right">
                                                         <a href="" class="ft-fade">
                                                            <b class="artical-level0">4</b> 回帖
                                                         </a>
                                                            &nbsp•&nbsp
                                                         <a href="" class="ft-fade">
                                                            <b class="artical-level1">100</b> 浏览
                                                         </a>
                                                      </span>
                                </div>
                                <h5><a href="" class="post-title">研究生怎么发展</a></h5>
                                <div class="post-fn">
                                    <div class="post-fn-flex">
                                        <a href="">
                                            <img src="http://img1.skqkw.cn:888/2014/11/15/10/zacke33f0o5-23294.jpg" class="avater" alter="头像">
                                        </a>
                                        <div class="ft-fade post-fn-flex">
                                            <a href="" class="author">
                                                北大高才僧
                                            </a>布衣码农，无冕数灵 <br>
                                            4 小时前
                                        </div>
                                    </div>
                                    <div>
                                        <a href="" class="simple-artical">

                                            项目开发碰到一个难题,开发中要用到图像处理,要获取每个像素的像素值,Android中的Bitmap类有getPixel(x, y)方法,然而iOS上没有这个方法...求解决啊!!!!!这个问题困扰了我好长时间了......

                                        </a>
                                    </div>
                                </div>
                            </li>

                            <li>
                                <div class="list-ft">
                                                      <span class="fn-left">
                                                            <a href="">MySQL</a>&nbsp&nbsp
                                                            <a href="">Java</a>&nbsp&nbsp
                                                      </span>
                                    <span class="fn-right">
                                                         <a href="" class="ft-fade">
                                                            <b class="artical-level0">2</b> 回帖
                                                         </a>
                                                            &nbsp•&nbsp
                                                         <a href="" class="ft-fade">
                                                            <b class="artical-level1">10</b> 浏览
                                                         </a>
                                                      </span>
                                </div>
                                <h5><a href="" class="post-title">MySql索引问题</a></h5>
                                <div class="post-fn">
                                    <div class="post-fn-flex">
                                        <a href="">
                                            <img src="http://img1.skqkw.cn:888/2014/11/26/08/iixrcnjeyxe-77006.jpg" class="avater" alter="头像">
                                        </a>
                                        <div class="ft-fade post-fn-flex">
                                            <a href="" class="author">
                                                爱你一万年
                                            </a> 曾经有份真挚的爱情<br>
                                            5 小时前
                                        </div>
                                    </div>
                                    <div>
                                        <a href="" class="simple-artical">

                                            Sping容器负责创建应用程序中的bean并通过DI来协调这些对象之间的关系。Spring具有非常大的灵活性，他提供了三种主要的装配机制 在XMl中显示配置 在java中显示配置 隐式的bean发现机制和自动装配 自动装配bean Spring 从两个角度来实现自动装配 组件扫描 自动装配 创建可被 ....

                                        </a>
                                    </div>
                                </div>
                            </li>

                            <li>
                                <div class="list-ft">
                                                      <span class="fn-left">
                                                            <a href="">Android</a>&nbsp&nbsp
                                                            <a href="">SDK</a>&nbsp&nbsp
                                                            <a href="">Java</a>&nbsp&nbsp
                                                      </span>
                                    <span class="fn-right">
                                                         <a href="" class="ft-fade">
                                                            <b class="artical-level0">0</b> 回帖
                                                         </a>
                                                            &nbsp•&nbsp
                                                         <a href="" class="ft-fade">
                                                            <b class="artical-level1">20</b> 浏览
                                                         </a>
                                                      </span>
                                </div>
                                <h5><a href="" class="post-title">Android Studio怎么用</a></h5>
                                <div class="post-fn">
                                    <div class="post-fn-flex">
                                        <a href="">
                                            <img src="http://dynamic-image.yesky.com/300x-/uploadImages/upload/20140912/upload/201409/pwlsiry01aujpg.jpg" class="avater" alter="头像">
                                        </a>
                                        <div class="ft-fade post-fn-flex">
                                            <a href="" class="author">
                                                六指狂魔
                                            </a> 废话少说拿命来 <br>
                                            6 小时前
                                        </div>
                                    </div>
                                    <div>
                                        <a href="" class="simple-artical">

                                            你们期待的终于来了，我可以算作是Android自学界的鼻祖了，之前自学的故事与分享的知识、经验影响了无数人，如今几年过去了，我经常收到不少人的感谢信，很多当初看我的教程的初学者如今已经在Android开发小有成就，而且让我欣慰的是他们也依然延续我的分享精神，影响更多的人。 如果你现在依然是一个And ....

                                        </a>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="list-ft">
                                                      <span class="fn-left">
                                                            <a href="">JDK</a>&nbsp&nbsp
                                                            <a href="">Oracle</a>&nbsp&nbsp
                                                            <a href="">JNI</a>&nbsp&nbsp
                                                            <a href="">Netty</a>&nbsp&nbsp
                                                      </span>
                                    <span class="fn-right">
                                                         <a href="" class="ft-fade">
                                                            <b class="artical-level0">4</b> 回帖
                                                         </a>
                                                            &nbsp•&nbsp
                                                         <a href="" class="ft-fade">
                                                            <b class="artical-level1">100</b> 浏览
                                                         </a>
                                                      </span>
                                </div>
                                <h5><a href="" class="post-title">研究生怎么发展</a></h5>
                                <div class="post-fn">
                                    <div class="post-fn-flex">
                                        <a href="">
                                            <img src="http://img1.skqkw.cn:888/2014/11/15/10/zacke33f0o5-23294.jpg" class="avater" alter="头像">
                                        </a>
                                        <div class="ft-fade post-fn-flex">
                                            <a href="" class="author">
                                                北大高才僧
                                            </a>布衣码农，无冕数灵 <br>
                                            4 小时前
                                        </div>
                                    </div>
                                    <div>
                                        <a href="" class="simple-artical">

                                            项目开发碰到一个难题,开发中要用到图像处理,要获取每个像素的像素值,Android中的Bitmap类有getPixel(x, y)方法,然而iOS上没有这个方法...求解决啊!!!!!这个问题困扰了我好长时间了......

                                        </a>
                                    </div>
                                </div>
                            </li>

                            <li>
                                <div class="list-ft">
                                                      <span class="fn-left">
                                                            <a href="">MySQL</a>&nbsp&nbsp
                                                            <a href="">Java</a>&nbsp&nbsp
                                                      </span>
                                    <span class="fn-right">
                                                         <a href="" class="ft-fade">
                                                            <b class="artical-level0">2</b> 回帖
                                                         </a>
                                                            &nbsp•&nbsp
                                                         <a href="" class="ft-fade">
                                                            <b class="artical-level1">10</b> 浏览
                                                         </a>
                                                      </span>
                                </div>
                                <h5><a href="" class="post-title">MySql索引问题</a></h5>
                                <div class="post-fn">
                                    <div class="post-fn-flex">
                                        <a href="">
                                            <img src="http://img1.skqkw.cn:888/2014/11/26/08/iixrcnjeyxe-77006.jpg" class="avater" alter="头像">
                                        </a>
                                        <div class="ft-fade post-fn-flex">
                                            <a href="" class="author">
                                                爱你一万年
                                            </a> 曾经有份真挚的爱情<br>
                                            5 小时前
                                        </div>
                                    </div>
                                    <div>
                                        <a href="" class="simple-artical">

                                            Sping容器负责创建应用程序中的bean并通过DI来协调这些对象之间的关系。Spring具有非常大的灵活性，他提供了三种主要的装配机制 在XMl中显示配置 在java中显示配置 隐式的bean发现机制和自动装配 自动装配bean Spring 从两个角度来实现自动装配 组件扫描 自动装配 创建可被 ....

                                        </a>
                                    </div>
                                </div>
                            </li>

                            <li>
                                <div class="list-ft">
                                                      <span class="fn-left">
                                                            <a href="">Android</a>&nbsp&nbsp
                                                            <a href="">SDK</a>&nbsp&nbsp
                                                            <a href="">Java</a>&nbsp&nbsp
                                                      </span>
                                    <span class="fn-right">
                                                         <a href="" class="ft-fade">
                                                            <b class="artical-level0">0</b> 回帖
                                                         </a>
                                                            &nbsp•&nbsp
                                                         <a href="" class="ft-fade">
                                                            <b class="artical-level1">20</b> 浏览
                                                         </a>
                                                      </span>
                                </div>
                                <h5><a href="" class="post-title">Android Studio怎么用</a></h5>
                                <div class="post-fn">
                                    <div class="post-fn-flex">
                                        <a href="">
                                            <img src="http://dynamic-image.yesky.com/300x-/uploadImages/upload/20140912/upload/201409/pwlsiry01aujpg.jpg" class="avater" alter="头像">
                                        </a>
                                        <div class="ft-fade post-fn-flex">
                                            <a href="" class="author">
                                                六指狂魔
                                            </a> 废话少说拿命来 <br>
                                            6 小时前
                                        </div>
                                    </div>
                                    <div>
                                        <a href="" class="simple-artical">

                                            你们期待的终于来了，我可以算作是Android自学界的鼻祖了，之前自学的故事与分享的知识、经验影响了无数人，如今几年过去了，我经常收到不少人的感谢信，很多当初看我的教程的初学者如今已经在Android开发小有成就，而且让我欣慰的是他们也依然延续我的分享精神，影响更多的人。 如果你现在依然是一个And ....

                                        </a>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="list-ft">
                                                      <span class="fn-left">
                                                            <a href="">JDK</a>&nbsp&nbsp
                                                            <a href="">Oracle</a>&nbsp&nbsp
                                                            <a href="">JNI</a>&nbsp&nbsp
                                                            <a href="">Netty</a>&nbsp&nbsp
                                                      </span>
                                    <span class="fn-right">
                                                         <a href="" class="ft-fade">
                                                            <b class="artical-level0">4</b> 回帖
                                                         </a>
                                                            &nbsp•&nbsp
                                                         <a href="" class="ft-fade">
                                                            <b class="artical-level1">100</b> 浏览
                                                         </a>
                                                      </span>
                                </div>
                                <h5><a href="" class="post-title">研究生怎么发展</a></h5>
                                <div class="post-fn">
                                    <div class="post-fn-flex">
                                        <a href="">
                                            <img src="http://img1.skqkw.cn:888/2014/11/15/10/zacke33f0o5-23294.jpg" class="avater" alter="头像">
                                        </a>
                                        <div class="ft-fade post-fn-flex">
                                            <a href="" class="author">
                                                北大高才僧
                                            </a>布衣码农，无冕数灵 <br>
                                            4 小时前
                                        </div>
                                    </div>
                                    <div>
                                        <a href="" class="simple-artical">

                                            项目开发碰到一个难题,开发中要用到图像处理,要获取每个像素的像素值,Android中的Bitmap类有getPixel(x, y)方法,然而iOS上没有这个方法...求解决啊!!!!!这个问题困扰了我好长时间了......

                                        </a>
                                    </div>
                                </div>
                            </li>

                            <li>
                                <div class="list-ft">
                                                      <span class="fn-left">
                                                            <a href="">MySQL</a>&nbsp&nbsp
                                                            <a href="">Java</a>&nbsp&nbsp
                                                      </span>
                                    <span class="fn-right">
                                                         <a href="" class="ft-fade">
                                                            <b class="artical-level0">2</b> 回帖
                                                         </a>
                                                            &nbsp•&nbsp
                                                         <a href="" class="ft-fade">
                                                            <b class="artical-level1">10</b> 浏览
                                                         </a>
                                                      </span>
                                </div>
                                <h5><a href="" class="post-title">MySql索引问题</a></h5>
                                <div class="post-fn">
                                    <div class="post-fn-flex">
                                        <a href="">
                                            <img src="http://img1.skqkw.cn:888/2014/11/26/08/iixrcnjeyxe-77006.jpg" class="avater" alter="头像">
                                        </a>
                                        <div class="ft-fade post-fn-flex">
                                            <a href="" class="author">
                                                爱你一万年
                                            </a> 曾经有份真挚的爱情<br>
                                            5 小时前
                                        </div>
                                    </div>
                                    <div>
                                        <a href="" class="simple-artical">

                                            Sping容器负责创建应用程序中的bean并通过DI来协调这些对象之间的关系。Spring具有非常大的灵活性，他提供了三种主要的装配机制 在XMl中显示配置 在java中显示配置 隐式的bean发现机制和自动装配 自动装配bean Spring 从两个角度来实现自动装配 组件扫描 自动装配 创建可被 ....

                                        </a>
                                    </div>
                                </div>
                            </li>

                            <li>
                                <div class="list-ft">
                                                      <span class="fn-left">
                                                            <a href="">Android</a>&nbsp&nbsp
                                                            <a href="">SDK</a>&nbsp&nbsp
                                                            <a href="">Java</a>&nbsp&nbsp
                                                      </span>
                                    <span class="fn-right">
                                                         <a href="" class="ft-fade">
                                                            <b class="artical-level0">0</b> 回帖
                                                         </a>
                                                            &nbsp•&nbsp
                                                         <a href="" class="ft-fade">
                                                            <b class="artical-level1">20</b> 浏览
                                                         </a>
                                                      </span>
                                </div>
                                <h5><a href="" class="post-title">Android Studio怎么用</a></h5>
                                <div class="post-fn">
                                    <div class="post-fn-flex">
                                        <a href="">
                                            <img src="http://dynamic-image.yesky.com/300x-/uploadImages/upload/20140912/upload/201409/pwlsiry01aujpg.jpg" class="avater" alter="头像">
                                        </a>
                                        <div class="ft-fade post-fn-flex">
                                            <a href="" class="author">
                                                六指狂魔
                                            </a> 废话少说拿命来 <br>
                                            6 小时前
                                        </div>
                                    </div>
                                    <div>
                                        <a href="" class="simple-artical">

                                            你们期待的终于来了，我可以算作是Android自学界的鼻祖了，之前自学的故事与分享的知识、经验影响了无数人，如今几年过去了，我经常收到不少人的感谢信，很多当初看我的教程的初学者如今已经在Android开发小有成就，而且让我欣慰的是他们也依然延续我的分享精神，影响更多的人。 如果你现在依然是一个And ....

                                        </a>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="pagination page-top">
                        <a href="" class="page page-selected">1</a>
                        <a href="" class="page">2</a>
                        <a href="" class="page">3</a>
                        <a href="" class="page">4</a>
                        <a href="" class="page">5</a>
                        <a href="" class="page">6</a>
                        <a href="" class="page">7</a>
                        <a href="" class="page">8</a>
                        <a href="" class="page">9</a>
                        <a href="" class="page">10</a>
                        <a href="" class="page">95>></a>
                    </div>
                </div>
            </div>



            <div class="side">
            <div class="module person-info" data-percent="0">
                <div class="info fn-clear">
                    <button class="btn red tooltipped">发帖</button>
                    <a href="" class="fn-right">每日签到</a>
                </div>
                <div class="module-pane tooltipped">
                    <div class="module-fn">
                        <strong>${userFolloVo.followLabelCount}</strong>
                        <span class="ft">关注标签</span>
                    </div>
                    <div class="module-fn">
                        <strong>${userFolloVo.followUserCount}</strong>
                        <span class="ft">关注用户</span>
                    </div>
                    <div class="module-fn">
                        <strong>${userFolloVo.storePostCount}</strong>
                        <span class="ft">收藏帖子</span>
                    </div>
                </div>
            </div>

            <div class="module">
                <div class="module-header">
                    <h5>近期热议</h5>
                </div>
                <div class="module-panel">
                    <ul class="module-list">
                        <c:forEach var="item" items="${hotPosts}">
                            <li>
                                <a href="">
                                    <img src="${item.headPicFileUrl}">
                                </a>
                                <a href="" class="title">${item.title}</a>
                            </li>
                        </c:forEach>
                    </ul>
                    </ul>
                    </ul>
                </div>
            </div>


            <div class="module">
                <div class="module-header"><h5>推荐标签</h5></div>
                <div class="module-panel">
                    <ul class="bq-ul">
                        <li>
                            <a href="">
                                <img src="https://static.hacpai.com/images/tags/jrebel.png">JRebel
                            </a>
                        </li>
                        <li>
                            <a href="">
                                <img src="https://static.hacpai.com/images/tags/nodejs.png">
                                node.js
                            </a>
                        </li>
                        <li>
                            <a href="">
                                <img src="https://static.hacpai.com/images/tags/love2d.png">
                                Love2D
                            </a>
                        </li>
                        <li>
                            <a href="">
                                <img src="https://static.hacpai.com/images/tags/redis.png">
                                Redis
                            </a>
                        </li>
                        <li>
                            <a href="">
                                <img src="https://static.hacpai.com/images/tags/v2ex.png">
                                V2EX
                            </a>
                        </li>
                        <li>
                            <a href="">
                                <img src="https://static.hacpai.com/images/tags/opensource.png">开源
                            </a>
                        </li>
                        <li>
                            <a href="">
                                <img src="https://static.hacpai.com/images/tags/jrebel.png">JRebel
                            </a>
                        </li>
                        <li>
                            <a href="">
                                <img src="https://static.hacpai.com/images/tags/nodejs.png">
                                node.js
                            </a>
                        </li>
                        <li>
                            <a href="">
                                <img src="https://static.hacpai.com/images/tags/love2d.png">
                                Love2D
                            </a>
                        </li>
                        <li>
                            <a href="">
                                <img src="https://static.hacpai.com/images/tags/redis.png">
                                Redis
                            </a>
                        </li>
                        <li>
                            <a href="">
                                <img src="https://static.hacpai.com/images/tags/v2ex.png">
                                V2EX
                            </a>
                        </li>
                        <li>
                            <a href="">
                                <img src="https://static.hacpai.com/images/tags/opensource.png">开源
                            </a>
                        </li>

                    </ul>
                </div>
            </div>

        </div>
    </div>


    <div class="footer">
        <div class="wrapper">
            <div class="slogan">

                这里是一个活跃的小众社区，大家相互<strong>信任</strong>，以<em>平等 • 自由 • 奔放</em>的价值分享交流

                <div class="footer-nav fn-clear">
                    <a rel="help" href="">关于</a>
                    <a href="">API</a>
                    <a href="">公告</a>
                    <a href="">领域</a>
                    <a href="">标签</a>
                    <a href="">熔炉    </a>
                    <a href="">数据统计</a>

                    <div class="fn-right">
                        <span class="ft-gray">© 2017</span>
                        <a rel="copyright" href="" target="_blank">陈卓</a>
                    </div>
                </div>
            </div>
        </div>
    </div>


</div>

<script src="${ctx}/webAssets/js/jquery.js"></script>
<script src="${ctx}/webAssets/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">

    $(function () {
        $('[data-toggle="popover"]').popover()
    })

</script>
</body>
</html>
