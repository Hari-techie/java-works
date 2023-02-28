<html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <body>
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
        </body>
</html>