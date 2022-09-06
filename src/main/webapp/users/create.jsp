<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Students Management Application</title>
</head>
<body>
<center>
  <h1>Students Management</h1>
  <h2>
    <a href="users?action=users">List All Students</a>
  </h2>
</center>
<div align="center">
  <form action="/users?action=create" method="post">
    <table border="1" cellpadding="5">
      <caption>
        <h2>Add New Students</h2>
      </caption>
      <tr>
        <th>Students Name:</th>
        <td>
          <input type="text" name="name" id="name" size="45"/>
        </td>
      </tr>
      <tr>
        <th>Students Birth Day:</th>
        <td>
          <input type="text" name="birthDay" id="birthDay" size="45"/>
        </td>
      </tr>
      <tr>
        <th>Students address:</th>
        <td>
          <input type="text" name="address" id="address" size="15"/>
        </td>
      </tr>
      <tr>
        <th>Students phone:</th>
        <td>
          <input type="text" name="phone" id="phone" size="45"/>
        </td>
      </tr>
      <tr>
        <th>Students email:</th>
        <td>
          <input type="text" name="email" id="email" size="45"/>
        </td>
      </tr>
      <tr>
        <th>Classroom:</th>
        <td>
          <input type="text" name="Classroom" id="Classroom" size="45"/>
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