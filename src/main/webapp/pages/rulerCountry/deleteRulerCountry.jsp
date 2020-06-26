<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Удалить пpавитель/стpана</title>
</head>
<body>

Вы действительно хотите удалить пpавитель/стpана где rulerCountryID = ${param.id}?

<form action="/rulerCountryRels/${param.id}" method="post">
    <input type="hidden" name="id" value="${param.id}">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Удалить">
</form>

</body>
</html>