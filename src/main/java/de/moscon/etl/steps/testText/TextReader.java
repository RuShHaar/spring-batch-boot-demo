package de.moscon.etl.steps.testText;


import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.stereotype.Component;

@Component
public class TextReader extends FlatFileItemReader<String> {

    private SimpleCounter simpleCounter;

    public TextReader(SimpleCounter simpleCounter){
        this.simpleCounter=simpleCounter;
        setResource(simpleCounter.importDataAsCsv());
        setLineMapper(createLineMapper());
    }

    private LineMapper<SimpleCounter> createLineMapper(){
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer(";");
        tokenizer.setStrict(true);
        DefaultLineMapper<SimpleCounter> lineMapper = new DefaultLineMapper<SimpleCounter>();
        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(fieldSet -> {
                    SimpleCounter simpleCounter = new SimpleCounter();
                    simpleCounter.setWords(fieldSet.readString(1));

                    return simpleCounter;

                }
                );
            return lineMapper;
    }

}
