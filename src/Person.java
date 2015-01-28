import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Person {
	private String name;
	private String surname;
	private LinkedList<Person> child;

	public void add(Person p) {
		child.add(p);
	}

	public LinkedList<Person> getChild() {
		return child;
	}

	public Person(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
		this.child = new LinkedList<Person>();
	}

	

	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + ", child="
				+ child + "]";
	}

	public static void personToXML(List t, OutputStream os) {
		PrintWriter pw = new PrintWriter(os);
		pw.println("<?xml version=\"1.0\"?>");
		pw.println("<people>");
		Iterator<Person> parent = t.iterator();
		Person temp = null;
		Person temp2 = null;
		while (parent.hasNext()) {
			temp = parent.next();
			pw.println("\t<person name=\"" + temp.name + "\" surname=\""
					+ temp.surname + "\" >");
			Iterator<Person> children = temp.child.iterator();
			while (children.hasNext()) {
				temp2 = children.next();
				pw.println("\t\t<child name=\"" + temp2.name + "\" surname=\""
						+ temp2.surname + "\" />");
			}
			pw.println("\t</person>");
		}

		pw.println("</people>");
		pw.flush();

	}
}
