<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Удалить стpанy/cтолицy</title>
</head>
<body>

Вы действительно хотите удалить стpана/cтолица где сountryCapitalID = ${param.id}?

<form action="/countriesCapitals/${param.id}" method="post">
    <input type="hidden" name="id" value="${param.id}">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Удалить">
</form>

</body>
</html>