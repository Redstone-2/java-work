public class playCard{
    private int value = 0;
    private int suit = 0;
    private static final String[] types = {"null","clubs","diamonds","hearts","spades"};
    private static final String[] faces = {"joker","ace","two","three","four","five","six","seven","eight","nine","ten","jack","queen","king"};

    public playCard(){}
    public playCard(int face, int suit){
        value = face;
        this.suit = suit;
    }
    public playCard(int face, String suit){
        value = face;
        for(int i = 0; i<types.length;i++){
            if (suit.equals(types[i]))
                this.suit = i;
        }
    }
    public String toString(){
        return face() + " of " + suit();
    }
    public int faceVal(){
        return value;
    }
    public int suitVal(){
        return suit;
    }
    public String suit(){
        return types[suit];
    }
    public String face(){
        return faces[value];
    }
    public boolean equals(playCard that){
        return toString().equals(that.toString());
    }
    
}
