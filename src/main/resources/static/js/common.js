/**
 *
 * Created by dmall on 2018/1/31.
 */
function showLoading(){
    var index = layer.load(1, {
        shade: [0.1,'#fff'] //0.1透明度的白色背景
    });

    return index;
}
function alertMsg(msg) {
    layer.alert(msg, {
        skin: 'layui-layer-lan'
        , closeBtn: 0
        , anim: 4 //动画类型
    });
}

function alertMsgCallback(msg,fn){
    if(typeof fn == 'function') {
        layer.alert(msg, {
            skin: 'layui-layer-lan'
            , closeBtn: 0
            , anim: 4 //动画类型
        }, function () {
            fn();
        });
    }else {
        alertMsg(msg);
    }
}
function ajaxCallback1(data,fn){
    var msg = data.msg;
    var code = data.code;
    if(msg != null && msg != '') {
        if(data.code == '0000'){
            alertMsg(msg);
        }else {
            alertMsgCallback(msg,fn);
        }
    }
}

function ajaxCallback2(data){
    if(data.msg != null && data.msg != '') {
        layer.alert(data.msg, {
            skin: 'layui-layer-lan'
            , closeBtn: 0
            , anim: 4 //动画类型
        });
    }
}
function ajax_post(url,param,fn) {
    axios.post(url,param)
        .then(function (response) {
           fn(response);
        })
        .catch(function (error) {
            errorCallback(error);
        });
}

function ajax_get(url,param,fn) {
    axios.get(url,param)
        .then(function (response) {
            fn(response);
        })
        .catch(function (error) {
            errorCallback(error);
        });
}

function errorCallback(data) {
    var msg = "请求失败";
    if(error.msg != null && error.msg != ''){
        msg = error.msg;
    }
    layer.alert(msg, {
        skin: 'layui-layer-lan'
        ,closeBtn: 0
        ,anim: 4 //动画类型
    });
}
