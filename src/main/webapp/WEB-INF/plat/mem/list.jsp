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

    <!-- 查询panel -->
    <div class="panel-body" style="margin-left: -100px">

        <form role="form" class="form-horizontal" action="${ctx}/Admin/member/query.do" method="post">

            <div class="form-group">

                <label class="col-xs-2 control-label" for="queryBuilder">账户名</label>

                <div class="col-xs-2">
                    <input type="text" class="form-control" id="queryBuilder" name="queryBuilder" placeholder="查询条件" value="${queryBuilder}">
                </div>

                <label class="col-xs-2 control-label">账户状态</label>

                <div class="col-xs-2">
                    <select class="form-control" name="status" >
                        <option value="0" <c:if test="${status == 0}">selected</c:if>>生效</option>
                        <option value="1" <c:if test="${status == 1}">selected</c:if>>禁用</option>
                    </select>
                </div>

            </div>

            <div class="form-group">
                <button class="btn btn-secondary" style="margin-left: 120px" type="submit">查询</button>

                <button class="btn btn-purple" id="off" type="button" onclick="showAjaxModalForHidden()">禁用</button>

                <button class="btn btn-info" id="on" type="button" onclick="showAjaxModalForShow()">生效</button>
            </div>

        </form>

    </div>

    <div class="panel-body" style="margin-top: -20px;">

        <table class="table table-bordered table-striped" id="example-2" style="font-size: 13px">
            <thead>
            <tr>
                <th class="no-sorting">
                    <input type="checkbox" class="cbr all">
                </th>
                <th style="text-align: center;">ID</th>
                <th style="text-align: center;">账户名</th>
                <th style="text-align: center;">昵称</th>
                <th style="text-align: center;">邮箱</th>
                <th style="text-align: center;">手机号</th>
                <th style="text-align: center;">账户状态</th>
                <th style="text-align: center;">操作</th>
            </tr>
            </thead>

            <tbody class="middle-align" id="plat-tbody">
            <c:forEach var="mem" items="${memberList}">
                <tr data-id="${mem.ID}">
                    <td>
                        <input type="checkbox" class="cbr single">
                    </td>
                    <td style="text-align: center;">${mem.ID}</td>
                    <td style="text-align: center;" class="cid">${mem.accountName}</td>
                    <td style="text-align: center;">${mem.nickName}</td>
                    <td style="text-align: center;">${mem.email}</td>
                    <td style="text-align: center;">${mem.mobilePhone}</td>
                    <td style="text-align: center;">
                        <c:if test="${mem.status==1}">
                            <div class="label label-warning">禁用</div>
                        </c:if>
                        <c:if test="${mem.status==0}">
                            <div class="label label-danger" >生效</div>
                        </c:if>
                    </td>
                    <td style="text-align: center;">
                        <a href="javascript:void(0);" class="btn btn-secondary btn-sm btn-icon icon-left" onclick="update(${func.funcid})">
                            编辑
                        </a>

                        <a href="javascript:void(0);" class="btn btn-danger btn-sm btn-icon icon-left" onclick="showAjaxModal(${func.funcid})" >
                            删除
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</div>

<div class="modal fade" id="modal-2">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">系统提示</h4>
            </div>

            <div class="modal-body">
                确定禁用用户？
            </div>

            <input value="" type="hidden" id="model_content2">

            <div class="modal-footer">
                <button type="button" class="btn btn-white" data-dismiss="modal" id="modal-cancel">取消</button>
                <button type="button" class="btn btn-info" onclick="activeOrForbid(1)" data-dismiss="modal" id="modal-ok">确定</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="modal-3">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">系统提示</h4>
            </div>

            <div class="modal-body" id="modal-content">
                确定生效用户？
            </div>

            <input value="" type="hidden" id="model_content3">

            <div class="modal-footer">
                <button type="button" class="btn btn-white" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-info" onclick="activeOrForbid(0)" data-dismiss="modal">确定</button>
            </div>
        </div>
    </div>
</div>

    <!-- Bottom Scripts -->
    <jsp:include page="../commonjs.jsp"/>
    <link rel="stylesheet" href="${ctx}/assets/js/datatables/dataTables.bootstrap.css">
    <script src="${ctx}/assets/js/datatables/js/jquery.dataTables.min.js"></script>
    <script src="${ctx}/assets/js/bootstrap.min.js"></script>

    <!-- Imported scripts on this page -->
    <script src="${ctx}/assets/js/datatables/dataTables.bootstrap.js"></script>
    <script src="${ctx}/assets/js/datatables/yadcf/jquery.dataTables.yadcf.js"></script>
    <script src="${ctx}/assets/js/datatables/tabletools/dataTables.tableTools.min.js"></script>

    <!-- JavaScripts initializations and stuff -->
    <script src="${ctx}/assets/js/xenon-custom.js"></script>
    <script src="${ctx}/assets/js/common-toast.js"></script>


</body>

<script type="text/javascript">

    $(document).ready(function($)
    {
        $("#example-2").dataTable({
            dom: "t" + "<'row'<'col-xs-6'i><'col-xs-6'p>>",
            aoColumns: [
                {bSortable: false},
                {bSortable: true},
                {bSortable: false},
                {bSortable: true},
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

    function showAjaxModalForHidden(){
        var ids = "";
        $("#plat-tbody").find("tr").each(function () {
            if ($(this).find(".single").prop("checked")){
                ids = $(this).data("id") + "," + ids;
            }
        });
        ids = ids.substring(0,(ids.length-1));
        if (ids==""){
            toastr.warning("至少选择一个操作项！", "操作警告", warn);
        } else {
            $("#model_content2").val(ids);
            jQuery('#modal-2').modal('show', {backdrop: 'fade'});
        }
    }

    function showAjaxModalForShow(){
        var ids = "";
        $("#plat-tbody").find("tr").each(function () {
            if ($(this).find(".single").prop("checked")){
                ids = $(this).data("id") + "," + ids;
            }
        });
        ids = ids.substring(0,(ids.length-1));
        if (ids==""){
            toastr.warning("至少选择一个操作项！", "操作警告", warn);
        } else {
            $("#model_content3").val(ids);
            jQuery('#modal-3').modal('show', {backdrop: 'fade'});
        }
    }

    function activeOrForbid(sta) {
        var memberIDs = "";
        if (sta == 0) {
            memberIDs = $("#model_content3").val();
        } else {
            memberIDs = $("#model_content2").val();
        }

        $.ajax({
            url: "${ctx}/Admin/member/activeOrforbid.do",
            method: 'POST',
            dataType: 'json',
            data: {
                memberIDs : memberIDs,
                status : sta
            },
            success: function(msg)
            {
                if (msg.result) {
                    window.location.reload();
                } else {
                    ShowNotification("error" , msg.error);
                }
            }
        });
    }

</script>


</html>
