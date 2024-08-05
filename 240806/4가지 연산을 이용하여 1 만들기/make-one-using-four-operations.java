import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int n;
    private static final int max_n = 1_000_001; 
    private static Queue<int[]> q = new LinkedList<>();
    private static boolean[] visited = new boolean[max_n];

    private static void bfs() {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int value = cur[0];
            int cnt = cur[1];

            if (value == 1) {
                System.out.println(cnt);
                return;
            }

            if (value - 1 >= 0 && !visited[value - 1]) {
                q.add(new int[]{value - 1, cnt + 1});
                visited[value - 1] = true;
            }

            if (value + 1 < max_n && !visited[value + 1]) {
                q.add(new int[]{value + 1, cnt + 1});
                visited[value + 1] = true;
            }

            if (value % 2 == 0 && !visited[value / 2]) {
                q.add(new int[]{value / 2, cnt + 1});
                visited[value / 2] = true;
            }

            if (value % 3 == 0 && !visited[value / 3]) {
                q.add(new int[]{value / 3, cnt + 1});
                visited[value / 3] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        q.add(new int[]{n, 0});
        visited[n] = true;
        bfs();
    }
}