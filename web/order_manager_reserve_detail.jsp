<%--订做明细--%>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.wcms.util.HtmlTagGenerater" %>
<%@ page import="com.wcms.service.CurtainCrudService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ServletContext context = request.getSession().getServletContext();
    ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
    CurtainCrudService curtainCrudService = (CurtainCrudService) ctx.getBean("curtainCrudService");
    Map<String, String> curtainOpt = curtainCrudService.getCurtainOpt();
%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>订做明细</title>

    <link rel="shortcut icon" href="images/favicon.ico">
    <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">

    <!-- Data Tables -->
    <link href="css/datatables.bootstrap.css" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div id="test">
</div>
<div class="wrapper wrapper-content animated fadeInRight">

    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>订做明细</h5>

                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-file-excel-o"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <div class="">
                        <a id="new_row_bn" href="javascript:void(0);" class="btn btn-primary ">添加记录</a>
                    </div>

                    <table class="table table-striped table-bordered table-hover " id="editable">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>窗帘</th>
                            <th>位置</th>
                            <th>高度</th>
                            <th>宽度</th>
                            <th>数量</th>
                            <th>备注</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 全局js -->
<script src="js/jquery.min.js?v=2.1.4"></script>
<script src="js/bootstrap.min.js?v=3.3.6"></script>

<!--<script src="js/plugins/jeditable/jquery.jeditable.js"></script>-->

<!-- Data Tables -->
<script src="js/datatables.min.js"></script>
<script src="js/datatables.bootstrap.js"></script>

<!-- 自定义js -->
<script src="js/apiservice.js"></script>

