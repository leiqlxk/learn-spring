package org.lql.i18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Title: I18nGreeting <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/10 15:27 <br>
 */
public class I18nGreeting {

    public static void rsrBdMessageResource() {
        String[] strings = new String[]{"org/lql/i18n/beans.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(strings);

        // 获取MessageSource的Bean
        MessageSource ms = (MessageSource) ctx.getBean("myResource1");
        Object[] params = {"John", new GregorianCalendar().getTime()};

        // 获取格式化的国际化信息
        String str1 = ms.getMessage("greeting.common",params, Locale.US);
        String str2 = ms.getMessage("greeting.morning",params,Locale.CHINA);
        String str3 = ms.getMessage("greeting.afternoon",params,Locale.CHINA);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }

    public static void rrsrBdlMessageResource() throws Exception {
        String[] strings = new String[]{"org/lql/i18n/beans.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(strings);

        // 获取MessageSource的Bean
        MessageSource ms = (MessageSource) ctx.getBean("myResource2");
        Object[] params = {"John", new GregorianCalendar().getTime()};

        for (int i = 0; i < 2; i++) {
            String str1 = ms.getMessage("greeting.common",params,Locale.US);
            System.out.println(str1);
            Thread.currentThread().sleep(20000);
        }
    }

    public static void ctxMessageResource() {
        String[] strings = new String[]{"org/lql/i18n/beans.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(strings);
        Object[] params = {"John", new GregorianCalendar().getTime()};

        String str1 = ctx.getMessage("greeting.common",params,Locale.US);
        String str2 = ctx.getMessage("greeting.morning",params,Locale.CHINA);
        System.out.println(str1);
        System.out.println(str2);
    }

    public static void main(String[] args) throws Exception {
//        rsrBdMessageResource();
//        rrsrBdlMessageResource();
        ctxMessageResource();
    }

}
