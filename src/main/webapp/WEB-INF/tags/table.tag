<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<c:choose>
    <c:when test="${requestScope['user'] != null}">
        <table>
            <tr>
                <th>user</th>
                <th>password</th>
                <th>rol</th>
            </tr>
            <c:forEach items="${requestScope['user']}" var="user">
                <c:forEach items="${user.roles}" var="rol">
                    <tr>
                        <td><c:out value="${user.name}"/></td>
                        <td><c:out value="${user.password}"/></td>
                        <td>
                            <c:out value="${rol.rol_name}"/>
                        </td>
                    </tr>
                </c:forEach>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <h1>No hay ninguna lista que pintar</h1>
    </c:otherwise>
</c:choose>

