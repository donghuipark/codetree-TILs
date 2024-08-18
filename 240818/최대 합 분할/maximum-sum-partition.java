import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            totalSum += arr[i];
        }

        int halfSum = totalSum / 2;
        boolean[][] dp = new boolean[n + 1][halfSum + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            int current = arr[i - 1];
            for (int j = halfSum; j >= current; j--) {
                dp[i][j] = dp[i - 1][j] || dp[i - 1][j - current];
            }
            for (int j = 0; j < current; j++) {
                dp[i][j] = dp[i - 1][j];
            }
        }

        int result = 0;
        for (int j = halfSum; j >= 0; j--) {
            if (dp[n][j]) {
                result = j;
                break;
            }
        }

        System.out.println(result);
    }
}