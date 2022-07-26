<%@ page import="model.MonthType" %>
<%@ page import="servlet.UnMarshaller" %>
<%@ page import="model.DayType" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>A</title>
    <div style="text-align: center;">
        <h1>A</h1>
    </div>
</head>
<body>
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
