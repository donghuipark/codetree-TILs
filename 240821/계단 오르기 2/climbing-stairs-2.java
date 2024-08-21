import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[] arr;
    private static int[][] dp; // i번째 계단 고려하고 +1 사용회수를 j라 했을때 동전최대


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n+1][4];
        for(int i=0;i<=n;i++){
            for(int j=0;j<4;j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[0][0] = 0;
        dp[1][1] = arr[1];
        dp[2][0] = arr[2];
        dp[2][2] = arr[1] + arr[2];

        for(int i=3;i<=n;i++){
            for(int j=0;j<4;j++){
                if (j==0) {
                    dp[i][j] = dp[i-2][j] + arr[i];
                    continue;
                }
                if (dp[i-1][j-1] != Integer.MIN_VALUE && dp[i-2][j] != Integer.MIN_VALUE) {
                    
                    if (j<=2) {
                        dp[i][j] = Math.max(dp[i-1][j-1] + arr[i], dp[i-2][j] + arr[i]);
                    }
                    else{
                        dp[i][j] = dp[i-2][j] + arr[i];
                    }
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i=0;i<4;i++){
            ans = Math.max(ans, dp[n][i]);
        }
        System.out.println(ans);
    }
}