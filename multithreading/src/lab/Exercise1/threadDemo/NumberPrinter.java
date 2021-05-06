package lab.Exercise1.threadDemo;

import java.util.Calendar;
import java.util.Date;

public class NumberPrinter extends Thread{
	
	//print current time with thread name
	public void printNumber(String threadName) {
		for(int counter = 0; counter < 10; counter++) {
			Date time = Calendar.getInstance().getTime();
			System.out.println(counter + "->" +threadName + ": " + time);
		}
	}
	
	public void run() {
		Thread currentThreat = Thread.currentThread();
		printNumber(currentThreat.getName());
	}
}
