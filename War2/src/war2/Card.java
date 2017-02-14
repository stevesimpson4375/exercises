package war2;

public class Card {
    String suit = "";
    int cardNumber = 0;
    int value = 0;
    String rank = "";
    
    static final int CARDS_IN_SUIT = 13;
    
    private int returnRandomCardNumber() {return (1 + (int)(Math.random() * 100) % CARDS_IN_SUIT + 1);}
    private String returnRandomSuit() {
        switch(1 + (int)(Math.random() * 4)){
            case 1: return "Spades";
            case 2: return "Hearts";
            case 3: return "Diamonds";
            case 4: return "Clubs";           
        };
        return "";
    }
    
    private boolean isCardValueValid(int value) {
        if(value > 0 && value <= CARDS_IN_SUIT) return true;
        return false;
    }
    
    public Card(){this.suit = returnRandomSuit(); this.cardNumber = returnRandomCardNumber();}
    
    public Card(String suit){this.suit = suit; this.cardNumber = returnRandomCardNumber();}
    
    public Card(String suit, int cardNumber){ this.suit = suit; this.cardNumber = cardNumber;}
    
    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        if(isCardValueValid(cardNumber)) this.cardNumber = cardNumber;
        else this.cardNumber = 1;
    }
    
    public boolean equals(Card card) {
        if(this.cardNumber == card.getCardNumber() && this.suit == card.getSuit())
            return true;
        return false;
    }
    
    public String toString() {
        return cardNumber + " of " + suit; 
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        
        if(value == 1) rank = "Ace";
        else if(value < 1 && value < 11) rank = "\"2\" Through \"10\"";
        else if(value == 11) rank = "Jack";
        else if(value == 12) rank = "Queen";
        else rank = "King";
    }
}
