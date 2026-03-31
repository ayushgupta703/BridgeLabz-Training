package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class User {
	String name;
	String email;
	int age;
	
	@Override
	public String toString() {
		return name + " " + email + " " + age;
	}
	
	public User() {
	}
	
}

public class CustomObjectMapper {
	public static <T> Object toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
		Class<T> class1 = clazz;
		Constructor<T> constructor = class1.getConstructor();
		Object obj = constructor.newInstance();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			if (properties.containsKey(field.getName())) {
				field.set(obj, properties.get(field.getName()));
			}
		}
		return obj;
	}
	
	public static void main(String[] args) throws Exception {
		Map<String, Object> userMap = new HashMap<>();
		userMap.put("name", "XYZ");
		userMap.put("email", "xyz@gmail.com");
		userMap.put("age", 20);
		Object obj = toObject(User.class, userMap);
//		User user = (User) obj;
//		System.out.println(user.name);
//		System.out.println(user.email);
//		System.out.println(user.age);
		System.out.println(obj);
	}
}
