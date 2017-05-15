<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.wcms.entity.UsersEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UsersEntity usersEntity = (UsersEntity) request.getSession().getAttribute("UsersEntity");
    if (usersEntity == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>窗帘布艺管理系统</title>

    <link rel="shortcut icon" href="images/favicon.ico">
    <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<span class="clear">
                                    <span class="block m-t-xs" style="font-size:17px;">
                                        <i class="fa fa-area-chart"></i>
                                        <strong class="font-bold">窗帘布艺管理系统</strong>
                                    </span>
								</span>
                        </a>
                    </div>
                    <div class="logo-element">窗帘布艺管理系统
                    </div>
                </li>
                <li>
                    <a class="J_menuItem" href="welcome.html">
                        <i class="fa fa-home"></i>
                        <span class="nav-label">主页</span>
                    </a>
                </li>
                <li>

                    <%
                        if (usersEntity.getAuBasic() > 0) {
                    %>
                    <a href="#">
                        <i class="fa fa fa-bar-chart-o"></i>
                        <span class="nav-label">基本资料</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="basic_info_client.html">客户资料</a>
                        </li>
                        <li><a class="J_menuItem" href="basic_info_curtain.html">窗帘资料</a>
                        </li>
                        <li><a class="J_menuItem" href="basic_info_provider.html">供应商资料</a>
                        </li>
                        <li><a class="J_menuItem" href="basic_info_warehouse.html">仓库资料</a>
                        </li>
                    </ul>
                </li>
                <%
                    }
                %>
                <%
                    if (usersEntity.getAuStore() > 0) {
                %>
                <li>
                    <a href="#">
                        <i class="fa fa-edit"></i>
                        <span class="nav-label">材料管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="store_keeping_info.html">材料资料</a>
                        </li>
                        <li><a class="J_menuItem" href="store_keeping_procurement.jsp">材料入库</a>
                        </li>
                        <li><a class="J_menuItem" href="store_keeping_return.jsp">材料出库</a>
                        </li>
                        <li><a class="J_menuItem" href="store_keeping_stock.html">库存明细</a>
                        </li>
                        <!--<li><a class="J_menuItem" href="store_keeping_gather.jsp">库存盈余汇总提醒</a>
                        </li>-->
                    </ul>
                </li>
                <%
                    }
                %>
                <%
                    if (usersEntity.getAuOrder() > 0) {
                %>
                <li>
                    <a href="#">
                        <i class="fa fa-desktop"></i>
                        <span class="nav-label">订单管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="order_manager_reserve.jsp">定做登记</a>
                        </li>
                        <li><a class="J_menuItem" href="order_manager_sign.jsp">签收登记</a>
                        </li>
                        <!--<li><a class="J_menuItem" href="order_manager_settlement.html">订单结算</a>-->
                        <!--</li>-->
                        <!--<li><a class="J_menuItem" href="order_manager_remind.html">订单提醒</a>-->
                        <!--</li>-->
                        <!--<li><a class="J_menuItem" href="order_manager_gross_profit.html">订单毛利</a>-->
                        <!--</li>-->
                    </ul>
                </li>
                <%
                    }
                %>
                <%
                    if (usersEntity.getAuBusiness() > 0) {
                %>
                <li>
                    <a href="#">
                        <i class="fa fa-table"></i>
                        <span class="nav-label">业务管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="business_management_business_register.jsp">业务预约</a>
                        </li>
                        <li><a class="J_menuItem" href="business_management_tasking_register.jsp">派工登记</a>
                        </li>
                        <!--<li><a class="J_menuItem" href="business_management_settle.html">费用结算</a>-->
                        <!--</li>-->
                        <!--<li><a class="J_menuItem" href="business_management_order.html">预约提醒</a>-->
                        <!--</li>-->
                        <li><a class="J_menuItem" href="business_management_after_sale.jsp">售后服务</a>
                        </li>
                    </ul>
                </li>
                <!--<li>-->
                <!--<a href="#">-->
                <!--<i class="fa fa-search"></i>-->
                <!--<span class="nav-label">查询统计</span>-->
                <!--<span class="fa arrow"></span>-->
                <!--</a>-->
                <!--<ul class="nav nav-second-level">-->
                <!--<li><a class="J_menuItem" href="query_order.html">订单查询</a>-->
                <!--</li>-->
                <!--<li><a class="J_menuItem" href="query_business.html">业务查询</a>-->
                <!--</li>-->
                <!--<li><a class="J_menuItem" href="query_tasking.html">派工查询</a>-->
                <!--</li>-->
                <!--<li><a class="J_menuItem" href="query_settle.html">结算查询</a>-->
                <!--</li>-->
                <!--<li><a class="J_menuItem" href="query_procurement.html">采购登记查询</a>-->
                <!--</li>-->
                <!--<li><a class="J_menuItem" href="query_sales_return.html">采购退货查询</a>-->
                <!--</li>-->
                <!--</ul>-->
                <!--</li>-->
                <%
                    }
                %>
                <%
                    if (usersEntity.getAuFinancial() > 0) {
                %>
                <li>
                    <a href="#">
                        <i class="fa fa-picture-o"></i>
                        <span class="nav-label">财务管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <!--<li><a class="J_menuItem" href="financial_management_.html">订单预存款</a>-->
                        <!--</li>-->
                        <!--<li><a class="J_menuItem" href="carousel.html">销售收入汇总</a>-->
                        <!--</li>-->
                        <!--<li><a class="J_menuItem" href="blueimp.html">应收款</a>-->
                        <!--</li>-->
                        <!--<li><a class="J_menuItem" href="blueimp.html">应付款</a>-->
                        <!--</li>-->
                        <!--<li><a class="J_menuItem" href="blueimp.html">供应商欠款</a>-->
                        <!--</li>-->
                        <!--<li>-->
                        <!--<a href="#">工资管理<span class="fa arrow"></span></a>-->
                        <!--<ul class="nav nav-third-level">-->
                        <li><a class="J_menuItem" href="employee_info.jsp">员工资料</a>
                        </li>
                        <li><a class="J_menuItem" href="employee_salary.jsp">员工工资</a>
                        </li>
                    </ul>
                    <!--</li>-->
                    <!--</ul>-->
                </li>
                <%
                    }
                %>
                <%
                    if ("admin".equals(usersEntity.getUsername())) {
                %>
                <li>
                    <a class="J_menuItem" href="admin.jsp">
                        <i class="fa fa-magic"></i>
                        <span class="nav-label">系统用户管理</span>
                    </a>
                </li>
                <%
                    }
                %>
            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->


    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-info " href="#"><i
                        class="fa fa-bars"></i> </a>

                    <form role="search" class="navbar-form-custom" method="post" action="search_results.html">
                        <div class="form-group">
                            <%--<input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search"--%>
                            <%--id="top-search">--%>
                        </div>
                    </form>
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li>
                        <div id="time_id"></div>
                    </li>
                    <li>
                        <a href="#"><%=usersEntity.getUsername()%>
                        </a>
                    </li>
                    <li>
                        <a href="logout.do">logout
                        </a>
                    </li>

                </ul>
            </nav>
        </div>
        <div class="row J_mainContent" id="content-main">
            <iframe id="J_iframe" width="100%" height="100%" src="welcome.html" frameborder="0" seamless></iframe>
        </div>
    </div>
</div>

<!-- 全局js -->
<script src="js/jquery.min.js?v=2.1.4"></script>
<script src="js/bootstrap.min.js?v=3.3.6"></script>
<script src="js/jquery.metisMenu.js"></script>
<script src="js/jquery.slimscroll.min.js"></script>
<!--<script src="js/plugins/layer/layer.min.js"></script>-->

<!-- 自定义js -->
<script type="text/javascript">

    $(document).ready(function () {

        var time_id = document.getElementById("time_id");
        setInterval(function () {
            time_id.innerText = new Date().toLocaleString();
        },100);
        // MetsiMenu
        $('#side-menu').metisMenu();

        // 打开右侧边栏
        $('.right-sidebar-toggle').click(function () {
            $('#right-sidebar').toggleClass('sidebar-open');
        });

        //固定菜单栏
        $(function () {
            $('.sidebar-collapse').slimScroll({
                height: '100%',
                railOpacity: 0.9,
                alwaysVisible: false
            });
        });


        // 菜单切换
        $('.navbar-minimalize').click(function () {
            $("body").toggleClass("mini-navbar");
            SmoothlyMenu();
        });


        // 侧边栏高度
        function fix_height() {
            var heightWithoutNavbar = $("body > #wrapper").height() - 61;
            $(".sidebard-panel").css("min-height", heightWithoutNavbar + "px");
        }

        fix_height();

        $(window).bind("load resize click scroll", function () {
            if (!$("body").hasClass('body-small')) {
                fix_height();
            }
        });

        //侧边栏滚动
        $(window).scroll(function () {
            if ($(window).scrollTop() > 0 && !$('body').hasClass('fixed-nav')) {
                $('#right-sidebar').addClass('sidebar-top');
            } else {
                $('#right-sidebar').removeClass('sidebar-top');
            }
        });

        $('.full-height-scroll').slimScroll({
            height: '100%'
        });

        $('#side-menu>li').click(function () {
            if ($('body').hasClass('mini-navbar')) {
                NavToggle();
            }
        });
        $('#side-menu>li li a').click(function () {
            if ($(window).width() < 769) {
                NavToggle();
            }
        });

        $('.nav-close').click(NavToggle);

        //ios浏览器兼容性处理
        if (/(iPhone|iPad|iPod|iOS)/i.test(navigator.userAgent)) {
            $('#content-main').css('overflow-y', 'auto');
        }

    });

    $(window).bind("load resize", function () {
        if ($(this).width() < 769) {
            $('body').addClass('mini-navbar');
            $('.navbar-static-side').fadeIn();
        }
    });

    function NavToggle() {
        $('.navbar-minimalize').trigger('click');
    }

    function SmoothlyMenu() {
        if (!$('body').hasClass('mini-navbar')) {
            $('#side-menu').hide();
            setTimeout(
                    function () {
                        $('#side-menu').fadeIn(500);
                    }, 100);
        } else if ($('body').hasClass('fixed-sidebar')) {
            $('#side-menu').hide();
            setTimeout(
                    function () {
                        $('#side-menu').fadeIn(500);
                    }, 300);
        } else {
            $('#side-menu').removeAttr('style');
        }
    }

    $(function () {
        //菜单点击
        J_iframe
        $(".J_menuItem").on('click', function () {
            var url = $(this).attr('href');
            $("#J_iframe").attr('src', url);
            return false;
        });
    });

</script>

</body>

</html>