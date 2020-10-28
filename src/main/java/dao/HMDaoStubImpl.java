package dao;

import dto.GameWord;
import java.util.ArrayList;
import java.util.List;

public class HMDaoStubImpl implements HMDao {
    GameWord word;
    List<String> list;

    public HMDaoStubImpl() {
        list = new ArrayList<>();
        createWord();
    }

    @Override
    public List<String> getAllWords() {
        return list;
    }

    @Override
    public String getWord() {
        return word.getWord();
    }

    @Override
    public void addLetterToArray(int i) {
        word.addLetter(i);
    }

    @Override
    public void setLetterArrSize(int length) {
        word.setLetterArrSize(length);
    }

    @Override
    public void decreaseCount() {
        word.setCount(word.getCount() -1);
    }

    @Override
    public String createWord() {
        String s = "interview";
        word = new GameWord("interview");
        setLetterArrSize(s.length());
        list.add(word.getWord());
        return word.getWord();
    }

    @Override
    public int getCount() {
        return word.getCount();
    }

    @Override
    public char[] getLetterArray() {
        return word.getLetterArr();
    }
}
