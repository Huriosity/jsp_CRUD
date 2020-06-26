<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить новый пpавитель/стpана</title>
</head>
<body>
<form action = "/rulerCountryRels" method="post">
    <input required type="text" name="rulerID" placeholder="rulerID">
    <input required type="text" name="countryID" placeholder="countryID">
    <input type="text" name="year_of_reign" placeholder="year_of_reign">
    <input type="text" name="year_end_of_reign" placeholder="year_end_of_reign">

    <input type="submit" value="Сохранить">
</form>
</body>
</html>