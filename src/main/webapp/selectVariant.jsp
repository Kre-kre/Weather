<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Select result</title>
</head>
<form name="Simple" action="SelectVariant" method="POST">
    <input id="monthType" name="monthType" type="hidden" value="${monthType}">
    <div style="text-align: center;">
        <p>Your choice is an month ${monthType}</p>
        <p>Select an option</p>
    </div>
    <div style="text-align: center;">
        <label>
            <select name="variant">
                <option value="a">a</option>
                <option value="b">b</option>
                <option value="c">c</option>
                <option value="d">d</option>
            </select>
        </label>
        <input type="submit" name="button" value="Variant"/>
    </div>
</form>
</html>
