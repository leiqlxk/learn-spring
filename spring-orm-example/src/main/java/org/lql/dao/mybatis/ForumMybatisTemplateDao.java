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
public class ForumMybatisTemplateDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    // 使用字符串指定映射项，容易引起错误
    public Forum getForum(int forumId) {
        return (Forum) sqlSessionTemplate.selectOne("org.lql.dao.mybatis.ForumMybatisDao.getForum", forumId);
    }

    // 根据接口返回接口实例的方法：getMapper，其比使用全限定名更安全便捷，但其仍然不是最优的方法
    // 在spring中，更希望在Service类中通过@Autowired注解直接注入接口实例，而非每次通过getMapper方法获取实例
    public Forum getForum2(int forumId) {
        ForumMybatisDao forumMybatisDao = sqlSessionTemplate.getMapper(ForumMybatisDao.class);
        return forumMybatisDao.getForum(forumId);
    }
}
