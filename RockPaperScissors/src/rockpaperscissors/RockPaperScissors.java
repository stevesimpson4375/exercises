package rockpaperscissors;

import javax.swing.JOptionPane;

public class RockPaperScissors {

    public static void main(String[] args) {
        
        String message = "enter 1, 2, or 3, for Rock, Paper, Scissors";
        
        int playerOne = Integer.parseInt(JOptionPane.showInputDialog(null, "Player one " + message));
        int playerTwo = Integer.parseInt(JOptionPane.showInputDialog(null, "Player two " + message));
        
        String winMessage = "Player one chose " + playerOne + " \n"
                + "Player two chose " + playerTwo + "\nThe winner is ";
        
        if(playerOne == playerTwo) winMessage = "It is a tie!";
        else if(playerOne == 1 && playerTwo == 2) winMessage += "Player Two, Paper covers Rock";
        else if(playerOne == 2 && playerTwo == 3) winMessage += "Player Two, Scissors beat Paper";
        else if(playerOne == 3 && playerTwo == 1) winMessage += "Player Two, Rock beats Scissors";
        else if(playerTwo == 1 && playerOne == 2) winMessage += "Player One, Paper covers Rock";
        else if(playerTwo == 2 && playerOne == 3) winMessage += "Player One, Scissors beat Paper" ;
        else winMessage += "Player One, Rock beats Scissors";
        
        JOptionPane.showMessageDialog(null, winMessage);
    }
}
