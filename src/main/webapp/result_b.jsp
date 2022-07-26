<%@ page import="model.MonthType" %>
<%@ page import="java.util.Objects" %>
<%@ page import="servlet.UnMarshaller" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.OptionalDouble" %>
<%@ page import="model.DayType" %>
<%@ page import="java.util.ArrayList" %>
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
    List<MonthType> monthTypes = Objects.requireNonNull(UnMarshaller.getYear()).getMonth();
    List<DayType> dayTypeList = new ArrayList<>();
    for (MonthType monthType : monthTypes) {
        if (monthType.getMonthName().name().equals(month)) {
            dayTypeList.addAll(monthType.getDay());
        }
    }
    OptionalDouble avgTemperature = dayTypeList.stream().mapToInt(DayType::getTemperature).average();
    int day = Math.toIntExact(dayTypeList.stream()
            .map(DayType::getTemperature)
            .filter(integer -> integer > avgTemperature.getAsDouble())
            .count());
%>
<div style="text-align: center;">
    <%= "Count day > avgTemp:  " + day %>
</div>
<div style="text-align: center;">
    <button onclick="location.href='/Weather_war_exploded/index.jsp'">Back to main</button>
    <button onclick="history.back()" type="button" name="back">Go back</button>
</div>
</body>
</html>
