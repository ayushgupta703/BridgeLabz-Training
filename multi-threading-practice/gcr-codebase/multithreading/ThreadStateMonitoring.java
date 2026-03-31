package multithreading;

import java.time.LocalTime;

class TaskRunner extends Thread {

    public TaskRunner(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000); // TIMED_WAITING
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // RUNNABLE work
        for (int i = 0; i < 1000000; i++) {
            Math.sqrt(i);
        }
    }
}

class StateMonitor extends Thread {

    private Thread[] threads;

    public StateMonitor(Thread[] threads) {
        this.threads = threads;
    }

    @Override
    public void run() {
        boolean allTerminated;

        do {
            allTerminated = true;
            for (Thread t : threads) {
                System.out.println("[Monitor] " + t.getName() +
                        " is in " + t.getState() +
                        " state at " + LocalTime.now());
                if (t.getState() != State.TERMINATED) {
                    allTerminated = false;
                }
            }
            System.out.println();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while (!allTerminated);

        System.out.println("Summary: All threads completed execution");
    }
}

public class ThreadStateMonitoring {
    public static void main(String[] args) {

        TaskRunner t1 = new TaskRunner("Task-1");
        TaskRunner t2 = new TaskRunner("Task-2");

        Thread[] tasks = {t1, t2};

        StateMonitor monitor = new StateMonitor(tasks);

        t1.start();
        t2.start();
        monitor.start();
    }
}
