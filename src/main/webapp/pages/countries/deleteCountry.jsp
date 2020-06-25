<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Удалить cтpанy</title>
</head>
<body>

Вы действительно хотите удалить cтpанy ${param.id}?

<form action="/countries/${param.id}" method="post">
    <input type="hidden" name="id" value="${param.id}">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Удалить">
</form>

</body>
</html>