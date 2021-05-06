package lab.Exercise2.TrackingMultipleThread;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class TextSelector implements Runnable{

	private String sentence[] = { "it","is","recommended","to","use","Calendar","class"};
	
	/**
	 * This method rearrange sequence of sentence
	 * Thread: word1
	 */
	private void rearrangeSentence() {
		Random random = new Random();
		Set<Integer>set = new LinkedHashSet<Integer>();
		
		while(set.size() < sentence.length) {
			int randomNumber = random.nextInt(sentence.length);
			set.add(randomNumber);
		}
		
		Object newArrangement[] = set.toArray();
		
		//set the new sentence
		String newSentence = "";
		for(int counter = 0; counter < sentence.length; counter++) {
			newSentence += sentence[(int)newArrangement[counter]] + " ";
		}
		System.out.println(newSentence);
	}
	
	/**
	 * extract characters from text
	 * Thread: word1
	 */
	private void extractString() {
		String text = "i am a boy";
		for(int counter = 0; counter < 10; counter++) {
			String subString = text.substring(0, counter + 1);
			System.out.println(subString);
		}
	}
	
	@Override
	public void run() {
		Thread currentThread = Thread.currentThread();
		String threadName = currentThread.getName();
		if(threadName.equals("text")) {
			extractString();
		}
		else if(threadName.equals("word1")) {
			rearrangeSentence();
		}
	}

}
