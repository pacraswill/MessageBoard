<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 29979
  Date: 2015/12/18
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
<h1>快去留(biao)言(bai)吧</h1>

<!-- 如果用户列表非空 -->
<c:if test="${!empty userList}">
    <table class="table table-bordered table-striped">
        <tr>
            <th>姓名</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${userList}" var="user" >
            <tr>
                <td>${user.name}</td>
                <td>
                    <a href="/comment/${user.name}" type="button" class="btn btn-sm btn-success">给Ta留言</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</div>
<h2><a href="/comment/showMessages/${currentUser}">给我的留言</a></h2>
</body>
</html>
