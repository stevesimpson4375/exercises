package fivedice;

import javax.swing.JOptionPane;

public class FiveDice {

    public static void main(String[] args) {
        Die[] computer = new Die[5];
        for(int x = 0; x < computer.length; x++) computer[x] = new Die();
        Die[] player = new Die[5];
        for(int x = 0; x < player.length; x++) player[x] = new Die();
        String computerHas = "";
        String playerHas = "";
        
        for(int x = 0; x < computer.length; x++) computerHas += computer[x].getValue() + " ";
        for(int x = 0; x < computer.length; x++) playerHas += player[x].getValue() + " ";
        
        JOptionPane.showMessageDialog(null, 
                "The computer has " + computerHas +
                "\nThe player has        " + playerHas);
    }  
}
