package pigdicegame;

public class Die {
    int value = 0;
    
    public static Die[] rollDice(){
        
        Die[] dice = new Die[2];
        for(int x = 0; x < dice.length; x++){dice[x] = new Die();}
        return dice;
    }
    
    public static int rollTwoDiceTotal(){
        Die[] rolled = rollDice();
        int rollTotal = 0;
        for (Die d : rolled) {
            rollTotal += d.getValue();
        }
        return rollTotal;
    }
    
    public static int totalARoll(Die[] rolled){
        int rollTotal = 0;
        for (Die d : rolled) {
            rollTotal += d.getValue();
        }
        return rollTotal;
    }
    
    public Die() {
        this.value =  1 + (int)(Math.random() * 6);
    }
    
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    public boolean equals(Die die) {
        if(this.value == die.getValue()) return true;
        return false;
    }
}
