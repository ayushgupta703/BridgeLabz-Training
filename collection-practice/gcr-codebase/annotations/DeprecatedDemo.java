package annotation;

class LegacyAPI {
	@Deprecated
	public static void oldFeature() {
		System.out.println("This is Old Feature.");
	}
	
	public static void newFeature() {
		System.out.println("This is New Feature.");		
	}
}

public class DeprecatedDemo {
	public static void main(String[] args) {
		LegacyAPI.newFeature();
		LegacyAPI.oldFeature();
	}
}
