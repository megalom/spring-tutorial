<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title> megalom company Home Page</title>
</head>

<body>
    <h2>megalom company Home Page</h2>
    <hr>
    User:<security:authentication property="principal.username"/><br>
    Role(s): <security:authentication property="principal.authorities"/>
    <hr>
    Welcome to the megalom company home page!<br>
    <security:authorize access="hasRole('MANAGER')">
        <a href="${pageContext.request.contextPath}/leaders">leaders only</a>
    </security:authorize>
    <security:authorize access="hasRole('ADMIN')">
        <a href="${pageContext.request.contextPath}/system">admins only</a>
    </security:authorize>



    <form:form action="${pageContext.request.contextPath}/logout"
    method="POST">
        <input type="submit" value="Logout"/>
    </form:form>

</body>
</html>