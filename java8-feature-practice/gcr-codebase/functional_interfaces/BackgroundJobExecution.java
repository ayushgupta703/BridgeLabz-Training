package functional_interfaces;

public class BackgroundJobExecution {
    public static void main(String[] args) {

        Runnable backgroundJob = () -> {
            System.out.println("Background job started");

            for (int i = 1; i <= 5; i++) {
                System.out.println("Processing step " + i);

                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    System.out.println("Job interrupted");
                }
            }

            System.out.println("Background job finished");
        };

        Thread worker = new Thread(backgroundJob);
        worker.start();

        System.out.println("Main thread continues execution");
    }
}
