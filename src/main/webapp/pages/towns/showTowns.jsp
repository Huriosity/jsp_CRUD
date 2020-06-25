<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список гоpодов</title>
</head>
<body>
<table border="2">
    <tr>
        <td>ID</td>
        <td>Гоpод</td>

        <td colspan = "2">Действия</td>
    </tr>
    <c:forEach items="${towns}" var = "town">
        <tr>
            <td>${town.getId()}</td>
            <td>${town.getName()}</td>
            <td>
                <form action = "pages/towns/updateTown.jsp" method="post">
                    <input type="hidden" name="id" value="${town.getId()}">
                    <input type="hidden" name="name" value="${town.getName()}">

                    <input type="submit" value="Изменить" style="float:left">
                </form>
            </td>
            <td>
                <form action="pages/towns/deleteTown.jsp" method="post">
                    <input type="hidden" name="id" value="${town.getId()}">
                    <input type="submit" value="Удалить" style="float:left">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<form action = "pages/towns/addTown.jsp">
    <input type="submit" value="Добавить новый гоpод">
</form>
</body>
</html>