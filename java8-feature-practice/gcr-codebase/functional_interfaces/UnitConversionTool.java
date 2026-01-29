package functional_interfaces;

interface UnitConverter {
    static double kmToMiles(double km) {
        return km * 0.621371;
    }

    static double kgToPounds(double kg) {
        return kg * 2.20462;
    }
}

public class UnitConversionTool {
    public static void main(String[] args) {
        System.out.println(UnitConverter.kmToMiles(10));
        System.out.println(UnitConverter.kgToPounds(5));
    }
}
