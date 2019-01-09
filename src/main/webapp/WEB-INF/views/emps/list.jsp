<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: haohan
  Date: 01/08/2019
  Time: 03:34 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工信息页面</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-3.3.1.js"></script>
    <script type="text/javascript">
        $(function() {
            $(".delete").click(function() {
                var label = $(this).next(":hidden").val();
                var flag = confirm("确定要删除" + label + "的信息吗？")
                if(flag) {
                    var url = $(this).attr("href");

                    $("#_form").attr("action", url);
                    $("#_method").val("delete");
                    $("#_form").submit();
                }
                return false;
            })
        })
    </script>
</head>
<body>

    <form action="" method="post" id="_form">
        <input type="hidden" id="_method" name="_method" />
    </form>

    <c:if test="${emps == null || emps.numberOfElements == 0}">
        没有任何记录
    </c:if>
    <c:if test="${emps != null && emps.numberOfElements != 0}">
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <th>ID</th>
                <th>LastName</th>
                <th>Email</th>
                <th>Birth</th>
                <th>CreateTime</th>
                <th>Department</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${emps.content}" var="emp">
                <tr>
                    <td>${emp.id}</td>
                    <td>${emp.lastName}</td>
                    <td>${emp.email}</td>
                    <td>
                        <fmt:formatDate value="${emp.birth}" pattern="yyyy-MM-dd" />
                    </td>
                    <td>
                        <fmt:formatDate value="${emp.createTime}" pattern="yyyy-MM-dd hh:mm:ss" />
                    </td>
                    <td>${emp.department.deptName}</td>
                    <td><a href="${pageContext.request.contextPath}/input/${emp.id}"> Edit </a></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/input/${emp.id}" class="delete"> Delete </a>
                        <input type="hidden" value="${emp.lastName}"/>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="8">
                    共${emps.totalElements }条记录
                    共${emps.totalPages} 页
                    当前${emps.number + 1} 页
                    <a href="?pageNo=${emps.number + 1 - 1}" >上一页</a>
                    <a href="?pageNo=${emps.number + 1 + 1}" >下一页</a>
                </td>
            </tr>
        </table>
        <a href="<%=request.getContextPath()%>/input">增加员工</a>
    </c:if>
</body>
</html>
