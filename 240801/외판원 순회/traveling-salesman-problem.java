import java.util.Scanner;

public class Main {
    private static final int INF = 1000000000;
    private static int n;
    private static int[][] cost;
    private static int[][] dp;
    private static int VISITED_ALL;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = scanner.nextInt();
            }
        }

        dp = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (1 << n); j++) {
                dp[i][j] = -1;
            }
        }

        VISITED_ALL = (1 << n) - 1;
        int result = tsp(0, 1);  // 시작 지점은 0번 지점, 1 << 0 = 1 (0번 지점만 방문한 상태)
        System.out.println(result);
    }

    private static int tsp(int currentPosition, int visited) {
        if (visited == VISITED_ALL) {
            return cost[currentPosition][0] != 0 ? cost[currentPosition][0] : INF;
        }

        if (dp[currentPosition][visited] != -1) {
            return dp[currentPosition][visited];
        }

        int minCost = INF;
        for (int next = 0; next < n; next++) {
            if ((visited & (1 << next)) == 0 && cost[currentPosition][next] != 0) {
                int newVisited = visited | (1 << next);
                int currentCost = cost[currentPosition][next] + tsp(next, newVisited);
                minCost = Math.min(minCost, currentCost);
            }
        }

        dp[currentPosition][visited] = minCost;
        return minCost;
    }
}