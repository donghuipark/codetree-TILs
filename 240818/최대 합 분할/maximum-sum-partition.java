import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(maxEqualSumPartition(arr, n));
    }

    public static int maxEqualSumPartition(int[] arr, int n) {
        int sum = Arrays.stream(arr).sum();
        int halfSum = sum / 2;

        int[][] dp = new int[n + 1][halfSum + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= halfSum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= arr[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - arr[i - 1]] + arr[i - 1]);
                }
            }
        }

        // 최대의 동일한 합을 찾는다.
        for (int j = halfSum; j >= 0; j--) {
            if (dp[n][j] == j) {
                return j;
            }
        }

        return 0;
    }
}