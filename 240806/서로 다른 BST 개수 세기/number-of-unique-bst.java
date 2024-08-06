import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int n;
    private static int[] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i=2; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                int left = j - 1;
                int right = i - j;
                dp[i] = dp[i] + (dp[left] * dp[right]);
            }
        }
       System.out.println(dp[n]);
        
        
    }
}