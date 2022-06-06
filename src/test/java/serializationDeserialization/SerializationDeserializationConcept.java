package serializationDeserialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationDeserializationConcept {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Test t = new Test();

		// Serialization

		FileOutputStream fos = new FileOutputStream("test.txt");// writing a file into memory
		ObjectOutputStream oos = new ObjectOutputStream(fos);// converting object into file
		oos.writeObject(t);
		System.out.println(oos);

		// De-Serialization

		FileInputStream fis = new FileInputStream("test.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		System.out.println(ois);

		Test t2 = (Test) ois.readObject();
		System.out.println(t2.i + " " + t2.j);

	}

}

@SuppressWarnings("serial")
// Serialize this class object by implementing Serializable interface
class Test implements Serializable {

	int i = 10, j = 20;
}
