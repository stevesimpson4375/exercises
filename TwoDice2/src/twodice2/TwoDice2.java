package twodice2;

import javax.swing.JOptionPane;

public class TwoDice2 {

    public static void main(String[] args) {
        Die dieOne = new Die();
        Die dieTwo = new Die();
        String message = "Die one is " + dieOne.getValue() + "\nDie two is " + dieTwo.getValue() + "\n";
        while(dieOne.equals(dieTwo)) dieTwo = new Die();
        
        if(dieOne.getValue() > dieTwo.getValue()) message += "Player One wins";
        else if (dieOne.getValue() < dieTwo.getValue()) message += "Player Two wins";
        else message += "It is a tie";
       
        JOptionPane.showMessageDialog(null, message);
    }   
}
