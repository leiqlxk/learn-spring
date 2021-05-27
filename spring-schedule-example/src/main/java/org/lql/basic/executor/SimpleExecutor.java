package org.lql.basic.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Title: SimpleExecutor <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/27 17:14 <br>
 */
public class SimpleExecutor {

    private Executor executor;

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    public void executeTasks() {
        for (int i = 0; i < 6; i++) {
            executor.execute(new SimpleTask("task" + i));
        }
    }

    public static void main(String[] args) {
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        simpleExecutor.setExecutor(Executors.newFixedThreadPool(3));
        simpleExecutor.executeTasks();
    }
}

class SimpleTask implements Runnable {
    private String taskName;

    public SimpleTask(String taskName) {
        this.taskName = taskName;
    }

    public void run() {
        System.out.println("do " + taskName + "... in Thread:"
                + Thread.currentThread().getId());
    }
}
