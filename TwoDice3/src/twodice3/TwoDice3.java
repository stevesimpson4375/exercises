package twodice3;

import javax.swing.JOptionPane;

public class TwoDice3 {

    public static void main(String[] args) {
        Die[] rolled = rollDice();
        int guess = 0;
        int rollTotal = 0;
        String message = "Enter a guess for the dice roll between 2 and 12";
        String winMessage = " ";
        String rollAgainMessage = "";
        int rollCount = 0;
        while(winMessage.equals(" ") && rollCount < 3){
            guess = Integer.parseInt(JOptionPane.showInputDialog(null, message));
            rollTotal = 0;
            for (Die d : rolled) {
                rollTotal += d.getValue();
            }
            if (guess == rollTotal) {
                winMessage = "You geussed right!";
                JOptionPane.showMessageDialog(null, winMessage);
            }
            else {rollAgainMessage = "Your guess of " + guess + " was incorrect\n"
                    + "The roll total was " + rollTotal;
                JOptionPane.showMessageDialog(null, rollAgainMessage);
            }
            rolled = rollDice();
            rollCount++;
        }
        
        if(rollCount == 3) JOptionPane.showMessageDialog(null, "You did not guess in 3 rolls, the computer wins!");
    }
    
    public static Die[] rollDice(){
        
        Die[] dice = new Die[2];
        for(int x = 0; x < dice.length; x++){dice[x] = new Die();}
        return dice;
    }
}
