<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить новyю стpанy/столицy</title>
</head>
<body>
<form action = "/countriesCapitals" method="post">
    <input required type="text" name="countryID" placeholder="countryID">
    <input required type="text" name="townID" placeholder="townID">

    <input type="text" name="capital_start_year" placeholder="capital_start_year">
    <input type="text" name="capital_end_year" placeholder="capital_end_year">

    <input type="submit" value="Сохранить">
</form>
</body>
</html>