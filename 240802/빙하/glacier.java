import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[][] grid;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static void bfs(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] curPos = q.poll();
            int x = curPos[0];
            int y = curPos[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (canGo(nx, ny)) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    private static boolean canGo(int x, int y) {
        return inRange(x, y) && !visited[x][y] && grid[x][y] == 0;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        bfs(q);

        int time = 0;
        int lastMeltedIce = 0;

        while (true) {
            boolean hasIce = false;
            Queue<int[]> nextQ = new LinkedList<>();
            int meltedIce = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                        hasIce = true;
                        boolean melt = false;
                        for (int d = 0; d < 4; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];
                            if (isRed(nx, ny)) {
                                melt = true;
                                break;
                            }
                        }
                        if (melt) {
                            grid[i][j] = 0;
                            nextQ.add(new int[]{i, j});
                            meltedIce++;
                        }
                    }
                }
            }

            if (!hasIce) break;

            for (int[] pos : nextQ) {
                visited[pos[0]][pos[1]] = true;
            }

            bfs(nextQ);
            lastMeltedIce = meltedIce;
            time++;
        }

        System.out.println(time + " " + lastMeltedIce);
    }

    private static boolean isRed(int x, int y) {
        return inRange(x, y) && visited[x][y] && grid[x][y] == 0;
    }
}