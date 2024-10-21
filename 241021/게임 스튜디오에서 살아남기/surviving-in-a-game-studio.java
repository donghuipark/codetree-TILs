import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static final long mod = 1000000007;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        // 같은 것을 찾아보자. 글자수, t수 , b수
        long[][][] dp = new long[n+1][3][3];

        dp[1][0][0] = 1;//good
        dp[1][1][0] = 1;//terrible
        dp[1][0][1] = 1;//bad

        for(int i=1;i<n;i++){
            for(int tCnt = 0;tCnt<3;tCnt++){
                for(int bCnt = 0;bCnt<3;bCnt++){
                    if(dp[i][tCnt][bCnt] > 0){
                        //good : t그대로, b =0
                        dp[i+1][tCnt][0] = (dp[i+1][tCnt][0] + dp[i][tCnt][bCnt])%mod;
                        //terrible
                        if(tCnt<2){
                            dp[i+1][tCnt+1][0] = (dp[i+1][tCnt+1][0] + dp[i][tCnt][bCnt])%mod;
                        }
                        if(bCnt<2){
                            dp[i+1][tCnt][bCnt+1] = (dp[i+1][tCnt][bCnt+1] + dp[i][tCnt][bCnt])%mod;
                        }
                    }
                }
            }
        }
        long result = 0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                result = (result + dp[n][i][j]) % mod;
            }
        }
        System.out.println(result);
    }
}