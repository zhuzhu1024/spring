package com.example.demo;

public class ServiceProxy implements IService{
    private IService target;

    public  ServiceProxy(IService target)
    {
        this.target = target;
    }
    @Override
    public void m1() {
        long startTime = System.nanoTime();
        this.target.m1();
        long endTime = System.nanoTime();
        System.out.println(this.target.getClass() + ".m1方法耗时（纳秒）:"+ (endTime - startTime));
    }

    @Override
    public void m2() {
        long startTime = System.nanoTime();
        this.target.m2();
        long endTime = System.nanoTime();
        System.out.println(this.target.getClass() + ".m2方法耗时（纳秒）:"+ (endTime - startTime));
    }

    @Override
    public void m3() {
        long startTime = System.nanoTime();
        this.target.m3();
        long endTime = System.nanoTime();
        System.out.println(this.target.getClass() + ".m3方法耗时（纳秒）:"+ (endTime - startTime));
    }
}
