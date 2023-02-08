package com.example.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CostTimeInvocationHandler implements InvocationHandler {
    private Object target;

    public CostTimeInvocationHandler(Object target)
    {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.nanoTime();
        Object result = method.invoke(this.target, args);
        long endTime = System.nanoTime();
        System.out.println(this.target.getClass() + ".m1方法耗时（纳秒）:"+ (endTime - startTime));
        return result;
    }

    public static <T> T CreateProxy(Object target, Class<T> targetInterface)
    {
        if(!targetInterface.isInterface())
        {
            throw new IllegalStateException("targetInterface必须是接口类型！");
        }else if (!targetInterface.isAssignableFrom(target.getClass()))
        {
            throw new IllegalStateException("target必须是targetInterface接口的实现 类!");
        }
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new CostTimeInvocationHandler(target));
    }
}
