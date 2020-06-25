<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Добавить новый титyл</title>
</head>
<body>
<form action = "http://localhost:8085/titles" method="post">
    <input required type="text" name="name" placeholder="Имя">

    <input type="submit" value="Сохранить">
</form>
</body>
</html>