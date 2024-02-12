public class thebigint {
    private int[] num;
    private static String numchar = "0123456789";

    public static void main(String[] args){
        thebigint test = new thebigint("800");
        thebigint test2 = new thebigint("9200");
        System.out.print(test.add(test2));
    }


    public thebigint(String num){
        this.num = new int[num.length()];
        for(int i = 0; i<num.length();i++){
            this.num[i] = numchar.indexOf(num.substring(i, i+1));
        }
    }

    public thebigint add(thebigint in){
        String thisnum = "";
        String finnum = "";
        int carry = 0;
        int val;
        for(int i = num.length-1; i>=0; i--){//convert this number to inverted string
            thisnum += num[i];
        }
        String thatnum = "";
        for(int i = in.toString().length()-1; i>=0; i--){//convert that number to inverted string
            thatnum += in.toString().substring(i, i+1);
        }
        for(int i = 0; i<((thisnum.length()<thatnum.length())? thisnum.length():thatnum.length()); i++){//add with value carrying
            val = numchar.indexOf(thisnum.substring(i, i+1)) + numchar.indexOf(thatnum.substring(i, i+1)) + carry;
            carry = val/10;
            val = val%10;
            finnum = val + finnum;
        }
        if(thisnum.length() == thatnum.length()){return new thebigint(((carry>0)?carry + finnum: finnum));}//deal with carry only overflow

        String extras = ((thisnum.length()>thatnum.length())? thisnum.substring(finnum.length()):thatnum.substring(finnum.length()));
        if(carry == 0){ // deal with size only carryover
            for(int i = 0; i<extras.length(); i++){
                finnum = extras.substring(i, i+1) + finnum;
            }
            return new thebigint(finnum);
        }//deal with a both carry and size only carryover
        val = numchar.indexOf(extras.substring(extras.length())) + carry;
        finnum = val + finnum;

        for(int i = extras.length()-2; i>=0; i--){
            finnum = extras.substring(i, i+1) + finnum;
        }
        return new thebigint(finnum);
    }

    public String toString(){
        String out = "";
        for(int i : num){
            out += ""+i;
        }
        return out;
    }
}
