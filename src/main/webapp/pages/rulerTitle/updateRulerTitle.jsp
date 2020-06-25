<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменить пpавитель/титyл</title>
</head>
<body>

Редактировать пpавитель/титyл

<form action="/rulerTitleRels/${param.id}" method="post">
    <input type="hidden" name = "id" value="${param.id}">
    <input type="text" name="titleID" value="${param.titleID}" placeholder=${param.titleID}>
    <input type="text" name="Got_the_title_in" value="${param.Got_the_title_in}" placeholder=${param.Got_the_title_in}>
    <input type="text" name="Lost_the_title_in" value="${param.Lost_the_title_in}" placeholder=${param.Lost_the_title_in}>

    <input type="hidden" name="_method" value="put">
    <input type="submit" value="Обновить">
</form>

</body>
</html>