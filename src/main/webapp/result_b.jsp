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
    <p>Your choice is an option ${variantType}</p>
    <p>Quantity days when the temperature is above average : ${result}</p>
</div>
<div style="text-align: center;">
    <button onclick="location.href='/Weather_war_exploded/index.jsp'">Back to main</button>
    <button onclick="history.back()" type="button" name="back">Go back</button>
</div>
</body>
</html>
