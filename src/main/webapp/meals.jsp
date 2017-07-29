<%@ page import="ru.javawebinar.topjava.util.TimeUtil" %>
<%@ page import="java.sql.Time" %><%--
  Created by IntelliJ IDEA.
  User: Apelsin
  Date: 27.07.2017
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meal List</title>
    <style>
        .normal {color: green;}
        .exceeded {color: red;}
    </style>
</head>
<body>
<section>
    <h3><a href="index.html">Home</a></h3>
    <h2>Meals</h2>
    <hr>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Date</th>
            <th>Description</th>
            <th>Calories</th>
        </tr>
        </thead>
        <c:forEach var="meal" items="${mealWithExceedsList}">
            <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.model.MealWithExceed"/>
            <tr class="${meal.exceed ? 'exceeded' : 'normal'}">
                <td>
                    <%=TimeUtil.toString(meal.getDateTime())%>
                </td>>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
            </tr>
        </c:forEach>
    </table>>
</section>
</body>
</html>
