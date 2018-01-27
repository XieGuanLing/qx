var authUtils = {
    setAllNodesUnchecked : function (zNodes){
        var that = this;
        $.each(zNodes, function (nodeIndex, node) {
            node.checked = false;
            if(node.children){
                that.setAllNodesUnchecked(node.children);
            }
        });
        return zNodes;
    },
    setAllNodesChecked : function (zNodes){
        var that = this;
        $.each(zNodes, function (nodeIndex, node) {
            node.checked = true;
            if(node.children){
                that.setAllNodesChecked(node.children);
            }
        });
        return zNodes;
    },

    setCheckNodes : function (zNodes, checkIds){
        var that = this;
        that.setAllNodesUnchecked(zNodes);
        $.each(zNodes, function (nodeIndex, node) {
            if(checkIds.indexOf(node.code) !== -1){
                node.checked = true;
            }
            if(node.children){
                that.setCheckNodes(node.children, checkIds);
            }
        });
        return zNodes;
    },

    //push 遇到数组参数时，把整个数组参数作为一个元素；而 concat 则是拆开数组参数，一个元素一个元素地加进去。
    //push 直接改变当前数组, concat 不改变当前数组, 如果想数组追加用concat,arr1=arr1.concat(arr2)
    getCheckNodeCodes : function (zNodes){
        var that = this;
        var codes =[];
        $.each(zNodes, function (nodeIndex, node) {
            if(node.checked){
                codes.push(node.code);
            }
            if(node.children){
                var childCodes = that.getCheckNodeCodes(node.children);
                codes = codes.concat(childCodes);
            }
        });
        return codes;
    },
};