package org.lql.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Title: FileSourceExample <br>
 * ProjectName: ioc-base-spring <br>
 * description: file类文件访问示例 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/30 9:24 <br>
 */
public class FileSourceExample {

    public static void main(String[] args) {

        try {
            String filePath = "D:\\workspace\\learn-spring\\ioc-base-example\\src\\main\\resources\\conf\\file1.txt";

            // 使用文件系统路径方式加载文件
            WritableResource writableResource = new PathResource(filePath);

            // 使用类路径方式加载文件
            Resource res = new ClassPathResource("conf/file1.txt");

            // 使用writableResource接口写资源文件
            OutputStream outputStream = writableResource.getOutputStream();
            outputStream.write("欢迎光临\n小春论坛".getBytes());

            // 使用resource接口读资源文件
            InputStream inputStream = writableResource.getInputStream();
            InputStream inputStream1 = res.getInputStream();

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            int i = 0;
            while ((i = inputStream.read()) != -1) {
                byteArrayOutputStream.write(i);
            }
            System.out.println(byteArrayOutputStream.toString());

            System.out.println("res1:" + writableResource.getFilename());
            System.out.println("res2:" + res.getFilename());

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
