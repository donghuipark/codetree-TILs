import java.io.*;
import java.util.*;

public class Main {

    static final int MAX_NUMBER = 1001;
    static final int MOD = 1_000_000_007;
    static int n;
    static long[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        dp = new long[MAX_NUMBER];

        dp[0] = 1;
        dp[1] = 2;

        for(int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 2] * 3) % MOD;
            for(int j = i - 3; j >= 0; j--)
                dp[i] = (dp[i] + dp[j] * 2) % MOD;
        }
        
        sb.append(dp[n]);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}