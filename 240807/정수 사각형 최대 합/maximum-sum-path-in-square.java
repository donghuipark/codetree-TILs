import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[][] grid;
    private static int[][] dp;
    
    private static void init(){
        dp[0][0] = grid[0][0];

        for(int i=1;i<n;i++){
            dp[0][i] = grid[0][i] + dp[0][i-1];
        }
        for(int i=1;i<n;i++){
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        grid = new int[n][n];
        dp = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        init();

        for(int i=1;i<n;i++){
            for(int j=1; j<n;j++){
                dp[i][j] = Math.max(dp[i-1][j] + grid[i][j], dp[i][j-1] + grid[i][j]);
            }
        }

        System.out.println(dp[n-1][n-1]);


    }
}