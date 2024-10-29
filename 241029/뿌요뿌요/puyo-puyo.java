import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int blockCnt = 0;
    private static int max = 0;
    private static int[][] grid;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static boolean isValid(int x, int y){
        return x>=0 && y>=0 && x<n && y<n;
    }
    private static int dfs(int x, int y){
        visited[x][y] = true;
        int cnt = 1;
        for(int d=0;d<4;d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(isValid(nx, ny) && !visited[nx][ny] && grid[x][y] == grid[nx][ny]){
                cnt += dfs(nx, ny);
            }
        }

        return cnt;
        
    }

    public static void main(String[] args) throws IOException {

        // 여기에 코드를 작성해주세요.
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

        //한칸씩 뒤져서 방문 한 곳 아니라면 dfs
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    int tmp = dfs(i, j);
                    if(tmp >= 4){
                        blockCnt++;
                        max = Math.max(max, tmp);
                    }
                }
            }
        }

        System.out.println(blockCnt + " " + max);




    }
}