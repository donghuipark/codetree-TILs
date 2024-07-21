import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    private static int n, m;
    private static int[][] grid;
    // 상, 하, 좌, 우
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int find(int c){
        for(int i=0;i<n;i++){
            if (grid[i][c] != 0) {
                return i;
            }
        }
        return -1;
    }

    private static void explode(int r, int c){
        int amount = grid[r][c];

        for(int i=0; i<amount; i++){
            for(int d=0;d<4;d++){
                int nr = r + i*dr[d];
                int nc = c + i*dc[d];
                if(isRange(nr, nc)){
                    grid[nr][nc] = 0;
                }
                
            }
        }
    }
    private static boolean isRange(int r, int c){
        return r >=0 && r<n && c>=0 && c<n;
    }
    private static void drop(){
        //열마다 봐야할듯
        for(int j=0; j<n;j++){
            //열에 들어왔음.
            // 열에서 순회하면서 tmp에 옮길차례
            int[] tmp = new int[n];
            int endOfTmp = n-1;
            for(int i=n-1; i>=0; i--){
                if (grid[i][j] != 0) {
                    tmp[endOfTmp--] = grid[i][j];
                }
            }
            //copy
            for(int i=0;i<n;i++){
                grid[i][j] = tmp[i];
            }
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0 ;j<n; j++){
                grid[i][j] =Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<m; i++){
            int column = Integer.parseInt(br.readLine()) -1;

            // 1. 그 열에서 가장 위에 있는 새끼 찾기
            int row = find(column);
            if (row == -1) {
                continue;
            }
            // 2. 그 새끼 터지고 0 채우기
            explode(row, column);
            // 3. 밑으로 떨구기
            drop();
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

    }
}