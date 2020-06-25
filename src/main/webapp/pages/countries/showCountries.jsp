<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список стpан</title>
</head>
<body>
<table border="2">
    <tr>
        <td>ID</td>
        <td>Стpана</td>

        <td colspan = "2">Действия</td>
    </tr>
    <c:forEach items="${countries}" var = "country">
        <tr>
            <td>${country.getId()}</td>
            <td>${country.getName()}</td>
            <td>
                <form action = "pages/countries/updateCountry.jsp" method="post">
                    <input type="hidden" name="id" value="${country.getId()}">
                    <input type="hidden" name="name" value="${country.getName()}">

                    <input type="submit" value="Изменить" style="float:left">
                </form>
            </td>
            <td>
                <form action="pages/countries/deleteCountry.jsp" method="post">
                    <input type="hidden" name="id" value="${country.getId()}">
                    <input type="submit" value="Удалить" style="float:left">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<form action = "pages/countries/addCountry.jsp">
    <input type="submit" value="Добавить новyю стpанy">
</form>
</body>
</html>