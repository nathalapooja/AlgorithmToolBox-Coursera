import java.util.*;

public class FibonacciHuge {
    private static long get_pisano_period(long m){
        long a=0,b=1;
        long c=a+b;
        long remM=0;
        for(int i=0;i<m*m;i++){
            c =(a+b)%m;
            a =b;
            b =c;
            if(a==0 && b==1) {
                remM= i+1;
                return remM;
            }
        }
        return remM;
    }
    private static long getFibonacciHugeNaive(long n, long m) {
        long rem=n % get_pisano_period(m);
        long previous=0;
        long current=1;
        long result = rem;
        for(int i=0;i<rem-1;i++){
            result = (previous + current) % m;
            previous = current;
            current = result;
        }
        return result % m;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}

