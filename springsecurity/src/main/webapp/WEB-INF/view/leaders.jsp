<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title> Leaders Home Page</title>
</head>

<body>
    <h2>Leaders Home Page</h2>
    <hr>
    User:<security:authentication property="principal.username"/><br>
    Role(s): <security:authentication property="principal.authorities"/>
    <hr>
    Welcome to leaders home page!<br>
    <a href="${pageContext.request.contextPath}/">back</a>

</body>
</html>