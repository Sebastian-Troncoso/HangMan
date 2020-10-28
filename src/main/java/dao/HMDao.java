package dao;


import java.util.List;

public interface HMDao {
    List<String> getAllWords();

    String getWord();

    void addLetterToArray(int i);

    void setLetterArrSize(int length);


    void decreaseCount();

    String createWord();

    int getCount();

    char[] getLetterArray();
}
