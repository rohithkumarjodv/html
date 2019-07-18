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
<%@taglib prefix="x"  uri="http://java.sun.com/jsp/jstl/xml"%>
<c:set var="employees">
<employees>
<employee>
  <eid> 4576</eid>
  <ename>Rohith</ename>
  <salary>4575</salary>
  </employee>
  <employee>
  <eid> 4577</eid>
  <ename>Afshaan</ename>
  <salary>5575</salary>
  </employee>
  </employees>
  </c:set>
  <x:parse xml="${employees}" var="emps"/>
  <x:choose>
    <x:when select="$emps//employee/ename ='rohith'">
    rohith is better
    </x:when>
  <x:when select="$emps//employee/ename ='Afshaan'">
    afshaan is good
    </x:when>
    <x:otherwise>
    employee is not available</x:otherwise>
  </x:choose>
  <x:forEach select="$emps//employee/ename" var="n">
  <li><x:out select="$n"/></li>
 </x:forEach>
 <ul>
 <x:forEach  select="$emps//employee/ename" var="n">
  <li><x:out select="$n"/></li>
 </x:forEach>
 </ul> 
  
</body>
</html>