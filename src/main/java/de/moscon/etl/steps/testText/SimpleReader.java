package de.moscon.etl.steps.testText;

import org.springframework.batch.item.ItemReader;

public class SimpleReader implements ItemReader<String> {

	private String[] messages = {
			"Spring Batch could be used for ETL",
			"Welcome to the Spring Batch demo",
			"In the background we use a memory sqlite database"
	};


	private int count = 0;


	@Override
	public String read() {
	String[] newMessage = null;

		if (count < messages.length) {
			//SimpleCounter.countDigits(messages);

//				for(String s : messages) {
//					if (s.contains("demo")) {
//						continue;
//					} else {
//						newMessage[] = messages[];
//					}
//				}
				String message = messages[count];
				System.out.println("---> Reading: " + message);
				count++;
				return message;

		}
		System.out.println("-----> Finished all reading!");
		count = 0;
		return null;
	}

}
