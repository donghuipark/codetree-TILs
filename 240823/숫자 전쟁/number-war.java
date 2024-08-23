import java.io.*;
import java.util.*;

public class Main{

    private static int n;
    private static int[] arr1;
    private static int[] arr2;
    private static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr1 = new int[n+1];
        arr2 = new int[n+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j] == -1) continue;

                if(arr1[i+1] < arr2[j+1]){
                    dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j]);
                }
                if(arr1[i+1] > arr2[j+1]){
                    dp[i][j+1] = Math.max(dp[i][j]+arr2[j+1], dp[i][j+1]);
                }
                
                dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j]);
            }
        }
        
        int ans = 0;
        for(int i=0;i<=n;i++){
            ans = Math.max(ans, dp[i][n]);
            ans = Math.max(ans, dp[n][i]);
        }
        System.out.println(ans);
    }
}