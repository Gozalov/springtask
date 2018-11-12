<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Department Form</title>
    <%--<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet"/>--%>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <spring:url value="/department/saveDepartment" var="saveURL"/>
    <h2>Department</h2>
    <form method="post" action="${saveURL }" cssClass="form">
        <form:hidden path="user.id"/>

        <div class="form-group">
            <label>Bank/Branch (mandatory)</label>
            <form:input path="department.account" cssClass="form-control" id="department.parent_account"/>
        </div>

        <div class="form-group">
            <label>Parent Bank</label>
            <form:input path="department.parent_account" cssClass="form-control" id="department.parent_account"/>
        </div>

        <div class="form-group">
            <label>Person (mandatory)</label>
            <form:input path="user.name" cssClass="form-control" id="department.account"/>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>

</div>
</body>
</html>