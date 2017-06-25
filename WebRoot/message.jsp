<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
  <head>   
    <title>消息提示</title>   
  </head>
  <body>
    <s:property value="#request.msg"/>
  </body>
</html>
