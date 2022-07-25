
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Select result</title>
</head>
<form name="Simple" action="SelectVariant" method="POST">
    <div style="text-align: center;">
        <p>Your choose ${monthType} month </p>
        <p>Select variant</p>
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
</html>
