<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="/index" method="post">
    <label>Nombre Usuario</label>
    <input name="nombre" type="text">
    <label>Password</label>
    <input type="text" name="password">
    <label>Roles</label>
    <c:choose>
        <c:when test="${requestScope['check_rol'] != null}">
            <c:forEach items="${requestScope['check_rol']}" var="rol">
                <c:set var="name" scope="page" value="${rol.rol_name}"></c:set>
                <input type="checkbox" name="rol" value="${name}">${name}
            </c:forEach>
        </c:when>
    </c:choose>
    <input type="submit" value="enviar">
</form>
