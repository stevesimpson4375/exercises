package fivedice;

public class Die {
    int value = 0;
    
    public Die() {
        this.value =  1 + (int)(Math.random() * 6);
    }
    
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
