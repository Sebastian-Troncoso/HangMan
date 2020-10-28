package controller;

import dao.HangManPersistenceException;
import service.HMServiceLayer;
import view.HMView;
import java.util.List;

public class HangManController {
    HMServiceLayer service;
    HMView view;

    public HangManController(HMServiceLayer service, HMView view) throws
            HangManPersistenceException {
        this.service = service;
        this.view = view;
    }

    public void run() throws HangManPersistenceException {

        generateRandomWord();
        while (service.checkGame()) {
            // displayAllWords();
            displayNumberOfGuessesLeft();
            if (getUserWord()) {
                displayLetterInSlot();
            } else {
                displayLetterInSlot();
                displayIncorrectLetter();
            }
            //view.guessAgain
        }

        if(service.getUserGameState())
            System.out.println("User wins game!!");
        else
            System.out.println("User lost game!!");

        if(playAgain()){
            run();
        } else {
            System.out.println("Good Bye!");
            System.exit(0);
        }
    }


    private boolean playAgain() {
        return view.askUserIfTheyWantToPlayAgain();
    }

    private void displayNumberOfGuessesLeft() {
        int nGuesses = service.getNumberOfGuesses();
        view.displayNumberOfGuessesLeft(nGuesses);
    }

    private void displayIncorrectLetter() {
        view.displayIncorrectUserGuess();
    }

    private void displayLetterInSlot() {
        char [] arr = service.getLetterArray();
        view.displayGuessInSlot(arr);
    }

    private boolean getUserWord() {
        String s = view.getUserGuess();
        return service.checkUserLetter(s);
    }

    private void generateRandomWord() {
        view.displayWelcomeBanner();
        String s = service.getRandomWord();
        char [] arr = service.getLetterArray();
        view.displayGuessInSlot(arr);
        System.out.println(s);
    }

    private void displayAllWords() {
        List<String> list = service.getAllWordsFromFile();
        for (String w: list){
            System.out.println(w);
        }
    }
}
