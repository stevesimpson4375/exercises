package war;

public class Card {
    char suit = ' ';
    int cardNumber = 0;
    
    static final int CARDS_IN_SUIT = 13;
    
    private int returnRandomCardNumber() {return (1 + (int)(Math.random() * 100) % CARDS_IN_SUIT + 1);}
    private char returnRandomSuit() {
        switch(1 + (int)(Math.random() * 4)){
            case 1: return 's';
            case 2: return 'h';
            case 3: return 'd';
            case 4: return 'c';           
        };
        return ' ';
    }
    
    private boolean isCardValueValid(int value) {
        if(value > 0 && value <= CARDS_IN_SUIT) return true;
        return false;
    }
    
    public Card(){this.suit = returnRandomSuit(); this.cardNumber = returnRandomCardNumber();}
    
    public Card(char suit){this.suit = suit; this.cardNumber = returnRandomCardNumber();}
    
    public Card(char suit, int cardNumber){ this.suit = suit; this.cardNumber = cardNumber;}
    
    public char getSuit() {
        return suit;
    }

    public void setSuit(char suit) {
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
        return suit +  " of " +cardNumber; 
    }
}
