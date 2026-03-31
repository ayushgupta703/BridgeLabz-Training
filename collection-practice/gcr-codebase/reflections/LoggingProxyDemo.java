package reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Greeting {
    void sayHello();
}

class GreetingImpl implements Greeting {
    public void sayHello() {
        System.out.println("Hello, World!");
    }
}

class LoggingHandler implements InvocationHandler {

    private Object target;

    public LoggingHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Calling method: " + method.getName());
        return method.invoke(target, args);
    }
}

public class LoggingProxyDemo {
    public static void main(String[] args) {
        Greeting greeting = new GreetingImpl();

        Greeting proxy = (Greeting) Proxy.newProxyInstance(
                greeting.getClass().getClassLoader(),
                new Class[]{Greeting.class},
                new LoggingHandler(greeting)
        );

        proxy.sayHello();
    }
}