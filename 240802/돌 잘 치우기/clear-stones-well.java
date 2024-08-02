import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int n, k, m;
    private static int[][] grid;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static List<int[]> stones = new ArrayList<>();
    private static List<int[]> startPoints = new ArrayList<>();
    private static int maxReachable = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) {
                    stones.add(new int[]{i, j});
                }
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            startPoints.add(new int[]{x, y});
        }

        // 돌의 조합을 선택하는 백트래킹 함수 호출
        chooseStones(0, new ArrayList<>());
        System.out.println(maxReachable);
    }

    private static void chooseStones(int idx, List<int[]> selected) {
        if (selected.size() == m) {
            // 돌을 선택했으므로, 선택된 돌들을 제거한 새로운 격자를 생성
            int[][] copyGrid = createCopyGrid(selected);
            // BFS를 통해 시작점들로부터 도달할 수 있는 최대 칸 수를 계산
            int reachable = calculateReachableCells(copyGrid);
            // 최대값 갱신
            maxReachable = Math.max(maxReachable, reachable);
            return;
        }

        for (int i = idx; i < stones.size(); i++) {
            selected.add(stones.get(i));
            chooseStones(i + 1, selected);
            selected.remove(selected.size() - 1);
        }
    }

    private static int[][] createCopyGrid(List<int[]> selectedStones) {
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            copy[i] = grid[i].clone();
        }
        for (int[] stone : selectedStones) {
            copy[stone[0]][stone[1]] = 0;
        }
        return copy;
    }

    private static int calculateReachableCells(int[][] grid) {
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;

        for (int[] start : startPoints) {
            queue.add(start);
            visited[start[0]][start[1]] = true;
            count++;
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && grid[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    count++;
                }
            }
        }
        return count;
    }
}