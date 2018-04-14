import java.util.*;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
        //Write your code here
        int n = a.length, m = b.length;
        int[][] table = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                    if(i == 0 || j == 0){
                        table[i][j]= 0;
                        continue;
                    }
                    if(a[i - 1] == b [j - 1]) {
                        table[i][j] = table[i - 1][j - 1] + 1;
                        continue;
                    }
                    // take max from either of the 3 cases
                    int x = table[i - 1][j],
                        y = table[i][j - 1];
                    table[i][j] = Math.max(x,y);
             }
        }
        return table[n][m];
        //return Math.min(a.length, b.length);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
        scanner.close();
    }
}

