<%--
  Created by IntelliJ IDEA.
  User: 29979
  Date: 2015/12/22
  Time: 0:26
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
  <style>
    .controls {
      margin-top: 10px;
    }
  </style>
</head>
<body>
<form class="form-horizontal" action="/user/registerHandler" method="post">
  <div class="control-group">
    <label class="control-label" for="inputEmail">Name</label>
    <div class="controls">
      <input type="text" id="inputEmail" name="name" placeholder="Name">
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="inputPassword">Password</label>
    <div class="controls">
      <input type="password" id="inputPassword" name="password" placeholder="Password">
    </div>
  </div>

  <div class="control-group">
    <div class="controls">
      <button type="submit" class="btn btn-large btn-primary">注册</button>
    </div>
  </div>
</form>
</form>

</body>
</html>
