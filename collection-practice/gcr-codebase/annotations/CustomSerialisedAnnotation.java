package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
	String name();
}

class Users {
	@JsonField(name = "user_name")
	String name;
	
	@JsonField(name = "email_id")
	private String email;
	
	public Users(String name, String email) throws Exception {
		this.name = name;
		this.email = email;
	}

	public void toJson(Object obj) throws Exception {
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(JsonField.class)) {
				JsonField jField = field.getAnnotation(JsonField.class);
				System.out.println(jField.name() + " : " + field.get(obj));
			}
		}
	}
}

public class CustomSerialisedAnnotation {
	public static void main(String[] args) throws Exception {
		Users user1 = new Users("XYZ", "xyz@gmail.com");
		user1.toJson(user1);
	}
}
