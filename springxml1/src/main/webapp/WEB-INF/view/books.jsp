<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html>

        <head>
            <title>Book List</title>
        </head>

        <body>
            <h1>Book List</h1>
            <div>
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Title</th>
                            <th>Author</th>
                            <th>Price</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="book" items="${books}">
                            <tr>
                                <td>${book.id}</td>
                                <td>${book.title}</td>
                                <td>${book.author}</td>
                                <td>${book.price}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/book/update/${book.id}">Edit</a>
                                    <a href="${pageContext.request.contextPath}/book/delete/${book.id}">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

            <h2>Add a Book</h2>
            <form method="post" action="${pageContext.request.contextPath}/book/insert">
                <label for="title">Title:</label>
                <input type="text" id="title" name="title" required><br>
                <label for="author">Author:</label>
                <input type="text" id="author" name="author" required><br>
                <label for="price">Price:</label>
                <input type="number" id="price" name="price" step="0.01" min="0" required><br>
                <button type="submit">Add Book</button>
            </form>

        </body>

        </html>