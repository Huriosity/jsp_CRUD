<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменить стpанy/cтолицy</title>
</head>
<body>

Редактировать стpанy/cтолицy

<form action="/countriesCapitals/${param.id}" method="post">
    <input type="hidden" name = "id" value="${param.id}">
    <input type="text" name="countryID" value="${param.countryID}" placeholder=${param.countryID}>
    <input type="text" name = "townID" value="${param.townID}" placeholder=${param.townID}>

    <input type="text" name="capital_start_year" value="${param.capital_start_year}" placeholder=${param.capital_start_year}>
    <input type="text" name="capital_end_year" value="${param.capital_end_year}" placeholder=${param.capital_end_year}>

    <input type="hidden" name="_method" value="put">
    <input type="submit" value="Обновить">
</form>

</body>
</html>