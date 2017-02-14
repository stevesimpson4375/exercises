package lottery;

import javax.swing.JOptionPane;

public class Lottery {

    public static void main(String[] args) {
        int[] winningNumbers = new int[3];
        for(int x = 0; x < winningNumbers.length; x++) winningNumbers[x] = (int)(Math.random() * 10);
        
        int[] winForMessage = new int[3];
            for(int x = 0; x < winForMessage.length; x++) winForMessage[x] = winningNumbers[x];
                    
        int[] guesses = new int[3];
        for(int x = 0; x < guesses.length; x++) guesses[x] = Integer.parseInt(
                JOptionPane.showInputDialog(null, "Enter guess " + (x + 1))); 
        
        int correctGuesses = 0;
        
        for(int x = 0; x < guesses.length; x++){
            for(int i = 0; i < winningNumbers.length; i++){
                if(guesses[x] == winningNumbers[i]){
                    correctGuesses++;
                    winningNumbers[i] = 10; // Assigning a number outside the range with prevent matching it again
                    i = winningNumbers.length;
                }
            }
        }
        
        if(guesses[0] == winningNumbers[0] && guesses[1] == winningNumbers[1] && guesses[2] == winningNumbers[2])
            correctGuesses++; // setting this to 4 identifies a jackpot
        
        String message = "Your guess was " + guesses[0] + " " + guesses[1] + " " + guesses[2] + " \n";
        
        switch(correctGuesses) {
            case 0:
                message += "You lost";
                break;
            case 1:
                message += "You matched one and win $10";
                break;
            case 2:
                message += "You matched two and win $100";
                break;
            case 3:
                message += "You matched three and win $1000";
                break;
            case 4:
                message += "You hit the jackpot and win $1,000,000";
                break;
            default: 
                message = "error";
        }
        
        JOptionPane.showMessageDialog(null, message + "\nThe winning numbers are " +
                winForMessage[0] + " " + winForMessage[1] + " " + winForMessage[2]);
    }  
}
