<html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <body>
            <form action="/update" method="post">
                <label for="id">Id</label>
                <input type="text" name="id" id="id" value="${id}" readonly><br>
                <label for="name">Name </label>
                <input type="text" name="name" id="name" value="${name}"><br>
                <label for="price">Price</label>
                <input type="text" name="price" id="price" value="${price}"><br>
                <input type="submit" value="submit">
            </form>
        </body>

</html>