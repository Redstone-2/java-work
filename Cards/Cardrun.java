import java.util.ArrayList;
public class Cardrun {
    public static void main(String[] args){
        ArrayList<Card> hand = new ArrayList<Card>();
        //Make Deck
        cardCollections deck = new cardCollections();
        deck.removeCard(new Card(7,0));

        int validTests = 0;

        for(int r = 0; r<1000000; r++){
            deck.shuffel();
            
            //Deal Hand
            for(int i = 0; i<5; i++){
                hand.add(deck.dealCard());
            }

            for(int i = 0; i< hand.size(); i++){
                for(int j = i; j<hand.size(); j++){
                    if(hand.get(i).getRank() > hand.get(j).getRank()){
                    hand.set(i, hand.set(j, hand.get(i)));
                    }
                }
            }
            
            if(isStreightFlush(hand) && !(hasCardRank(11, hand)&&hasCardRank(12, hand)&&hasCardRank(13, hand)&&hasCardRank(1, hand))){
                validTests ++;
                System.out.println(hand.toString());
            }
            
            //Return Hand
            for(int i = hand.size()-1; i >= 0; i--){
                deck.addCard(hand.remove(i));
            }
        }
    System.out.print(validTests/1000000.0);
    }
    private static boolean isStreightFlush(ArrayList<Card> hand){
        int suit = hand.get(0).getSuit();
        for(int i = 1; i<hand.size(); i++){
            if(hand.get(i).getSuit() != suit){
                return false;
            }
            if(hand.get(i).getRank() == hand.get(i-1).getRank()+1){
                continue;
            }
            return false;
        }
        return true;
    }
    private static boolean hasCardRank(int c, ArrayList<Card> hand){
        for (int i = 0; i < hand.size(); i++) {
            if(hand.get(i).getRank() == c){
                return true;
            }
        }
        return false;
    }
}
