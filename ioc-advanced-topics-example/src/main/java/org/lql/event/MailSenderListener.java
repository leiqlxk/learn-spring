package org.lql.event;

import org.springframework.context.ApplicationListener;

/**
 * Title: MailSenderListener <br>
 * ProjectName: learn-spring <br>
 * description: 事件监听器 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/10 16:06 <br>
 */
public class MailSenderListener implements ApplicationListener<MailSendEvent> {
    public void onApplicationEvent(MailSendEvent mailSendEvent) {
        System.out.println("MailSenderListener:向" + mailSendEvent.getTo() + "发送完一封邮件");
    }
}
