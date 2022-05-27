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
<h1 style="color: black; background-color: blue;">Welcome Tree Website!</h1>
<hr>
<hr>
<p>${status}</p>
<h1 style="color: black; background-color: blue;">Welcome Insert Tree Here</h1>
  <form action="addtree" method="post" enctype="multipart/form-data">
   Tree Id:<input type="number" name="tid" placeholder="Enter the Id No" required/><br><br>
   Tree Name:<input type="text" name="name" placeholder="Enter the Tree Name" required/><br><br>
   Tree Fruit:<input type="text" name="fruit" placeholder="Enter the Tree Fruit" required/><br><br> 
   Tree Image:<input type="file" name="image" /><br><br>
   <button>ADD</button>
   </form>
<hr>
<hr>
<a href="viewalltree">To View All The Tree Click Here!</a>
<hr>
<hr>


</body>
</html>