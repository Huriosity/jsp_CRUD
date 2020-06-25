<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Удалить пpавитель/титyл</title>
</head>
<body>

Вы действительно хотите удалить пpавитель/титyл где rulerID = ${param.rulerID}?

<form action="/rulerTitleRels/${param.rulerID}" method="post">
    <input type="hidden" name="rulerID" value="${param.rulerID}">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Удалить">
</form>

</body>
</html>