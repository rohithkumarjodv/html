<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set value="Bhuma is a bad girl" var="name"/>
<c:set value="<b>seriously</b>" var="comment"/>
<c:if test="${fn:containsIgnoreCase(name,'Bhuma')}">
<p> The string contains Bhuma</p>
</c:if>
${comment}
<br/>
<br/>
${fn:escapeXml(comment)}
<br/>
${fn:escapeXml(name)}
<br/>
</body>
</html>