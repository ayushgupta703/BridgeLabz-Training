package functional_interfaces;

interface Sensitive {
}

class PatientRecord implements Sensitive {
    String data = "Confidential";
}

public class SensitiveDataMarker {
    public static void main(String[] args) {
        PatientRecord record = new PatientRecord();
        if (record instanceof Sensitive) {
            System.out.println("Encrypt data before storing");
        }
    }
}
