<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    <form:form action="${pageContext}/input" method="post">
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
