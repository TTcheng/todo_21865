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

/**
 * convert {2018-12-07T09:52:16.000+0000} to {2018/12/07 09:52}
 * @param str
 * @returns {string}
 */
function formatDateStr(str) {
    var split = str.split('T');
    return split[0].replace(/\-/g, '/') + " " + split[1].substr(0, 5);
}

/**
 * convert {2018-12-07T09:52:16.000+0000} to date
 * @param isoDateStr
 * @returns {Date}
 */
function getIsoDate(isoDateStr) {
    var split = isoDateStr.match(/\d+/g);
    return new Date(split[0] + '-' + split[1] + '-' + split[2] + ' ' + split[3] + ':' + split[4] + ':' + split[5]);
}