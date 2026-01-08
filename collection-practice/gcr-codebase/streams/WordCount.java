
import java.io.*;
import java.util.*;

public class WordCount {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("text.txt"));
        HashMap<String, Integer> map = new HashMap<>();
        String line;

        while ((line = br.readLine()) != null) {
            for (String word : line.split("\\s+")) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        br.close();

        map.entrySet().stream()
            .sorted((a,b) -> b.getValue() - a.getValue())
            .limit(5)
            .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
    }
}
