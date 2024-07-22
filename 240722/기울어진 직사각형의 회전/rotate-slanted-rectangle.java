import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    private static int n;
    private static int[][] grid;
    private static int[][] temp;
    //dir =0 (반시계), dir =1(시계)
    private static int r, c, m1, m2, m3, m4, dir;
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        grid = new int[n][n];
        temp = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m1 = Integer.parseInt(st.nextToken());
        m2 = Integer.parseInt(st.nextToken());
        m3 = Integer.parseInt(st.nextToken());
        m4 = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        sovle(r-1, c-1, m1, m2, dir);
        draw(); 
    }
    private static void sovle(int x, int y, int w, int h, int move_dir){
        int[] dxs, dys, move_nums;
        //반시계
        if (dir == 0) {
           dxs = new int[]{-1, -1, 1, 1};
           dys = new int[]{1, -1, -1, 1};
           move_nums = new int[]{w, h, w, h};

        }else{
            dxs = new int[]{-1, -1, 1, 1};
            dys = new int[]{-1, 1, 1, -1};
            move_nums = new int[]{h, w, h, w}; 
        }
        // copy 
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                temp[i][j] = grid[i][j];
            }
        }
        // 경계따라서 shift
        for(int i=0;i < dxs.length; i++){
            int dx = dxs[i];
            int dy = dys[i];
            int move_num = move_nums[i];
            for(int j=0; j<move_num; j++){
                int nx = x + dx;
                int ny = y + dy;
                temp[nx][ny] = grid[x][y];
                x = nx;
                y = ny;
            }
        }
        //옮겨
        for(int i=0;i<n;i++){
            for(int j=0;j<n; j++){
                grid[i][j] = temp[i][j];
            }
        }
    }
    private static void draw(){
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}