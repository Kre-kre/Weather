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
    <p>Your choice is an option ${variantType}</p>
    <p>AVG temperature in this month: ${result}</p>
</div>
<div style="text-align: center">
    <button onclick="location.href='/Weather_war_exploded/index.jsp'">Back to main</button>
    <button onclick="history.back()" type="button" name="back">Go back</button>
</div>

</body>
</html>
