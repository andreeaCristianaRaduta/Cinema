<%@ page import="main.Movie" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.lang.reflect.Array" %>
  Created by IntelliJ IDEA.
  User: Alli
  Date: 5/26/2019
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="CSS/movies.css">
    <title>Cinema - Movies</title>

</head>
<body>

<br>

<form action="http://localhost:8080/Cinema_war_exploded/movies" method="post">
    <input type="submit" value="Show movies"/>
</form>

<div id="result0" class="">
    <pre>
        ${requestScope.movies}
    </pre>
</div>


<div>
    <form method="post" action="makeReservation">
        <label for="idMovie">Id-ul filmului: </label>
        <input  type="text" placeholder="Enter the id" name="idMovie" id = "idMovie" required >
        <input type="submit" value="Make Rezerv"/>

    </form>
</div>

<form method="post" action="makeReservation">
<div id="result" class="result">
    <pre>
        ${requestScope.reservationStatus}
    </pre>
</div>
</form>

<div>
    <form method="post" action="allReservations">
        <input type="submit" value="Show Rezerv"/>

    </form>
</div>

<form method="post" action="allReservation">
<div id="result3" class="">
    <pre>
        ${requestScope.allReservations}
    </pre>
</div>
</form>


</body>
</html>
