import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    private static int n, m, q;
    private static int[][] map;
    private static int[][] copy;
    private static int r1, c1, r2, c2;
    private static int[] dr = {0, 0, -1, 1};
    private static int[] dc = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            r1 = Integer.parseInt(st.nextToken())-1;
            c1 = Integer.parseInt(st.nextToken())-1;
            r2 = Integer.parseInt(st.nextToken())-1;
            c2 = Integer.parseInt(st.nextToken())-1;    
            
            rotate();
            copy = new int[n][m];
            for (int i = 0; i < n; i++) {
                System.arraycopy(map[i], 0, copy[i], 0, m); // map 배열을 copy 배열로 복사
            }
            for (int r = r1; r <= r2; r++) {
                for (int c = c1; c <= c2; c++) {
                    map[r][c] = average(r, c);
                }
            }
            
        }

        for(int i =0 ;i<n;i++){
            for(int j=0; j<m;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void rotate(){
        int tmp = map[r1][c2];
        for(int i = c2;i>c1;i--){
            map[r1][i] = map[r1][i-1];
        }
        
        for(int i=r1; i<r2;i++){
            map[i][c1] = map[i+1][c1];
        }

        for(int i =c1;i<c2;i++){
            map[r2][i] = map[r2][i+1];
        }
        for(int i=r2;i>r1;i--){
            map[i][c2] = map[i-1][c2];
        }
        map[r1+1][c2] = tmp;
    }

    private static int average(int r, int c){
        int cnt = 1;
        int sum = copy[r][c];
        for(int d=0; d<4;d++){
            int cur_r = r+dr[d];
            int cur_c = c+dc[d];
       //우, 좌, 하, 상
            if (cur_r >=0 && cur_r<n && cur_c >=0 && cur_c < m) {
                cnt++;
                sum += copy[cur_r][cur_c];
            }
       }
       return sum/cnt;

    }
}