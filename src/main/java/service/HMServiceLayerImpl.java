package service;

import dao.HMDao;
import dao.HangManPersistenceException;
import java.util.List;


public class HMServiceLayerImpl implements HMServiceLayer {

    HMDao dao;
    private boolean userWin = false;

    public HMServiceLayerImpl(HMDao dao) throws HangManPersistenceException {
        this.dao = dao;
    }

    public List<String> getAllWordsFromFile() {
        return dao.getAllWords();
    }

    public boolean checkUserLetter(String letter) {
        if (letter.length() > 1) {
            return false;
        } else if ((letter.charAt(0) >= 'A' && letter.charAt(0) <='Z') ||
                (letter.charAt(0) >= 'a' && letter.charAt(0) <= 'z')) {
            if (dao.getWord().contains(letter)) {
                for (int i = 0; i < dao.getLetterArray().length; i++) {
                    if (letter.charAt(0) == dao.getWord().charAt(i)) {
                        dao.addLetterToArray(i);
                    }
                }
                return true;
            }else {
                countNumberOfWrongGuesses();
                return false;
            }
        }  else {
            return false;
        }
    }

    public String getRandomWord() {
        return dao.createWord();
    }

    public void countNumberOfWrongGuesses() {
        dao.decreaseCount();
    }

    public int getNumberOfGuesses() {
        return dao.getCount();
    }

    public char[] getLetterArray() {
        return dao.getLetterArray();
    }

    @Override
    public boolean checkGame() {
        String userWord = convertToString(dao.getLetterArray());
        if (userWord.equals(dao.getWord())) {
            userWin = true;
            return false;
        } else if (dao.getCount() == 0) {
            userWin = false;
            return false;
        }
        return true;
    }

    private String convertToString(char[] letterArr) {
        StringBuilder s = new StringBuilder();
        for (Character c : letterArr)
            s.append(c);
        return s.toString();
    }

    @Override
    public boolean getUserGameState() {
        return userWin;
    }


}
