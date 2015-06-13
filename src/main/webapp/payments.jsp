<!--

/**
 * Created by Julius Myszkowski on 14/05/2015.
* Subject: SENG4400 - Enterprise Architecture
 * University of Newcastle
 * Student Number: c3155112
 * email: c3155112@uon.edu.au, julius.skye@gmail.com
 */
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Payments
</title>
  </head>
  <body>
  <H1>Payments</H1>

  <form action="MakePayment" method="POST" id="form">
      <input type="radio" id="paypal" name="type" value="paypal"checked="checked" />
      <label for="paypal">PayPal</label> <input type="radio" id="creditcard" name="type" value="card" />
      <label for="creditcard">Credit Card</label><br />
      <input id="id" name="id" placeholder="id" /><br />
      <input id="amount" name="amount" placeholder="amount" /><br />
      <input type="submit" id="submit" />
  </form>

  <br><a href="loginResult.jsp?doLogout=true">Logout?</a>
  </body>
</html>
