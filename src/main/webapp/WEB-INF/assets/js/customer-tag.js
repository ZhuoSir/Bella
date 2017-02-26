/**
 * Created by sunny-chen on 16/11/20.
 */
function searchTages(pid) {
    var kinds = getCheckedStr('.kind');
    var types = getCheckedStr('.type');
    var prioritys = getCheckedStr('.priority');
    var version = $("#versionSelect").val();
    var model = $("#modelSelect").val();
    $.ajax({
        type: "POST",
        url: "search.do",
        data: {
            proid: pid,
            kinds: kinds,
            types: types,
            versionID: version,
            modelID: model,
            prioritys: prioritys
        },
        dataType: "json",
        success: function (data) {
            var tdlist = data.tdlist;
            $("#tagbody").html(tdlist);
        }
    });
}

//提交新版本前端校验
function validateBeforSubmitNewVersion(pid) {
    var version = $("#version").val();
    var build = $("#build").val();
    if (version == null || version == "") {
        ShowNotification("warn", "版本号不能为空");
        return false;
    }
    if (build == null || build == "") {
        ShowNotification("warn", "build不能为空");
        return false;
    }
    var flag = false;
    $.ajax({
        type: "POST",
        url: "checkVersion.do",
        async: false,
        data: {
            proid: pid,
            version: version
        },
        dataType: "json",
        success: function (data) {
            if (data.type != "success") {
                ShowNotification(data.type, data.content);
                flag = false;
            } else {
                flag = true;
            }
        }
    });
    return flag;
}

function editTagModelShow(id, pid) {
    var tr = $(id).parents('.tr-tagslist');
    var ID = $(tr).children().get(0);
    var iD = $("#mod-id");
    var title = $("#mod-title");
    var ctime = $("#mod-createtime");
    var mtime = $("#mod-modifyTime");
    var detail = $("#mod-detail");
    var type = $("#mod-type");
    var priority = $("#mod-priority");
    var kind = $("#mod-kind");
    var feedback = $("#mod-feedback");
    var point = $("#mod-point");
    var proid = $("#mod-proid");
    var modelid = $("#mod-modelid");
    var versionid = $("#mod-versionid");
    $.ajax({
        type: "POST",
        url: 'taginfo.do',
        data: {
            tagID: $(ID).html(),
            proid: pid
        },
        dataType: "json",
        success: function (data) {
            iD.val(data.id);
            title.val(data.title);
            ctime.val(data.ctime);
            mtime.val(data.mtime);
            detail.val(data.detail);
            priority.val(data.priority);
            kind.val(data.kindid);
            type.val(data.typeid);
            point.html(data.partAdminsOptions);
            point.val(data.pointWhoID);
            proid.val(data.proID);
            modelid.val(data.modelID);
            versionid.val(data.versionID);
        }
    });
    $('#edittag-model').modal('show', {backdrop: 'static'});
}

function edit() {
    var title = $("#mod-title").val();
    var ID = $("#mod-id").val();
    var detail = $("#mod-detail").val();
    var type = $("#mod-type").val();
    var priority = $("#mod-priority").val();
    var feedback = $("#mod-feedback").val();
    var kind = $("#mod-kind").val();
    var point = $("#mod-point").val();
    var proid = $("#mod-proid").val()
    var modelid = $("#mod-modelid").val();
    var versionid = $("#mod-versionid").val();
    $.ajax({
        type: "POST",
        url: 'updatetag.do',
        data: {
            id: ID,
            title: title,
            detail: detail,
            typeid: type,
            priority: priority,
            feedback: feedback,
            kindid: kind,
            pointWhoID: point,
            proID: proid,
            modelID: modelid,
            versionID: versionid
        },
        dataType: "json",
        success: function (data) {
            if (data.type == 'success') {
                window.location.reload();
            } else {
                ShowNotification(data.type, data.content);
            }
        }
    });
}