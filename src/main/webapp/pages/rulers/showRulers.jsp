<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
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

        <td>titleID</td>
        <td>Got_the_title_in</td>
        <td>Lost_the_title_in</td>
        <td colspan = "2">Действия</td>
        <td>title name</td>
    </tr>
    <c:forEach items="${rulers}" var = "ruler">
        <tr>
            <td>${ruler.getId()}</td>
            <td>${ruler.getName()}</td>
            <td>${ruler.getYear_of_birth()}</td>
            <td>${ruler.getYear_of_death()}</td>
            <td>${ruler.getTestator().getId()}</td>
            <td>
                <form action = "pages/rulers/updateRuler.jsp" method="post">
                    <input type="hidden" name="id" value="${ruler.getId()}">
                    <input type="hidden" name="name" value="${ruler.getName()}">
                    <input type="hidden" name="year_of_birth" value="${ruler.getYear_of_birth()}">
                    <input type="hidden" name="year_of_death" value="${ruler.getYear_of_death()}">

                    <input type="hidden" name="testatorID" value="${ruler.getTestator().getId()}">
                    <input type="submit" value="Изменить" style="float:left">
                </form>
            </td>
            <td>
                <form action="pages/rulers/deleteRuler.jsp" method="post">
                    <input type="hidden" name="id" value="${ruler.getId()}">
                    <input type="submit" value="Удалить" style="float:left">
                </form>
            </td>

            <%----%>
            <c:forEach items="${titles}" var = "title">
                <c:choose>
                    <c:when test="${title.getRuler().getId() == ruler.getId()}">
                        <td>${title.getTitle().getId()}</td>
                        <td>${title.getGot_the_title_in()}</td>
                        <td>${title.getLost_the_title_in()}</td>
                        <td>
                            <form action = "pages/rulerTitle/updateRulerTitle.jsp" method="post">
                                <input type="hidden" name="id" value="${title.getRuller_id()}">
                                <input type="hidden" name="titleID" value="${title.getTitle().getId()}">
                                <input type="hidden" name="Got_the_title_in" value="${title.getGot_the_title_in()}">
                                <input type="hidden" name="Lost_the_title_in" value="${title.getLost_the_title_in()}">

                                <input type="submit" value="Изменить" style="float:left">
                            </form>
                        </td>
                        <td>
                            <form action="pages/rulerTitle/deleteRulerTitle.jsp" method="post">
                                <input type="hidden" name="id" value="${title.getTitle().getId()}">
                                <input type="submit" value="Удалить" style="float:left">
                            </form>
                        </td>

                        <td>${title.getTitle().getName()}</td>
                        <td>
                            <form action = "pages/title/updateTitle.jsp" method="post">
                                <input type="hidden" name="id" value="${title.getTitle().getId()}">
                                <input type="hidden" name="name" value="${title.getTitle().getName()}">

                                <input type="submit" value="Изменить" style="float:left">
                            </form>
                        </td>
                        <td>
                            <form action="pages/title/deleteTitle.jsp" method="post">
                                <input type="hidden" name="id" value="${title.getTitle().getId()}">
                                <input type="submit" value="Удалить" style="float:left">
                            </form>
                        </td>
                    </c:when>
                </c:choose>
            </c:forEach>


        </tr>
    </c:forEach>
</table>

<form action = "/">
    <input type="submit" value="Home">
</form>

<form action = "pages/rulers/addRuler.jsp">
    <input type="submit" value="Добавить нового пpавителя">
</form>
</body>
</html>