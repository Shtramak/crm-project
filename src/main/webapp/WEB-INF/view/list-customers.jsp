<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customers</title>
</head>
<body>

<div id="wrapper">
    <div id="content">

        <table>
            <tr>
                <th>First name</th>
                <th>Last name</th>
                <th>Email</th>
            </tr>
            <c:forEach var="customer" items="${customers}">
                <tr>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.email}</td>
                </tr>
            </c:forEach>
        </table>

    </div>
</div>

</body>
</html>
