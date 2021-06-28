package de.moscon.etl.steps.testText;

import org.springframework.batch.item.ItemProcessor;

public class SimpleProcessor implements ItemProcessor<String, String> {


	@Override
	public String process(String data)  {

		if(data.contains("demo")){
			return null;
		}
		return data.toUpperCase() + " ||| Number of Chars: " + SimpleCounter.countChars(data);
	}

}
