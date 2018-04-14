import java.util.*;

public class FibonacciSumLastDigit {
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
    private static long getFibonacciSumNaive(long n) {
        
        long rem= n%60;
        if (rem <= 1)
            return rem;
        long previous = 0;
        long current  = 1;
        long sum      = 1;
        long tmp_previous = rem;
        for (long i = 0; i < rem-1; ++i) {
           tmp_previous = (previous + current) % 10;
            previous = current;
            current = tmp_previous;
            sum += tmp_previous;
        }

        return sum % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumNaive(n);
        System.out.println(s);
    }
}

