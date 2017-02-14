package picktwocards;

import javax.swing.JOptionPane;

public class PickTwoCards {

    public static void main(String[] args) {
        Card cardOne = new Card();
        Card cardTwo = new Card();
        
        JOptionPane.showMessageDialog(null, "Card one is " + cardOne.getCardNumber() +
                " " + cardOne.getSuit() + "\nCard two is " + cardTwo.getCardNumber() +
                " " + cardTwo.getSuit());
    }  
}
