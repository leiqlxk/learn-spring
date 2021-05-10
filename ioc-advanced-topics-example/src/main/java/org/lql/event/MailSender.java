package org.lql.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Title: MailSender <br>
 * ProjectName: learn-spring <br>
 * description: 事件源 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/10 16:08 <br>
 */
public class MailSender implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    // ApplicationContextAware的接口方法，以便容器启动时注入容器实例
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void sendMail(String to) {
        System.out.println("MailSender:模拟发送邮件....");
        MailSendEvent mailSendEvent = new MailSendEvent(this.applicationContext, to);

        // 向容器中的所有事件监听器发送事件
        this.applicationContext.publishEvent(mailSendEvent);
    }
}
