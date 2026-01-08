
import java.io.*;

public class ImageByteArray {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("image.jpg");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int data;
        while ((data = fis.read()) != -1) {
            baos.write(data);
        }

        byte[] imgBytes = baos.toByteArray();
        FileOutputStream fos = new FileOutputStream("new_image.jpg");
        fos.write(imgBytes);

        fis.close();
        fos.close();
    }
}
