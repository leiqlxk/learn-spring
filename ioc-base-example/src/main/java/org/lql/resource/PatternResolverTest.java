package org.lql.resource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * Title: PatternResolverTest <br>
 * ProjectName: learn-spring <br>
 * description: PathMacthingResourcePatternResolver加载资源示例 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/30 15:48 <br>
 */
public class PatternResolverTest {

    public static void main(String[] args) throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        Resource[] resources = resolver.getResources("classpath*:org/lql/**/*.xml");

        for (Resource resource : resources) {
            System.out.println(resource.getDescription());
        }
    }
}
