import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] arr;
    static int[][] pos;
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        pos = new int[n * n + 1][2];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                pos[arr[i][j]][0] = i;
                pos[arr[i][j]][1] = j;
            }
        }

        while (m-- > 0) {
            simulate();
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void simulate() {
        for (int idx=1; idx<=n*n; idx++) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[0], o1[0]));
            int[] cur = pos[idx];
            int x = cur[0];
            int y = cur[1];

            for (int i=0; i<8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                pq.offer(new int[]{arr[nx][ny], nx, ny});
            }

            int[] toChange = pq.poll();
            int tmp = arr[x][y];
            arr[x][y] = toChange[0];
            arr[toChange[1]][toChange[2]] = tmp;
            pos[idx][0] = toChange[1];
            pos[idx][1] = toChange[2];
            pos[toChange[0]][0] = x;
            pos[toChange[0]][1] = y;
        }   
    }
}