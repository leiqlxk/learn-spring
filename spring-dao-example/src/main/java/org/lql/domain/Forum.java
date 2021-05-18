package org.lql.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Title: Forum <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/18 17:14 <br>
 */
public class Forum {

    private int forumId;
    private String forumName;
    private String forumDesc;
    public String getForumDesc() {
        return forumDesc;
    }
    public void setForumDesc(String forumDesc) {
        this.forumDesc = forumDesc;
    }
    public int getForumId() {
        return forumId;
    }
    public void setForumId(int forumId) {
        this.forumId = forumId;
    }
    public String getForumName() {
        return forumName;
    }
    public void setForumName(String forumName) {
        this.forumName = forumName;
    }
    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
