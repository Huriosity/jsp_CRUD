<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить нового пpавителя</title>
</head>
<body>
<form action = "http://localhost:8085/rulers" method="post">
    <input required type="text" name="name" placeholder="Имя">
    <input type="text" name="year_of_birth" placeholder="year_of_birth">
    <input type="text" name="year_of_death" placeholder="year_of_death">

    <input type="text" name="testatorID" placeholder="testatorID">
    <input type="submit" value="Сохранить">
</form>
</body>
</html>