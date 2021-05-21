package hust.soict.globalict.aims;

public class MemoryDaemon extends Thread implements java.lang.Runnable {
	long memoryUsed;
	
	public MemoryDaemon() {
		super();
		memoryUsed = 0l;
	}
	
	public void run() {
		Runtime rt = Runtime.getRuntime();
		long used;
		
		while (true) {
			used = rt.totalMemory() - rt.freeMemory();
			if ( used != memoryUsed ) {
				System.out.println("\tMemory used = " + used);
				memoryUsed = used;
			}
		}
	}
}
