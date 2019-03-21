package com.test.demo1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Reflection {

	public static void main(String[] args) {
		 User e = new User(); 
		 e.setAge(10);
		 e.setName("haha");
		 e.setHeight(1.7f);
		 e.setWeight(48);
		 Map<String,Object> map = new HashMap<String,Object>();
         reflect(e,map); 
         for (Map.Entry<String, Object> y : map.entrySet()) {
			System.out.println("key:"+y.getKey()+",value:"+y.getValue());
		}
         Account ac = new Account();
         ac.setAccountName("hfoaeh");
         ac.setMoney(11111d);
         ac.setPassword("agareg");
         map = new HashMap<String,Object>();
         reflect(ac,map); 
         for (Map.Entry<String, Object> y : map.entrySet()) {
			System.out.println("key:"+y.getKey()+",value:"+y.getValue());
		}
	}

	private static void reflect(Object t,Map<String,Object> map) {
		Class c = t.getClass();
		Field[] fields = c.getDeclaredFields();
		
		for (Field f : fields) {
			String fieldName = f.getName();
			if(-1!=f.toGenericString().indexOf("static")||-1!=f.toGenericString().indexOf("final")) {
				continue;
			}
			
			// 将属性的首字符大写，方便构造get，set方法
            String getName = f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
            // 获取属性的类型
            String type = f.getGenericType().toString();
            // 如果type是类类型，则前面包含"class "，后面跟类名
            System.out.println("属性为：" + getName);
            if (type.equals("class java.lang.String")) {
				try {
					Method m = c.getClass().getMethod("get" + getName);
					String value = (String) m.invoke(t);
					// 调用getter方法获取属性值
					System.out.println("数据类型为：String");
					if (value != null && !value.isEmpty()) {
						System.out.println("属性值为：" + value);
//						map.put(fieldName, value);
					} else {
						System.out.println("属性值为：空");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
			
		}
	}
}
