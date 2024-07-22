import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Pair { 
    int x, y;
    public Pair(int x, int y) { 
        this.x = x; 
        this.y = y; 
    } 
}
public class Main{
    private static int n,m,t;
    private static int[][] arr;
    private static int[][] count;
    private static int[][] nextCount;

    private static boolean inRange(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= n;
    }
    private static void simulate(){
        //움직이기
        moveAll();
        //remove
        remove();
    }
    private static void moveAll(){
        nextCount = new int[n+1][n+1];
        //nextCount init
        for(int i=1; i<=n;i++){
            for(int j=1;j<=n;j++){
               nextCount[i][j] =0;
            }
        }
        //구슬 있으면 move해보기
        for(int i=1; i<=n;i++){
            for(int j=1;j<=n; j++){
                if (count[i][j] == 1) {
                    move(i, j);                    
                }
            }
        }
        //nextCount값을 count에 copy
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                count[i][j] = nextCount[i][j];
            }
        }
    }
    private static void move(int x, int y){
        Pair nextPos = getMaxNeighborPos(x,y);
        int nextX = nextPos.x, nextY = nextPos.y;

        nextCount[nextX][nextY] += 1;
    }
    
    private static Pair getMaxNeighborPos(int curX, int curY){
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0,0,-1,1};

        int maxNum =0;
        Pair maxPos = new Pair(-1, -1);

        for(int i=0;i<4;i++){
            int nextX = curX + dx[i];
            int nextY = curY + dy[i];

            if (inRange(nextX, nextY) && arr[nextX][nextY] > maxNum) {
                maxNum = arr[nextX][nextY];
                maxPos = new Pair(nextX, nextY);
            }
        }
        return maxPos;
    }
    private static void remove(){
        for(int i=1; i<=n;i++){
            for(int j=1; j<=n ;j++){
                if (count[i][j] >= 2) {
                    count[i][j] =0;                    
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

        arr = new int[n+1][n+1];
        count = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1;i<=m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            count[x][y] = 1;
        }

        while (t-- >0) {
            simulate();
        }
        int ans = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                ans += count[i][j];
            }
        }
        System.out.println(ans);
    }
}