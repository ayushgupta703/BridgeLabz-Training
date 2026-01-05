package Collections.List_Interface;

import java.util.*;

public class FrequencyCounter {
    public static Map<String, Integer> findFrequency(List<String> list) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String item : list) {
            freqMap.put(item, freqMap.getOrDefault(item, 0) + 1);
        }
        return freqMap;
    }

    public static void main(String[] args) {
        List<String> items = Arrays.asList("apple", "banana", "apple", "orange");
        System.out.println("Input List: " + items);
        System.out.println("Frequencies: " + findFrequency(items));
    }
}
