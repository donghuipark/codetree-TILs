import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[][] grid;
    private static boolean[][] visited;
    private static int ans = 0;
    private static int[] dx = {1, 0};
    private static int[] dy = {0, 1};
    private static void dfs(int x, int y){
        
        for(int d=0; d<2; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (canGo(nx, ny)) {
                visited[nx][ny] = true;
                dfs(nx, ny);    
            }
        }
    }
    private static boolean canGo(int x, int y){
        if (inRange(x, y)) {
            if (grid[x][y] == 1 && !visited[x][y]) {
                return true;
            }
        }
        
        return false;
    }
    private static boolean inRange(int x, int y){
        return x >= 0 && x<n && y >=0 && y<m;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                grid[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        visited[0][0] =true;        
        
        dfs(0, 0);
        
        if (visited[n-1][m-1]) {
            ans=1;
        }
        System.out.println(ans);
            
        

    }
}