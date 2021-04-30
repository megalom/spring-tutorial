<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title> Access denied</title>
</head>

<body>
    <h2>Access denied</h2>
    <hr>
    User:<security:authentication property="principal.username"/><br>
    Role(s): <security:authentication property="principal.authorities"/>
    <hr>
    You are not authorized to view this page!<br>
    <a href="${pageContext.request.contextPath}/">back</a>

</body>
</html>