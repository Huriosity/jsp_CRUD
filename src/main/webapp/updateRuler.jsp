<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменить данные пpавителя</title>
</head>
<body>

Редактировать пpавителя

<form action="/rulers/${param.id}" method="post">
    <input type="hidden" name = "id" value="${param.id}">
    <input type="text" name="name" value="${param.name}" placeholder=${param.name}>
    <input type="text" name="year_of_birth" value="${param.year_of_birth}" placeholder=${param.year_of_birth}>

    <input type="text" name="year_of_death" value="${param.year_of_death}" placeholder=${param.year_of_death}>

    <input type="text" name="testatorID" value="${param.testatorID}" placeholder=${param.testatorID}>

    <input type="hidden" name="_method" value="put">
    <input type="submit" value="Обновить">
</form>

</body>
</html>