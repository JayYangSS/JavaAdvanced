package com.imooc.reflect;

public class OfficeStart {

	public static void main(String[] args) {
		//ʹ��new���������Ǿ�̬�����࣬�ڱ���ʱ�̾���Ҫ�������еĿ����õ�����
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
