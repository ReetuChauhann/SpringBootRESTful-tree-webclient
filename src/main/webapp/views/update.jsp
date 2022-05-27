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
<p>${result}</p>
<h1 style="color: black; background-color: blue;">All the data about tree</h1>
   <form action="update" method="post" enctype="multipart/form-data">
 Select tid here:  <select name="tid">
   <c:forEach items="${ids}" var="id">
   <option>${id}</option>
   </c:forEach>
   </select><br><br>
  
   Tree Name:<input type="text" name="name" placeholder="Enter the Tree Name" required/><br><br>
   Tree Fruit:<input type="text" name="fruit" placeholder="Enter the Tree Fruit" required/><br><br> 
   Tree Image:<input type="file" name="image" /><br><br>
   <button>Update </button>
     
    </form>
<hr>
<hr>
  
</body>
</html>