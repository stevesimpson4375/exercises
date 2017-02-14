package pigdicegame;

import javax.swing.JOptionPane;

public class PigDiceGame {

    public static void main(String[] args) {
        int highestScore = 0;
        Die[] diceRoll = new Die[2];
        int player1Score = 0;
        int player2Score = 0;
        String continueMessage = ", press OK to roll \n The current score is: \n";
                
        String endMessage = " won with a total of ";
        String lostAllPointsMessage = " lost all points ";
        int playerNumber = 1;
        int currentRoll = 0;
        
        boolean rollAgain = true;
        
        while(highestScore < 100){
            rollAgain = true;
            while(rollAgain){
                JOptionPane.showMessageDialog(null, "Player " + playerNumber + continueMessage
                        + "Player one: " + player1Score
                        + "\nPlayer two: " + player2Score);
                
                diceRoll = Die.rollDice();
                currentRoll = Die.totalARoll(diceRoll);
                
                JOptionPane.showMessageDialog(null, "Player " + playerNumber + " rolled "
                        + diceRoll[0].getValue() + " and " + diceRoll[1].getValue()
                        + " for a total of " + currentRoll);
                
                if (diceRoll[0].getValue() != 1 || diceRoll[1].getValue() != 1 && rollAgain) {
                    if (playerNumber == 1) {
                        player1Score += currentRoll;
                    } else {
                        player2Score += currentRoll;
                    }
                    if(diceRoll[0].getValue() == 1 && diceRoll[1].getValue() != 1 ||
                            diceRoll[0].getValue() != 1 && diceRoll[1].getValue() == 1) rollAgain = false;
                } else {
                    if (diceRoll[0].getValue() == 1 && diceRoll[1].getValue() == 1) {
                        if (playerNumber == 1) {
                            player1Score = 0;
                        } else {
                            player2Score = 0;
                        }
                        JOptionPane.showMessageDialog(null, "Player " + playerNumber + lostAllPointsMessage);
                    }
                    rollAgain = false;
                }
                if(player1Score >= 100 || player2Score >= 100) rollAgain = false;
                if(rollAgain){
                    String askRoll = JOptionPane.showInputDialog(null,
                            "Would Player " + playerNumber + " like to roll again?\n Enter Y for Yes or anything else for no");
                    if(!askRoll.equals("y") && !askRoll.equals("Y")) rollAgain = false;
                }
            }
            if(playerNumber == 1) playerNumber++;
            else playerNumber--;
            
            if(player1Score > player2Score) highestScore = player1Score;
            else highestScore = player2Score;
        }
        if(player1Score > player2Score)
        JOptionPane.showMessageDialog(null, "Player 1 " + endMessage + highestScore);
        else
            JOptionPane.showMessageDialog(null, "Player 2 " + endMessage + highestScore);
    }
}
