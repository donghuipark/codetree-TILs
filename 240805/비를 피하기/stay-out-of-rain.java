import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, h, m;
    private static int[][] grid;
    private static boolean[][] visited;
    private static int[][] score;
    private static List<int[]> mPos = new ArrayList<>();
    private static Queue<int[]> q = new LinkedList<>();
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static boolean canGo(int x, int y ){
        return inRange(x, y) && !visited[x][y] && grid[x][y] != 1;
    }
    private static boolean inRange(int x, int y){
        return x>=0 && y>=0 && x<n && y<n;
    }
    private static void push(int x, int y, int dis){
        visited[x][y] = true;
        q.add(new int[]{x, y});
        score[x][y] = dis;
    }
    private static void bfs(){
        while (!q.isEmpty()) {
            int[] curPos = q.poll();
            int x = curPos[0];
            int y = curPos[1];

            for(int d=0;d<4;d++){
                int nx = x+ dx[d];
                int ny = y + dy[d];

                if (canGo(nx, ny)) {
                    push(nx, ny, score[x][y] + 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());    

        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        visited = new boolean[n][n];
        score = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 3) {
                    mPos.add(new int[]{i, j});
                }
            }
        }

        for(int i=0;i<mPos.size();i++){
            int[] shelter = mPos.get(i);
            push(shelter[0], shelter[1], 0);
        }
        bfs();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if (grid[i][j] != 2) {
                    System.out.print(0 + " ");
                }
                else{
                    if (!visited[i][j]) {
                        System.out.print(-1 + " ");
                    }
                    else{
                        System.out.println(score[i][j] + " ");
                    }
                }
            }
            System.out.println();
        }
    }
}