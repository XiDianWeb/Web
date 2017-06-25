<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
  <head>
    <title>登录</title>
    <link href="/WebOnline/CSS/user-css/login.css" rel="stylesheet">
  </head>
  <body>
    <div class="title">
      <h1>大学生职业生涯规划</h1>
    </div>
    <div class="login">
      <form action="${pageContext.request.contextPath }/user_login" method="post">
        <h2>用户登录</h2>
        <label>
          用户名：
          <input type="text" name="name"/>
        </label>
        <br />
        <div class="password">
          <label>
            密<span class="word">码：</span>
            <input type="password" name="password"/>
          </label>
        </div>
        <div class="warning">
          <p></p>
        </div>
        <input type="submit" class="submit" value="登录" />
        <a href="./register.html">注册</a>
      </form>
    </div>
  </body>
</html>