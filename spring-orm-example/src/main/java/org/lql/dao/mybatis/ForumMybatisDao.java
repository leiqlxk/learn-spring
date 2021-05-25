package org.lql.dao.mybatis;

import org.lql.domain.Forum;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Title: ForumMybatisDao <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/25 17:07 <br>
 */
@Repository
public class ForumMybatisDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public Forum getForum(int forumId) {
        return (Forum) sqlSessionTemplate.selectOne("org.lql.dao.mybatis.ForumMybatisDao.getForum", forumId);
    }
}
