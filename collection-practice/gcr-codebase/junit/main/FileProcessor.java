
package BridgeLabz_Training.jUnit;
import java.io.IOException;
import java.nio.file.*;
public class FileProcessor {
    public void writeToFile(String f,String c)throws IOException{
        Files.write(Path.of(f),c.getBytes());
    }
    public String readFromFile(String f)throws IOException{
        return Files.readString(Path.of(f));
    }
}
