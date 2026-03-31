package annotation;

import java.util.ArrayList;
import java.util.List;

public class SupressWarningsDemo {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("Java");
		list.add(10);
		for(Object object : list) {
			System.out.println(object);
		}
	}
}
