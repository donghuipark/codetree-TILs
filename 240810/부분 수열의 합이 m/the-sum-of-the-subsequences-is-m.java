import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n,m; 
    private static int[] arr;
    private static int[] dp;

    private static void initDp(){
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

        arr = new int[n];
        dp = new int[m+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        initDp();
        for(int i=0;i<n;i++){
            for(int j = m; j>=0; j--){
                if (j >= arr[i]) {
                    if (dp[j-arr[i]] != Integer.MAX_VALUE) {
                        dp[j] = Math.min(dp[j], dp[j-arr[i]]+1);
                    }
                }
            }
        }
        System.out.println(dp[m] == Integer.MAX_VALUE ? -1 : dp[m]);
    }
}