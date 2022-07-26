
<%@ page import="java.util.List" %>
<%@ page import="model.DayType" %>
<%@ page import="Helper.models.DaysHolder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <div style="text-align: center;">
        <h1>C</h1>
    </div>
</head>
<body>
<div style="text-align: center;">
    <input id="monthType" name="monthType" type="hidden" value="${monthType}">
    <p>Your choice is an option ${variantType}  </p>
</div>
<%
    String month = request.getParameter("monthType");
    List<DayType> dayTypeList = DaysHolder.getDayTypes(month);
    int day = Math.toIntExact(dayTypeList.stream()
            .map(DayType::getTemperature)
            .filter(integer -> integer < 0)
            .count());
%>
<div style="text-align: center;">
    <%= "Quantity days when the temperature is below 0:" + day %>
</div>
<div style="text-align: center;">
    <button onclick="location.href='/Weather_war_exploded/index.jsp'">Back to main</button>
    <button onclick="history.back()" type="button" name="back">Go back</button>
</div>
</body>
</html>
