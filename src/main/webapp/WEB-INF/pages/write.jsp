<%--
  Created by IntelliJ IDEA.
  User: 29979
  Date: 2015/12/22
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <!-- 新 Bootstrap 核心 CSS 文件 -->
  <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

  <!-- 可选的Bootstrap主题文件（一般不用引入） -->
  <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
</head>
<body>
<h1>留言：</h1>
  <form action="/comment/commit" method="post">
    <textarea rows="6" name="message"></textarea>
      <input type="hidden" name="userName" value="${userName}">
      <hr>
      <button type="submit" class="btn btn-large btn-primary">好了  就说这么多了</button>
  </form>
</body>
</html>
