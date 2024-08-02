import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n,m;
    private static int[][] grid;
    private static int[][] distance;
    private static boolean[][] visited;
    private static Queue<int[]> q = new LinkedList<>();
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static void bfs(int score){
        while (!q.isEmpty()) {
            int[] curV = q.poll();
            int x = curV[0];
            int y = curV[1];

            for(int d=0; d<4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (canGo(nx, ny)) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    distance[nx][ny] = distance[x][y]+1;
                }
            }
        }
    }

    private static boolean canGo(int x, int y){
        return inRange(x, y) && !visited[x][y] && grid[x][y] == 1;
    }
    private static boolean inRange(int x, int y){
        return x>=0 && y>=0 && x<n && y<m;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        visited = new boolean[n][m];
        distance = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        q.add(new int[]{0, 0});
        visited[0][0] = true;
        distance[0][0] = 0;
        bfs(0);
        
        System.out.println(distance[n-1][m-1]);
    }
}