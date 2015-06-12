package au.edu.newcastle.seng4400.c3155112.RESTServer;

import org.restlet.*;
import org.restlet.data.Protocol;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * Created by Julius Myszkowski on 12/06/2015.
 * Subject: ${subjectCode} - ${subjectTitle}
 * University of Newcastle
 * Student Number: c3155112
 * email: c3155112@uon.edu.au, julius.skye@gmail.com
 */
public class FirstServerResource extends ServerResource {

    public static void main(String[] args) throws Exception {
        // Create the HTTP server and listen on port 8182
        new Server(Protocol.HTTP, 8182, FirstServerResource.class).start();
    }

    @Get
    public String toString() {
        return "hello, world";
    }

}