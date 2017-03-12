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


<div class="row">
    <div class="col-sm-12">

        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">添加功能</h3>
                <div class="panel-options">
                    <a href="#" data-toggle="panel">
                        <span class="collapse-icon">–</span>
                        <span class="expand-icon">+</span>
                    </a>
                    <a href="#" data-toggle="remove">
                        ×
                    </a>
                </div>
            </div>
            <div class="panel-body">

                <form role="form" class="form-horizontal" method="post" action="${ctx}/Admin/func/add.do">

                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="funcid">功能标题</label>

                        <div class="col-sm-3">
                            <input type="hidden" id="funcid" name="funcid" value="0">
                            <input type="text" class="form-control" id="funcName" name="funcName">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="levelNum">功能等级</label>

                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="levelNum" name="levelNum" value="0">
                            <%--<input type="hidden" id="update" name="update" value="${update}">--%>
                            <%--<input type="hidden" id="createTime" name="createTime" value="${thePlat.createTime}">--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="parentFuncID">父节点ID</label>

                        <div class="col-sm-3">
                            <select class="form-control" name="parentFuncID" id="parentFuncID">
                                <option value="0">/</option>
                                <c:forEach var="func" items="${funces}">
                                    <option value="${func.funcid}">${func.funcName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="status">状态</label>

                        <div class="col-sm-3">
                            <select class="form-control" name="status" id="status">
                                <option value="1">显示</option>
                                <option value="0">隐藏</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="description">功能描述</label>

                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="description" name="description">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="funcUrl">指向URL</label>

                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="funcUrl" name="funcUrl">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="funcIcon">图标URL</label>

                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="funcIcon" name="funcIcon">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="orderNum">排序序号</label>

                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="orderNum" name="orderNum" value="0">
                        </div>
                    </div>

                    <div class="form-group">

                        <div class="col-sm-3" style="margin-left: 10%">

                            <button class="btn btn-danger btn-lg" type="reset">重置</button>
                            <button class="btn btn-success btn-lg" type="submit">确定</button>

                        </div>

                    </div>

                </form>

            </div>
        </div>

    </div>
</div>


<!-- Bottom Scripts -->
<jsp:include page="../commonjs.jsp"/>
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
</html>
