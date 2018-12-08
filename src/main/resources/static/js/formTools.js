function getSubmitData(formObj){
    var formDataAry = formObj.serializeArray();
    var formData = {};
    $.each(formDataAry, function () {
        var index = this.name.indexOf('.');
        if(index>0){
            var childObjName=this.name.substr(0,index);
            formData[childObjName] =setParam(formData[childObjName],this.name.substr(index+1),this.value)
        }else{
            setParam(formData,this.name,this.value)
        }
    });
    return formData;
}

function setParam(data,paramName,paramValue){
    if(!data)
        data = {};

    if (data[paramName]) {//已有相同名的参数
        data[paramName]+=','+paramValue;
    } else {
        data[paramName] = paramValue || '';
    }

    return data;
}

function normalSubmitFormData(submit_url,submit_data,call_back,type,clickObj){
    loading('open','数据提交中,请稍候...');

    $.ajax({
        url : submit_url,
        type: 'post',
        dataType: 'json',
        data:submit_data,
        success : function(data){
            if(clickObj){
                $(clickObj).hide();
            }
            loading('close');
            if(data && data.status=='success'){
                if (call_back) {
                    try {
                        var fn = eval(call_back);
                        if (type == 'notips') {//不提示，页面自己处理
                            fn(data);
                        }else{//弹出提示，然后调用函数
                            $.messager.show({
                                title: '提示信息',
                                msg: data.message
                            });
                            setTimeout(function () {
                                fn(data);
                            }, 3000);
                        }
                    } catch (e) {
                        console.log('请确认函数call_back是否存在');
                    }
                } else {
                    $.messager.show({
                        title: '提示信息',
                        msg: data.message
                    });
                }
            }else{
                var errorMsg="提交失败，未获取到错误信息！";

                if(data.message) errorMsg=data.message;

                $.messager.show({
                    title : '错误信息',
                    msg : errorMsg
                });
            }
        },
        complete : function(){
            loading('close');
        }
    });
}