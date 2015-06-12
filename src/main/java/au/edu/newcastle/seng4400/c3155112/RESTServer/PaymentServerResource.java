package au.edu.newcastle.seng4400.c3155112.RESTServer;

/**
 * Created by Julius Myszkowski on 12/06/2015.
 * Subject: ${subjectCode} - ${subjectTitle}
 * University of Newcastle
 * Student Number: c3155112
 * email: c3155112@uon.edu.au, julius.skye@gmail.com
 */

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

/**
 * The server side implementation of the Restlet resource.
 */
public class PaymentServerResource extends ServerResource implements
        PaymentResource {

    private static Payment payment;
    private static volatile Payment paymentServerResource;


    // constructor sets leb to leb server resource
    public PaymentServerResource(Payment payment){
        this.paymentServerResource = payment;
    }

    @Delete
    public void remove() {
        paymentServerResource = null;
    }

    @Get
    public Payment retrieve() {
        return paymentServerResource;
    }

    @Put
    public void store(Payment payment) {
        PaymentServerResource.paymentServerResource = payment;
    }

}
