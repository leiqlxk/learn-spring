package org.lql.proxy;

/**
 * Title: ForumService <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/11 9:37 <br>
 */
public interface ForumService {

    void removeTopic(int topicId);

    void removeForum(int forumId);
}
