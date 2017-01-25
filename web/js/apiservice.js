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
        //timeout: 5000,
        data: "data=" + JSON.stringify(data),
        dataType: "json",
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
function customer_add(name, contactPerson, phone, comments, callback) {
    exec(arguments);
}
function customer_remove(id, callback) {
    exec(arguments);
}
function customer_update(id, no, name, contactPerson, phone, comments, callback) {
    exec(arguments);
}
//客户资料

//窗帘资料
function curtain_getall(callback) {
    exec(arguments);
}
function curtain_add(specifications, brand, size, color, callback) {
    exec(arguments);
}
function curtain_remove(id, callback) {
    exec(arguments);
}
function curtain_update(id, no, specifications, brand, size, color, callback) {
    exec(arguments);
}
//窗帘资料

//供应商资料
function supplier_getall(callback) {
    exec(arguments);
}
function supplier_add(name, contactPerson, phone, area, address, zipCode, comments, callback) {
    exec(arguments);
}
function supplier_remove(id, callback) {
    exec(arguments);
}
function supplier_update(id, no, name, contactPerson, phone, area, address, zipCode, comments, callback) {
    exec(arguments);
}
//供应商资料

//仓库资料
function warehouse_getall(callback) {
    exec(arguments);
}
function warehouse_add(name, comments, callback) {
    exec(arguments);
}
function warehouse_remove(id, callback) {
    exec(arguments);
}
function warehouse_update(id, no, name, comments, callback) {
    exec(arguments);
}
//仓库资料

//材料资料
function material_getall(callback) {
    exec(arguments);
}
function material_add(name, category, model, unit, price, producingArea, ingredient, callback) {
    exec(arguments);
}
function material_remove(id, callback) {
    exec(arguments);
}
function material_update(id, no, name, category, model, unit, price, producingArea, ingredient, callback) {
    exec(arguments);
}
//材料资料

//采购登记
function procurement_getall(callback) {
    exec(arguments);
}
function procurement_add(buyDate, operator, warehouse, supplier, totalPaid, amountPaid, callback) {
    exec(arguments);
}
function procurement_remove(id, callback) {
    exec(arguments);
}
function procurement_update(id, no, buyDate, operator, warehouse, supplier, totalPaid, amountPaid, callback) {
    exec(arguments);
}
//采购登记

//采购明细
function procurement_detail_getall(procurement, callback) {
    exec(arguments);
}
function procurement_detail_add(procurement, material, counts, callback) {
    exec(arguments);
}
function procurement_detail_remove(id, callback) {
    exec(arguments);
}
function procurement_detail_update(id, material, counts, callback) {
    exec(arguments);
}
//采购明细

//采购退货
function return_getall(callback) {
    exec(arguments);
}
function return_add(returnDate, operator, warehouse, supplier, comments, callback) {
    exec(arguments);
}
function return_remove(id, callback) {
    exec(arguments);
}
function return_update(id, no, returnDate, operator, warehouse, supplier, comments, callback) {
    exec(arguments);
}
//采购退货

//退货明细
function return_detail_getall(returnl, callback) {
    exec(arguments);
}
function return_detail_add(returnl, material, counts, callback) {
    exec(arguments);
}
function return_detail_remove(id, callback) {
    exec(arguments);
}
function return_detail_update(id, material, counts, callback) {
    exec(arguments);
}
//退货明细