import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[][] cards;
    private static int ans;
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        cards = new int[2*n][2];

        for(int i=0;i<2*n;i++){
            st = new StringTokenizer(br.readLine());
            cards[i][0] = Integer.parseInt(st.nextToken());
            cards[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[2*n+1][n+1];
        for(int i=0;i<2*n;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        dp[0][0] = 0;

        for(int i=0;i<2*n;i++){
            for(int j=0;j<=Math.min(i, n); j++){
                if (dp[i][j] == Integer.MIN_VALUE) continue;
                //red card pick 
                //red card = j
                if(j<n){
                    dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j]+cards[i][0]);
                }

                //blue card pick
                //blue card = i - j
                if(i-j < n){
                    dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j]+cards[i][1]);
                }
            }
        }
        System.out.println(dp[2*n][n]);
       
    }
}