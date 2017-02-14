package twodice;

import javax.swing.JOptionPane;

public class TwoDice {

    public static void main(String[] args) {
        Die dieOne = new Die();
        Die dieTwo = new Die();
        
        JOptionPane.showMessageDialog(null, "Die one is " + dieOne.getValue() +
                "\nDie two is " + dieTwo.getValue());
    }   
}
