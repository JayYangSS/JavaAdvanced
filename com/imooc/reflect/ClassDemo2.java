package com.imooc.reflect;

public class ClassDemo2 {

	public static void main(String[] args) {
		Class class1=int.class;
		Class class2=String.class;
		Class class3=double.class;
		Class class4=Double.class;
		Class class5=void.class;
		
		System.out.println(class1.getName());
		System.out.println(class4.getSimpleName());
	}

}
