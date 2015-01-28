import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedList;

public class PersonTest {

	public static void main(String[] args) throws FileNotFoundException {
		Person person1 = new Person("Haris", "Arifovic");
		Person person2 = new Person("Faris", "Arifovic");
		Person person3 = new Person("Tarik", "Arifovic");
		Person person4 = new Person("Selma", "Arifovic");
		Person person5 = new Person("Belma", "Arifovic");
		Person person6 = new Person("Mulat", "Arifovic");
		System.out.println(person1.toString());
		System.out.println(person2.toString());
		System.out.println(person3.toString());
		System.out.println(person4.toString());
		System.out.println(person5.toString());
		System.out.println(person6.toString());
		LinkedList<Person> people = new LinkedList<Person>();
		people.add(person6);
		people.add(person5);
		people.add(person4);
		people.add(person3);
		people.add(person2);
		people.add(person1);
		person1.add(new Person("Halima","Arifovic"));
		person1.add(new Person("Muhamed","Arifovic"));
		person2.add(new Person("Bilal","Arifovic"));
		person2.add(new Person("Esma","Arifovic"));
		person3.add(new Person("Medina","Arifovic"));
		person3.add(new Person("Sumeja","Arifovic"));
		
		Person.personToXML(people, new FileOutputStream("./XML/peopleXML.xml"));
	
	}

}
