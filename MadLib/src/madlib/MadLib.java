
package madlib;

import javax.swing.JOptionPane;

public class MadLib {

    public static void main(String[] args) {
        String[] entered = new String[5];
        entered[0] = JOptionPane.showInputDialog(null, "Enter a noun");
        entered[1] = JOptionPane.showInputDialog(null, "Enter another noun");
        entered[2] = JOptionPane.showInputDialog(null, "Enter a verb");
        entered[3] = JOptionPane.showInputDialog(null, "Enter another noun");
        entered[4] = JOptionPane.showInputDialog(null, "Enter a past tense verb");
        
        String message = "Mary had a little " + entered[0]
                + "\nIts " + entered[1] + " was " + entered[2] + " as " + entered[3]
                + "\nAnd everywhere that Mary " + entered[4]
                + "\nThe " + entered[0] + " was sure to go.";
        
        JOptionPane.showMessageDialog(null, message);
    }
    
}
