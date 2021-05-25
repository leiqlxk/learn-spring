package org.lql.dao.hibernate;

import org.lql.domain.Forum;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Title: ForumDao <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/25 13:20 <br>
 */
@Repository
public class ForumHibernateDao extends BaseDao{

    public void addForum(Forum forum) {
        // 保存实体对象
        getHibernateTemplate().save(forum);
    }

    public void updateForum(Forum forum) {
        // 更新实体对象
        getHibernateTemplate().update(forum);
    }

    public Forum getForum(int forumId) {
        // 根据id获取数据
        return getHibernateTemplate().get(Forum.class, forumId);
    }

    public List<Forum> findForumByName(String forumName) {
        // 使用HQL查询
        return (List<Forum>) getHibernateTemplate().find("from Forum f where f.forumName like ?", forumName + "%");
    }

    public long getForumNum() {
        //使用Iterate返回结果
        Object obj = getHibernateTemplate().iterate("select count(f.forumId) from Forum f").next();
        return (Long) obj;
    }
}
