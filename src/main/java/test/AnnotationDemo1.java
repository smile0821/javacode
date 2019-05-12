package test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import annotation.Property;
import annotation.SetTable;

public class AnnotationDemo1 {
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> forName = Class.forName("entity.UserEntity");
		Annotation[] classAnnotations = forName.getAnnotations();
		Field[] fields = forName.getDeclaredFields();
		StringBuffer sf = new StringBuffer();
		sf.append("select ");
		for (int i = 0; i < fields.length; i++) {
			Property property = fields[i].getAnnotation(Property.class);
			sf.append(property.value());
			if(i==(fields.length-1))
			{
				sf.append(" from ");
			}
			else
			{
				sf.append(" , ");
			}
		}
		
		SetTable setTable = forName.getAnnotation(SetTable.class);
		sf.append(setTable.value());
		
		System.out.println(sf.toString());
	}
}
