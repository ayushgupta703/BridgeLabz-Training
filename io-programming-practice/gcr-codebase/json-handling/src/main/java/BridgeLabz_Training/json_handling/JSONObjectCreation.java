package BridgeLabz_Training.json_handling;

import org.json.JSONObject;
import org.json.JSONArray;

public class JSONObjectCreation {
	public static void main(String[] args) {
		JSONObject jsonObject = new JSONObject();
		JSONArray subjects = new JSONArray();
		subjects.put("JAVA");
		subjects.put("Python");
		subjects.put("Spring");
		jsonObject.put("name", "XYZ");
		jsonObject.put("age", 20);
		jsonObject.put("Subject", subjects);
		System.out.println(jsonObject.toString());
	}
}
