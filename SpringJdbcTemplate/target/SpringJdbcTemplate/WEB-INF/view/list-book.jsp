<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
            <%@ page isELIgnored="false" %>
                <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
                <title>javaguides.net</title>

        </head>

        <body>
            <div class="container">
                <div class="col-md-offset-1 col-md-10">
                    <hr />
                    <h2>Book Shop</h2>
                    <input type="button" value="Add Book" onclick="window.location.href='showForm'; return false;"
                        class="btn btn-primary" />
                    <br /><br />
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <div class="panel-title">Book List</div>
                        </div>
                        <div class="panel-body">
                            <table class="table table-striped table-bordered">
                                <tr>
                                    <th>Title</th>
                                    <th>Author</th>
                                    <th>Price</th>
                                    <th>Qty</th>
                                </tr>

                                <!-- loop over and print our Books -->
                                <c:forEach var="tempBook" items="${Books}">

                                    <!-- construct an "update" link with Book id -->
                                    <c:url var="updateLink" value="/updateForm">
                                        <c:param name="BookId" value="${tempBook.id}" />
                                    </c:url>

                                    <!-- construct an "delete" link with Book id -->
                                    <c:url var="deleteLink" value="/delete">
                                        <c:param name="BookId" value="${tempBook.id}" />
                                    </c:url>

                                    <tr>
                                        <td>${tempBook.title}</td>
                                        <td>${tempBook.author}</td>
                                        <td>${tempBook.price}</td>
                                        <td>${tempBook.qty}</td>
                                        <td>
                                            <!-- display the update link --> <a href="${updateLink}">Update</a>
                                            | <a href="${deleteLink}"
                                                onclick="if (!(confirm('Are you sure you want to delete this Book?'))) return false">Delete</a>
                                        </td>

                                    </tr>

                                </c:forEach>

                            </table>

                        </div>
                    </div>
                </div>

            </div>
        </body>

        </html>