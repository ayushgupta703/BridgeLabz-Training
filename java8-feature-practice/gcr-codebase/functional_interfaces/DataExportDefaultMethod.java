package functional_interfaces;

interface DataExporter {
    void exportCSV();

    default void exportToJSON() {
        System.out.println("Exported to JSON");
    }
}

class CSVExporter implements DataExporter {
    public void exportCSV() {
        System.out.println("Exported to CSV");
    }
}

public class DataExportDefaultMethod {
    public static void main(String[] args) {
        DataExporter exporter = new CSVExporter();
        exporter.exportCSV();
        exporter.exportToJSON();
    }
}
