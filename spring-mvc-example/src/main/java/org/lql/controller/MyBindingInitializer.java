package org.lql.controller;

import org.lql.domain.User;
import org.lql.domain.UserEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

/**
 * Title: MyBindingInitializer <br>
 * ProjectName: learn-spring <br>
 * description: 全局范围内使用UserEditor编辑器 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/31 13:18 <br>
 */
public class MyBindingInitializer implements WebBindingInitializer {

    public void initBinder(WebDataBinder webDataBinder, WebRequest webRequest) {
        webDataBinder.registerCustomEditor(User.class, new UserEditor());
    }
}
