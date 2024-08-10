import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[] coins;
    private static int[] dp;
    
    private static void init(){
        for(int i=0;i<=m;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        coins = new int[n];
        dp = new int[m+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            coins[i] = Integer.parseInt(st.nextToken());
        }
        //dp initialization?ㅋㅋ
        init();

        for(int i=1;i<=m;i++){
            for(int j=0;j<n;j++){
                if (i >= coins[j]) {
                    if (dp[i-coins[j]] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }
        System.out.println(dp[m] == Integer.MAX_VALUE ? -1 : dp[m]);
    }
}