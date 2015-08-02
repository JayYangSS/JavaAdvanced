package com.imooc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解作用范围：@Target,作用范围：包，类，字段，方法，方法的参数，局部变量
 */
@Target({ElementType.TYPE})
/**
 * 注解生命周期：@Rentention,生命周期：源文件SOURCE,编译CLASS，运行RUNTIME
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
	String value();
}
