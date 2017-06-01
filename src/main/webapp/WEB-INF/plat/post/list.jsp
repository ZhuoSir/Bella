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
        <h3 class="panel-title">帖子列表</h3>

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

        <form role="form" class="form-horizontal" action="${ctx}/Admin/post/query.do" method="post">

            <div class="form-group">

                <label class="col-xs-2 control-label" for="pf-field">帖子标题</label>

                <div class="col-xs-2">
                    <input type="text" class="form-control" id="pf-field" name="title" placeholder="帖子标题" value="${title}">
                </div>

                <label class="col-xs-2 control-label" for="fid-field">贴主</label>

                <div class="col-xs-2">
                    <input type="text" class="form-control" id="fid-field" name="author" placeholder="贴主" value="${author}">
                </div>

                <label class="col-xs-2 control-label">显示状态</label>

                <div class="col-xs-2">
                    <select class="form-control" name="status" >
                        <option value="0" <c:if test="${status == 0}">selected</c:if>>显示</option>
                        <option value="-1" <c:if test="${status == -1}">selected</c:if>>隐藏</option>
                        <option value="-9" <c:if test="${status == -9}">selected</c:if>>删除</option>
                        <option value="-8" <c:if test="${status == -8}">selected</c:if>>禁止回复</option>
                    </select>
                </div>

            </div>

            <div class="form-group">
                <button class="btn btn-secondary" style="margin-left: 120px" type="submit">查询</button>

                <button class="btn btn-purple" id="hiddenpost" type="button" onclick="showAjaxModalForHidden()">隐藏</button>

                <button class="btn btn-info" id="showpost" type="button" onclick="showAjaxModalForShow()">显示</button>
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
                <th style="text-align: center;">帖子ID</th>
                <th style="text-align: center;">帖子标题</th>
                <th style="text-align: center;">贴主</th>
                <th style="text-align: center;">回复数</th>
                <th style="text-align: center;">创建时间</th>
                <th style="text-align: center;">显示状态</th>
                <th style="text-align: center;">操作</th>
            </tr>
            </thead>

            <tbody class="middle-align" id="plat-tbody">
            <c:forEach var="post" items="${postList}">
                <tr data-id="${post.postID}">
                    <td>
                        <input type="checkbox" class="cbr single">
                    </td>
                    <td style="text-align: center;" class="cid">${post.postID}</td>
                    <td style="text-align: center;">${post.title}</td>
                    <td style="text-align: center;">${post.accountName}</td>
                    <td style="text-align: center;">${post.replyTimes}</td>
                    <td style="text-align: center;">${post.createTime}</td>
                    <td style="text-align: center;">
                        <c:if test="${post.status==0}">
                            <div class="label label-default">正常</div>
                        </c:if>
                        <c:if test="${post.status==-1}">
                            <div class="label label-danger" >隐藏</div>
                        </c:if>
                        <c:if test="${post.status==-8}">
                            <div class="label label-blue" >禁止回复</div>
                        </c:if>
                        <c:if test="${post.status==-9}">
                            <div class="label label-black" >删除</div>
                        </c:if>
                    </td>
                    <td style="text-align: center;">
                        <a href="javascript:void(0);" class="btn btn-secondary btn-sm btn-icon icon-left" onclick="update(${post.postID})">
                            编辑
                        </a>

                        <a href="javascript:void(0);" class="btn btn-danger btn-sm btn-icon icon-left" onclick="showAjaxModal(${post.postID})" >
                            删除
                        </a>

                            <%--<c:if test="${post.status==1}">--%>
                            <%--<a href="#" class="btn btn-info btn-sm btn-icon icon-left">--%>
                            <%--显示--%>
                            <%--</a>--%>
                            <%--</c:if>--%>

                            <%--<c:if test="${post.status==0}">--%>
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

    jQuery(document).ready(posttion($)
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
        $("#example-2").on('draw.dt', posttion()
        {
            cbr_replace();
            $state.trigger('change');
        });
        // Script to select all checkboxes
        $state.on('change', posttion(ev)
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


    $("#addpost").click(posttion () {
        window.location.href = "${ctx}/Admin/post/edit.do";
    });

    posttion update(id) {
        window.location.href = "${ctx}/Admin/post/update.do?postid=" + id;
    }

</script>

</body>
</html>
