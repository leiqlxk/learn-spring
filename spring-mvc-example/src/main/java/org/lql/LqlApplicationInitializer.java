package org.lql;

import org.springframework.stereotype.Controller;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Title: LqlApplicationInitializer <br>
 * ProjectName: learn-spring <br>
 * description: 变成方式配置DispatcherServlet <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/28 13:21 <br>
 */
//public class LqlApplicationInitializer implements WebApplicationInitializer {
public class LqlApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException {
        // servlet 3.0环境中支持
        /*ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", new DispatcherServlet());

        registration.setLoadOnStartup(1);
        registration.addMapping("*.html");*/

    }
}
