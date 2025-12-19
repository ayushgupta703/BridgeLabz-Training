public class EarthVolume {
    public static void main(String[] args) {
        double radius = 6378; // in km
        double radiusInMiles = radius * 0.621371; // in miles
        double volumeInKm3 = (4.0 / 3.0) * 22 / 7 * Math.pow(radius, 3);
        double volumeInMiles3 = (4.0 / 3.0) * 22 / 7 * Math.pow(radiusInMiles, 3);
        System.out.println(
                "The volume of earth in cubic kilometers is " + String.format("%.3f", volumeInKm3)
                        + " and cubic miles is " + String.format("%.3f", volumeInMiles3));
    }
}
