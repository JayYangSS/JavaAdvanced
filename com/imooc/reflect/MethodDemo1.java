package com.imooc.reflect;

import java.lang.reflect.Method;


public class MethodDemo1 {

	public static void main(String[] args) {
		A a1=new A();
		Class class1=a1.getClass();
		
		try {
			Method method=class1.getMethod("print", int.class,int.class);
			//Object object=method.invoke(a1, new Object[]{10,20});
			Object object=method.invoke(a1, 10,20);
			
			
			//正常情况下是建立实例对象，使用对象调用方法
			//方法反射的做法是：先得到方法对象，使用方法对象来进行方法调用，就好像用方法掉用实例一样，与正常的做法
			//反过来了，所以叫做反射，该方式与a1.print()调用效果相同
			System.out.println("====================================");
			Method method2=class1.getMethod("print", String.class,String.class);
			object=method2.invoke(a1, "hello","WORLD");
			System.out.println("====================================");
			Method method3=class1.getMethod("print");
			method3.invoke(a1,new Object[]{});
			method3.invoke(a1);//没有参数也可以不写
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}

class A{
	public void print(int a, int b){
		System.out.println(a+b);
	}
	
	public void print() {
		System.out.println("helloworld");
	}
	public void print(String a, String b) {
			System.out.println(a.toUpperCase()+","+b.toLowerCase());
	}
}