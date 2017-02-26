/**
 * Created by sunny-chen on 16/11/19.
 */
/**
 * 获取某个id,class dom节点checked状态的值
 * */
function getCheckedStr(t) {
    var str = "";
    $(t).each(function () {
        if ($(this).is(':checked')) {
            str += $(this).val() + ",";
        }
    });
    str = str.substring(0, str.length - 1);
    return str;
}