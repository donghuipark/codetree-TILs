import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[][] grid;
    private static int result = -1;

    private static boolean isRange(int x, int y, int r, int c) {
        return x >= 0 && x <= r && r < n && y >= 0 && y <= c && c < m;
    }

    private static boolean cal(int x, int y, int r, int c) {
        for (int i = x; i <= r; i++) {
            for (int j = y; j <= c; j++) {
                if (grid[i][j] <= 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void simulate(int x, int y) {
        for (int i = x; i < n; i++) {
            for (int j = y; j < m; j++) {
                if (isRange(x, y, i, j) && cal(x, y, i, j)) {
                    result = Math.max(result, (j - y + 1) * (i - x + 1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                simulate(i, j);
            }
        }
        System.out.println(result);
    }
}