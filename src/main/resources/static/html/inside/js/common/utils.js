/**
 * Created by lihaodi on 2016/7/20.
 */

function validateNeedField(m, fields, tips){
    if(fields.length != tips.length){
        return false;
    }
    var size = fields.length;
    for(var i=0; i<size; i++){
        var field = fields[i];
        var tip = tips[i];
        try {
            if(!m[field]){
                dialogUtils.showAutoCloseTip('请检查' + tip);
                return false;
            }
        }catch(error){
            dialogUtils.showAutoCloseTip('请检查必输项');
            return false;
        }
    }
    return true;
}

function showDialog(dialogId, width, height, ok, cancel) {
    $(dialogId).dialog({
        resizable: false,
        draggable: true,
        modal: true,
        width: width,
        height: height,
        open: function (event, ui) {
            $(".ui-dialog-titlebar-close", $(this).parent()).hide();
            $(dialogId).find('input:enabled').first().focus();
        },
        buttons: [
            {
                text: "取消",
                click: function () {
                    if (cancel) {
                        //可以取消则销毁框
                        if(cancel()){
                            $(this).dialog("destroy");
                        }
                    }else{
                        $(this).dialog("destroy");
                    }
                }
            },
            {
                text: "确定",
                click: function () {
                    ok();
                    //$( this ).dialog( "destroy" );
                }
            }
        ]
    });
}


function showDialogWith3Button(dialogId, width, height, ok, cancel, remove) {
    $(dialogId).dialog({
        resizable: false,
        draggable: true,
        modal: true,
        width: width,
        height: height,
        open: function (event, ui) {
            $(".ui-dialog-titlebar-close", $(this).parent()).hide();
            $(dialogId).find('input:enabled').first().focus();
        },
        buttons: [
            {
                text: "取消",
                click: function () {
                    if (cancel) {
                        //可以取消则销毁框
                        if(cancel()){
                            $(this).dialog("destroy");
                        }
                    }else{
                        $(this).dialog("destroy");
                    }

                }
            },
            {
                text: "确定",
                click: function () {
                    ok();
                }
            },
            {
                text: "删除",
                click: function () {
                    remove();
                }
            }
        ]
    });
}

function checkPhone(phone){
    var pattern = /^1[0-9]{10}$/;
    return pattern.test(phone);
}

function initPage(scope, search){
    scope.firstPage = function () {
        if(scope.currPage <= 0){
            return ;
        }
        scope.currPage = 0;
        scope.q.start = scope.currPage * scope.q.max;

        search();
    };
    scope.previousPage = function(){
        if(scope.currPage <= 0){
            return ;
        }
        scope.currPage = scope.currPage - 1 ;
        scope.q.start = scope.currPage * scope.q.max;

        search();
    };

    scope.nextPage = function () {
        if(scope.currPage >= scope.totalPage-1){
            return ;
        }
        scope.currPage = scope.currPage + 1;
        scope.q.start = scope.currPage * scope.q.max;

        search();
    };
    scope.lastPage = function () {
        if(scope.currPage >= scope.totalPage-1){
            return ;
        }
        scope.currPage = scope.totalPage-1;
        scope.q.start = scope.currPage * scope.q.max;

        search();
    };
}

function initKeyPress(search){
    $(function(){
        $('input').bind('keypress',function(event){
            if(event.keyCode == '13') {
                search();
            }
        });
    });
}

/**
 * 从数组中删除指定值
 */
if (!Array.prototype.remove) {
    Array.prototype.remove = function(val) {
        var index = this.indexOf(val);
        if (index > -1) {
            this.splice(index, 1);
        }
    };
}