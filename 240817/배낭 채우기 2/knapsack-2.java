import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[] weight;
    private static int[] value;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        weight = new int[n+1];
        value = new int[n+1];
        dp = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        // dp init
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<=m;j++){
            dp[0][j] = 0;
        }
        

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if (j >= weight[i]) {
                    dp[i][j] = Math.max(dp[i-1][j] 
                                ,dp[i-1][j-weight[i]]+value[i]);
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-weight[i]]+value[i]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i=0;i<=m;i++){
            ans = Math.max(ans, dp[n][i]);
        }
        System.out.println(ans);



    }
}