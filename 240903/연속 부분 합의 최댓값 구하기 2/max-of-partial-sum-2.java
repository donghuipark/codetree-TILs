import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[] arr;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
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
            dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
        }
        
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}