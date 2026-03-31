package Collections.Map_Interface;

import java.util.*;

public class MaxValueKey {
    public static <K> K getKeyWithMaxValue(Map<K, Integer> map) {
        K maxKey = null;
        int maxValue = Integer.MIN_VALUE;
        for (Map.Entry<K, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        System.out.println("Map: " + map);
        System.out.println("Key with max value: " + getKeyWithMaxValue(map));
    }
}
