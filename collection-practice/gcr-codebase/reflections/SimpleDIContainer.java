package reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

class Service {
    public void serve() {
        System.out.println("Service Executed");
    }
}

class Client {

    @Inject
    private Service service;

    public void execute() {
        service.serve();
    }
}

public class SimpleDIContainer {

    public static <T> T createObject(Class<T> clazz) throws Exception {
        T obj = clazz.getConstructor().newInstance();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Object dependency = field.getType().getConstructor().newInstance();
                field.set(obj, dependency);
            }
        }
        return obj;
    }

    public static void main(String[] args) throws Exception {
        Client client = createObject(Client.class);
        client.execute();
    }
}