package rockpaperscissors2;

import javax.swing.JOptionPane;

public class RockPaperScissors2 {

    public static void main(String[] args) {

        String message = "Enter Rock, Paper, or Scissors";
        String playerOne;
        String computer;
        int playerWin = 0;
        int computerWin = 0;
        int tie = 0; 
        int gameCount = 10;
        for (int x = 0; x < gameCount; x++) {
            do {
                String playerOneEntered = JOptionPane.showInputDialog(null, "Player one " + message);
                playerOne = determineEntered(playerOneEntered);
                if (playerOne.equals("error")) {
                    JOptionPane.showMessageDialog(null, "That was not a valid entry");
                }
            } while (playerOne == "error");

            computer = computerChoice();

            String winMessage = "Player one chose " + playerOne + " \n"
                    + "The computer chose " + computer + "\nThe winner is ";

            if (playerOne.equals(computer)) {
                winMessage = "It is a tie!";
                tie++;
            } else if (playerOne.equals("Rock") && computer.equals("Paper")) {
                winMessage += "The computer, Paper covers Rock";
                computerWin++;
            } else if (playerOne.equals("Paper") && computer.equals("Scissors")) {
                winMessage += "The computer, Scissors beat Paper";
                computerWin++;
            } else if (playerOne.equals("Scissors") && computer.equals("Rock")) {
                winMessage += "The computer, Rock beats Scissors";
                computerWin++;
            } else if (computer.equals("Rock") && playerOne.equals("Paper")) {
                winMessage += "Player One, Paper covers Rock";
                playerWin++;
            } else if (computer.equals("Paper") && playerOne.equals("Scissors")) {
                winMessage += "Player One, Scissors beat Paper";
                playerWin++;
            } else {
                winMessage += "Player One, Rock beats Scissors";
                playerWin++;
            }

            JOptionPane.showMessageDialog(null, winMessage);
        }
        
        JOptionPane.showMessageDialog(null, "After 10 games,\nPlayer 1 won " + playerWin
            + "\nThe computer won " + computerWin
            + "\nAlso, there were " + tie + " ties");
    }

    public static String determineEntered(String entered) {
        if (entered.toLowerCase().startsWith("ro")) {
            return "Rock";
        } else if (entered.toLowerCase().startsWith("pa")) {
            return "Paper";
        } else if (entered.toLowerCase().startsWith("sc")) {
            return "Scissors";
        } else {
            return "error";
        }
    }

    public static String computerChoice() {
        int num = 1 + (int) (Math.random() * 3);
        String choice = "";

        switch (num) {
            case 1:
                choice = "Rock";
                break;
            case 2:
                choice = "Paper";
                break;
            case 3:
                choice = "Scissors";
                break;
            default:
                choice = Integer.toString(num);
        }

        return choice;
    }
}
