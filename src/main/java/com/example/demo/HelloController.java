package com.example.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/index")
    public String Index()
    {
        //1.bean配置文件位置
        String beanXml = "classpath:/com/example/demo/beans.xml";
        //2.创建ClassPathXmlApplicationContext容器，给容器指定需要加载的bean配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);
        //3.从容器中获取需要的bean
        HelloWorld helloWorld = context.getBean("helloWorld", HelloWorld.class);
        // 4.使用对象
        return helloWorld.SayHello();
    }
}
