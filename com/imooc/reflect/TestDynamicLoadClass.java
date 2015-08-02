package com.imooc.reflect;

public class TestDynamicLoadClass {

	public static void main(String[] args) {
		try {
			//∂ØÃ¨º”‘ÿ¿‡
			Class class1=Class.forName("com.imooc.reflect.Excel");
			OfficeAble oa=(OfficeAble) class1.newInstance();
			oa.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
