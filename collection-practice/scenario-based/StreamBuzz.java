package scenario_based;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class CreatorStats {
	private String creatorName;
	private double[] weeklyLikes;
	
	public CreatorStats(String creatorName, double[] weeklyLikes) {
		this.creatorName = creatorName;
		this.weeklyLikes = weeklyLikes;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public double[] getWeeklyLikes() {
		return weeklyLikes;
	}
}

public class StreamBuzz {
	public static List<CreatorStats> engagementBoard = new ArrayList<>(); 
	
	public void RegisterCreator(CreatorStats record) {
		engagementBoard.add(record);
	}
	
	public Map<String, Integer> GetTopPostCounts(List<CreatorStats> records, double likeThreshold) {
		Map<String, Integer> topPostCounter = new HashMap<String, Integer>();
		for (CreatorStats creator : records) {
			int counter = 0;
			double[] likesArray = creator.getWeeklyLikes();
			for (double like : likesArray) {
				if (like > likeThreshold) {
					counter++;
				}
			}
			if (counter > 0) {
				topPostCounter.put(creator.getCreatorName(), counter);
			}
		}
		return topPostCounter;
	}
	
	public double CalculateAverageLikes() {
		int likesCounter = 0;
		double totalLikes = 0;
		for (CreatorStats creator : engagementBoard) {
			double[] likesArray = creator.getWeeklyLikes();
			for (double like : likesArray) {
				totalLikes += like;
				likesCounter++;
			}
		}
		if (likesCounter == 0) {
			return 0;
		}
		double averageLikes = totalLikes / likesCounter;
		return averageLikes;
	}
	
	public static void main(String[] args) {

	    Scanner sc = new Scanner(System.in);
	    StreamBuzz buzz = new StreamBuzz();
	    int choice;

	    do {
	        System.out.println("\n--- StreamBuzz Menu ---");
	        System.out.println("1. Register Creator");
	        System.out.println("2. Get Top Post Counts");
	        System.out.println("3. Calculate Average Likes");
	        System.out.println("4. Exit");
	        System.out.print("Enter your choice: ");

	        choice = sc.nextInt();
	        sc.nextLine(); // consume newline

	        switch (choice) {

	            case 1:
	                // Register Creator
	                System.out.print("Enter Creator Name: ");
	                String name = sc.nextLine();

	                double[] weeklyLikes = new double[4];
	                System.out.println("Enter likes for 4 weeks:");
	                for (int i = 0; i < 4; i++) {
	                    weeklyLikes[i] = sc.nextDouble();
	                }
	                sc.nextLine(); // consume newline

	                CreatorStats creator = new CreatorStats(name, weeklyLikes);
	                buzz.RegisterCreator(creator);

	                System.out.println("Creator registered successfully");
	                break;

	            case 2:
	                // Get Top Post Counts
	                System.out.print("Enter like threshold: ");
	                double threshold = sc.nextDouble();

	                Map<String, Integer> result =
	                        buzz.GetTopPostCounts(engagementBoard, threshold);

	                if (result.isEmpty()) {
	                    System.out.println("No creator meets the threshold");
	                } else {
	                    for (Map.Entry<String, Integer> entry : result.entrySet()) {
	                        System.out.println(entry.getKey() + " : " + entry.getValue());
	                    }
	                }
	                break;

	            case 3:
	                // Calculate Average Likes
	                double average = buzz.CalculateAverageLikes();
	                System.out.println("Average Likes: " + average);
	                break;

	            case 4:
	                System.out.println("Exiting StreamBuzz...");
	                break;

	            default:
	                System.out.println("Invalid choice. Please try again.");
	        }

	    } while (choice != 4);

	    sc.close();
	}

}
