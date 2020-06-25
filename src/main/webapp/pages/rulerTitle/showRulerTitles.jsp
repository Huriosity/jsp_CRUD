<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список пpавителей/титyлов</title>
</head>
<body>
<table border="2">
    <tr>
        <td>ID пpавителя</td>
        <td>ID титyла</td>
        <td>Got_the_title_in</td>
        <td>Lost_the_title_in</td>

        <td colspan = "2">Действия</td>
    </tr>
    <c:forEach items="${rulerTitleRels}" var = "rulerTitle">
        <tr>
            <td>${rulerTitle.getRuller_id()}</td>
            <td>${rulerTitle.getTitle().getId()}</td>
            <td>${rulerTitle.getGot_the_title_in()}</td>
            <td>${rulerTitle.getLost_the_title_in()}</td>
            <td>
                <form action = "pages/rulerTitle/updateRulerTitle.jsp" method="post">
                    <input type="hidden" name="id" value="${rulerTitle.getRuller_id()}">
                    <input type="hidden" name="titleID" value="${rulerTitle.getTitle().getId()}">
                    <input type="hidden" name="Got_the_title_in" value="${rulerTitle.getGot_the_title_in()}">
                    <input type="hidden" name="Lost_the_title_in" value="${rulerTitle.getLost_the_title_in()}">

                    <input type="submit" value="Изменить" style="float:left">
                </form>
            </td>
            <td>
                <form action="pages/rulerTitle/deleteRulerTitle.jsp" method="post">
                    <input type="hidden" name="id" value="${rulerTitle.getRuller_id()}">
                    <input type="submit" value="Удалить" style="float:left">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<form action = "/">
    <input type="submit" value="Home">
</form>

<form action = "pages/rulerTitle/addRulerTitle.jsp">
    <input type="submit" value="Добавить новый пpавитель/титyл">
</form>
</body>
</html>