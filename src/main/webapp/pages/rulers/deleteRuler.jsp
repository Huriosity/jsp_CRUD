<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Удалить пpавителя</title>
</head>
<body>

Вы действительно хотите удалить пpавителя ${param.id}?

<form action="/rulers/${param.id}" method="post">
<input type="hidden" name="id" value="${param.id}">
<input type="hidden" name="_method" value="delete">
<input type="submit" value="Удалить">
</form>

</body>
</html>