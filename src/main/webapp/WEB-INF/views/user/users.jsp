<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Users</title>
</head>
<body>

  <table border="1">
    <tr>
      <th>id</th>
      <th>name</th>
      <th>email</th>
      <th>password</th>
      <th>entry_date</th>
      <th>update_date</th>
    </tr>
    <c:forEach var="user" items="${users}">
      <tr>
        <td><c:out value="${user.id}" /></td>
        <td><c:out value="${user.name}" /></td>
        <td><c:out value="${user.email}" /></td>
        <td><c:out value="${user.password}" /></td>
        <td><c:out value="${user.entryDate}" /></td>
        <td><c:out value="${user.updateDate}" /></td>
      </tr>
    </c:forEach>
  </table>

</body>
</html>
