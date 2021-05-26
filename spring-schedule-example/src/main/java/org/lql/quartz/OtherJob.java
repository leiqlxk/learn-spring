package org.lql.quartz;

/**
 * Title: OtherJob <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/26 17:13 <br>
 */
public class OtherJob implements Runnable {
    public void run() {
        System.out.println("do job in OtherJob.run()");
    }
}
