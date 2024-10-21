import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static int[] arr;
    private static long[][] dp;


    public static void main(String[] args)throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new long[n][41];

       
        dp[0][arr[0] + 20]= 1;
        dp[0][-arr[0] + 20] += 1;

        for(int i=1;i<n;i++){
            for(int sum = -20; sum<=20;sum++){
                if(dp[i-1][sum+20] > 0){
                    if(sum + arr[i] <= 20){
                        dp[i][sum+20+arr[i]] += dp[i-1][sum+20];
                    }
                    if(sum - arr[i] >= -20){
                        dp[i][sum+20-arr[i]] += dp[i-1][sum+20];
                    }
                }
            }
        }

        System.out.println(dp[n-1][m+20]);
      




    }
}