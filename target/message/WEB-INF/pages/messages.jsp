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
<h1>我的留言</h1>
<!-- 如果用户列表非空 -->
<c:if test="${!empty messages}">
    <table class="table table-bordered table-striped">
        <tr>
            <th>内容</th>
            <th>时间</th>
        </tr>

        <c:forEach items="${messages}" var="message" >
            <tr>
                <td>${message.message}</td>
                <td>${message.message_time}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</div>
</body>
</html>
