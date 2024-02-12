public class loops{
    public static void main(String[] Args){
        printTable(1000);
    };
    public static void printRow(int n, int column){
        int i=1;
        while (i<=column){
            System.out.printf("%1000d", n * i);
            i++;
        }
        System.out.println(" ");
    };
    public static void printTable(int rows){
        int i = 1;
        while (i<= rows){
            printRow(i, rows);
            i++;
        }
    }
}