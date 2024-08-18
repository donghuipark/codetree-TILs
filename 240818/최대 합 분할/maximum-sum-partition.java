import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int OFFSET = 100000;
    private static final int MAX_N = 100;
    private static int n, m;
    private static int[] arr;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            m += arr[i];
        }

        dp = new int[n + 1][2 * OFFSET + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = -m; j <= m; j++) {
                dp[i][j + OFFSET] = Integer.MIN_VALUE;
            }
        }
        dp[0][OFFSET] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = -m; j <= m; j++) {
                // 그룹 A에 i번째 원소를 추가하는 경우
                if (j - arr[i] >= -m && j - arr[i] <= m && dp[i - 1][j - arr[i] + OFFSET] != Integer.MIN_VALUE) {
                    dp[i][j + OFFSET] = Math.max(dp[i][j + OFFSET], dp[i - 1][j - arr[i] + OFFSET] + arr[i]);
                }

                // 그룹 B에 i번째 원소를 추가하는 경우
                if (j + arr[i] >= -m && j + arr[i] <= m && dp[i - 1][j + arr[i] + OFFSET] != Integer.MIN_VALUE) {
                    dp[i][j + OFFSET] = Math.max(dp[i][j + OFFSET], dp[i - 1][j + arr[i] + OFFSET]);
                }

                // 그룹 C에 i번째 원소를 추가하는 경우
                if (dp[i - 1][j + OFFSET] != Integer.MIN_VALUE) {
                    dp[i][j + OFFSET] = Math.max(dp[i][j + OFFSET], dp[i - 1][j + OFFSET]);
                }
            }
        }

        System.out.println(dp[n][OFFSET]);
    }
}