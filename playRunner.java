public class playRunner { 
    public static void main(String[] args){
        playDeck deck = new playDeck();
        deck.shuffel();
        playCard card = deck.drawCard();
        System.out.println(card);
        deck.sort();
        System.out.print(deck);
    }
}
