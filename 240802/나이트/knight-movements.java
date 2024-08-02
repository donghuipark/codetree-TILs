import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, r1, c1, r2, c2;
    private static int[][] grid;
    private static boolean[][] visited;
    private static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    private static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static Queue<int[]> q = new LinkedList<>();

    private static void push(int x, int y, int score){
        visited[x][y] = true;
        q.add(new int[]{x, y});
        grid[x][y] = score;
    }

    private static void bfs(){
        while (!q.isEmpty()) {
            int[] curPos = q.poll();
            int x = curPos[0];
            int y = curPos[1];

            for(int d=0;d<dx.length;d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (canGo(nx, ny)) {
                    push(nx, ny, grid[x][y]+1);
                }
            }
        }
    }
    private static boolean canGo(int x, int y){
        return inRange(x, y) && !visited[x][y];
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

        st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken())-1;
        c1 = Integer.parseInt(st.nextToken())-1;
        r2 = Integer.parseInt(st.nextToken())-1;
        c2 = Integer.parseInt(st.nextToken())-1;

        
        push(r1, c1, 0);
        bfs();

        int ans = -1;
        if (r1 == r2 && c1 == c2) {
            ans = 1;
        }
        else{
            if (grid[r2][c2] != 0) {
                ans = grid[r2][c2];
            }
            else{
                ans = -1;
            }
        }

        System.out.println(ans);
    }
}