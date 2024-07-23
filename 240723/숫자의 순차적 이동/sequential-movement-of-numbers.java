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
    private static int n, m;
    private static int[][] arr;

    private static void simulate(){
        //0. copy만들기
        int[][] copy = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                copy[i][j] = arr[i][j];
            }
        }
        
        for(int i=1;i<=n*n;i++){
            //1. 1부터 n*n까지 찾기
            Pair center = findPair(i);
            //2. center 기준으로 여덟방향 중 가장 큰 pair 찾기
            Pair maxPair = findMaxPair(center);
            //3. 값바꾼거 copy에 저장
            switch_and_save(copy, center, maxPair);
            //4. arr에 다시 옮기기
            for(int a=1; a<=n;a++){
                for(int b=1; b<=n; b++){
                    arr[a][b] = copy[a][b];
                }
            }
        }
        
    }
    private static void switch_and_save(int[][] copy,Pair c, Pair m){
        copy[c.x][c.y] = arr[m.x][m.y];
        copy[m.x][m.y] = arr[c.x][c.y];
    }

    private static Pair findMaxPair(Pair c){
        int[] dxs = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dys = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
        
        int max = arr[c.x][c.y];
        int nx=c.x, ny =c.y;
        for(int d=0;d<8;d++){
            if (isRange(c.x+dxs[d], c.y+dys[d]) && arr[c.x + dxs[d]][c.y + dys[d]] > max) {
                max = arr[c.x + dxs[d]][c.y + dys[d]];
                nx = c.x+dxs[d];
                ny = c.y+dys[d];
            }
        }
        return new Pair(nx, ny);
    }
    private static boolean isRange(int a, int b){
        return a>=1 && a<=n && b>=1 && b<=n;
    }
    private static Pair findPair(int a){
        Pair result = new Pair(a, a);
        for(int i=1; i<=n;i++){
            for(int j=1; j<=n;j++){
                if (arr[i][j] == a) {
                    result = new Pair(i, j);
                }        
            }
        }
        return result;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];
        
        for(int i=1; i<=n ;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<m;i++){
            simulate();
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n ;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}