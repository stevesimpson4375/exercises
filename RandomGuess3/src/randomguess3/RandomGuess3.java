package randomguess3;

import javax.swing.JOptionPane;

public class RandomGuess3 {

    public static void main(String[] args) {
        final int MAX = 5;
        int randomNumber = 1 + (int) (Math.random() * MAX);
        int guessCount = 0;
        String guessHint = "";
        boolean correct = false;
        while (!correct) {
            int guess = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a guess between 1 and 5"));
            
            if (guess == randomNumber) {
                correct = true;
                guessHint = "";
            }
            else if (guess > randomNumber) {
                guessHint = " is high";
            } else {
                guessHint = " is low";
            }
            if(guessHint != "")
                JOptionPane.showMessageDialog(null, "Your guess of " + guess + " " + guessHint);
            else JOptionPane.showMessageDialog(null, "You guessed right!");
            guessCount++;
        }
        JOptionPane.showMessageDialog(null, "That took " + guessCount + " guesses");
    }
}
