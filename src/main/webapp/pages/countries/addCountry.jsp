<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить новyю стpанy</title>
</head>
<body>
<form action = "http://localhost:8085/countries" method="post">
    <input required type="text" name="name" placeholder="Имя">

    <input type="submit" value="Сохранить">
</form>
</body>
</html>