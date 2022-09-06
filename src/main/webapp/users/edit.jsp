<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<html>
<head>
    <title>Students Management Application</title>
</head>
<style>
    h1 {
        color: blue;
        font-family: Tahoma;
        font-size: 200%;
    }
    h2 {
        color: red;
        font-family: Arial;
        font-size: 120%;
        border: 1px solid grey;
        padding: 10px;
    }
    #element1 {
        color: blue;
    }
</style>
<body>
<center>
    <h1>Students Management</h1>
    <h2>
        <a href="users?action=users">List All Students</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Students
                </h2>
            </caption>
            <c:if test="${user != null}">
                <input type="hidden" name="id" value="<c:out value='${user.id}' />"/>
            </c:if>
            <tr>
                <th>Students Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${user.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Students birthDay:</th>
                <td>
                    <input type="text" name="birthDay" size="45"
                           value="<c:out value='${user.birthDay}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Students Address:</th>
                <td>
                    <input type="text" name="address" size="15"
                           value="<c:out value='${user.address}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Students Phone:</th>
                <td>
                    <input type="text" name="phone" size="45"
                           value="<c:out value='${user.phone}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Students Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${user.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Students Classroom:</th>
                <td>
                    <input type="text" name="classroom" size="45"
                           value="<c:out value='${user.classroom}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>