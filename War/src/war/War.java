package war;

import javax.swing.JOptionPane;

public class War {

    public static void main(String[] args) {
        Card cardOne = new Card();
        Card cardTwo = new Card();
        String message = "";
        
        while(cardOne.equals(cardTwo)) cardTwo = new Card();
        
        if(cardOne.getCardNumber() < cardTwo.getCardNumber())
            message = "Player two wins!";
        else if (cardOne.getCardNumber() > cardTwo.getCardNumber())
            message = "Player one wins!";
        else
            message = "It is a tie!";
        
        message += "\nPlayer one has " + cardOne.toString() +
                    "\n Player two has " + cardTwo.toString();
        
        JOptionPane.showMessageDialog(null, message);
    }
}
