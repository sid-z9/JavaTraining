import java.util.HashMap;

public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String, String> map = new HashMap<>();
		map.put("Scott", "Tiger");
		map.put("Jack", "Jill");
		map.put("Polo", "Lili");
		map.put("Jack", "Rose");
		
		System.out.println(map.get("Scott"));
		System.out.println(map.get("Polo"));
		System.out.println(map.get("Jack"));
		
		for (String key : map.keySet()) {
			System.out.println(key + ": " + map.get(key));
		}
	}

}
