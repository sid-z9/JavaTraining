
public class Person implements Comparable<Person> {

	private String name;
	private int age;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name: " + name + "\tAge: " + age;
	}
	
	public int getAge() {
		return age;
	}

	@Override
	public int compareTo(Person p) {
		return name.compareTo(p.name);
	}
}
