package view;

public class HMView {
    UserIO io;

    public HMView(UserIO io) {
        this.io = io;
    }


    public void displayWelcomeBanner() {
        io.print("\n=== Welcome to HangMan! ===");
    }

    public String getUserGuess() {
        return io.readString("Please guess a letter");
    }

    public void displayGuessInSlot(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            io.printSymbol(" " + arr[i] + " ");
        }
        io.print("");
    }

    public void displayIncorrectUserGuess() {
        io.print("Incorrect letter!");
    }

    public void displayNumberOfGuessesLeft(int nGuesses) {
        io.print("Number of guesses left " + nGuesses + ".");
    }

    public boolean askUserIfTheyWantToPlayAgain() {
        io.print("");
        String s = io.readString("Would you like to play again? (Y/N)");
        return s.equalsIgnoreCase("Y");
    }
}