<!-- Page-Level Scripts -->
<script>
    $(document).ready(function () {

        var TableDatatablesEditable = function () {

            var handleTable = function () {

                function restoreRow(oTable, nRow) {
                    var aData = oTable.fnGetData(nRow);
                    var jqTds = $('>td', nRow);

                    for (var i = 0, iLen = jqTds.length; i < iLen; i++) {
                        oTable.fnUpdate(aData[i], nRow, i, false);
                    }

                    oTable.fnDraw();
                }

                function setSelected(select, def) {
                    var child = select.children;
                    for (var i in child) {
                        if (child[i].innerText === def) {
                            child[i].selected = true;
                        }
                    }
                }

                function editRow(oTable, nRow) {
                    var aData = oTable.fnGetData(nRow);
                    var jqTds = $('>td', nRow);
                    // jqTds[0].innerHTML = '<input type="text" class="form-control input-small" value="' + aData[0] + '">';
                    jqTds[1].innerHTML = '<%=HtmlTagGenerater.genSelectTag(curtainOpt)%>';
                    setSelected(jqTds[1].children[0], aData[1]);
                    jqTds[2].innerHTML = '<input type="text" class="form-control input-small" value="' + aData[2] + '">';
                    jqTds[3].innerHTML = '<input type="text" class="form-control input-small" value="' + aData[3] + '">';
                    jqTds[4].innerHTML = '<input type="text" class="form-control input-small" value="' + aData[4] + '">';
                    jqTds[5].innerHTML = '<input type="text" class="form-control input-small" value="' + aData[5] + '">';
                    jqTds[6].innerHTML = '<input type="text" class="form-control input-small" value="' + aData[6] + '">';
                    jqTds[7].innerHTML = '<a class="edit" href="">Save</a>';
                    jqTds[8].innerHTML = '<a class="cancel" href="">Cancel</a>';
                }

                function saveRow(oTable, nRow) {
                    ajaxSaveOrUpdate(oTable, nRow);
                }

                function getQueryString(name) {
                    var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
                    var r = window.location.search.substr(1).match(reg);
                    if (r != null) {
                        return unescape(r[2]);
                    }
                    return null;
                }

                var orderId = getQueryString('order_id');

                function ifor(data, opt) {
                    if (typeof (data) === "undefined" || data === null)
                        return opt;
                    else
                        return data;
                }

                function ajaxInitData() {
                    order_detail_getall({'id': orderId}, {
                        success: function (result) {
                            if (result.code != 0) {
                                alert("错误:" + result.msg);
                                return;
                            }


                            var data = result.data;
                            oTable.fnClearTable();
                            for (var i in data) {
                                var row = data[i];
                                var a = [];
                                a.push(row.id);
                                var curtain = row.curtain;
                                a.push(curtain.no + ':' + ifor(curtain.specifications, ''));
                                a.push(ifor(row.location, ''));
                                a.push(ifor(row.height, ''));
                                a.push(ifor(row.width, ''));
                                a.push(ifor(row.count, ''));
                                a.push(ifor(row.comments, ''));
                                a.push('<a class="edit" href="">Edit</a>');
                                a.push('<a class="delete" href="">Delete</a>');
                                oTable.fnAddData(a);
                            }

                        },
                        error: function (xhr, msg) {
                            alert("错误:" + msg);
                        }
                    });
                }

                function ajaxSaveOrUpdate(oTable, nRow) {
                    var jqInputs = $('input', nRow);
                    var jqSelects = $('select', nRow);
                    var aData = oTable.fnGetData(nRow);
                    var curtain = {"no": jqSelects[0].options[jqSelects[0].selectedIndex].text.split(':')[0]};
                    var order = {"id": orderId};
                    var location = jqInputs[0].value;

                    function check(a) {
                        if (a === '' || isNaN(parseFloat(a))) {
                            return '0';
                        }
                        return a;
                    }

                    var height = check(jqInputs[1].value);
                    var width = check(jqInputs[2].value);
                    var counts = check(jqInputs[3].value);
                    var comments = jqInputs[4].value;

                    if (aData[0] !== '') {
                        order_detail_update(aData[0], curtain, location, height, width, counts, comments, {
                                    success: function (result) {
                                        if (result.code === 0) {
                                            oTable.fnUpdate(jqSelects[0].options[jqSelects[0].selectedIndex].text, nRow, 1, false);
                                            oTable.fnUpdate(location, nRow, 2, false);
                                            oTable.fnUpdate(height, nRow, 3, false);
                                            oTable.fnUpdate(width, nRow, 4, false);
                                            oTable.fnUpdate(counts, nRow, 5, false);
                                            oTable.fnUpdate(comments, nRow, 6, false);
                                            oTable.fnUpdate('<a class="edit" href="">Edit</a>', nRow, 7, false);
                                            oTable.fnUpdate('<a class="delete" href="">Delete</a>', nRow, 8, false);
                                            oTable.fnDraw();
                                        } else {
                                            alert(result.msg);
                                            ajaxInitData();
                                        }
                                    },
                                    error: function (xhr, msg) {
                                        alert(msg);
                                        ajaxInitData();
                                    }
                                }
                        );
                    } else {
                        order_detail_add(curtain, order, location, height, width, counts, comments, {
                                    success: function (result) {
                                        if (result.code === 0) {
                                            var data = result.data;
                                            oTable.fnUpdate(data.id, nRow, 0, false);
                                            oTable.fnUpdate(jqSelects[0].options[jqSelects[0].selectedIndex].text, nRow, 1, false);
                                            oTable.fnUpdate(location, nRow, 2, false);
                                            oTable.fnUpdate(height, nRow, 3, false);
                                            oTable.fnUpdate(width, nRow, 4, false);
                                            oTable.fnUpdate(counts, nRow, 5, false);
                                            oTable.fnUpdate(comments, nRow, 6, false);
                                            oTable.fnUpdate('<a class="edit" href="">Edit</a>', nRow, 7, false);
                                            oTable.fnUpdate('<a class="delete" href="">Delete</a>', nRow, 8, false);
                                            oTable.fnDraw();
                                        } else {
                                            alert(result.msg);
                                            ajaxInitData();
                                        }
                                    }
                                    ,
                                    error: function (xhr, msg) {
                                        alert(msg);
                                        ajaxInitData();
                                    }
                                }
                        );
                    }

                }

                function ajaxDelete(nRow) {

                    var aData = oTable.fnGetData(nRow);

                    order_detail_remove(aData[0], {
                        success: function (result) {
                            if (result.code == 0) {
                                oTable.fnDeleteRow(nRow);
                            } else {
                                alert("错误:" + result.msg);
                            }
                        }
                    });
                }


                var table = $('#editable');

                var oTable = table.dataTable({

                    "lengthMenu": [
                        [10, 25, 50, -1],
                        [10, 25, 50, "All"] // change per page values here
                    ],
                    dom:'Bfrtip',
                    buttons: [ {
                        extend: 'excelHtml5',
                        text:'导出EXCEL',
                        customize: function( xlsx ) {
                            console.log(xlsx)
                            var sheet = xlsx.xl.worksheets['sheet1.xml'];

//                            $('row c[r^="C"]', sheet).attr( 's', '2' );
                        }
                    } ],
                    // Or you can use remote translation file
                    // "language": {
                    //   url: '//cdn.datatables.net/plug-ins/3cfcc339e89/i18n/Portuguese.json'
                    // },

                    // set the initial value
                    "pageLength": 10,

                    "language": {

                        "emptyTable": "No data available in table",
                        "info": "Showing _START_ to _END_ of _TOTAL_ entries",
                        "infoEmpty": "No entries found",
                        "infoFiltered": "(filtered1 from _MAX_ total entries)",
                        "lengthMenu": "每页 _MENU_ 条记录",
                        "search": "搜索 ",
                        "zeroRecords": "No matching records found"
                    },
                    "columnDefs": [{ // set default column settings
                        'orderable': true,
                        'targets': [0]
                    }, {
                        "searchable": true,
                        "targets": [0]
                    }],
                    "order": [
                        [0, "asc"]
                    ], // set first column as a default sort by asc


                });

                var tableWrapper = $("#editable_wrapper");

                var nEditing = null;
                var nNew = false;

                $('#new_row_bn').click(function (e) {
                    e.preventDefault();

                    if (nNew && nEditing) {
                        if (confirm("Previose row not saved. Do you want to save it ?")) {
                            saveRow(oTable, nEditing); // save
                            $(nEditing).find("td:first").html("Untitled");
                            nEditing = null;
                            nNew = false;

                        } else {
                            oTable.fnDeleteRow(nEditing); // cancel
                            nEditing = null;
                            nNew = false;

                            return;
                        }
                    }

                    var aiNew = oTable.fnAddData(['', '', '', '', '', '', '', '', '']);
                    var nRow = oTable.fnGetNodes(aiNew[0]);
                    editRow(oTable, nRow);
                    nEditing = nRow;
                    nNew = true;
                });

                table.on('click', '.delete', function (e) {
                    e.preventDefault();

                    if (confirm("Are you sure to delete this row ?") == false) {
                        return;
                    }

                    var nRow = $(this).parents('tr')[0];
                    ajaxDelete(nRow);
//                oTable.fnDeleteRow(nRow);
//                alert("Deleted! Do not forget to do some ajax to sync with backend :)");
                });

                table.on('click', '.cancel', function (e) {
                    e.preventDefault();
                    if (nNew) {
                        oTable.fnDeleteRow(nEditing);
                        nEditing = null;
                        nNew = false;
                    } else {
                        restoreRow(oTable, nEditing);
                        nEditing = null;
                    }
                });

                table.on('click', '.edit', function (e) {
                    e.preventDefault();
                    nNew = false;

                    /* Get the row as a parent of the link that was clicked on */
                    var nRow = $(this).parents('tr')[0];

                    if (nEditing !== null && nEditing != nRow) {
                        /* Currently editing - but not this row - restore the old before continuing to edit mode */
                        restoreRow(oTable, nEditing);
                        editRow(oTable, nRow);
                        nEditing = nRow;
                    } else if (nEditing == nRow && this.innerHTML == "Save") {
                        /* Editing this row and want to save it */
                        saveRow(oTable, nEditing);
                        nEditing = null;
//                    alert("Updated! Do not forget to do some ajax to sync with backend :)");
                    } else {
                        /* No edit in progress - let's start one */
                        editRow(oTable, nRow);
                        nEditing = nRow;
                    }
                });
                ajaxInitData();
            };

            return {

                //main function to initiate the module
                init: function () {
                    handleTable();
                }

            };

        }();

        jQuery(document).ready(function () {
            TableDatatablesEditable.init();
        });

    });
</script>


</body>

</html>