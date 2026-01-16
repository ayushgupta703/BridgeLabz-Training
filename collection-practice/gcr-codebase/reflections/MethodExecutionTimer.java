package reflection;

import java.lang.reflect.Method;

class Task {

    public void longTask() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Task Completed");
    }
}

public class MethodExecutionTimer {

    public static void main(String[] args) throws Exception {
        Task task = new Task();
        Method method = task.getClass().getDeclaredMethod("longTask");

        long start = System.nanoTime();
        method.invoke(task);
        long end = System.nanoTime();

        System.out.println("Execution Time (ns): " + (end - start));
    }
}