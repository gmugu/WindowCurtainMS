<!--业务预约-->
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.wcms.util.HtmlTagGenerater" %>
<%@ page import="com.wcms.service.CustomerCrudService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ServletContext context = request.getSession().getServletContext();
    ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
    CustomerCrudService customerCrudService = (CustomerCrudService) ctx.getBean("customerCrudService");

    Map<String, String> customerOpt = customerCrudService.getCustomerOpt();

%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>业务预约</title>

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
                    <h5>业务预约</h5>

                </div>
                <div class="ibox-content">
                    <div class="">
                        <a id="new_row_bn" href="javascript:void(0);" class="btn btn-primary ">添加记录</a>
                    </div>

                    <table class="table table-striped table-bordered table-hover " id="editable">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>业务编号</th>
                            <th>登记日期</th>
                            <th>业务类型</th>
                            <th>客户名称</th>
                            <th>预约日期</th>
                            <th>状态</th>
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

<!--layui & layer-->
<script src="js/layer/layer.js"></script>
<script src="js/layui/layui.js"></script>

<!-- 自定义js -->
<script src="js/apiservice.js"></script>


<!-- Page-Level Scripts -->
<script>
    layui.use('laydate');
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
                    // jqTds[1].innerHTML = '<input type="text" class="form-control input-small" value="' + aData[1] + '">';
                    jqTds[2].innerHTML = '<input type="text" class="form-control input-small" onclick="layui.laydate({elem: this})" value="' + aData[2] + '">';
                    jqTds[3].innerHTML = '<input type="text" class="form-control input-small" value="' + aData[3] + '">';
                    jqTds[4].innerHTML = '<%=HtmlTagGenerater.genSelectTag(customerOpt)%>';
                    setSelected(jqTds[4].children[0], aData[4]);
                    jqTds[5].innerHTML = '<input type="text" class="form-control input-small" onclick="layui.laydate({elem: this})" value="' + aData[5] + '">';
                    jqTds[7].innerHTML = '<input type="text" class="form-control input-small" value="' + aData[7] + '">';
                    jqTds[8].innerHTML = '<a class="edit" href="">Save</a>';
                    jqTds[9].innerHTML = '<a class="cancel" href="">Cancel</a>';
                }

                function saveRow(oTable, nRow) {

                    ajaxSaveOrUpdate(oTable, nRow);
                }

                function ifor(data, opt) {
                    if (typeof (data) === "undefined" || data === null)
                        return opt;
                    else
                        return data;
                }

                function ajaxInitData() {
                    business_getall({
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
                                a.push(row.no);
                                a.push(ifor(row.signTime, ''));
                                a.push(ifor(row.businessType, ''));
                                var customer = row.customer;
                                a.push(customer.no + ':' + customer.name);
                                a.push(ifor(row.appointmentTime, ''));
                                a.push(row.state);
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
                    var id = aData[0];
                    var no = aData[1];
                    var signTime = jqInputs[0].value;
                    var businessType = jqInputs[1].value;
                    var customer = {"no": jqSelects[0].options[jqSelects[0].selectedIndex].text.split(':')[0]};
                    var appointmentTime = jqInputs[2].value;
                    var comments = jqInputs[3].value;
                    if (aData[0] !== '') {
                        business_update(id, no, signTime, businessType, customer, appointmentTime, comments, {
                            success: function (result) {
                                if (result.code === 0) {
                                    oTable.fnUpdate(signTime, nRow, 2, false);
                                    oTable.fnUpdate(businessType, nRow, 3, false);
                                    oTable.fnUpdate(jqSelects[0].options[jqSelects[0].selectedIndex].text, nRow, 4, false);
                                    oTable.fnUpdate(appointmentTime, nRow, 5, false);
//                                    oTable.fnUpdate("预定", nRow, 6, false);
                                    oTable.fnUpdate(comments, nRow, 7, false);
                                    oTable.fnUpdate('<a class="edit" href="">Edit</a>', nRow, 8, false);
                                    oTable.fnUpdate('<a class="delete" href="">Delete</a>', nRow, 9, false);
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
                        });
                    } else {
                        business_add(signTime, businessType, customer, appointmentTime, comments, {
                            success: function (result) {
                                if (result.code === 0) {
                                    var data = result.data;
                                    oTable.fnUpdate(data.id, nRow, 0, false);
                                    oTable.fnUpdate(data.no, nRow, 1, false);
                                    oTable.fnUpdate(signTime, nRow, 2, false);
                                    oTable.fnUpdate(businessType, nRow, 3, false);
                                    oTable.fnUpdate(jqSelects[0].options[jqSelects[0].selectedIndex].text, nRow, 4, false);
                                    oTable.fnUpdate(appointmentTime, nRow, 5, false);
                                    oTable.fnUpdate("预定", nRow, 6, false);
                                    oTable.fnUpdate(comments, nRow, 7, false);
                                    oTable.fnUpdate('<a class="edit" href="">Edit</a>', nRow, 8, false);
                                    oTable.fnUpdate('<a class="delete" href="">Delete</a>', nRow, 9, false);
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
                        });
                    }

                }

                function ajaxDelete(nRow) {

                    var aData = oTable.fnGetData(nRow);

                    business_remove(aData[0], {
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
                            var sheet = xlsx.xl.worksheets['sheet1.xml'];

//                            $('row c[r^="C"]', sheet).attr( 's', '2' );
                        }
                    } ],
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

                    var aiNew = oTable.fnAddData(['', '', '', '', '', '', '', '', '', '']);
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
//                    oTable.fnDeleteRow(nRow);
                    ajaxDelete(nRow);
//                    alert("Deleted! Do not forget to do some ajax to sync with backend :)");
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
//                        alert("Updated! Do not forget to do some ajax to sync with backend :)");
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