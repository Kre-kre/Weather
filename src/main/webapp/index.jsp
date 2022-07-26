<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="Helper.models.UnMarshaller" %>
<%@ page import="java.util.List" %>
<%@ page import="model.MonthType" %>
<%@ page import="java.util.Objects" %>
<%@ page import="java.util.ListIterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Weather</title>
</head>
<body>
<div style="text-align: center;">
    <h1>Select an option</h1>
</div>
<form name="Simple" action="SelectMonth" method="POST">
    <%
        List<MonthType> monthTypes = Objects.requireNonNull(UnMarshaller.getYear()).getMonth();
        ListIterator<MonthType> monthTypeListIterator = monthTypes.listIterator();
    %>
    <div style="text-align: center;">
        <label>
            <select name="month">
                <% while (monthTypeListIterator.hasNext()) { %>
                <option><%= monthTypeListIterator.next().getMonthName()%>
                </option>
                <% } %>
            </select>
        </label>
        <input type="submit" name="button" value="Select"/>
    </div>
</form>
</body>
</html>
