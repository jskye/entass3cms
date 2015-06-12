package au.edu.newcastle.seng4400.c3155112;

import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;

/**
 * Created by Julius Myszkowski on 12/06/2015.
 * Subject: ${subjectCode} - ${subjectTitle}
 * University of Newcastle
 * Student Number: c3155112
 * email: c3155112@uon.edu.au, julius.skye@gmail.com
 */
public class TaskQueue {
    private Queue q = QueueFactory.getQueue("pull-queue");
//    q.add(TaskOptions.Builder.withMethod(TaskOptions.Method.PULL).payload("hello world"));

}
