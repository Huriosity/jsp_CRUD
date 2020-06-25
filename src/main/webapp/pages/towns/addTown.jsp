<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить новый гоpод</title>
</head>
<body>
<form action = "http://localhost:8085/towns" method="post">
    <input required type="text" name="name" placeholder="Имя">

    <input type="submit" value="Сохранить">
</form>
</body>
</html>