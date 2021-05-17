package org.lql.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Title: SystemPropertyBean <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/17 11:36 <br>
 */
@Component
public class SystemPropertyBean {

    // 直接通过注解获取参数
    @Value("#{systemProperties['os.name']}")
    private String osName;

    @Value("#{systemProperties['java.home']}")
    private String javaHome;

    @Value("#{systemProperties['java.class.path']}")
    private String classPath;

    @Value("#{systemProperties['java.version']}")
    private String javaVersion;


    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getJavaHome() {
        return javaHome;
    }

    public void setJavaHome(String javaHome) {
        this.javaHome = javaHome;
    }

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    public String getJavaVersion() {
        return javaVersion;
    }

    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
    }
}
