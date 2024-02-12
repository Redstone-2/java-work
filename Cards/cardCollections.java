import java.util.ArrayList;
public class cardCollections {
    ArrayList<Card> cards = new ArrayList<Card>();
    public cardCollections(){
        for(int i = 0; i< Card.SUITS.length; i++){
            for(int j = 1; j<Card.RANKS.length; j++)
                cards.add(new Card(j, i));
        }
    }
    public String toString(){
        return cards.toString();
    }
    private void swap(int first, int second){
        cards.set(first, cards.set(second, cards.get(first)));
    }
    private int randomInt(int low, int high){
        return low + (int)(Math.random() * (high+1-low));
    }
    public void shuffel(){
        for(int i = 0; i<cards.size(); i++){
            swap(i, randomInt(i, cards.size()-1));
        }
    }
    public Card indexLowest(int low, int high){
        Card lowest = cards.get(0);
        for(int i = 1; i<cards.size(); i++){
            if(cards.get(i).compareTo(lowest)<0){
                lowest = cards.get(i);
            }
        }
        return lowest;
    }
    public void sort(){
        int n = cards.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (cards.get(i).compareTo(cards.get(j))>0) {
                    swap(i,j);
                }
            }
        }
    }
    public Card dealCard(){
        return cards.remove(0);
    }
    public void addCard(Card c){
        cards.add(c);
    }
    public Card removeCard(Card c){
        for (int i = 0; i < cards.size(); i++) {
            if(cards.get(i).compareTo(c) == 0){
                return (Card)cards.remove(i);
            }
        }
        return new Card();
    }

    public boolean hasCard(Card c){
        for (int i = 0; i < cards.size(); i++) {
            if(cards.get(i).compareTo(c) == 0){
                return true;
            }
        }
        return false;
    }
}
