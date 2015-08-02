package com.imooc.reflect;

public class OfficeStart {

	public static void main(String[] args) {
		//使用new创建对象，是静态加载类，在编译时刻就需要加载所有的可能用到的类
		if("Word".equals(args[0]))
		{
			Word word=new Word();
			word.start();
		}
		if ("Excel".equals(args[0])) {
			Excel excel=new Excel();
			excel.start();
		}
	}

}
