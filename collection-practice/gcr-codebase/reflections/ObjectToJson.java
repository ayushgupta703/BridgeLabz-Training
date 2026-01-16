package reflection;

import java.lang.reflect.Field;

class Users {
    String name;
    String email;
    int age;

    public Users(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
}

public class ObjectToJson {

    public static String toJson(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        StringBuilder json = new StringBuilder("{");

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            json.append("\"")
                .append(field.getName())
                .append("\": \"")
                .append(field.get(obj))
                .append("\"");

            if (i < fields.length - 1) {
                json.append(", ");
            }
        }

        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) throws Exception {
        Users user = new Users("XYZ", "xyz@gmail.com", 22);
        System.out.println(toJson(user));
    }
}