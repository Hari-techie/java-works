<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="ISO-8859-1">
                <title>Spring MVC </title>

            </head>

            <body>
                <div class="container">
                    <div class="col-md-offset-2 col-md-7">
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <div class="panel-title">Add Book</div>
                            </div>
                            <div class="panel-body">
                                <form:form method="post"    action="saveBook" modelAttribute="Book">
                                    <!-- need to associate this data with Book id -->
                                    <form:hidden path="id" />

                                    <div class="form-group">
                                        <label for="title" class="col-md-3 control-label">Title
                                        </label>
                                        <div class="col-md-9">
                                            <form:input path="title" cssClass="form-control" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="author" class="col-md-3 control-label">Author
                                        </label>
                                        <div class="col-md-9">
                                            <form:input path="author" cssClass="form-control" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="price" class="col-md-3 control-label">Price</label>
                                        <div class="col-md-9">
                                            <form:input path="price" cssClass="form-control" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="qty" class="col-md-3 control-label">Qty</label>
                                        <div class="col-md-9">
                                            <form:input path="qty" cssClass="form-control" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <!-- Button -->
                                        <div class="col-md-offset-3 col-md-9">
                                            <button type="submit" cssClass="btn btn-primary">Submit</button>
                                        </div>
                                    </div>

                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </body>

            </html>