package dao;

import dto.GameWord;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HMDaoImpl implements HMDao {

    private static final String WORD_LIST_FILE = "wordlist.txt";
    private List<String> wordList = new ArrayList<>();
    Random r = new Random();
    GameWord word;

    public HMDaoImpl() throws HangManPersistenceException {
        loadFile();
    }

    private void loadFile() throws HangManPersistenceException {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(WORD_LIST_FILE)));
        } catch (FileNotFoundException e) {
            throw new HangManPersistenceException("-___- Could not load roster data into memory.");
        }
        String currentWord;
        while(scanner.hasNextLine()) {
            currentWord = scanner.nextLine();
            wordList.add(currentWord);
        }
        scanner.close();
    }


    public List<String> getAllWords() {
        return wordList;
    }

    @Override
    public String getWord() {
        return word.getWord();
    }

    @Override
    public String createWord() {
        int select = r.nextInt(wordList.size());
        String w = wordList.get(select);
        word = new GameWord(w);
        while(word.getWord().contains("(") || word.getWord().contains(")")){
            getWord();
        }
        setLetterArrSize(word.getWord().length());
        return w;
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
        word.setCount(word.getCount() - 1);
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
