<%@ page import="model.MonthType" %>
<%@ page import="java.util.Objects" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ListIterator" %>
<%@ page import="servlet.UnMarshal" %>
<%@ page import="model.MonthNameType" %>
<%@ page import="model.DayType" %>
<%@ page import="java.util.OptionalDouble" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>A</title>
    <div style="text-align: center;">
        <h1>SOME RESULT</h1>
    </div>
</head>
<body>
<div style="text-align: center;">
    <p>Your choice is an option ${variantType}  </p>
</div>
<%
    //    int month = request.getParameter("monthType"); ??
    List<MonthType> monthTypes = Objects.requireNonNull(UnMarshal.getYear()).getMonth();
    MonthType monthType = monthTypes.get(6); // the month of the result selection in the first servlet
    List<DayType> dayTypeList = monthType.getDay();
    OptionalDouble avgTemperature = dayTypeList.stream().mapToInt(DayType::getTemperature).average();



%>
<div style="text-align: center;">
    <%="AVG temp: " + avgTemperature%>
</div>
<div style="text-align: center">
    <button onclick="location.href='/Weather_war_exploded/index.jsp'">Back to main</button>
    <button onclick="history.back()" type="button" name="back">Go back</button>
</div>

</body>
</html>
