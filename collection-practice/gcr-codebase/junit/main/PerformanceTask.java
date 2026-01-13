
package BridgeLabz_Training.jUnit;
public class PerformanceTask {
    public String longRunningTask() throws InterruptedException{
        Thread.sleep(3000);
        return "Done";
    }
}
