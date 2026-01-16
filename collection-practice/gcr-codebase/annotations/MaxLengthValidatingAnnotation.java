package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
	int value();
}

class User {
	@MaxLength(value = 10)
	private String userName;

	public User(String userName) throws Exception {
		validateMaxLength(userName);
		this.userName = userName;
	}

	private void validateMaxLength(String userName) throws Exception {
		Field field = this.getClass().getDeclaredField("userName");
		if (field.isAnnotationPresent(MaxLength.class)) {
			MaxLength maxLength = field.getAnnotation(MaxLength.class);
			int allowedLength = maxLength.value();
			if (userName != null && userName.length() > allowedLength) {
				throw new IllegalArgumentException("Username exceeds the max length of " + allowedLength);
			}
		}
	}
}

public class MaxLengthValidatingAnnotation {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		User user1 = new User("Ayush");
		System.out.println("User1 Create Successfully");
		User user2 = new User("Ayush Gupta");
		System.out.println("User2 Create Successfully");
	}
}
