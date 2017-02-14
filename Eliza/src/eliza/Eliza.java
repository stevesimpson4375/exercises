package eliza;

import javax.swing.JOptionPane;

public class Eliza {

    public static void main(String[] args) {

        /*
            This program is a simple version of the original Eliza program 
            that imitates a Rogerian therapist
        */
        boolean keepTalking = true;
        String question = "Tell me why you are here";
        
        while(keepTalking) {
           String entered =  JOptionPane.showInputDialog(null, question);
           if(entered == null) {keepTalking = false;}
           else {question = whatToSay(entered);}
        } 

    }
    
    public static String whatToSay(String sentence) {
        String whatToSay = "";
        if(sentence.contains("love") || sentence.contains("hate")){
            whatToSay = "You seem to have strong feelings about that.";
        }
        else if(sentence.contains("my")) {
            String subject = findKeyWord("my", sentence);

            whatToSay = "Tell me more about your " + subject + ".";

        }
        else if (sentence.contains("dislike")) {
            String subject = findKeyWord("dislike", sentence);
            
            whatToSay = "Why do you say you dislike " + subject + ".";
            
        } else {
            switch (1 + (int) (Math.random() * 2)) {
                case 1:
                    whatToSay = "Please go on.";
                    break;
                case 2:
                    whatToSay = "Tell me more.";
                    break;
                case 3:
                    whatToSay = "Continue";
                    break;
                default:

            }
        }
        return whatToSay;
    }
    
    public static String findKeyWord(String found, String sentence){
        
            int start = sentence.indexOf(found);
            String subject;
            sentence += " "; // ensures there is a space incase the subject is the final word
            int end = 0;
            for (int x = start + found.length() + 1; x < sentence.length(); x++) {
                if(sentence.charAt(x) == ' ') {end = x; x = sentence.length() + 1;}          
            }
            subject = sentence.substring(start + found.length() + 1, end);

        return subject; 
    }
}
