import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[][] dp = new int[n + 1][k + 1];

        // dp 초기화: 최소값으로 설정
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        dp[0][0] = 0;  // 아무것도 선택하지 않은 경우 초기값 설정

        int maxSum = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                // 음수가 아닌 경우, 현재 값 포함
                if (arr[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j] + arr[i - 1], arr[i - 1]);
                }
                // 음수인 경우, 음수 추가 가능 여부 확인
                if (j > 0 && arr[i - 1] < 0) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + arr[i - 1], arr[i - 1]);
                }
                // 이전 상태 유지
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);

                // 현재 최대값 갱신
                maxSum = Math.max(maxSum, dp[i][j]);
            }
        }

        System.out.println(maxSum);

        scanner.close();
    }
}