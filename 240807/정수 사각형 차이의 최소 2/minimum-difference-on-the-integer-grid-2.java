import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] grid;
    static int[][] dp;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        dp = new int[n][n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int lowerBound=1; lowerBound<=100; lowerBound++) {
            int upperBound = solve(lowerBound);

            if (upperBound == Integer.MAX_VALUE) {
                continue;
            }

            min = Math.min(min, upperBound - lowerBound);
        }

        sb.append(min);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static int solve(int lowerBound) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] < lowerBound) {
                    grid[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        initialize();

        for (int i=1; i<n; i++) {
            for (int j=1; j<n; j++) {
                dp[i][j] = Math.max(Math.min(dp[i-1][j], dp[i][j-1]), grid[i][j]);
            }
        }

        return dp[n-1][n-1];
    }

    private static void initialize() {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = grid[0][0];

        for (int i=1; i<n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], grid[i][0]);
        }

        for (int j=1; j<n; j++) {
            dp[0][j] = Math.max(dp[0][j-1], grid[0][j]);
        }
    }
}