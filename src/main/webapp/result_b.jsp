<%@ page import="model.MonthType" %>
<%@ page import="java.util.Objects" %>
<%@ page import="servlet.UnMarshal" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.OptionalDouble" %>
<%@ page import="model.DayType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>B</title>
</head>
<div style="text-align: center;">
    <p>Your choice is an option ${variantType} </p>
</div>
<body>

<title>Result</title>
<h1>SOME RESULT B</h1>
<div style="text-align: center">
    <%
        //    int month = request.getParameter("monthType"); ??
        List<MonthType> monthTypes = Objects.requireNonNull(UnMarshal.getYear()).getMonth();
        MonthType monthType = monthTypes.get(6); // the month of the result selection in the first servlet
        List<DayType> dayTypeList = monthType.getDay();
        OptionalDouble avgTemperature = dayTypeList.stream().mapToInt(DayType::getTemperature).average();
//        int day = dayTypeList.stream().map(DayType::getTemperature).filter(integer -> integer>(int)avgTemperature);
    %>
<%--    <%= "Count day > avgTemp " + day %>--%>

    <button onclick="location.href='/Weather_war_exploded/index.jsp'">Back to main</button>
    <button onclick="history.back()" type="button" name="back">Go back</button>
</div>
</body>
</html>
