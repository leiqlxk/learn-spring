package org.lql.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;

/**
 * Title: MailSendEvent <br>
 * ProjectName: learn-spring <br>
 * description: 邮件发送事件 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/10 16:02 <br>
 */
public class MailSendEvent extends ApplicationEvent {
    private String to;

    public MailSendEvent(ApplicationContext source, String to) {
        super(source);
        this.to = to;
    }

    public String getTo() {
        return this.to;
    }
}
