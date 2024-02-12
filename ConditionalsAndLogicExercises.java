public class ConditionalsAndLogicExercises {
    
    public static void main(String[] args){
        System.out.print(oddSum(5));
    };
    public static boolean IsDivisible(int n, int m){
    return n % m == 0;
    };
    public static boolean isTriangle(int a, int b, int c){
        return !(a+b<=c || a+c<=b || b+c<=a);
    };
    public static int gradeTiming(int min, int sec){
        sec = sec + (min*60);
        if (300 < sec && sec < 420){
            return 15;
        }else if(sec > 270 || sec < 430){
            return 10;
        }else if(sec > 240 || sec < 480){
            return 5;
        }else{
            return 0;
        }
    };
    public static int oddSum(int num){
        if (num==1){
            return 1;
        }
        return oddSum(num-2)+num;
        }
    }
