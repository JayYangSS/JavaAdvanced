package com.imooc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ע�����÷�Χ��@Target,���÷�Χ�������࣬�ֶΣ������������Ĳ������ֲ�����
 */
@Target({ElementType.TYPE})
/**
 * ע���������ڣ�@Rentention,�������ڣ�Դ�ļ�SOURCE,����CLASS������RUNTIME
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
	String value();
}
