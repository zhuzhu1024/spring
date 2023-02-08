package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    public  void normalBean()
    {
        String beanXml = "classpath:/com/example/demo/beans.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);
        System.out.println(context.getBean(ServiceA.class));
        System.out.println(context.getBean(ServiceA.class));
        System.out.println("ServiceB中的ServiceA");
        ServiceB serviceB = context.getBean(ServiceB.class);
    }
    @Test
    public void m1() throws NoSuchMethodException,IllegalAccessException, InvocationTargetException,InstantiationException
    {
        //Class<IService> proxyClass = (Class<IService>) Proxy.getProxyClass(IService.class.getClassLoader(), IService.class);
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("我是InvocationHandler,被调用的方法是:" + method.getName());
                return null;
            }
        };
        IService proxyService = (IService) Proxy.newProxyInstance(IService.class.getClassLoader(), new Class[]{IService.class},invocationHandler);
        proxyService.m1();
        proxyService.m2();
        proxyService.m3();
    }
    @Test
    public void test1()
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigBean.class);
        for(String beanName :context.getBeanDefinitionNames())
        {
            String[] aliases = context.getAliases(beanName);
            System.out.println(String.format("bean名称：%s,别名：%s,bean对象：%s", beanName, Arrays.asList(aliases),context.getBean(beanName)));
        }
    }

    @Test
    public void test6()
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig6.class);
    }
}
