package com.example.demo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ServiceB implements IService{
    @Override
    public void m1() {
        System.out.println("我是ServiceB中的m1方法！");
    }

    @Override
    public void m2() {
        System.out.println("我是ServiceB中的m2方法！");
    }

    @Override
    public void m3() {
        System.out.println("我是ServiceB中的m3方法！");
    }
}
