import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[][] grid;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static boolean[][] visited;
    private static int cnt;
    private static List<Integer> People = new ArrayList<>();

    private static void dfs(int x, int y){
        for(int d =0; d<4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if (canGo(nx, ny)) {
                cnt++;
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }
    private static boolean canGo(int x, int y){
        if (inRange(x, y)) {
            if (!visited[x][y] && grid[x][y] == 1) {
                return true;
            }
        }
        return false;
    }
    private static boolean inRange(int x, int y){
        return x>=0 && y>=0 && x<n && y<n;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        visited = new boolean[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if (!canGo(i, j)) {
                    continue;
                }
                cnt =1;
                visited[i][j]= true;
                dfs(i, j);
                People.add(cnt);
            }
        }
        Collections.sort(People);
        System.out.println(People.size());
        for(int i=0;i<People.size();i++){
            System.out.println(People.get(i) + " ");
        }

    }
}