import java.math.BigInteger;
public class exponentian_mod {
    public static void main(String[] args){
        // a^b mod c
        BigInteger a = new BigInteger("2038098497");
        BigInteger b = new BigInteger("-1");
        BigInteger c = new BigInteger("3370736872568417873");
        System.out.println("1: "+exp_mod(a,b,c));

        

        String inphrase = "Carthago delenda est";
        System.out.println("6: "+ASCII_to_10(inphrase));

        System.out.println(new BigInteger("9293").modInverse(new BigInteger("22576")));

        //n-moudlus, e-encryption exponent, c-cyphertext, p-plaintext, Private: n = p * q, d=e^-1(mod phi(n))-decryption exponent
        //c^d = p^e^d = p^ed = p^1 = p(mod n)

    }

    public static BigInteger ASCII_to_10(String in){
        BigInteger out = new BigInteger(Integer.toString(((int) in.charAt(0))));
        for(int i = 1; i<in.length(); i++){
            out = out.add(new BigInteger(Integer.toString(((int) in.charAt(i)))).pow(i-1));
        }
        return out;
    }

    //public static String 10_to_ASCII(BigInteger in){

    //}

    public static BigInteger exp_mod(BigInteger a, BigInteger b, BigInteger c){
        BigInteger res = BigInteger.ONE;
        if(b.compareTo(BigInteger.ZERO) == -1){
            b = b.divide(new BigInteger("-1"));
            a = a.modInverse(c);
        }
        BigInteger x = a.mod(c);
        while(b.compareTo(BigInteger.ZERO) == 1){
            if(b.mod(new BigInteger("2")).equals(BigInteger.ONE)){
                res = res.multiply(x).mod(c);
            }
            x = x.multiply(x).mod(c);
            b = b.divide(new BigInteger("2"));
        }
    return res;
    }
}