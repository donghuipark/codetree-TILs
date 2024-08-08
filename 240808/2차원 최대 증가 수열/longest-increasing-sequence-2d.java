import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[][] grid;
    private static int[][] dp;
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        dp = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int x1=0; x1<n; x1++){
            for(int y1=0; y1<m; y1++){
                dp[x1][y1] = 1;

                for(int x2=0; x2<x1; x2++){
                    for(int y2=0; y2<y1; y2++){
                        if (grid[x1][y1] > grid[x2][y2] &&
                        grid[x1][y1] > grid[0][0]) {
                            dp[x1][y1] = Math.max(dp[x1][y1], dp[x2][y2]+1);
                        }
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max);

     }
}