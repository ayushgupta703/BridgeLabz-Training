package Collections.Map_Interface;

import java.util.*;
import java.io.*;

public class WordFrequencyCounter {
    public static Map<String, Integer> countWordFrequency(String fileName) throws IOException {
        Map<String, Integer> freqMap = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (!word.isEmpty()) {
                    freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
                }
            }
        }
        reader.close();
        return freqMap;
    }

    public static void main(String[] args) throws IOException {
        String fileName = "sample.txt"; // Make sure this file exists in your project folder
        Map<String, Integer> wordFreq = countWordFrequency(fileName);
        System.out.println("Word Frequencies: " + wordFreq);
    }
}
