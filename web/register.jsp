
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="CSS/register.css">
    <title>Register Home Page</title>
</head>
<body>
<%--<div class="register-img">--%>
<div class="">
    <h1 style="font-size:100px">Register</h1>
</div>
<form method="post" action="register">
    <div class="">
        <div class="">
            <label for="lastName">Last name: </label>
            <input  type="text" placeholder="Enter last name" name="lastName" id = "lastName" required >
        </div>
        <div class="">
            <label for="firstName">First name: </label>
            <input  type="text" placeholder="Enter first name" name="firstName" id = "firstName" required >
        </div>
        <%--<div class="">--%>
            <%--<label for="id">Phone number: </label>--%>
            <%--<input  type="number" placeholder="Enter id" name="id" id = "id">--%>
        <%--</div>--%>

        <div class="">
            <label for="email">Email: </label>
            <input  type="text" placeholder="Enter Email" name="email" id = "email" required >
        </div>

        <div class="">
            <label for="password">Password: </label>
            <input type="password" placeholder="Enter Password" name="password" id = "password" required>
        </div>

        <div>
            <button class = "btn" type="submit" name="action">Register</button>
        </div>

    </div>
</form>

</body>
</html>
