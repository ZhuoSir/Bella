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
    <div class="panel-heading">
        <h3 class="panel-title">会员列表</h3>

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
    <div class="panel-body">

        <script type="text/javascript">
            jQuery(document).ready(function($)
            {
                $("#memberlist").dataTable({
                    aLengthMenu: [
                        [10, 25, 50, 100, -1], [10, 25, 50, 100, "All"]
                    ]
                });
            });
        </script>

        <table id="memberlist" class="table table-striped table-bordered" cellspacing="0" width="100%" style="font-size: 13px">
            <thead>
            <tr>
                <th class="no-sorting">
                    <input type="checkbox" class="cbr all">
                </th>
                <th hidden="hidden">ID</th>
                <th>账户名</th>
                <th>昵称</th>
                <th>邮件</th>
                <th>电话号码</th>
                <th>账户状态</th>
                <th>创建时间</th>
            </tr>
            </thead>

            <%--<tfoot>--%>
            <%--<tr>--%>
                <%--<td>--%>

                <%--</td>--%>
                <%--<th hidden="hidden">ID</th>--%>
                <%--<th>Name</th>--%>
                <%--<th>Nick</th>--%>
                <%--<th>Email</th>--%>
                <%--<th>MobilePhone</th>--%>
                <%--<th>Status</th>--%>
                <%--<th>CreateTime</th>--%>
            <%--</tr>--%>
            <%--</tfoot>--%>

            <tbody>

            <c:forEach var="mem" items="${memberList}">
                <tr>
                    <td>
                        <input type="checkbox" class="cbr single">
                    </td>
                    <td hidden="hidden">${mem.ID}</td>
                    <td>${mem.accountName}</td>
                    <td>
                        <a href="${ctx}/admin/other.do?aid=${mem.ID}">${mem.nickName}</a>
                    </td>
                    <td>${mem.email}</td>
                    <td>${mem.mobilePhone}</td>
                    <td>
                        <c:if test="${mem.status==0}">
                            <div class="label label-black">生效</div>
                        </c:if>
                        <c:if test="${mem.status==1}">
                            <div class="label label-orange">禁用</div>
                        </c:if>
                    </td>
                    <td><fmt:formatDate value="${mem.addTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                </tr>
            </c:forEach>

            </tbody>
        </table>

    </div>
</div>



<link rel="stylesheet" href="${ctx}/assets/js/datatables/dataTables.bootstrap.css">
<script src="${ctx}/assets/js/datatables/js/jquery.dataTables.min.js"></script>

<!-- Imported scripts on this page -->
<script src="${ctx}/assets/js/datatables/dataTables.bootstrap.js"></script>
<script src="${ctx}/assets/js/datatables/yadcf/jquery.dataTables.yadcf.js"></script>
<script src="${ctx}/assets/js/datatables/tabletools/dataTables.tableTools.min.js"></script>

<!-- JavaScripts initializations and stuff -->
<script src="${ctx}/assets/js/xenon-custom.js"></script>
<script src="${ctx}/assets/js/common-toast.js"></script>

<!-- Bottom Scripts -->
<jsp:include page="../commonjs.jsp"/>

<script type="application/javascript">
    jQuery(document).ready(function($)
    {
        $("#memberlist").dataTable({
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
        var $state = $("#memberlist thead input[type='checkbox']");
        $("#memberlist").on('draw.dt', function()
        {
            cbr_replace();
            $state.trigger('change');
        });
        // Script to select all checkboxes
        $state.on('change', function(ev)
        {
            var $chcks = $("#memberlist tbody input[type='checkbox']");
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

</script>

</body>
</html>
