/**
 * 日期格式化
 * @param date 日期
 * @param filter 格式
 * @returns
 */
function getDateStr(date, filter) {
    var yyyy = date.getFullYear();
    var mm = (date.getMonth() + 1) >= 10 ? date.getMonth() + 1 : '0' + (date.getMonth() + 1);
    var dd = date.getDate() >= 10 ? date.getDate() : '0' + date.getDate();

    var hh = date.getHours() >= 10 ? date.getHours() : '0' + date.getHours();
    var mi = date.getMinutes() >= 10 ? date.getMinutes() : '0' + date.getMinutes();
    var ss = date.getSeconds() >= 10 ? date.getSeconds() : '0' + date.getSeconds();

    filter = filter.replace('yyyy', yyyy);
    filter = filter.replace('mm', mm);
    filter = filter.replace('dd', dd);
    filter = filter.replace('hh', hh);
    filter = filter.replace('mi', mi);
    filter = filter.replace('ss', ss);

    return filter;
}

//global const
var localVersion = getDateStr(new Date(), 'yyyymmddhh');//版本号，每小时一个版本
var basePath = location.origin;//服务的基本路径
var dictBasePath = basePath + '/js/dict/';//字典js的目录
// css
document.write('\<link href="' + basePath + '/css/base.css?v=' + localVersion + '" rel="stylesheet" />');
// script
document.write('<script src="' + basePath + '/js/jquery-3.3.1.js"></script>');
document.write('<script src="' + basePath + '/js/jquery.blockUI.js"></script>');
document.write('<script src="' + basePath + '/js/common.js"></script>');
// document.write('<script src="jquery.blockUI.js"></script>');
// document.write('<script src="common.js"></script>');
