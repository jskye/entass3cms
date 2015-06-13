package au.edu.newcastle.seng4400.c3155112.RESTServer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//package au.edu.newcastle.seng4400.c3155112.RESTServer;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * Created by Julius Myszkowski on 13/06/2015.
// * Subject: ${subjectCode} - ${subjectTitle}
// * University of Newcastle
// * Student Number: c3155112
// * email: c3155112@uon.edu.au, julius.skye@gmail.com
// */

public class MakePayment extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        try {
            //create new payment object from post params
            Payment payment = new Payment();
            payment.setId(request.getParameter("id"));
            payment.setType(request.getParameter("type"));
            payment.setAmount(Double.parseDouble(request.getParameter("amount")));

            // create payment queue resource
            PaymentQueueResource serverPayRes = new PaymentQueueResource();
            //store the payment on the queue resource

            serverPayRes.store(payment);

            PrintWriter out = response.getWriter();

            //print receipt page
            out.println("<html>");
            out.println("<body>");
            out.println("SUCCESS<br>");
            out.println("Your payment has been received and is enqueued to be processed.<br>");
            out.println("Payment id: "+payment.getId()+"<br>");
            out.println("Payment Type: "+payment.getType()+"<br>");
            out.println("Payment Amount: "+payment.getAmount()+"<br>");
            out.println("<a href=\"payments.jsp\">Make another payment</a>");
            out.println("</body>");
            out.println("</html>");

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            response.flushBuffer();
        }
    }
}
