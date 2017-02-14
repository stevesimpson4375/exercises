package randomguessmatch;

import javax.swing.JOptionPane;

public class RandomGuessMatch {

    public static void main(String[] args) {
        final int MAX = 5;
        int randomNumber = 1 + (int)(Math.random() * MAX);
        boolean correct = false;
        int guess = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a guess between 1 and 5"));
        if(guess == randomNumber) correct = true;
        int difference = 0;
        if(guess > randomNumber) difference = guess - randomNumber;
        else difference = randomNumber - guess;
        JOptionPane.showMessageDialog(null, "Your guess is " + difference + " from the correct number");
        JOptionPane.showMessageDialog(null, "The random number is " + randomNumber+ ". Is correct? " + correct);   
    }
}
