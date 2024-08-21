import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[] arr;
    private static int[] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        for(int i=1;i<n;i++){
            // dp[i-1]+arr[i]를 할지. 새로 arr[i]부터 시작할지 정해야함.
            if (dp[i-1]+arr[i] > arr[i]) {
                dp[i] = dp[i-1]+arr[i];
            }
            else{
                dp[i] = arr[i];
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
        
    }
}