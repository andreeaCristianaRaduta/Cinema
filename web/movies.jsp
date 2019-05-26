<%--
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
<div class="quizzes-img">
</div>
<br>
<form action="http://localhost:8080/Cinma_war_exploded/movies" method="post">
    <input type="submit" value="Show movies"/>
</form>

<div id="result0" class="result">
    <pre>
        ${requestScope.movies}
    </pre>
</div>

<div>
    <div class = "container1">

        <form action="http://localhost:8080/Cinema_war_exploded/shNames" method="POST">
            <input type="submit" value="Show the ids"/>
        </form>

        <div id="result1" class="result">
            <pre>
                ${requestScope.ids}
            </pre>
        </div>

        <form action="http://localhost:8080/Cinema_war_exploded/shNames" method="POST">
            <input type="submit" value="Show the Movies"/>
        </form>

        <div id="result2" class="result">
            <pre>
                ${requestScope.names}
            </pre>
        </div>

        <form action="http://localhost:8080/Cinema_war_exploded/shPrice" method="post">
            <input type="submit" value="Show the price"/>
        </form>

        <div id="result3" class="result">
            <pre>
                ${requestScope.pries}
            </pre>
        </div>

        <form action="http://localhost:8080/Cinema_war_exploded/shNames" method="POST">
            <input type="submit" value="Show the formats"/>
        </form>

        <div id="result4" class="result">
            <pre>
                ${requestScope.formats}
            </pre>
        </div>
        <form action="http://localhost:8080/Cinema_war_exploded/shNames" method="POST">
            <input type="submit" value="Show the dates"/>
        </form>

        <div id="result5" class="result">
            <pre>
                ${requestScope.dates}
            </pre>
        </div>
        <form action="http://localhost:8080/Cinema_war_exploded/seeTop", method="post">
            <input type="submit" value="See top" />
        </form>
    </div>




</body>
</html>
