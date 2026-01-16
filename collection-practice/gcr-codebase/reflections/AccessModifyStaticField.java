package reflection;

import java.lang.reflect.Field;

class Configuration {
	@SuppressWarnings("unused")
	private static String API_KEY = "qwertyuiop";
}

public class AccessModifyStaticField {
	public static void main(String[] args) throws Exception {
		Configuration configuration = new Configuration();
		Field field = configuration.getClass().getDeclaredField("API_KEY");
		field.setAccessible(true);
//		object can be "null" also for both get and set when field is static
		System.out.println(field.get(configuration));
		field.set(configuration, "asdfghjkl");
		System.out.println(field.get(null));
	}
}
