import java.io.*;
import java.util.*;

public class Main{
    private static int n, k;
    private static int[] arr;
    private static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n][2];
        dp[0][0] = arr[0];
        if(arr[0] <0){
            dp[0][1] = 1;
        }
        else{
            dp[0][1] = 0;
        }

        for(int i=1;i<n;i++){
            
            if(dp[i-1][0]+arr[i] > arr[i]){
                if(arr[i] <0){
                    dp[i][1] = dp[i-1][1]++;
                }
                else{
                    dp[i][1] = dp[i-1][1];
                }
                dp[i][0] = dp[i-1][0]+arr[i];
            }
            else{
                if(arr[i] < 0){
                    dp[i][1] = 1;
                }
                else{
                    dp[i][1] = 0;
                }
                dp[i][0] = arr[i];
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(dp[i][1] <= k){
                max = Math.max(max, dp[i][0]);
            }
        }
        System.out.println(max);
    }
}