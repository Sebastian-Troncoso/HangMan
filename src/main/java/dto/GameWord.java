package dto;

import java.util.Arrays;

public class GameWord {

    private String word;
    private char [] letterArr;
    private int count = 3;

    public int getCount() {
        return count;
    }

    public GameWord(String w) {
        word = w;
    }

    public String getWord() {
        return word;
    }

    public void addLetter(int letterIndex){
        letterArr[letterIndex] = word.charAt(letterIndex);
    }

    public char [] getLetterArr() {
        return letterArr;
    }

    public void setLetterArrSize(int length){
        letterArr = new char[length];
        Arrays.fill(letterArr, '_');
    }

    public void setCount(int i) {
        count = i;
    }
}
