<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> List Customers</title>
    <!-- reference on our style sheet -->
    <link type="text/css"
        rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>

<body>
    <div id="wrapper">
        <div id="header">
            <h2> CRM - Customer Relationship Manager</h2>
        </div>
    </div>

    <div id="container">
        <div id="content">
            <!-- add button -->
            <input type="button" value="Add Customer"
                onclick="window.location.href='customer/add';return false;"
                class="add-button"
             />

            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>email</th>
                    <th>action</th
                </tr>

                <c:forEach var="tempCustomer" items="${customers}">
                    <tr>
                        <td>${tempCustomer.firstName}</td>
                        <td>${tempCustomer.lastName}</td>
                        <td>${tempCustomer.email}</td>
                        <td><a href="/customer/update?id=${tempCustomer.id}">Update</a>
                            |
                            <a href="/customer/delete?id=${tempCustomer.id}"
                            onclick="if (!(confirm('Are you sure you want to delete this customer')))return false">
                            Delete</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>
</body>
</html>