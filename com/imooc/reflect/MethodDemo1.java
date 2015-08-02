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
			
			
			//����������ǽ���ʵ������ʹ�ö�����÷���
			//��������������ǣ��ȵõ���������ʹ�÷������������з������ã��ͺ����÷�������ʵ��һ����������������
			//�������ˣ����Խ������䣬�÷�ʽ��a1.print()����Ч����ͬ
			System.out.println("====================================");
			Method method2=class1.getMethod("print", String.class,String.class);
			object=method2.invoke(a1, "hello","WORLD");
			System.out.println("====================================");
			Method method3=class1.getMethod("print");
			method3.invoke(a1,new Object[]{});
			method3.invoke(a1);//û�в���Ҳ���Բ�д
			
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