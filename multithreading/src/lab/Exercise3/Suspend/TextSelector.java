package lab.Exercise3.Suspend;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class TextSelector implements Runnable {

	private String sentence[] = { "it", "is", "recommended", "to", "use", "Calendar", "class" };
	
	//use for checking thread "word1" is running
	private static boolean isRunning = false;

	/**
	 * This method rearrange sequence of sentence
	 * Thread: word1
	 */
	private void rearrangeSentence() {

		Random random = new Random();
		Set<Integer> set = new LinkedHashSet<Integer>();

		while (set.size() < sentence.length) {
			//generate random number
			int randomNumber = random.nextInt(sentence.length);
			set.add(randomNumber);
		}

		Object newArrangement[] = set.toArray();

		String newSentence = "";
		//set the new sentence
		for (int counter = 0; counter < sentence.length; counter++) {
			newSentence += sentence[(int) newArrangement[counter]] + " ";
			
			//set isRunning to true indicate thread "word1" is executing
			isRunning = true;
		}
		System.out.println(newSentence);
	}

	/**
	 * overloaded function
	 * Thread: sleepingText
	 */
	public void rearrangeSentence(String threadName) {
		Random random = new Random();
		Set<Integer> set = new LinkedHashSet<Integer>();

		while (set.size() < sentence.length) {
			int randomNumber = random.nextInt(sentence.length);
			set.add(randomNumber);
		}

		Object newArrangement[] = set.toArray();

		String newSentence = threadName + " : ";
		for (int counter = 0; counter < sentence.length; counter++) {
			newSentence += sentence[(int) newArrangement[counter]] + " ";
			try {
				//display sleeping message when isRunning is true
				if (isRunning == true) {
					System.out.println("\n\n" + threadName + " is sleeping" + "\n\n");
					//sleep for 5 seconds
					Thread.sleep(5000);
					isRunning = false;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(newSentence);
	}

	/**
	 * extract characters from text
	 * Thread: word1
	 */
	private void extractString() {
		String text = "i am a boy";
		for (int counter = 0; counter < 10; counter++) {
			String subString = text.substring(0, counter + 1);
			System.out.println(subString);
		}
	}

	@Override
	public void run() {
		Thread currentThread = Thread.currentThread();
		String threadName = currentThread.getName();
		if (threadName.equals("text")) {
			extractString();
		} else if (threadName.equals("word1")) {
			rearrangeSentence();
		} else if (threadName.equals("sleepText")) {
			rearrangeSentence(threadName);
		}
	}

}
