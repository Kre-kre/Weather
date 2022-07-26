<%@ page import="model.MonthType" %>
<%@ page import="servlet.UnMarshaller" %>
<%@ page import="model.DayType" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>D</title>
</head>
<div style="text-align: center;">
    <h1>D</h1>
</div>
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
    dayTypeList.sort(Comparator.comparingDouble(DayType::getTemperature));
    Collections.reverse(dayTypeList);

%>
<div style="text-align: center;">
    <%=  dayTypeList.get(0).getTemperature() + ", "
            + dayTypeList.get(1).getTemperature()
            + "," + dayTypeList.get(2).getTemperature()%>
</div>
<div style="text-align: center;">
    <button onclick="location.href='/Weather_war_exploded/index.jsp'">Back to main</button>
    <button onclick="history.back()" type="button" name="back">Go back</button>
</div>
</body>
</html>