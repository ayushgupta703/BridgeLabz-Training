package collectors;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequencyCounter {
	public static void main(String[] args) {
		String paragraph = "java is powerful and java is popular";
		Map<String, Integer> frequencyMapCounter = Arrays.stream(paragraph.toLowerCase().split(" "))
				.collect(Collectors.toMap(word -> word, word -> 1, Integer::sum));
		frequencyMapCounter.forEach((word, count) -> System.out.println(word + " -> " + count));
	}
}
