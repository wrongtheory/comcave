package september.woche4.tag2;

import java.beans.Transient;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AufgabeSerializierung {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		SpicherManger manager = new SpicherManger(2000, new Defragmentierung(3000, "/home/vleunti", 2), 1);
		SpicherManger manager1 = new SpicherManger(4000, new Defragmentierung(5000, "/home/vleunti", 7), 8);


		String file = "manager.bin";
		serializieren(manager, file);
		System.out.println(manager + " serilaiziert1");
		
		String file2 = "manager2.bin";
		serializieren(manager1, file2);
		System.out.println(manager1 + " serilaiziert2");
		
//		SpicherManger manager2 =  deserializieren(file);
//		SpicherManger manager3 =  deserializieren(file);
//		System.out.println(manager2 + " Deserialisiert1");
//		System.out.println(manager3 + " Deserialisiert2");
		
		SpicherManger manager2 = deserializieren(file);
		SpicherManger manager3 = deserializieren(file2);
		
		SpicherManger[] managers = {
				manager2,
				manager3
		};

		for(SpicherManger sp : managers) {
			//sp = deserializieren(file);
			System.out.println(sp + " deserializiert");
		}
	}
	
	private static void serializieren(SpicherManger manager, String file) throws FileNotFoundException, IOException {
		try(ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(file))){
			ous.writeObject(manager);
			ous.writeObject(manager);
		}
	}
	
	private static SpicherManger deserializieren(String file) throws FileNotFoundException, IOException, ClassNotFoundException {
	
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
			return (SpicherManger)ois.readObject();

		}
	}
	
	

}
