package reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
	String name();
}

@Author(name = "XYZ")
class AuthorName {
}

public class AnnotationRetriever {
	public static void main(String[] args) {
		AuthorName aName = new AuthorName();
		Class<?> class1 = aName.getClass();
		if (class1.isAnnotationPresent(Author.class)) {
			Author author = class1.getAnnotation(Author.class);
			System.out.println(author.name());
		}
	}
}
