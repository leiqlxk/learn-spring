package org.lql.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

/**
 * Title: EncodeResourceExample <br>
 * ProjectName: ioc-base-spring <br>
 * description: 特定编码的资源文件访问通过EncodedResource对资源进行编码 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/30 11:38 <br>
 */
public class EncodedResourceExample {

    public static void main(String[] args) throws Throwable{
        Resource resource = new ClassPathResource("conf/file1.txt");
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
        String cont = FileCopyUtils.copyToString(encodedResource.getReader());
        System.out.println(cont);
    }
}
