import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[][] grid;
    private static int[][] copy;
    private static int r, c; //폭탄 중심 위치
    //상, 하, 좌, 우
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        grid = new int[n][n];

        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) -1;
        c = Integer.parseInt(st.nextToken()) -1;
        int amount = grid[r][c];
        // 터뜨리기 -> 0으로 만드라는 소리임.
        for(int a = 0; a<amount;a++){
            for(int d =0;d<4;d++){
                int nr = r + dx[d]*a;
                int nc = c + dy[d]*a;
                if (check(nr, nc)){
                    grid[nr][nc] = 0;
                }
            }
        }

        // 내리기 -> n행 있으니깐 하나씩 내리는 작업을 해줘야함.
        copy = new int[n][n];
        for(int i=0; i<n; i++){
            getoff(i);
        }
        
        for(int i=0;i<n; i++){
            for(int j=0;j<n;j++){
                System.out.print(copy[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static boolean check(int r, int c){
        return r >=0 && r<n && c>=0 && c<n;
    }
    private static void getoff(int a){
        int tmp = n-1;
        for(int i=n-1; i>=0 ;i--){
            if(grid[i][a] != 0){
                copy[tmp][a] = grid[i][a];
                tmp--;
            }
        }
    }
}