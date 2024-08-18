import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[] arr;
    private static boolean[][] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            m += arr[i];
        }


        dp = new boolean[n+1][m+1];
        dp[0][0] = true;

        for(int i=1;i<=n;i++){
            for(int j=0;j<=m;j++){
                if (j>= arr[i] && dp[i-1][j-arr[i]]) {
                    dp[i][j] = true;
                }                
                if(dp[i-1][j]){
                    dp[i][j] = true;
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i=0;i<=m;i++){
            if (dp[n][i]) {
                ans = Math.min(ans, Math.abs(i - (m-i)));
            }

        }
        System.out.println(ans);


    }
}