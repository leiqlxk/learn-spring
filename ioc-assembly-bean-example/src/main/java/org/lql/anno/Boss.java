package org.lql.anno;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * Title: Boss <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/8 17:47 <br>
 */
@Component
public class Boss {

    private Car car;

    public Boss(){
        System.out.println("construct...");
    }

//	@Autowired
//	private void setCar(Car car){
//		System.out.println("execute in setCar");
//		this.car = car;
//	}

    // JSR-250标准注解Resource，其按名称匹配，要求提供一个Bean名称的属性，如果属性为空，则自动采用标注处的变量名或方法名作为Bean的名称
    // JSR-330的Inject注解和Autowired注解一样按类型匹配进行注入，只是它没有required属性，不管是Resource还是Inject注解都没有Autowired强大，非必要推荐是有Autowired
    @Resource
    private void setCar(Car car){
        System.out.println("execute in setCar");
        this.car = car;
    }

    // 相当于init-method，不同的是其在一个勒种可以有多个
    @PostConstruct
    private void init1(){
        System.out.println("execute in init1");
    }

    @PostConstruct
    private void init2(){
        System.out.println("execute in init1");
    }

    // 相当于destory-method
    @PreDestroy
    private void destory1(){
        System.out.println("execute in destory1");
    }

    @PreDestroy
    private void destory2(){
        System.out.println("execute in destory2");
    }
}
