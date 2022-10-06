<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Average Numbers</title>
    </head>
    <body>
        <h1>Average Numbers</h1>
        <form action="average" method="get">
            <div>
                <label>Enter a Number:</label>
                <input type="number" name="number" value="">
            </div>
            <div>
                <input type="submit" value="Calculate Average">
            </div>
           
        </form>
        
        <form method="get" action="average">
            <input type="submit" value="Reset the Average">
            <input type="hidden" name="operation" value="reset">
        </form>
        
        <p><b>Average:</b>  ${average}</p>
    </body>
</html>
