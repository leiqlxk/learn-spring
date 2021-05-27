package org.lql.executor;

import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

/**
 * Title: ExecutorExample <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/27 17:22 <br>
 */
public class ExecutorExample {
    private TaskExecutor executor;
    public void setExecutor(TaskExecutor executor) {
        this.executor = executor;
    }
    public void executeTasks() {
        for (int i = 0; i < 6; i++) {
            executor.execute(new SimpleTask("task" + i));
        }
    }
    public static void main(String[] args) {
        ExecutorExample ee = new ExecutorExample();
        ee.setExecutor(new SimpleAsyncTaskExecutor());
        ee.executeTasks();
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
