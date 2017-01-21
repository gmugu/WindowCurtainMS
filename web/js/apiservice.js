/**
 * Created by Administrator on 2017/1/21.
 */


//获取函数名称
var getFnName = function (callee) {
    var _callee = callee.toString().replace(/[\s\?]*/g, ""),
        comb = _callee.length >= 50 ? 50 : _callee.length;
    _callee = _callee.substring(0, comb);
    var name = _callee.match(/^function([^\(]+?)\(/);
    if (name && name[1]) {
        return name[1];
    }
    var caller = callee.caller,
        _caller = caller.toString().replace(/[\s\?]*/g, "");
    var last = _caller.indexOf(_callee),
        str = _caller.substring(last - 30, last);
    name = str.match(/var([^\=]+?)\=/);
    if (name && name[1]) {
        return name[1];
    }
    return "anonymous"
};
//获取函数参数名称
function getArgsName(callee) {
    // 首先匹配函数括弧里的参数
    var args = callee.toString().match(/function\s.*?\(([^)]*)\)/)[1];
    // 分解参数成数组
    return args.split(",").map(function (arg) {
        // 去空格和内联注释
        return arg.replace(/\/\*.*\*\//, "").trim();
    }).filter(function (arg) {
        // 确保没有undefineds
        return arg;
    });
}
function _exec(fnName, data, callback) {

    var success, error, complete;
    if (typeof(callback) === "function") {
        complete = callback;
    } else if (callback != null) {
        success = callback.success;
        error = callback.error;
        complete = callback.complete;
    }

    $.ajax({
        type: "POST",
        url: fnName + ".do",
        timeout: 5000,
        data: "data=" + JSON.stringify(data),
        //dataType: "json",
        success: success,
        error: error,
        complete: complete
    })
}
function exec(args) {
    var callback = args[args.length - 1];
    var callee = args.callee;
    var argsName = getArgsName(callee);
    var fnName = getFnName(callee);
    var data = {};
    for (var i = 0; i < args.length - 1; i++) {
        data[argsName[i]] = args[i];
    }

    _exec(fnName, data, callback);
}
//客户资料
function customer_getall(callback) {
    exec(arguments);
}
function customer_add(no, name, contactPerson, phone, comments, callback) {
    exec(arguments);
}
function customer_remove(id, callback) {
    exec(arguments);
}
function customer_update(no, name, contactPerson, phone, comments, callback) {
    exec(arguments);
}
//客户资料

//窗帘资料
function curtain_getall(callback) {

}
function curtain_add(no, specifications, brand, size, color, callback) {

}
function curtain_remove(id, callback) {

}
function curtain_update(no, specifications, brand, size, color, callback) {

}
//窗帘资料

//供应商资料
function supplier_getall(callback) {

}
function supplier_add(no, name, contactPerson, phone, area, callback) {

}
function supplier_remove(id, callback) {

}
function supplier_update(no, name, contactPerson, phone, area, callback) {

}
//供应商资料

//仓库资料
function warehouse_getall(callback) {

}
function warehouse_add(no, name, comments, callback) {

}
function warehouse_remove(id, callback) {

}
function warehouse_update(no, name, comments, callback) {

}
//仓库资料

//材料资料
function material_getall(callback) {

}
function material_add(no, name, category, model, unit, price, producingArea, ingredient, callback) {

}
function material_remove(id, callback) {

}
function update(no, name, category, model, unit, price, producingArea, ingredient, callback) {

}
//材料资料