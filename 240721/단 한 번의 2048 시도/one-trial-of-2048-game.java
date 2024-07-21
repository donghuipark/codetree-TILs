import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    private static int n = 4;
    private static int[][] grid = new int[n][n];
    private static int[][] newGrid = new int[n][n];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        char dir = br.readLine().charAt(0);
        int[] dirMapper = new int[4];
        dirMapper['D'] = 0;
        dirMapper['R'] = 1;
        dirMapper['U'] = 2;
        dirMapper['L'] = 3;
        
        titlt(dirMapper[dir]);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void initNewGrid(){
        for(int i=0;i<n;i++){
            for(int j=0; j<n; j++){
                newGrid[i][j] = 0;
            }
        }
    }
    private static void titlt(int moveDir){
        // movedir만큼 90도 시계방향 회전을 한다.
        for(int i=0;i<moveDir;i++){
            rotate();
        }
        // 그러면 다 밑으로 drop시키면 된다는 소리.
        drop();
        // 다시 원상태로 돌리면 된다. 총 360도 돌리면 되니깐 4-movedir번 돌려
        for(int i=0; i<4-moveDir ; i++){
            rotate();
        }
    }
    private static void rotate(){
        initNewGrid();

        // 90도 시계방향으로 돌려.
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                newGrid[i][j] = grid[3-j][i];
            }
        }
        // 다시 grid에 옮겨.
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                grid[i][j] = newGrid[i][j];
            }
        }
    }

    private static void drop(){
        for (int j=0;j<n;j++){
             //밑으로 밀기
             int[] tmp1 = new int[4];
             int endOfTmp1 = 3;
             for(int i=3;i>=0;i--){
                 if (grid[i][j] !=0) {
                     tmp1[endOfTmp1--] = grid[i][j];
                 }
             }
             //copy
             for(int i=0;i<4;i++){
                 grid[i][j] = tmp1[i];
             }
             //벽이 밑이다.
             for(int curIdx = 3; curIdx>0; curIdx--){
                 if (grid[curIdx][j] == 0) {
                     continue;
                 }
 
                 if (grid[curIdx][j] == grid[curIdx-1][j]) {
                     grid[curIdx][j] = 2*grid[curIdx][j];
                     grid[curIdx-1][j] = 0;
                 }
             }
 
             //밑으로 밀기
             int[] tmp = new int[4];
             int endOfTmp = 3;
             for(int i=3;i>=0;i--){
                 if (grid[i][j] !=0) {
                     tmp[endOfTmp--] = grid[i][j];
                 }
             }
             //copy
             for(int i=0;i<4;i++){
                 grid[i][j] = tmp[i];
             }
        }

    }
}