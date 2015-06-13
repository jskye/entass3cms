package au.edu.newcastle.seng4400.c3155112.RESTServer;

import com.google.appengine.api.taskqueue.*;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Julius Myszkowski on 12/06/2015.
 * Subject: ${subjectCode} - ${subjectTitle}
 * University of Newcastle
 * Student Number: c3155112
 * email: c3155112@uon.edu.au, julius.skye@gmail.com
 */
public class PaymentQueueResource extends ServerResource implements PaymentResource{

    // gets/retrieves a payment from the task queue
    @Get
    public Payment retrieve() throws UnsupportedEncodingException, UnsupportedOperationException {

        //get the queue
        Queue q = QueueFactory.getQueue("pull-queue");

        // get a 100 millisecond lease on the next task in the queue
        List<TaskHandle> tasks = q.leaseTasks(100, TimeUnit.MILLISECONDS,1);

        if(!tasks.isEmpty())
        {
            //get the list of key:value pairs from the task
            List<java.util.Map.Entry<java.lang.String,java.lang.String>> list = tasks.get(0).extractParams();

            //make a new payment object with the above parameters
            Payment payment = new Payment();
//            payment.setAmount(500);
//            payment.setId(list.get(1).getValue().toString());
//            payment.setType(list.get(0).getValue().toString());
            payment.setId(list.get(0).getValue().toString());

            //delete the task from the queue
            q.deleteTask(tasks.get(0));
            //send to the client
            return payment;
        }
        return null;
    }

    // puts/stores a payment on the task queue
    @Put
    public void store(Payment payment)
    {
        Queue q = QueueFactory.getQueue("pull-queue");
        q.add(TaskOptions.Builder.withMethod(TaskOptions.Method.PULL).payload(payment.toString()));

    }

    @Override
    public void remove() {
        //TODO
    }

    // returns approximate num of uncompleted tasks on queue.
    public int size(){
        Queue q = QueueFactory.getQueue("pull-queue");
        // get Queue stats
        QueueStatistics qStat = q.fetchStatistics();
        return qStat.getNumTasks();
    }

}