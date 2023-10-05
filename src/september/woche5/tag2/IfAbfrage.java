package september.woche5.tag2;

public class IfAbfrage {
	
	static volatile boolean inVerwendung;

	public static void main(String[] args) {
		
		Runnable target = () -> {

			Thread th = Thread.currentThread();
			
			if(!inVerwendung) {
				pause();
				inVerwendung = true;
				System.out.println("Thread " + th.getId() + " gewinnt");
			}
			else
				System.out.println("Thread " + th.getId() + " verliert");
		};
		
		new Thread(target).start();
		new Thread(target).start();

	}
	
	static void pause() {
		try {
			Thread.sleep(1);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
