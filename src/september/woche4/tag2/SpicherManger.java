package september.woche4.tag2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SpicherManger extends Dienst implements Serializable{
	private static final long serialVersionUID = 1L;
	
	int size;
	transient Defragmentierung defrag;
	static int var;
	
	
	public SpicherManger(String name) {
		super(name);
	}

	public SpicherManger(int size, Defragmentierung defrag, int var) {
		//super("");
		this.size = size;
		this.defrag = defrag;
		SpicherManger.var = var;
	}

	@Override
	public String toString() {
		return "Manger. Size=" + size + ". Defrag-Dienst: " + defrag + " " + var;
	} 
	

	private void writeObject(ObjectOutputStream oos) throws IOException {
		System.out.println("*** writeObject");
		oos.defaultWriteObject(); // Standardserialisieren aktivieren
		oos.writeInt(defrag.zeitabstand);
		oos.writeUTF(defrag.laufwerk);
	}


	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		System.out.println("*** readObject");
		ois.defaultReadObject(); // StandardDeSerialisieren aktivieren
		this.defrag = new Defragmentierung(name);
		this.defrag.zeitabstand = ois.readInt();
		this.defrag.laufwerk = ois.readUTF();
	
	}


}
