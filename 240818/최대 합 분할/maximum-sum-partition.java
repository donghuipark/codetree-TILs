import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[] arr;
    private static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        int halfSum = sum / 2;
        dp = new boolean[n + 1][halfSum + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = halfSum; j >= 0; j--) {
                if (j >= arr[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int ans = 0;
        for (int i = halfSum; i >= 0; i--) {
            if (dp[n][i]) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}