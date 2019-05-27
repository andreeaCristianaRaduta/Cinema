
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
      <h1 style="font-size:100px">Cinema Shalom</h1>
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
            <label for="email">Email: </label>
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



    <div id="result" class="">
    <pre>
      ${requestScope.loginStatus}
    </pre>
    </div>
  </div>

  </body>
</html>
