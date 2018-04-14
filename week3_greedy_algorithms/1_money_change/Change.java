import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        //write your code here
        int num10=0,num5=0,num1=0;
        if(m>=10){
        	num10=m/10;
        	m=m%10;
        }
        if(m>=5 && m<10){
        	num5=m/5;
        	m=m%5;
        }
        if(m>=1 && m<5){
        	num1=m;
        }
        m=num10+num5+num1;


        return m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

