package lambda_expression;

@FunctionalInterface
interface LightAction {
    void activate();
}

public class SmartHome {
    public static void main(String[] args) {
        LightAction motionTrigger = () -> System.out.println("Lights ON at full brightness");
        LightAction nightTimeTrigger = () -> System.out.println("Lights ON in warm dim mode");
        LightAction voiceCommandTrigger = () -> System.out.println("Lights ON as per voice command");

        motionTrigger.activate();
        nightTimeTrigger.activate();
        voiceCommandTrigger.activate();
    }
}