import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class CollectionDemo {

	public static void main(String[] args) {

		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("Apple");
		arrayList.add("Microsoft");
		arrayList.add("Oracle");
		arrayList.add(1, "Apache");
		arrayList.add("JBoss");
		
		System.out.println(" -- Iterating over collection using for-loop");
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}
		
		System.out.println(" -- Traversing over collection using Iterator");
		Iterator<String> itr = arrayList.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println(" -- Traversing over collection using for-each");
		for (String elem : arrayList) {
			System.out.println(elem);
		}
		
		
		LinkedList<String> list = new LinkedList<>();
		list.add("Google");
		list.add("Nokia");
		list.add("Apple");
		
		arrayList.addAll(list); // merging collections
		
		System.out.println("-- Traversing over updated collection using for-each");
		for (String elem : arrayList) {
			System.out.println(elem);
		}
		
		HashSet<String> set = new HashSet<>(arrayList);
		System.out.println("Traversing over HashSet using for-each");
		for (String elem : set) {
			System.out.println(elem);
		}
		
		TreeSet<String> tree = new TreeSet<>(set);
		System.out.println(" -- Traversing over Tree set using for-each");
		for (String elem : tree) {
			System.out.println(elem);
		}
		
		// introduced from java8 new feature to traverse over TreeSet
		System.out.println(" -- Traversing over Tree set using for-each method");
		tree.forEach(System.out::println);
	}

}
