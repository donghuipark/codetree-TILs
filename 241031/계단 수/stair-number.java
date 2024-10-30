import java.util.*;
import java.io.*;

public class Main {
    private static final int mod = 1000000007;
    private static int n;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n+1][10];
        dp[1][0] = 0;

        for(int i=1;i<10;i++){
            dp[1][i] = 1;
        }

        for(int i=2;i<=n;i++){
            for(int j=0;j<10;j++){
                if(j == 0){
                    dp[i][j] = dp[i-1][1] % mod;
                }
                else if(j == 9){
                    dp[i][j] = dp[i-1][8] % mod;
                }
                else{
                    dp[i][j] = (dp[i-1][j-1]+ dp[i-1][j+1]) % mod;
                }
            }
        }

        int result = 0;
        for(int i=0;i<10;i++){
            result = ( result + dp[n][i]) % mod;
        }
        System.out.println(result);
    }
}