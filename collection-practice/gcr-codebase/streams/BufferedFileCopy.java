
import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("bigfile.txt");
        FileOutputStream fos = new FileOutputStream("copy.txt");

        long start = System.nanoTime();
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        byte[] buffer = new byte[4096];
        int bytesRead;

        while ((bytesRead = bis.read(buffer)) != -1) {
            bos.write(buffer, 0, bytesRead);
        }
        bos.flush();
        long end = System.nanoTime();

        System.out.println("Time taken: " + (end - start));
        bis.close();
        bos.close();
    }
}
