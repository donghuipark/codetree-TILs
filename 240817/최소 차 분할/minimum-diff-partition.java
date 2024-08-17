import java.util.Scanner;

public class Main {
    public static int minDifference(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        // dp[i][j]는 앞 i개의 숫자를 고려했을 때 j의 합이 가능한지 여부를 저장
        boolean[][] dp = new boolean[n + 1][sum / 2 + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true; // 합이 0인 경우는 항상 가능
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= arr[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        int diff = Integer.MAX_VALUE;

        // 가능한 최대의 sum/2를 찾는다.
        for (int j = sum / 2; j >= 0; j--) {
            if (dp[n][j]) {
                diff = sum - 2 * j;
                break;
            }
        }

        return diff;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(minDifference(arr, n));
    }
}