<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменить пpавитель/cтpана</title>
</head>
<body>

Редактировать пpавитель/cтpана

<form action="/rulerCountryRels/${param.id}" method="post">
    <input type="hidden" name = "id" value="${param.id}">
    <input type="text" name = "rulerID" value="${param.rulerID}" placeholder=${param.rulerID}>
    <input type="text" name="countryID" value="${param.countryID}" placeholder=${param.countryID}>
    <input type="text" name="year_of_reign" value="${param.year_of_reign}" placeholder=${param.year_of_reign}>
    <input type="text" name="year_end_of_reign" value="${param.year_end_of_reign}" placeholder=${param.year_end_of_reign}>

    <input type="hidden" name="_method" value="put">
    <input type="submit" value="Обновить">
</form>

</body>
</html>