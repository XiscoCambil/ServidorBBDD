<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<tag:welcome></tag:welcome>
<tag:table-user></tag:table-user>
<c:choose>
    <c:when test="${requestScope['admin'] == true}">
        <tag:form-user></tag:form-user>
    </c:when>
</c:choose>
</body>
</html>
