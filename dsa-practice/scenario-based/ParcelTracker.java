package scenario_based;

class ParcelStage {
    String stage;
    ParcelStage next;

    public ParcelStage(String stage) {
        this.stage = stage;
        this.next = null;
    }
}

public class ParcelTracker {
    private ParcelStage head;

    public void addStage(String stage) {
        ParcelStage newStage = new ParcelStage(stage);
        if (head == null) {
            head = newStage;
            return;
        }
        ParcelStage temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStage;
    }

    public void addCheckpoint(String afterStage, String newStage) {
        ParcelStage temp = head;
        while (temp != null && !temp.stage.equals(afterStage)) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Stage not found");
            return;
        }
        ParcelStage checkpoint = new ParcelStage(newStage);
        checkpoint.next = temp.next;
        temp.next = checkpoint;
    }

    public void trackParcel() {
        if (head == null) {
            System.out.println("Parcel lost");
            return;
        }
        ParcelStage temp = head;
        while (temp != null) {
            System.out.print(temp.stage + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        ParcelTracker tracker = new ParcelTracker();
        tracker.addStage("Packed");
        tracker.addStage("Shipped");
        tracker.addStage("In Transit");
        tracker.addStage("Delivered");
        tracker.addCheckpoint("Shipped", "Customs Check");
        tracker.trackParcel();
    }
}
