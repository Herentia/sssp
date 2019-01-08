<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: haohan
  Date: 01/08/2019
  Time: 02:33 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工列表</title>
</head>
<body>
    <c:if test="${page == null || page.numberOfElements == 0}">
        没有任何记录
    </c:if>
</body>
</html>
