import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[] dp;
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        dp = new int[n+1];

        for(int i=0;i<=n;i++){
            dp[i] = -1;
        }
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = -1;
        dp[4] = 2;
        dp[5] = 1;

        for(int i=6;i<=n;i++){
            if(dp[i-2] == -1){
                if(dp[i-5] != -1){
                    dp[i] = dp[i-5] + 1;
                }
            }
            else{
                if(dp[i-5] != -1){
                    dp[i] = Math.min(dp[i-2] +1, dp[i-5]+1);
                }
                else{
                    dp[i] = dp[i-2]+1;
                }
            }
        }

        System.out.println(dp[n]);

        
    }
}