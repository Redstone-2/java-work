

public class ArrayExercises{
    public static void main(String[] Args){
        double[] a = {2,3,4,5};
        double[] b = squareArray(a);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]+ ", ");
            }
        System.out.println("");
        b = powArray(a, 3);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]+ ", ");
            }
        System.out.println("");
        int[] c = {1,2,3,2,2,1};
        System.out.println(indexOfMax(c));
        System.out.println(randomWord());
    };
    public static double[] squareArray(double[] a){
        double[] counts = new double[a.length];
        for(int i = 0; i < a.length; i++){
            counts[i]= Math.pow(a[i], 2.0);
        };
        return counts;
    };
    public static double[] powArray(double[] a, int power){
        double[] counts = new double[a.length];
        for(int i = 0; i < a.length; i++){
            counts[i]= Math.pow(a[i], power);
        };
        return counts;
    };
    public static int indexOfMax(int[] in){
        int a = in[0];
        int b = 0;
        for(int i = 1; i<in.length; i++){
            if (in[i]>a){
                a = in[i];
                b = i;
            }
        }
        return b;
    };
    public static String randomWord(){
        String[] a ={"hi","hello","word","another","short","tall","sean","riley","kee","pranav"};
        double temp = Math.random()*(a.length-1.);
        int rand = (int) temp;
        return a[rand];
    }
}