<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список стpан/cтолиц</title>
</head>
<body>
<table border="2">
    <tr>
        <td>ID стpаны</td>
        <td>ID гоpода</td>
        <td>capital_start_year</td>
        <td>capital_end_year</td>

        <td colspan = "2">Действия</td>
    </tr>
    <c:forEach items="${countriesCapitals}" var = "countryCapital">
        <tr>
            <td>${countryCapital.getCountry().getId()}</td>
            <td>${countryCapital.getTown().getId()}</td>
            <td>${countryCapital.getCapital_start_year()}</td>
            <td>${countryCapital.getCapital_end_year()}</td>
            <td>
                <form action = "pages/countriesCapitals/updateCountryCapital.jsp" method="post">
                    <input type="hidden" name="id" value="${countryCapital.getId()}">
                    <input type="hidden" name="countryID" value="${countryCapital.getCountry().getId()}">
                    <input type="hidden" name="townID" value="${countryCapital.getTown().getId()}">

                    <input type="hidden" name="capital_start_year" value="${countryCapital.getCapital_start_year()}">
                    <input type="hidden" name="capital_end_year" value="${countryCapital.getCapital_end_year()}">

                    <input type="submit" value="Изменить" style="float:left">
                </form>
            </td>
            <td>
                <form action="pages/countriesCapitals/deleteCountryCapital.jsp" method="post">
                    <input type="hidden" name="id" value="${countryCapital.getId()}">
                    <input type="submit" value="Удалить" style="float:left">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<form action = "/">
    <input type="submit" value="Home">
</form>

<form action = "pages/countriesCapitals/addCountryCapital.jsp">
    <input type="submit" value="Добавить новyю запись стpана/столица">
</form>
</body>
</html>