package com.imooc.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) {
		Filter f1=new Filter();
		f1.setId(10);//查询id为10的用户
		
		Filter f2=new Filter();
		f2.setUserName("lucy");
		f2.setAge(18);
		
		Filter f3=new Filter();
		f3.setEmail("liu@sina.com, zh@163.com, 77777@qq.com");
		
		String sql1=query(f1);
		String sql2=query(f2);
		String sql3=query(f3);
		
		System.out.println(sql1);
		System.out.println(sql2);
		System.out.println(sql3);
		
		
		
		Filter2 filter2=new Filter2();
		filter2.setAmount(10);
		filter2.setName("技术部");
		filter2.setLeader("Jayn");
		System.out.println(query(filter2));
	}
	
	private static String query(Object f) {
		StringBuilder sb=new StringBuilder();
		//1.获取class
		Class c=f.getClass();
		//2.获取到table的名字
		boolean exists=c.isAnnotationPresent(Table.class);
		if(!exists){
			return null;
		}
		
		Table t=(Table)c.getAnnotation(Table.class);
		String tableName=t.value();
		sb.append("select * from ").append(tableName).append(" where 1=1");
		//3.遍历所有字段
		Field[] fArrayFields=c.getDeclaredFields();
		for(Field field:fArrayFields){
			//4.处理每个字段对应的sql
			//4.1拿到字段名
			boolean fExists=field.isAnnotationPresent(Column.class);
			if(!fExists){
				continue;
			}
			Column column=field.getAnnotation(Column.class);
			String columnName=column.value();
			//4.2拿到字段值
			String fieldName=field.getName();
			String getMethodName="get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
			Object fieldValue=null;
			try {
				Method getMethod=c.getMethod(getMethodName);
				try {
					fieldValue=getMethod.invoke(f);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
			//4.3拼接
			if(fieldValue==null||fieldValue instanceof Integer &&(Integer)fieldValue==0){
				continue;
			}
			sb.append(" and ").append(fieldName);
			if(fieldValue instanceof String){
				if(((String)fieldValue).contains(",")){
					String []valueStrings=((String)fieldValue).split(",");
					sb.append(" in(");
					for(String v:valueStrings){
						sb.append("'").append(v).append("'").append(",");
					}
					sb.deleteCharAt(sb.length()-1);
					sb.append(")");
				}else {
					sb.append("=").append("'").append(fieldValue).append("'");
				}
			}else {
				sb.append("=").append(fieldValue);
			}
		}
		return sb.toString();
	}

}
