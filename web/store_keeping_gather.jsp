<!--库存盈余汇总提醒-->

<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="com.wcms.service.EmployeeCrudService" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.wcms.service.WarehouseCrudService" %>
<%@ page import="com.wcms.service.SupplierCrudService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ServletContext context = request.getSession().getServletContext();
    ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
    EmployeeCrudService employeeCrudService = (EmployeeCrudService) ctx.getBean("employeeCrudService");
    WarehouseCrudService warehouseCrudService = (WarehouseCrudService) ctx.getBean("warehouseCrudService");
    SupplierCrudService supplierCrudService = (SupplierCrudService) ctx.getBean("supplierCrudService");
    Map<String, String> opt = employeeCrudService.getEmployeeOpt();
%>
<%=opt%>