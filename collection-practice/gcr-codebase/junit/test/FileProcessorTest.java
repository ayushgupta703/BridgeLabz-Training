
package BridgeLabz_Training.jUnit;
import org.junit.jupiter.api.*;
import java.nio.file.*;
import static org.junit.jupiter.api.Assertions.*;
class FileProcessorTest {
    String f="test.txt"; FileProcessor p;
    @BeforeEach void setUp(){ p=new FileProcessor(); }
    @AfterEach void clean() throws Exception{
        Files.deleteIfExists(Path.of(f));
    }
    @Test void testWriteRead() throws Exception{
        p.writeToFile(f,"Hello");
        assertEquals("Hello",p.readFromFile(f));
    }
    @Test void testFileExists() throws Exception{
        p.writeToFile(f,"Hi");
        assertTrue(Files.exists(Path.of(f)));
    }
    @Test void testReadInvalid(){
        assertThrows(Exception.class,()->p.readFromFile("x.txt"));
    }
}
