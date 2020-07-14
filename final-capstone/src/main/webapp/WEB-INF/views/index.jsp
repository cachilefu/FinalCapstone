<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shows</title>
</head>
<body>
<div align="center">
    <h2>Shows</h2>
    <form method="get" action="search">
        <input type="text" name="keyword" /> &nbsp;
        <input type="submit" value="Search" />
    </form>
    <h3><a href="/new">New Show</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Demographic</th>
            <th>Genre</th>
            <th>Studio</th>
            <th>Year</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${listShow}" var="show">
        <tr>
            <td>${show.id}</td>
            <td>${show.name}</td>
            <td>${show.demo}</td>
            <td>${show.genre}</td>
             <td>${show.studio}</td>
              <td>${show.year}</td>
            <td>
                <a href="/edit?id=${show.id}">Edit</a>
                &nbsp;&nbsp;&nbsp;
                <a href="/delete?id=${show.id}">Delete</a>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>   
</body>
</html>