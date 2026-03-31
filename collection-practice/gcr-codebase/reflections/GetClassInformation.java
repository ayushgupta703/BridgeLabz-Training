package reflection;

class DemoClass {
	String demoString;
	int demoInt;
	public void demoMethod() {
		System.out.println("Inside Demo Method");
	}
}

public class GetClassInformation {
	public static void main(String[] args) {
		DemoClass dClass = new DemoClass();
		Class<?> className =  dClass.getClass();
		String name = className.getName();
		String packageName = className.getPackageName();
		System.out.println(className);
		System.out.println(packageName);
		System.out.println(name);
	}
}
