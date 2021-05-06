package lab.Exercise2.TrackingMultipleThread;

public class SentencePrinterApplication {

	public static void main(String[] args) {

		//create object
		Runnable selector1 = new TextSelector();
		Runnable selector2 = new TextSelector();
		
		//create frame
		Thread thread2 = new Thread(selector2,"word1");
		Thread thread1 = new Thread(selector1,"text");
	
		//execute
		thread1.start();
		thread2.start();
		
	}

}
