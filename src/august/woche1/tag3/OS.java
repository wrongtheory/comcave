package august.woche1.tag3;

public class OS implements Comparable<OS>{
	
	private String name;
	private int version;

	
	
	
	public OS(String name, int version) {
		this.name = name;
		this.version = version;
	}

	


	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public int getVersion() {
		return version;
	}




	public void setVersion(int version) {
		this.version = version;
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}




	@Override
	public int compareTo(OS o) {
		int x = name.compareTo(o.name);
		if(x == 0)
			x = version - o.version;
		return x;
	}

}
