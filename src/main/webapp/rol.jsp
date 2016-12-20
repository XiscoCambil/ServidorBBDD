<%--
  Created by IntelliJ IDEA.
  User: blackwidow
  Date: 13/12/16
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/Rol" method="POST">
    <label>name</label>
    <input type="text" name="rol_name">
    <label>descripcion</label>
    <input type="text" name="rol_desc">
    <input type="submit" value="Enviar">
</form>
<c:choose>
    <c:when test="${requestScope['roles'] != null}">
        <table>
            <tr>
                <th>Rol Name</th>
                <th>Rol Desc</th>
            </tr>
            <c:forEach items="${requestScope['roles']}" var="rol">
                    <tr>
                        <td><c:out value="${rol.rol_name}"/></td>
                        <td><c:out value="${rol.rol_desc}"/></td>
                        <td><a href="/Rol?delete=${rol.rol_name}">delete</a></td>
                    </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <jsp:forward page="/Rol"></jsp:forward>
    </c:otherwise>
</c:choose>
</body>
</html>
