package functional_interfaces;

interface BackupMarker {
}

class UserData implements BackupMarker {
    String name = "Ayush";
}

public class BackupMarkerInterface {
    public static void main(String[] args) {
        UserData user = new UserData();
        if (user instanceof BackupMarker) {
            System.out.println("Eligible for backup");
        }
    }
}
