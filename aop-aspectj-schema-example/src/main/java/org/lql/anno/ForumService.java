package org.lql.anno;

/**
 * Title: ForumService <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/13 11:50 <br>
 */
public class ForumService {

    @NeedTest(true)
    public void deleteForum(int forumId) {
        System.out.println("删除论坛模块：" + forumId);
    }

    @NeedTest(false)
    public void deleteTopic(int topicId) {
        System.out.println("删除论坛主题：" + topicId);
    }
}
