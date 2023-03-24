<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book List</title>
</head>
<body>
    <h1>Book List</h1>
    <form action="/book/insertbook">
        <input type="text" name="title" id="title" placeholder="title">
        <input type="text" name="author" id="author" placeholder="author">
        <input type="text" name="price" id="price" placeholder="price">
        <input type="text" name="qty" id="qty" placeholder="qty">
        <input type="submit" value="submit">
    </form>
    <table>
        <thead>
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Price</th>
                <th>Quantity</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${bookList}">
                <tr>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.price}</td>
                    <td>${book.qty}</td>
                    <td><a href="<c:url value='/book/editbook/${book.id}'/>">Edit</a></td>
                    <td><a href="<c:url value='/book/deletebook/${book.id}'/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
