import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PersonReader {

	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {
		DocumentBuilder docReader = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		Document xmldoc = docReader.parse(new File("./XML/peopleXML.xml"));
		NodeList xmlPeople = xmldoc.getElementsByTagName("person");
		LinkedList<Person> people = new LinkedList<Person>();
		for (int i = 0; i < xmlPeople.getLength(); i++) {
			Node current = xmlPeople.item(i);
			if (current instanceof Element) {
				Element currentElement = (Element) current;
				String name = currentElement.getAttribute("name");
				String surname = currentElement.getAttribute("surname");
				Person temp = new Person(name, surname);
				people.add(temp);

				NodeList childElement = current.getChildNodes();
				for (int j = 0; j < childElement.getLength(); j++) {
					Node currentChildren = childElement.item(j);
					if (currentChildren instanceof Element) {
						Element currentChild = (Element) currentChildren;
						String childName = currentChild.getAttribute("name");
						String childSurname = currentChild
								.getAttribute("surname");
						temp.add(new Person(childName, childSurname));
					}
				}

			}
		}
		Iterator toPrint = people.iterator();
		while (toPrint.hasNext()) {
			System.out.println(toPrint.next().toString());
		}
	}

}
