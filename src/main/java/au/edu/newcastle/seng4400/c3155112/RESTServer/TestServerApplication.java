package au.edu.newcastle.seng4400.c3155112.RESTServer;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.resource.Directory;
import org.restlet.routing.Router;

/**
 * Created by Julius Myszkowski on 12/06/2015.
 * Subject: ${subjectCode} - ${subjectTitle}
 * University of Newcastle
 * Student Number: c3155112
 * email: c3155112@uon.edu.au, julius.skye@gmail.com
 */
public class TestServerApplication extends Application {

    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());

        router.attachDefault(new Directory(getContext(), "war:///"));
        router.attach("/loginevent", PaymentServerResource.class);

        return router;
    }

}