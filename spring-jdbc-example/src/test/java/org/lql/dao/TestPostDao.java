package org.lql.dao;

import org.lql.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

/**
 * Title: TestPostDao <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/24 10:40 <br>
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Rollback
@Transactional
public class TestPostDao extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private PostDao postDao;

    @Test
    public void addPost() throws IOException {
        Post post = new Post();
        post.setUserId(1);
        post.setPostText("测试");

        ClassPathResource classPathResource = new ClassPathResource("temp.jpg");
        byte[] mockImg = FileCopyUtils.copyToByteArray(classPathResource.getFile());
        post.setPostAttach(mockImg);

        postDao.addPost(post);
    }

    @Test
    public void getAttachs() throws IOException {
        Post post = new Post();
        post.setUserId(1);
        post.setPostText("测试");

        ClassPathResource classPathResource = new ClassPathResource("temp.jpg");
        byte[] mockImg = FileCopyUtils.copyToByteArray(classPathResource.getFile());
        post.setPostAttach(mockImg);

        postDao.addPost(post);

        List<Post> list = postDao.getAttachs(1);

        for (Post p : list) {
            System.out.println(p.getPostId());
            System.out.println(p.getPostAttach());
        }
    }
}
