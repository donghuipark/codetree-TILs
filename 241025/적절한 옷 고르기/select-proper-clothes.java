import java.util.*;
import java.io.*;

public class Main {
    private static int n,m;
    private static int[] s;
    private static int[] e;
    private static int[] v;

    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 옷 수
        m = Integer.parseInt(st.nextToken()); // 일 수

        s = new int[n];
        e = new int[n];
        v = new int[n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            s[i] = Integer.parseInt(st.nextToken());
            e[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[m+1][n];
        //init
        for(int i=1;i<=m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        //처음 initi
        for(int i=0;i<n;i++){
            if(s[i] == 1){
                dp[1][i] = 0;
            }
        }

        for(int i=2;i<=m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(s[k] <= i-1 && i-1 <= e[k] && s[j] <= i && i<= e[j]){
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + Math.abs(v[j] - v[k]));
                    }
                }
            }
        }

        int result = 0;
        for(int i=0;i<n;i++){
            result = Math.max(result , dp[m][i]);
        }
        System.out.println(result);





    }
}