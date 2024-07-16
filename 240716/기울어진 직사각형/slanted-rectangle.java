import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    private static int n;
    private static int[][] grid;
    
    //대각선
    private static int[] dr = {-1, -1, 1, 1};
    private static int[] dc = {1, -1, -1, 1};

    private static boolean isRange(int nx, int ny){
        return nx >=0 && nx < n && ny >=0 && ny <n;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        grid = new int[n][n];
        
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                //가능한 최도 넓이의 직사각형 탐색
                for(int w=1;w<n;w++){
                    for(int h=1;h<n;h++){
                        ans = Math.max(ans, getScore(i,j,w,h));
                    }
                }                
            }
        }
        System.out.println(ans);            
    
    }
    public static int getScore(int r, int c, int w, int h ){
        int[] movesize = {w, h, w, h};
        int total = 0;
        for(int k=0;k<4;k++){
            int len = movesize[k];

            for (int l=0;l<len;l++){
                r = r+dr[k];
                c = c+dc[k];
                if (!isRange(r, c)) {
                    return 0;
                }
                total += grid[r][c];
            }
        }
        return total;
    }
}