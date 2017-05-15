<%--订单结算--%>
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
    <title>订单结算</title>

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
                    <h5>订单结算</h5>

                </div>
                <div class="ibox-content">

                    <table class="table table-striped table-bordered table-hover " id="editable">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>窗帘</th>
                            <th>位置</th>
                            <th>高度</th>
                            <th>宽度</th>
                            <th>数量</th>
                            <th>单价</th>
                            <th>备注</th>
                            <th>总计</th>
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
                            var total = 0;
                            for (var i in data) {
                                var row = data[i];
                                var a = [];
                                a.push(row.id);
                                var curtain = row.curtain;
                                var price = curtain.price;
                                a.push(curtain.no + ':' + ifor(curtain.specifications, ''));
                                a.push(ifor(row.location, ''));
                                a.push(ifor(row.height, ''));
                                a.push(ifor(row.width, ''));
                                a.push(ifor(row.count, ''));
                                a.push(ifor(price, ''));
                                a.push(ifor(row.comments, ''));
                                var items = row.height * row.width * row.count * price;
                                if (isNaN(items)) {
                                    items = 0;
                                }
                                a.push(items);
                                total += items;
                                oTable.fnAddData(a);
                            }
                            if (data.length > 0) {
                                var a = [];
                                a.push('总计');
                                a.push('');
                                a.push('');
                                a.push('');
                                a.push('');
                                a.push('');
                                a.push('');
                                a.push('');
                                if (isNaN(total)) {
                                    total = 0;
                                }
                                a.push(total);

                                oTable.fnAddData(a);
                            }

                        },
                        error: function (xhr, msg) {
                            alert("错误:" + msg);
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