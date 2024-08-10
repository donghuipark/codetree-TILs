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

        //보석 weight, value 알려주기
        n = Integer.parseInt(st.nextToken());
        // 총 무게 == 원하는 무게.
        m = Integer.parseInt(st.nextToken());

        weight = new int[n+1];
        value = new int[n+1];

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        //dp만들기
        dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[0][0] = 0;

        for(int i=1;i<=n;i++){
            //case1. i번째 보석 집어넣기.
            //case2. i번째 보석 안 집어넣기.
            for(int j=0;j<=m;j++){
                if (j>= weight[i]) {
                    dp[i][j] = Math.max(dp[i-1][j-weight[i]]+value[i], dp[i-1][j]);
                } 
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
          int ans = 0;

        for(int j = 0; j <= m; j++)
            ans = Math.max(ans, dp[n][j]);

        System.out.print(ans);

    }
}