var dialogUtils = {};
dialogUtils.showSysError = function () {
    dialogUtils.showTip("系统异常，请联系技术支持");
};

dialogUtils.showTip = function(cont){
    dialog({
        title: msg.dialog.title,
        content: cont,
        width: 300,
        cancel: false,
        okValue: '确定',
        zIndex: 10000,
        ok: function () {}
    }).show();
};


dialogUtils.showAutoCloseTip = function(cont){
    if(dialog.getCurrent()){
        dialog.getCurrent().close();
    }
    var d = dialog({
        title: msg.dialog.title,
        content: cont,
        width: 300,
        cancel: false,
        okValue: '确定',
        zIndex: 10000,
        ok: function () {}
    });
    d.show();
    setTimeout(function () {
        d.close().remove();
    }, 3000);
};

dialogUtils.showTipAndCloseCurrent = function(cont){
    if(dialog.getCurrent()){
        dialog.getCurrent().close();
    }
    dialog({
        title: msg.dialog.title,
        content: cont,
        width: 300,
        cancel: false,
        okValue: '确定',
        zIndex: 10000,
        ok: function () {}
    }).show();
};


dialogUtils.showTipAndNotCloseCurrent = function (cont){
    dialog({
        title: msg.dialog.title,
        content: cont,
        width: 300,
        cancel: false,
        okValue: '确定',
        zIndex: 10000,
        ok: function () {}
    }).show();
};

dialogUtils.showTipWithCB = function(cont,cb, closeCB){
    var d = dialog({
        title: msg.dialog.title,
        content: cont,
        width: 300,
        cancelValue:'取消',
        zIndex: 10000,
        cancel: function () {
            if(closeCB){
                closeCB();
            }
            this.close().remove();
        },
        okValue: '确定',
        ok: function () {this.close().remove(); cb();}
    });
    d.show();
};

dialogUtils.showContent = function (cont, cb, closeCB) {
    var d = dialog({
        title: msg.dialog.title,
        content: cont,
        cancelValue:'取消',
        zIndex: 10000,
        cancel: function () {
            this.close().remove();
        },
        okValue: '确定',
        ok: function () {
            var that = this;
            if(cb){
                cb(that);
            }else{
                this.close().remove();
            }
        }
    });
    d.addEventListener('close', function () {
        if(closeCB){
            closeCB();
        }
    });
    d.show();
};

dialogUtils.showAuthDialog = function(cont, cb){
    var d = dialog({
        title: '权限设置',
        content: cont,
        cancelValue:'取消',
        cancel: function () {
            this.close().remove();
        },
        okValue: '确定',
        ok: function () {
            if(cb()){
                this.close().remove();
            }

        }
    });
    d.show();
};

dialogUtils.autoCloseTip = function(cont, cb){
    var d = dialog({
        title: msg.dialog.title,
        content: cont,
        width: 300,
        cancel: false,
        okValue: '确定',
        zIndex: 10000,
        ok: function () {
            if(cb){
                cb();
            }
            this.close().remove();
        }
    });
    d.show();
    setTimeout(function () {
        if(cb){
            cb();
        }
        d.close().remove();
    }, 2000);
};

dialogUtils.getLoadingDialog = function (){
    return  dialog({
        width: 300,
        title: '数据正在加载...'
    });
};




