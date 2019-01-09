<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: haohan
  Date: 2019/1/8
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <c:set value="${pageContext.request.contextPath}/input" var="url" />
    <c:if test="${emp.id != null}">
        <c:set value="${pageContext.request.contextPath}/input/${emp.id}" var="url" />
    </c:if>

    <form:form action="${url }" method="POST" modelAttribute="emp">
        <c:if test="${emp.id != null}">
            <input type="hidden" id="_oldLastName" value="${emp.lastName}" />
            <form:hidden path="id" />
            <input type="hidden" name="_method" value="PUT" />
        </c:if>
        LastName: <form:input path="lastName" />
        <br>
        Email:    <form:input path="email" />
        <br>
        Birth:    <form:input path="birth" />
        <br>
        Department:<form:select path="department.id" items="${dept}" itemLabel="deptName" itemValue="id" />
        <br>
        <input type="submit" value="submit" />
    </form:form>

</body>
</html>
