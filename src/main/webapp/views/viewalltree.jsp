<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color: black; background-color: blue;">All the data about tree</h1>
 <c:forEach  items="${data}" var="d">
 Tree ID: <c:out value="${d.tid}"></c:out><br><br>
 Tree Name: <c:out value="${d.name}"></c:out><br><br>
 Tree Fruit: <c:out value="${d.fruit}"></c:out><br><br>
 <img alt="" src="getimage?tid=${d.tid}" height="50"><br><br>
 
 <a href="updatet">Want to edit Something about the tree click here!</a>
     
 <hr>
 <hr>
 </c:forEach>

</body>
</html>