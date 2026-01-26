package BridgeLabz_Training.json_handling;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

class User {
	public int id;
	public String name;
	public int age;
	public String email;
	public List<String> skills;
	public Map<String, String> address; // city, zip
}

public class ReadJSON {
	public static void main(String[] args) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		User user = objectMapper.readValue(new File("Json_Files/user.json"), User.class);
		System.out.println("User Name: " + user.name);
		System.out.println("User Skills: " + user.skills);
	}
}
