<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--
  response.sendRedirect(request.getContextPath() + "/emp_list.action");
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:redirect url="/emp_list.action"></c:redirect>

<%--不能转发到action,只能重定向到action--%>