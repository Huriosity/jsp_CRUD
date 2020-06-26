<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список пpавителей/стpан</title>
</head>
<body>
<table border="2">
    <tr>
        <td>ID пpавителя</td>
        <td>ID стpаны</td>
        <td>year_of_reign</td>
        <td>year_end_of_reign</td>

        <td colspan = "2">Действия</td>
    </tr>
    <c:forEach items="${rulerCountryRels}" var = "rulerCountry">
        <tr>
            <td>${rulerCountry.getRuler().getId()}</td>
            <td>${rulerCountry.getCountry().getId()}</td>
            <td>${rulerCountry.getYear_of_reign()}</td>
            <td>${rulerCountry.getYear_end_of_reign()}</td>
            <td>
                <form action = "pages/rulerCountry/updateRulerCountry.jsp" method="post">
                    <input type="hidden" name="id" value="${rulerCountry.getId()}">
                    <input type="hidden" name="rulerID" value="${rulerCountry.getRuler().getId()}">
                    <input type="hidden" name="countryID" value="${rulerCountry.getCountry().getId()}">
                    <input type="hidden" name="year_of_reign" value="${rulerCountry.getYear_of_reign()}">
                    <input type="hidden" name="year_end_of_reign" value="${rulerCountry.getYear_end_of_reign()}">

                    <input type="submit" value="Изменить" style="float:left">
                </form>
            </td>
            <td>
                <form action="pages/rulerCountry/deleteRulerCountry.jsp" method="post">
                    <input type="hidden" name="id" value="${rulerCountry.getId()}">
                    <input type="submit" value="Удалить" style="float:left">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<form action = "/">
    <input type="submit" value="Home">
</form>

<form action = "pages/rulerCountry/addRulerCountry.jsp">
    <input type="submit" value="Добавить новый пpавитель/стpана">
</form>
</body>
</html>