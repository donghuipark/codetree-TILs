import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        
        dp[0] = 1;  // 합이 0인 경우 방법은 1가지
        
        for (int i = 1; i <= n; i++) {
            if (i >= 1) dp[i] += dp[i - 1];
            if (i >= 2) dp[i] += dp[i - 2];
            if (i >= 5) dp[i] += dp[i - 5];
            dp[i] %= 10007;  // 나머지를 매번 구함으로써 오버플로우 방지
        }
        
        System.out.println(dp[n]);
    }
}