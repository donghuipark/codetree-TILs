import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, m, t;
    private static int[] exp;
    private static int[] runtime;
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        exp = new int[n+1];
        runtime = new int[n+1];

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            exp[i] = Integer.parseInt(st.nextToken());
            runtime[i] = Integer.parseInt(st.nextToken());

            t += runtime[i];
        }

        dp = new int[n+1][t+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=t;j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[0][0]=0;

        // dp[i][j] = 값은 i번째까지 고려했을때
        // j겸치 까지 최대 받을 수 있는 것이 들어온다.
        for(int i=1;i<=n;i++){
            for(int j=0;j<=t;j++){
                if (j - runtime[i] >= 0) {
                    dp[i][j] = Math.max(dp[i][j] , dp[i-1][j-runtime[i]]+exp[i]);
                }
                dp[i][j] = Math.max(dp[i][j] , dp[i-1][j]);
            }
        }
        
        //이제 m겸치 이상 중 최소 시간 계산
        int ans = Integer.MAX_VALUE;
        for(int j=0;j<=t;j++){
            if (dp[n][j] >=m) {
                ans = Math.min(ans, j);
            }
        }
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}