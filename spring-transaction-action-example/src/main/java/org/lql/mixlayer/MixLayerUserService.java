package org.lql.mixlayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Title: mixlayer <br>
 * ProjectName: learn-spring <br>
 * description: 部分层级，所有代码放在一起 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/20 14:36 <br>
 */
@Controller
public class MixLayerUserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/login.do")
    @Transactional
    public String logon(String username, String password) {
        if (isRightUser(username, password)) {
            String sql = "UPDATE t_user u SET u.score = u.score + ? WHERE u.user_name = ? and u.password = ?";
            jdbcTemplate.update(sql, 20, username, password);

            return "success";
        }else {
            return "fail";
        }
    }

    private boolean isRightUser(String username, String password) {

        return true;
    }
}
