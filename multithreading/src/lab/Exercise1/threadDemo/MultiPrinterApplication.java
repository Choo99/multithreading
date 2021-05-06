package lab.Exercise1.threadDemo;

public class MultiPrinterApplication {

	public static void main(String[] args) throws InterruptedException {
		
		//create thread
		NumberPrinter printer1 = new NumberPrinter();
		NumberPrinter printer2 = new NumberPrinter();
		
		//set name to thread
		printer1.setName("Thread 1");
		printer2.setName("Thread 2");
		
		//start execute
		printer2.start();
		printer1.start();
		
	}

}
