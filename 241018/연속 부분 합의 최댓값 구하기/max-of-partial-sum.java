import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[] arr;
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n];
        dp[0] = arr[0];
        for(int i=1;i<n;i++){
            dp[i] = Math.max(dp[i-1]+arr[i] , arr[i]);
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
        
    }
}