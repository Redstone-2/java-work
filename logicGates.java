public class logicGates {
    public static void main(String[] args) {
        boolean x = false;
        boolean y = false;
        boolean z;

        z = !(!x || !y); //and statement
        z = !(!x || y) || !(x || !y); //xor statement


        System.out.println(z);
    }
}
