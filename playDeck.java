public class playDeck {
    private playCard[] deck = new playCard[52];

    public playDeck(){
        for(int i = 0; i<deck.length; i++){
            deck[i] = new playCard((i%13)+1,(i/13)+1);
        }
        
    }

    public String toString(){
        String ret="";
        for(int i = 0; i<deck.length; i++){
            ret += deck[i] + ", ";
        }
        return ret;
    }

    public playCard[] cards(){
        return deck;
    }

    public void shuffel(){
        int[] order = new int[deck.length];
        for(int i = 0; i<order.length;i++){
            order[i] = -1;
        }
        int rand;
        int randnum;
        int[] pool = new int[deck.length];
            for(int i = 0; i<pool.length; i++)
                pool[i] = i;
        while(order[deck.length-1] == -1 ){
            randnum = (int)(Math.random()*(pool.length));
            rand = pool[randnum];
            int[] temp = new int[pool.length-1];
            int j = 0;
            for(int i = 0; i<temp.length; i++){
                if(j == randnum){
                    j++; i--; 
                    continue;
                }
                temp[i] = pool[j];
                j++;
            }
            pool = temp;
            for(int i = 0; i< order.length; i++){
                if(order[i]==rand){
                    break;
                }
                if(order[i]==-1){
                    order[i] = rand;
                    break;
                }
            }
        }
        playCard[] fin = new playCard[order.length];
        for(int i = 0; i < order.length; i++){
            fin[i] = deck[order[i]];
        }
        deck = fin;
    }
    
    public void addCard(playCard card){
        playCard[] temp = new playCard[deck.length+1];
        for(int i = 0; i<deck.length;i++){
            temp[i] = deck[i];
        }
        temp[temp.length-1] = card;
        deck = temp;
    }

    public void removeCard(playCard card){
        playCard[] temp = new playCard[deck.length-1];
        for(int i = 0; i < deck.length; i++){
            if(card.equals(deck[i])){
                int j = 0;
                for(int k = 0; k<temp.length; k++){
                    if(j == i){
                        j++; k--; 
                        continue;
                    }
                    temp[k] = deck[j];
                    j++;
                }
            }
        }
        deck = temp;
    }

    public void insertCard(int location,playCard card){
        playCard[] temp = new playCard[deck.length+1];
        int j = 0;
        for(int i = 0; i < temp.length; i++){
            if(i == location){
                temp[i] = card;
                j++;
            }else{
                temp[i] = deck[i-j];
                }
            }
        deck = temp;
    }

    public playCard drawCard(){
        playCard topCard = deck[0];
        removeCard(topCard);
        return topCard;
    }
    
    public void sort(){
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (deck[i].suitVal()>deck[j].suitVal()) {
                    swap(i,j);
                }else if (deck[i].faceVal()>deck[j].faceVal() && deck[i].suitVal() == deck[j].suitVal()){
                    swap(i,j);
                }
            }
        }
    }
    private void swap(int first, int second){
        playCard temp = deck[first];
        deck[first] = deck[second];
        deck[second] = temp;
    }
}
