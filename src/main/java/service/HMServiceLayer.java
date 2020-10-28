package service;

import java.util.List;

public interface HMServiceLayer {

    List<String> getAllWordsFromFile();

    boolean checkUserLetter(String s);

    void countNumberOfWrongGuesses();

    int getNumberOfGuesses();

    char [] getLetterArray();

    boolean checkGame();

    boolean getUserGameState();

    String getRandomWord();
}
