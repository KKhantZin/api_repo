package com.jdc.anno2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Main {
	public static void main(String[] args) {

		try {
			Class<?> myClass = TestClass.class;

			if (myClass.isAnnotationPresent(TypeInfo.class)) {
				TypeInfo info = myClass.getAnnotation(TypeInfo.class);
				System.out.println("Type Info : " + info.value());
			}

			Field field = myClass.getDeclaredField("name");
			if (field.isAnnotationPresent(FieldInfo.class)) {
				FieldInfo fieldAnno = field.getAnnotation(FieldInfo.class);
				System.out.println(fieldAnno.value());
			}

			// for constructor
			Constructor<?> constructor = myClass.getConstructor(String.class);
			if(constructor.isAnnotationPresent(ConstructorInfo.class)) {
				ConstructorInfo conAnno = constructor.getAnnotation(ConstructorInfo.class);
				System.out.println(conAnno.value());
			}
			
			// parameter
			Parameter [] params = constructor.getParameters();
			for (Parameter p : params) {
				if(p.isAnnotationPresent(ParamInfo.class)) {
					var para = p.getAnnotation(ParamInfo.class);
					System.out.println(para.value());
				}
			}
			
			// method
			Method method = myClass.getMethod("getName",String.class,int.class);
			if(method.isAnnotationPresent(MethodInfo.class)) {
				var methodAnno = method.getAnnotation(MethodInfo.class);
				System.out.println(methodAnno.value());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
