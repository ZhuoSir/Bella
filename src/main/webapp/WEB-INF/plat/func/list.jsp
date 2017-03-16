<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>

    <jsp:include page="../commoncss.jsp"/>
</head>
<body class="page-body">

<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">功能列表</h3>

        <div class="panel-options">
            <a href="#" data-toggle="panel">
                <span class="collapse-icon">&ndash;</span>
                <span class="expand-icon">+</span>
            </a>
            <a href="#" data-toggle="remove">
                &times;
            </a>
        </div>
    </div>

    <!-- 查询panel -->
    <div class="panel-body" style="margin-left: -100px">

        <form role="form" class="form-horizontal" action="${ctx}/Admin/func/query.do" method="post">

            <div class="form-group">

                <label class="col-xs-2 control-label" for="pf-field">功能标题</label>

                <div class="col-xs-2">
                    <input type="text" class="form-control" id="pf-field" name="funcName" placeholder="功能标题" value="${funcName}">
                </div>

                <label class="col-xs-2 control-label" for="fid-field">父节点ID</label>

                <div class="col-xs-2">
                    <input type="text" class="form-control" id="fid-field" name="parentFuncID" placeholder="父节点ID" value="${parentFuncID}">
                </div>

                <label class="col-xs-2 control-label">显示状态</label>

                <div class="col-xs-2">
                    <select class="form-control" name="status" >
                        <option value="1" <c:if test="${status == 1}">selected</c:if>>显示</option>
                        <option value="0" <c:if test="${status == 0}">selected</c:if>>隐藏</option>
                    </select>
                </div>

            </div>

            <div class="form-group">
                <button class="btn btn-secondary" style="margin-left: 120px" type="submit">查询</button>

                <button class="btn btn-turquoise" id="addFunc" type="button">添加</button>

                <button class="btn btn-purple" id="hiddenFunc" type="button" onclick="showAjaxModalForHidden()">隐藏</button>

                <button class="btn btn-info" id="showFunc" type="button" onclick="showAjaxModalForShow()">显示</button>
            </div>

        </form>

    </div>

    <div class="panel-body" style="margin-top: -20px">

        <table class="table table-bordered table-striped" id="example-2">
            <thead>
            <tr>
                <th class="no-sorting">
                    <input type="checkbox" class="cbr all">
                </th>
                <th style="text-align: center;">功能ID</th>
                <th style="text-align: center;">功能标题</th>
                <th style="text-align: center;">功能等级</th>
                <th style="text-align: center;">父节点ID</th>
                <th style="text-align: center;">显示状态</th>
                <th style="text-align: center;">操作</th>
            </tr>
            </thead>

            <tbody class="middle-align" id="plat-tbody">
            <c:forEach var="func" items="${platFuncs}">
                <tr data-id="${func.funcid}">
                    <td>
                        <input type="checkbox" class="cbr single">
                    </td>
                    <td style="text-align: center;" class="cid">${func.funcid}</td>
                    <td style="text-align: center;">${func.funcName}</td>
                    <td style="text-align: center;">${func.levelNum}</td>
                    <td style="text-align: center;">
                        <c:choose>
                            <c:when test="${func.parentFuncID==0}">
                                /
                            </c:when>
                            <c:otherwise>
                                ${func.parentFuncID}
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td style="text-align: center;">
                        <c:if test="${func.status==1}">
                            <div class="label label-warning">显示</div>
                        </c:if>
                        <c:if test="${func.status==0}">
                            <div class="label label-danger" >隐藏</div>
                        </c:if>
                    </td>
                    <td style="text-align: center;">
                        <a href="javascript:void(0);" class="btn btn-secondary btn-sm btn-icon icon-left" onclick="update(${func.funcid})">
                            编辑
                        </a>

                        <a href="javascript:void(0);" class="btn btn-danger btn-sm btn-icon icon-left" onclick="showAjaxModal(${func.funcid})" >
                            删除
                        </a>

                            <%--<c:if test="${func.status==1}">--%>
                            <%--<a href="#" class="btn btn-info btn-sm btn-icon icon-left">--%>
                            <%--显示--%>
                            <%--</a>--%>
                            <%--</c:if>--%>

                            <%--<c:if test="${func.status==0}">--%>
                            <%--<a href="#" class="btn btn-purple btn-sm btn-icon icon-left">--%>
                            <%--隐藏--%>
                            <%--</a>--%>
                            <%--</c:if>--%>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

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

    <script type="application/javascript">

        jQuery(document).ready(function($)
        {
            $("#example-2").dataTable({
                dom: "t" + "<'row'<'col-xs-6'i><'col-xs-6'p>>",
                aoColumns: [
                    {bSortable: false},
                    {bSortable: true},
                    {bSortable: false},
                    {bSortable: true},
                    {bSortable: true},
                    {bSortable: false},
                    {bSortable: false}
                ],
            });
            // Replace checkboxes when they appear
            var $state = $("#example-2 thead input[type='checkbox']");
            $("#example-2").on('draw.dt', function()
            {
                cbr_replace();
                $state.trigger('change');
            });
            // Script to select all checkboxes
            $state.on('change', function(ev)
            {
                var $chcks = $("#example-2 tbody input[type='checkbox']");
                if($state.is(':checked'))
                {
                    $chcks.prop('checked', true).trigger('change');
                }
                else
                {
                    $chcks.prop('checked', false).trigger('change');
                }
            });
        });


        $("#addFunc").click(function () {
            window.location.href = "${ctx}/Admin/func/edit.do";
        });

        function update(id) {
            window.location.href = "${ctx}/Admin/func/update.do?funcid=" + id;
        }

    </script>

</body>
</html>
