<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="u" class=com.mphasis.cart.beans.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>
<jsp:getProperty property="name" name="u"/><br/>
<jsp:getProperty property="pass" name="u"/><br/>
<jsp:getProperty property="address" name="u"/><br/>
</body>
</html>