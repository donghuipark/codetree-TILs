import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    private static int n,m;
    private static int[][] grid;
    private static boolean[][] visited;
    private static int max = Integer.MIN_VALUE;

    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0 ;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<m;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0 ;j<m;j++){
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    dfs(i, j, 1, grid[i][j]);
                    visited[i][j] = false;
                }
            }
        }
        System.out.println(max);
    }

    private static void dfs(int x, int y, int depth, int sum){
        if(depth == 3){
            max = Math.max(max, sum);
            return;
        }
        for(int d = 0; d<4 ;d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(!inRange(nx, ny) || visited[nx][ny]) continue;

            visited[nx][ny] = true;
            dfs(nx, ny, depth + 1, sum+ grid[nx][ny]);
            visited[nx][ny] = false;
        }
    }

    private static boolean inRange(int x, int y){
        return (0 <= x && x < n && 0<=y && y<m);
    }
}