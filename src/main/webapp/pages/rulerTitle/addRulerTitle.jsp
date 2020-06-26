<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить новый пpавитель/титyл</title>
</head>
<body>
<form action = "/rulerTitleRels" method="post">
    <input required type="text" name="rulerID" placeholder="rulerID">
    <input required type="text" name="titleID" placeholder="titleID">
    <input type="text" name="Got_the_title_in" placeholder="Got_the_title_in">
    <input type="text" name="Lost_the_title_in" placeholder="Lost_the_title_in">

    <input type="submit" value="Сохранить">
</form>
</body>
</html>