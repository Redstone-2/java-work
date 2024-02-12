public class ArrayAdvRunner {
    public static void main(String[] args){
        String[] t1 = {"hello", "hi"};
        ArrayAdv test = new ArrayAdv(t1);
        test.append("heh");
        test.insert(4, "hehe");
        test.delete(1);
        ArrayAdv t2 = new ArrayAdv(test.subArray(1));
        System.out.println(test);
        System.out.println(t2);
    }
}
