<!--
* Created by Julius Myszkowski on 5/05/2015.
* Subject: SENG440 - Assignment2
* University of Newcastle
* Student Number: c3155112
* email: c3155112@uon.edu.au, julius.skye@gmail.com
* TODO: convert to tag libs
-->

<!--
we are assuming invalid input events are still required to be logged.
-->

<%@ page import="java.util.logging.Logger" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login Result
</title>
  </head>
  <body>
<%
            final Logger log = java.util.logging.Logger.getLogger(this.getClass().getName());
            String authorisedUser = "admin";
            String authorisedPassword = "admin";


            ServletContext context = request.getSession().getServletContext();
            String loginCountStr = (String) context.getAttribute("loginCountStr");

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String doLogout = request.getParameter("doLogout");
            String loginResult = null;

            String[] post = new String[4];


            try{

                int loginCount;

                // initialise loginCount
                if(loginCountStr == null){
                    loginCount = 0;
                }
                else{
                    loginCount = Integer.valueOf(loginCountStr);
                }

                out.println("Checking login<br>");

                 //  user is logging out
                if(doLogout !=null){

                  out.println(" logged out, <a href=\"login.jsp\">Back to login</a>");
                  session.removeAttribute("username");
                  //loginResult = "LOGOUT_SUCCESS"

                }
                // user attempting login
                else{

                    //  user entered form with one or more params having no input
                    if (username.equals(null) || username.equals("")
                            || password.equals(null) || password.equals("")) {

                        out.print("One or all of the input parameters were missing... " + "<br>" + "<a href=\"login.jsp\">try again?</a>");
                        loginResult = "LOGIN_FAILURE_INVALID";

                    }

                    //  username and password are correct
                    else if (username.toLowerCase().trim().equals(authorisedPassword) && password.toLowerCase().trim().equals(authorisedPassword)) {
                        loginResult = "LOGIN_SUCCESS";
                        out.println("Welcome " + username + "<br>");
                        loginCount++;
                        out.println("Congratulations, you've logged in " + loginCount + " times"
                        + "<br>"+ "<a href=\"payments.jsp\">go to payments</a>"
                        + "<br>"+"<a href=\"loginResult.jsp?doLogout=true\">Logout?</a>");

                        // pass as a string
                        context.setAttribute("loginCountStr", Integer.toString(loginCount));
                        session.setAttribute("username", username);

                    }
                    // username and/or password wrong
                    else
                    {
                        loginResult = "LOGIN_FAILURE";
                        out.println("Wrong username or password" + "<br>" + "<a href=\"login.jsp\">try again?</a>");
                    }

                        post[0] = username;
                        post[1] = password;
                        post[2] = "12pm";
                        post[3] = loginResult;
                        String postString = post[0]+ " "+post[1]+" "+post[2]+" "+post[3];
                        //TODO send full string or object and split at other end


                        //send just result for now
                       // Publisher publisher = new Publisher();
                       // publisher.sendMessage(post[3]);

                        //send 10 copies per message
                        //publisher.sendMessage(post[3], 10);
                        log.info("User: "+post[0]+" pw: "+post[1]+" time: "+post[2]+" result: "+post[3]);


                }


      }catch(Exception e){
        e.printStackTrace();
      }

  %>
  </body>
</html>
