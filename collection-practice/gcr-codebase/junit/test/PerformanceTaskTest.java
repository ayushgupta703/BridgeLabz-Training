
package BridgeLabz_Training.jUnit;
import org.junit.jupiter.api.*;
class PerformanceTaskTest {
    @Test @Timeout(2)
    void testTimeout() throws Exception{
        new PerformanceTask().longRunningTask();
    }
}
