<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/simple.css">
</head>
<body>
<p style="color:red">${message}</p>

<form action="login" method="post">
    <fieldset><legend>Logg Inn</legend>

        Mobil: <input type="text" name="mobil"/><br>
        Passord: <input type="password" name="passord"/><br>
        <input type="submit" value="Logg inn"/><br>

    </fieldset>
</form>
</body>
</html>