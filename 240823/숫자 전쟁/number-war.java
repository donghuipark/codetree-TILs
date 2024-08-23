import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] player1 = new int[n];
        int[] player2 = new int[n];

        for (int i = 0; i < n; i++) {
            player1[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            player2[i] = scanner.nextInt();
        }

        // DP 테이블 초기화
        int[][] dp = new int[n + 1][n + 1];

        // DP로 최대 점수 계산
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // 카드를 버리는 경우
                dp[i][j] = dp[i + 1][j];
                
                // 남우의 카드가 상대의 카드보다 클 경우
                if (player2[j] > player1[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j + 1] + player2[j]);
                }

                // 그 외의 경우
                dp[i][j] = Math.max(dp[i][j], dp[i + 1][j + 1]);
            }
        }

        System.out.println(dp[0][0]);

        scanner.close();
    }
}