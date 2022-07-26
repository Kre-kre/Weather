
<%@ page import="java.util.List" %>
<%@ page import="java.util.OptionalDouble" %>
<%@ page import="model.DayType" %>
<%@ page import="Helper.models.DaysHolder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>B</title>
</head>
<div style="text-align: center;">
    <h1>B</h1>
</div>
<body>

<title>Result</title>

<div style="text-align: center;">
    <input id="monthType" name="monthType" type="hidden" value="${monthType}">
    <p>Your choice is an option ${variantType}  </p>
</div>
<%
    String month = request.getParameter("monthType");
    List<DayType> dayTypeList = DaysHolder.getDayTypes(month);
    OptionalDouble avgTemperature = dayTypeList.stream().mapToInt(DayType::getTemperature).average();
    int day = Math.toIntExact(dayTypeList.stream()
            .map(DayType::getTemperature)
            .filter(integer -> integer > avgTemperature.getAsDouble())
            .count());
%>
<div style="text-align: center;">
    <%= "Quantity days when the temperature is above average :  " + day %>
</div>
<div style="text-align: center;">
    <button onclick="location.href='/Weather_war_exploded/index.jsp'">Back to main</button>
    <button onclick="history.back()" type="button" name="back">Go back</button>
</div>
</body>
</html>
