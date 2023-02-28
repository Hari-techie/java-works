<html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <body>
            <form action="/carservlet" method="post">
                <label for="id">Id</label>
                <input type="text" name="id" id="id"><br>
                <label for="name">Name </label>
                <input type="text" name="name" id="name"><br>
                <label for="price">Price</label>
                <input type="text" name="price" id="price"><br>
                <input type="submit" value="submit">
            </form>

            

            <div align="center">
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>List of Cars</h2>
                    </caption>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                    </tr>
                    <c:forEach var="carList" items="${carList}">
                        <tr>
                            <td>
                                <c:out value="${carList.id}" />
                            </td>
                            <td>
                                <c:out value="${carList.name}" />
                            </td>
                            <td>
                                <c:out value="${carList.price}" />
                            </td>
                            <td> <a href="/edit?id=<c:out value='${carList.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="/delete?id=<c:out value='${carList.id}' />">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

            <form action="/update" method="get">
                <label for="id">Id</label>
                <input type="text" name="id" id="id" value="${id}" readonly><br>
                <label for="name">Name </label>
                <input type="text" name="name" id="name" value="${name}"><br>
                <label for="price">Price</label>
                <input type="text" name="price" id="price" value="${price}"><br>
                <input type="submit" value="update">
            </form>

            
        </body>

</html>