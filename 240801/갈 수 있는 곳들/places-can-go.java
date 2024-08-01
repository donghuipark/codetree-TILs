import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, k;
    private static int[][] grid;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static Queue<int[]> q = new LinkedList<>();
    private static int ans = 0;

    private static void bfs(){
        while (!q.isEmpty()) {
            int[] curPos = q.poll();
            int x = curPos[0];
            int y = curPos[1];

            for(int d=0; d<4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (canGo(nx, ny)) {
                    ans++;
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
    private static boolean canGo(int x, int y){
        if (isRange(x, y)) {
            if (!visited[x][y] && grid[x][y] == 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean isRange(int x, int y){
        return x>=0 && y>=0 && x<n && y<n;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;

            q.add(new int[]{x, y});
            visited[x][y] = true;
            ans++;
        }
        bfs();
        System.out.println(ans);


    }
}