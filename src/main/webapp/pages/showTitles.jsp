<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список титyлов</title>
</head>
<body>
<table border="2">
    <tr>
        <td>ID</td>
        <td>Титyл</td>

        <td colspan = "2">Действия</td>
    </tr>
    <c:forEach items="${titles}" var = "title">
        <tr>
            <td>${title.getId()}</td>
            <td>${title.getName()}</td>
            <td>
                <form action = "pages/updateTitle.jsp" method="post">
                    <input type="hidden" name="id" value="${title.getId()}">
                    <input type="hidden" name="name" value="${title.getName()}">

                    <input type="submit" value="Изменить" style="float:left">
                </form>
            </td>
            <td>
                <form action="pages/deleteTitle.jsp" method="post">
                    <input type="hidden" name="id" value="${title.getId()}">
                    <input type="submit" value="Удалить" style="float:left">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<form action = "/">
    <input type="submit" value="Home">
</form>

<form action = "pages/addTitle.jsp">
    <input type="submit" value="Добавить новый титyл">
</form>
</body>
</html>