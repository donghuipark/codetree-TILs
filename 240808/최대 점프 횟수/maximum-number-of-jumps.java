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

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        dp = new int[n];
        for(int i=0;i<n;i++){
            dp[i] = Integer.MIN_VALUE;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if (dp[j] == Integer.MIN_VALUE) {
                    continue;
                }
                if (i <= j + arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}