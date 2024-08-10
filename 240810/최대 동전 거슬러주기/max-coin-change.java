import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n,m;
    private static int[] arr;
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[m+1];

        for(int i=0;i<=m;i++){
            dp[i] = Integer.MIN_VALUE;
        }
        dp[0] = 0;
        
        for(int i=1;i<=m;i++){
            for(int j=0;j<n;j++){
                if (i >= arr[j]) {
                    if (dp[i-arr[j]] != Integer.MIN_VALUE) {
                        dp[i] = Math.max(dp[i], dp[i-arr[j]]+1);
                    }
                }
            }
        }
        System.out.println(dp[m] == Integer.MIN_VALUE ? -1 : dp[m]);

    }
}