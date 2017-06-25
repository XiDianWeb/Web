<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
  <title>大学生职业生涯规划网</title>
  <link rel="stylesheet" type="text/css" href="./CSS/user-css/index.css">
</head>
<body>
  <div class="up">
    <header>
        <p>大学生职业生涯规划网</p>
        <c:choose>
        	<c:when test="${empty sessionScope.user }">
       		<ul>
          <a href="./HTML/login.jsp" target="_blank"><li>登录</li></a>
          <a href="./HTML/register.jsp" target="_blank"><li>注册</li></a>
          </ul>  
        	</c:when>
        	<c:otherwise>
        		<div id="welcome">欢迎回来，${sessionScope.user.name }</div>
        	</c:otherwise>
        </c:choose>       
    </header>
    <main>
      <h2>毕业，你准备好了吗？</h2>
      <p>大学生职业生涯规划网助你领先一步！</p>
    </main>
  </div>
  <footer>
    <ul>
      <li id="null"></li>
      <a href="${pageContext.request.contextPath }/mine" target="_blank"><li>心理咨询师</li></a>
      <a href="${pageContext.request.contextPath }/ui" target="_blank"><li>UI设计师</li></a>
      <a href="${pageContext.request.contextPath }/front" target="_blank"><li>前端工程师</li></a>
      <a href="${pageContext.request.contextPath }/film" target="_blank"><li>影视后期制作</li></a>
    </ul>
  </footer>
</body>
</html>