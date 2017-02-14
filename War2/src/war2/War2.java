package war2;

import javax.swing.JOptionPane;

public class War2 {

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
        
        message += "\nPlayer one has a " + cardOne.toString() +
                    "\nPlayer two has a " + cardTwo.toString();
        
        JOptionPane.showMessageDialog(null, message);
    }
}
