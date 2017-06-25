<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
  <head>
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="/WebOnline/CSS/user-css/register.css" />
  </head>
  <body>
    <div class="title">
      <h1>大学生职业生涯规划</h1>
    </div>
    <div class="register">
      <form action="${pageContext.request.contextPath }/user_register" method="post">
      <s:token></s:token>
        <h2>用户注册</h2>
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
        <label>
          邮<span class="word">箱：</span>
          <input type="email" name="email"/>
        </label>
        <div class="warning">
          <p></p>
        </div>
        <input type="submit" class="submit" value="注册" />
      </form>
    </div>
  </body>
</html>