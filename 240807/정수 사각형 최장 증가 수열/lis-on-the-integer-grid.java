import java.util.Scanner;

public class Main {
    static int n;
    static int[][] board;
    static int[][] dp;
    static int[] dxs = {-1, 1, 0, 0};
    static int[] dys = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        board = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
                dp[i][j] = -1;  // 초기값으로 -1 설정
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, DFS(i, j));
            }
        }

        System.out.println(ans);
        sc.close();
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    static int DFS(int x, int y) {
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        int best = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dxs[i];
            int ny = y + dys[i];
            if (inRange(nx, ny) && board[nx][ny] > board[x][y]) {
                best = Math.max(best, DFS(nx, ny) + 1);
            }
        }

        dp[x][y] = best;
        return dp[x][y];
    }
}