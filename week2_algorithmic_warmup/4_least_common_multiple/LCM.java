import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
      int gcd=gcd_naive(a, b);
      b=b/gcd;
      return (long) a * b ;
  }
  private static int gcd_naive(int a, int b) {
    //int current_gcd = 1;
    if(b>a){
        int temp=b;
        b=a;
        a=temp;
    }
    if(b==0){
        return a;
    }
    return gcd_naive(a%b,b);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_naive(a, b));
  }
}