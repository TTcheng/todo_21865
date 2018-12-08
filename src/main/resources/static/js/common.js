/*
 * 加载遮罩提示信息
 */
function loading (actoin,msg) {
    if(actoin==="open"){
        $.blockUI({message:'<div class="spinner">\n' +
                '  <div class="rect1"></div>\n' +
                '  <div class="rect2"></div>\n' +
                '  <div class="rect3"></div>\n' +
                '  <div class="rect4"></div>\n' +
                '  <div class="rect5"></div>\n' +
                '</div><div>'+msg+'</div>'})//显示遮罩
    }
    else {
        $.unblockUI()
    }
}


function guid() {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
        var r = Math.random()*16|0, v = c == 'x' ? r : (r&0x3|0x8);
        return v.toString(16);
    });
}