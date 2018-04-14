import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        // long sum = 0;

        // long current = 0;
        // long next  = 1;

        // for (long i = 0; i <= to; ++i) {
        //     if (i >= from) {
        //         sum += current;
        //     }

        //     long new_current = next;
        //     next = next + current;
        //     current = new_current;
        // }

        // return sum % 10;

        long rem1= from%60;
        long rem2= to%60;
        if (rem1==rem2 && rem1 <= 1)
            return rem1;
        long tmp_previous = rem1;
        long previous = 0;
        long current  = 1;
        long sum1    = 1;
        long sum2 =1;   
        if(rem1==rem2){
            for (long i = 0; i < rem1-1; ++i) {
           tmp_previous = (previous + current) % 10;
            previous = current;
            current = tmp_previous;
        }
        return tmp_previous % 10;
        }
        
        
        for (long i = 0; i < rem1-2; ++i) {
           tmp_previous = (previous + current) % 10;
            previous = current;
            current = tmp_previous;
            sum1 += tmp_previous;
        }
        for (long i = 0; i < rem2-1; ++i) {
           tmp_previous = (previous + current) % 10;
            previous = current;
            current = tmp_previous;
            sum2 += tmp_previous;
        }

        return (sum2-sum1) % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumNaive(from, to));
    }
}

