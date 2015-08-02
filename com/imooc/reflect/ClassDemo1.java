package com.imooc.reflect;

public class ClassDemo1 {

	public static void main(String[] args) {
		// Foo的实例对象如何表示
		Foo fool=new Foo();//fool就表示出了
		//Foo这个类也是一个实例对象，Class类的实例对象，如何表示？不能直接new出了，类的外部不能直接访问
		//只有JVM可以创建类
		//任何类都是Class的实例对象，有三种表示方式
		//第一种表示方式-->任何一个类，都有一个隐含的静态成员变量class
		Class class1=Foo.class;
		
		//第二种表示方式，已经知道该类的对象通过getClass方法
		Class class2=fool.getClass();
		
		/**
		 * 官网c1,c2表示了Fool类的类类型（class type）
		 * 万事万物皆对象
		 * 类也是对象，是Class的实例对象，这个对象我们成为该类的类类型
		 */
		//不管c1,c2都代表了Foo类的类型，一个类只可能是Class类的一个实例对象
		System.out.println(class1==class2);
		
		
		//第三种表示方式，不仅表示了类的类型，还代表了动态加载类
		//编译时刻加载类是静态加载类，运行时刻加载类是动态加载类
		Class class3=null;
		try {
			class3=Class.forName("com.imooc.reflect.Foo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(class3==class2);
		//我们完全可以通过类的类类型创建该类的对象实例---->可以通过c1,c2,或c3创建Foo的实例
		try {
			Foo foo=(Foo) class1.newInstance();
			foo.print();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Foo{
	void print(){
		System.out.print("foo");
	}
};