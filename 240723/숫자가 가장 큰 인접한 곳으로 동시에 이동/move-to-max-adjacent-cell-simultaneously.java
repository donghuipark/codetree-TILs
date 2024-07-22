import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Pair{
    int x;
    int y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main{
    private static int n, m, t;
    private static int[][] grid;
    private static int[][] count;
    
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static boolean isRange(int x, int y){
        return x >=0 && x < n && y >=0 && y< n;
    }
    private static void move(){
        int[][] newCount = new int[n][n];

        int nx=0, ny=0;
        
        for(int i=0;i<n;i++){
            for(int j=0; j<n;j++){
                if (count[i][j] == 1) {
                    int max = grid[i][j];
                    for(int d=0;d<4;d++){
                        if (isRange(i + dx[d], j + dy[d])) {
                            if (max < grid[i + dx[d]][j + dy[d]]) {
                                max = grid[i+dx[d]][j+dy[d]];
                            }
                            nx = i + dx[d];
                            ny = j + dy[d];
                        }
                    }
                    newCount[nx][ny] += 1;
                }
            }
        }
        //copy
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                count[i][j] = newCount[i][j];
            }
        }
        //remove
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if (count[i][j] >= 2) {
                    count[i][j] = 0;                    
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        count = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) -1;
            int b = Integer.parseInt(st.nextToken()) -1;

            count[a][b] = 1;
        }

        for(int i=0;i<t;i++){
            move();
        }

        int result = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                result += count[i][j];
            }
        }
        System.out.println(result);
    }
}