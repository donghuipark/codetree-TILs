import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    private static int n, r, c;
    private static int[][] grid;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static boolean isRange(int x, int y){
        return x>=0 && x<n && y>=0 && y<n;
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()) -1;
        c = Integer.parseInt(st.nextToken()) -1;

        grid = new int[n][n];

        for(int i=0;i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.print(grid[r][c] + " ");
        boolean isMoved = true;
        int cur = grid[r][c];
        while (isMoved) {
            isMoved = false;

            for(int d=0; d<4; d++){
                int nx = r + dx[d];
                int ny = c + dy[d];

                if (isRange(nx, ny) && grid[nx][ny] > cur) {
                    System.out.print(grid[nx][ny] + " ");
                    cur = grid[nx][ny];
                    r = nx;
                    c = ny; 
                    isMoved = true;
                    
                    break;
                }
            }
        }
    }
}