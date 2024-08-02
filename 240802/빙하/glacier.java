import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[][] grid;
    private static boolean[][] redZone;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        redZone[0][0] = true;

        while (!q.isEmpty()) {
            int[] curPos = q.poll();
            int x = curPos[0];
            int y = curPos[1];

            for(int d=0; d<4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (canGo(nx, ny)) {
                    redZone[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
            
        }
    }
    private static boolean canGo(int x, int y){
        return inRange(x, y) && !redZone[x][y] && grid[x][y] == 0;
    }
    private static boolean inRange(int x, int y){
        return x>=0 && y>=0 && x<n && y<m;
    }
    private static boolean isRed(int x, int y){
         return inRange(x, y) && redZone[x][y] && grid[x][y] == 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());    

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        redZone = new boolean[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int time = 0;
        int meltCnt =0;

        while (true) {
            //1. 일단 (0, 0)부터 시작해서 (dfs),bfs로 조져
            bfs();
            boolean hasIce = false;
            boolean[][] newRedZone = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                System.arraycopy(redZone[i], 0, newRedZone[i], 0, m);
            }

            int meltedIce = 0;
           
            //2. 그럼 redZone다 표시 되었으니깐,
            // ice부분 for문 돌리면서 인근에 redZone인지 판단하기.
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                        hasIce = true;
                        for (int d = 0; d < 4; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];
                            if (isRed(nx, ny)) {
                                grid[i][j] = 0;
                                newRedZone[i][j] = true;
                                meltedIce++;
                                break;
                            }
                        }
                    }
                }
            }

            if (!hasIce) break;

            redZone = newRedZone;
            meltCnt = meltedIce;
            time++;
        }
        System.out.println(time + " " + meltCnt);


    }
}