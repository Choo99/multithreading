package lab.Exercise3.Suspend;


public class SentencePrinterApplication {

	public static void main(String[] args) {

		//create object
		Runnable selector1 = new TextSelector();
		Runnable selector2 = new TextSelector();
		Runnable selector3 = new TextSelector();
		
		//create frame
		Thread thread1 = new Thread(selector1,"text");
		Thread thread2 = new Thread(selector2,"word1");
		Thread thread3 = new Thread(selector3,"sleepText");
	
		//execute
		thread3.start();
		thread2.start();
		thread1.start();
		
	}

}
