package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class Cache {
	@CacheResult
	public int task() {
		int sum = 1;
		for (int i = 1; i < 10; i++) sum *= i;
		return sum;
	}
}

public class CacheResultAnnotation {
	public static void main(String[] args) throws Exception {

	    Cache cache = new Cache();

	    // Cache storage
	    Map<String, Object> cacheMap = new HashMap<>();

	    Method[] methods = cache.getClass().getDeclaredMethods();

	    // Call twice to prove caching
	    for (int i = 0; i < 2; i++) {

	        for (Method method : methods) {

	            if (method.isAnnotationPresent(CacheResult.class)) {

	                String key = method.getName();

	                if (cacheMap.containsKey(key)) {
	                    System.out.println("Returning cached result");
	                    System.out.println(cacheMap.get(key));
	                } else {
	                    System.out.println("Computing result");
	                    Object result = method.invoke(cache);
	                    cacheMap.put(key, result);
	                    System.out.println(result);
	                }
	            }
	        }

	        System.out.println("-----");
	    }
	}

}
