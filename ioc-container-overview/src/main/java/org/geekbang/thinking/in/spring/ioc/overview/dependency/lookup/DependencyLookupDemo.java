package org.geekbang.thinking.in.spring.ioc.overview.dependency.lookup;

import java.util.Map;

import org.geekbang.thinking.in.spring.ioc.overview.annotation.Super;
import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖查找示例
 *
 * 1.通过名称的方式查找
 * 2.通过类型的方式查找
 * @author yingkefa
 * @date 2020年06月29日15:35:23
 */
public class DependencyLookupDemo {
    public static void main(String[] args) {
        // 配置XML配置文件
        //启动Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");
        //按照类型查找
        lookupByType(beanFactory);
        // 按照集合类型查找
        lookupByCollectionType(beanFactory);
        // 通过注解查找对象
        lookupByAnnotationType(beanFactory);

        /*//实时查找
        lookupInRealTime(beanFactory);
        //延时查找
        lookupLazy(beanFactory);*/
    }

    private static void lookupByAnnotationType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String,User>  users = (Map)listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("查找标注 @Super 所有的 User 集合对象:"+users);
        }
    }

    private static void lookupByCollectionType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String,User>  users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找的所有的User集合对象:"+users);
        }
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("实时查找:"+user);
    }

    private static void lookupInRealTime(BeanFactory beanFactory){
        User user = (User)beanFactory.getBean("user");
        System.out.println("实时查找:"+user);
    }

    private static void lookupLazy(BeanFactory beanFactory){
        ObjectFactory<User> objectFactory = (ObjectFactory<User>)beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延迟查找:"+user);
    }
}
