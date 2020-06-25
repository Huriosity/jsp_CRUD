<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменить стpанy</title>
</head>
<body>

Редактировать стpанy

<form action="/countries/${param.id}" method="post">
    <input type="hidden" name = "id" value="${param.id}">
    <input type="text" name="name" value="${param.name}" placeholder=${param.name}>

    <input type="hidden" name="_method" value="put">
    <input type="submit" value="Обновить">
</form>

</body>
</html>