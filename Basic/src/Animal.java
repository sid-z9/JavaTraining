import java.util.*;

class Cat {
	
}

class Tiger extends Cat {
}

public class Animal {
	public static void main(String[] args) {
		Set<Cat> c1 = new TreeSet<Cat>();
		Set<Tiger> t1 = new TreeSet<Tiger>();
		Set<Object> o1 = new TreeSet<>();
		// hunt(c1);
		// hunt(t1);
		// hunt(o1);
	}
	// insert code here 
	// public static void hunt(Set<?> s) { } 
	// public static void hunt(Set<? super Tiger> s) { }
	// public static void hunt(Set<? extends Cat> s) { }
	// public static void hunt(Set<Object> s) { }
}
