import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int n;
    private static int[] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[1001];
        
        dp[2] = 1;
        dp[3] = 1;

        for(int i=4; i<=n; i++){
            dp[i] = (dp[i-2]%10007) + (dp[i-3]%10007);
        }

        System.out.println(dp[n]%10007);


    }
}