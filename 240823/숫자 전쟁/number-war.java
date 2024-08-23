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

        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j + 1];
                if (player1[i] > player2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j + 1] + player2[j]);
                }
                dp[i][j] = Math.max(dp[i][j], dp[i + 1][j]);
            }
        }

        System.out.println(dp[0][0]);

        scanner.close();
    }
}