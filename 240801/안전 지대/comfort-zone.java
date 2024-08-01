import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[][] grid;
    private static boolean[][] visited;
    private static int ans = Integer.MIN_VALUE;
    private static int cnt, ans_k =1;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static boolean canGo(int x, int y, int rain){
        if (inRange(x, y)) {
            if (!visited[x][y] && grid[x][y] > rain) {
                return true;
            }
        }
        return false;
    }

    private static boolean inRange(int x, int y ){
        return x>=0 && y>=0 && x<n && y<m;
    }

    private static void dfs(int x, int y, int rain){
        for(int d=0; d<4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (canGo(nx, ny, rain)) {
                visited[nx][ny] = true;
                dfs(nx, ny, rain);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
       
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k =1; k<=100 ;k++){
            cnt = 0;
            visited = new boolean[n][m];

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if (canGo(i, j, k)) {
                        cnt++;
                        visited[i][j] = true;
                        dfs(i,j,k);
                    }
                }
            }
            if (ans < cnt) {
                ans = cnt;
                ans_k = k;
            }
        }

        System.out.print(ans_k + " ");
        System.out.println(ans);


    }
}