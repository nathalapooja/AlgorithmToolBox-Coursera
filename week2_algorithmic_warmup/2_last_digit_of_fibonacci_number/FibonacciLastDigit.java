import java.util.*;
import java.math.*;
public class FibonacciLastDigit {
    private static BigInteger getFibonacciLastDigitNaive(int n) {
        if (n <= 1){
             BigInteger nbig=new  BigInteger(Integer.toString(n));
             return nbig;
        }
        BigInteger previous = new BigInteger("0");
        BigInteger current  = new BigInteger("1");
        BigInteger ten  = new BigInteger("10");
        for (int i = 0; i < n - 1; ++i) {
            BigInteger tmp_previous = current;
            current = (current.add(previous)).mod(ten);
            previous = tmp_previous.mod(ten);
        }

        // String temp= Long.toString(current);
        // String charAtLastPosition = temp.charAt(temp.length()-1)+"";
        // return Integer.parseInt(charAtLastPosition);
        
        return current;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
       // System.out.println(n);
        BigInteger c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}

