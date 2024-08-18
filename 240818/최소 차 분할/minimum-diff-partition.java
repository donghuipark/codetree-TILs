import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[] number;
    private static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        number = new int[n+1];

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int i=1;i<=n;i++){
            number[i] = Integer.parseInt(st.nextToken());
            sum += number[i];
        }

        dp = new boolean[n+1][sum+1];
        dp[0][0] = true;

        for(int i=1;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if (j >= number[i] && dp[i-1][j-number[i]]) {
                    dp[i][j] = true;            
                }

                if (dp[i-1][j]) {
                    dp[i][j] = true;
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i=1;i<sum;i++){
            if (dp[n][i]) {
                ans = Math.min(ans, Math.abs(i - (sum-i)));
            }
        }
        System.out.println(ans);
       }
}