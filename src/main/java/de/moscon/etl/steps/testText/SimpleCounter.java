package de.moscon.etl.steps.testText;

public class SimpleCounter {

    private Integer countDigits;
    private String words;

    public SimpleCounter() {
    }

    public SimpleCounter(Integer countDigits, String words) {
        this.countDigits = countDigits;
        this.words = words;
    }


    public static Integer countChars(String text){

            int counter = 0;
            for (int i = 0; i < text.length(); i++) {
                if(text.charAt(i)!=' ') {
                    counter++;
            }
        }
        return counter;

    }



    public Integer getCountDigits() {
        return countDigits;
    }

    public void setCountDigits(Integer countDigits) {
        this.countDigits = countDigits;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }
}
