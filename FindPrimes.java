import java.math.BigInteger;
import java.util.Arrays;

public class FindPrimes {
    
    public static void main(String[] args){
        BigInteger a = new BigInteger("52643");
        System.out.print(Arrays.toString(findThePrimes(a)));
    }

    public static BigInteger[] findThePrimes(BigInteger compIn){
        for(BigInteger i = compIn.sqrt(); i.compareTo(BigInteger.ONE) != -1; i = i.subtract(BigInteger.ONE)){
            if(compIn.mod(i) == BigInteger.ZERO){
                BigInteger[] ret = new BigInteger[2];
                ret[0] = i;
                ret[1] = compIn.divide(i);
                return ret;
            }
        }
    return new BigInteger[1];
    }

}
