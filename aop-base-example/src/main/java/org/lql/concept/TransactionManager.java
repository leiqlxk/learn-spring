package org.lql.concept;

/**
 * Title: TransactionManager <br>
 * ProjectName: learn-spring <br>
 * description: 事务管理器 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/10 16:52 <br>
 */
public interface TransactionManager {

    void beginTransaction();

    void endTransaction();
}
