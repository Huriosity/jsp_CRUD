<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список пpавителей</title>
</head>
<body>
<table border="2">
    <tr>
        <td>ID</td>
        <td>Имя</td>
        <td>year_of_birth</td>
        <td>year_of_death</td>
        <td>testatorID</td>

        <td colspan = "2">Действия</td>
    </tr>
    <c:forEach items="${rulers}" var = "ruler">
        <tr>
            <td>${ruler.getId()}</td>
            <td>${ruler.getName()}</td>
            <td>${ruler.getYear_of_birth()}</td>
            <td>${ruler.getYear_of_death()}</td>
            <td>${ruler.getTestator().getId()}</td>
            <td>
                <form action = "updateRuler.jsp" method="post">
                    <input type="hidden" name="id" value="${ruler.getId()}">
                    <input type="hidden" name="name" value="${ruler.getName()}">
                    <input type="hidden" name="year_of_birth" value="${ruler.getYear_of_birth()}">
                    <input type="hidden" name="year_of_death" value="${ruler.getYear_of_death()}">

                    <input type="hidden" name="testatorID" value="${ruler.getTestator().getId()}">
                    <input type="submit" value="Изменить" style="float:left">
                </form>
            </td>
            <td>
                <form action="deleteRuler.jsp" method="post">
                    <input type="hidden" name="id" value="${ruler.getId()}">
                    <input type="submit" value="Удалить" style="float:left">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<form action = "addRuler.jsp">
    <input type="submit" value="Добавить нового пpавителя">
</form>
</body>
</html>