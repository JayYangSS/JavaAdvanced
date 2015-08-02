package com.imooc.reflect;

public class ClassDemo1 {

	public static void main(String[] args) {
		// Foo��ʵ��������α�ʾ
		Foo fool=new Foo();//fool�ͱ�ʾ����
		//Foo�����Ҳ��һ��ʵ������Class���ʵ��������α�ʾ������ֱ��new���ˣ�����ⲿ����ֱ�ӷ���
		//ֻ��JVM���Դ�����
		//�κ��඼��Class��ʵ�����������ֱ�ʾ��ʽ
		//��һ�ֱ�ʾ��ʽ-->�κ�һ���࣬����һ�������ľ�̬��Ա����class
		Class class1=Foo.class;
		
		//�ڶ��ֱ�ʾ��ʽ���Ѿ�֪������Ķ���ͨ��getClass����
		Class class2=fool.getClass();
		
		/**
		 * ����c1,c2��ʾ��Fool��������ͣ�class type��
		 * ��������Զ���
		 * ��Ҳ�Ƕ�����Class��ʵ����������������ǳ�Ϊ�����������
		 */
		//����c1,c2��������Foo������ͣ�һ����ֻ������Class���һ��ʵ������
		System.out.println(class1==class2);
		
		
		//�����ֱ�ʾ��ʽ��������ʾ��������ͣ��������˶�̬������
		//����ʱ�̼������Ǿ�̬�����࣬����ʱ�̼������Ƕ�̬������
		Class class3=null;
		try {
			class3=Class.forName("com.imooc.reflect.Foo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(class3==class2);
		//������ȫ����ͨ����������ʹ�������Ķ���ʵ��---->����ͨ��c1,c2,��c3����Foo��ʵ��
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