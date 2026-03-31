package multithreading;

import java.util.Random;

/* ================================
   Runnable Interface Approach
   ================================ */
class FileDownloaderRunnable implements Runnable {

    private String filename;

    public FileDownloaderRunnable(String filename) {
        this.filename = filename;
    }

    @Override
    public void run() {
        Random random = new Random();

        for (int progress = 0; progress <= 100; progress += 10) {
            System.out.println("[" + Thread.currentThread().getName() +
                    "] Downloading " + filename + ": " + progress + "%");
            try {
                int delay = 200 + random.nextInt(0, 1500);
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println("Download interrupted: " + filename);
            }
        }
    }
}

/* ================================
   Thread Class Approach
   ================================ */
class FileDownloaderThread extends Thread {

    private String filename;

    public FileDownloaderThread(String filename, String threadName) {
        super(threadName);
        this.filename = filename;
    }

    @Override
    public void run() {
        Random random = new Random();

        for (int progress = 0; progress <= 100; progress += 10) {
            System.out.println("[" + getName() +
                    "] Downloading " + filename + ": " + progress + "%");
            try {
                int delay = 200 + random.nextInt(0, 1500);
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println("Download interrupted: " + filename);
            }
        }
    }
}

/* ================================
   Main Controller Class
   ================================ */
public class DownloadManager {

    public static void main(String[] args) {

        System.out.println("===== Runnable Interface Approach =====");

        FileDownloaderRunnable r1 =
                new FileDownloaderRunnable("Document.pdf");
        FileDownloaderRunnable r2 =
                new FileDownloaderRunnable("Image.jpg");
        FileDownloaderRunnable r3 =
                new FileDownloaderRunnable("Video.mp4");

        Thread t1 = new Thread(r1, "Downloader-R1");
        Thread t2 = new Thread(r2, "Downloader-R2");
        Thread t3 = new Thread(r3, "Downloader-R3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All downloads completed using Runnable.\n");

        System.out.println("===== Thread Class Approach =====");

        FileDownloaderThread th1 =
                new FileDownloaderThread("Document.pdf", "Downloader-T1");
        FileDownloaderThread th2 =
                new FileDownloaderThread("Image.jpg", "Downloader-T2");
        FileDownloaderThread th3 =
                new FileDownloaderThread("Video.mp4", "Downloader-T3");

        th1.start();
        th2.start();
        th3.start();

        try {
            th1.join();
            th2.join();
            th3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All downloads completed using Thread class.");
    }
}
