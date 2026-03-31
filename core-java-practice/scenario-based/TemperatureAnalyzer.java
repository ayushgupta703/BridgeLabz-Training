package ScenarioBased;

public class TemperatureAnalyzer {

    public static void analyzeTemperatures(float[][] temps) {

        float hottestTemp = temps[0][0];
        float coldestTemp = temps[0][0];
        int hottestDay = 0;
        int coldestDay = 0;

        for (int day = 0; day < 7; day++) {
            float dailySum = 0;

            for (int hour = 0; hour < 24; hour++) {
                float current = temps[day][hour];
                dailySum += current;

                if (current > hottestTemp) {
                    hottestTemp = current;
                    hottestDay = day;
                }

                if (current < coldestTemp) {
                    coldestTemp = current;
                    coldestDay = day;
                }
            }

            float dailyAverage = dailySum / 24;
            System.out.println("Average temperature of Day " + (day + 1) + ": " + dailyAverage);
        }

        System.out.println("\nHottest Day: Day " + (hottestDay + 1) + " (" + hottestTemp + "°C)");
        System.out.println("Coldest Day: Day " + (coldestDay + 1) + " (" + coldestTemp + "°C)");
    }

    public static void main(String[] args) {

        float[][] temperatures = new float[7][24];

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 24; j++) {
                temperatures[i][j] = 20 + (float) (Math.random() * 15);
            }
        }

        analyzeTemperatures(temperatures);
    }
}
