<%--
  Created by IntelliJ IDEA.
  User: Alli
  Date: 5/12/2019
  Time: 7:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Cinema Main Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="CSS/index.css">
  </head>
  <body>
  <!-- banner -->
  <div class="">
    <div class="">
      <h1 style="font-size:100px">Cinama Shalom</h1>
    </div>
  </div>
  <div>
    <!--casuta de login-->
    <div class="">
      <p><b>Already have an account? <br>
        Login and come enjoy the best movies on Earth! </b>
      </p>
      <form method = "post" action = "home">
        <div class="">
          <div>
            <label for="email">Username: </label>
            <input  type="text" placeholder="Enter Email" name="email" id = "email" required >
          </div>

          <div>
            <label for="password">Password: </label>
            <input type="password" placeholder="Enter Password" name="password" id = "password" required>
          </div>

          <div>
            <button class = "btn" type="submit" name="action">Login</button>
          </div>
        </div>
      </form>
    </div>
    <!-- casuta de register -->
    <div class="">
      <p><b>Don't have an account?<br>
        Make your life better!<br>
        Register now. :)</b> </p>

      <form action="http://localhost:8080/Cinema_war_exploded/register.jsp">
        <input type="submit" value="Register" />
      </form>
    </div>

    <%--<div class="animated-gif">  ///punem o poza ceva--%>
      <%--<img src="css/gallery/blank-paper.gif" alt = "quiz gif">--%>
    <%--</div>--%>



    <div id="result" class="result">
    <pre>
      ${requestScope.loginStatus}
    </pre>
    </div>


  </body>
</html>
