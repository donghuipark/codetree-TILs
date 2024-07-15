import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    private static int n, m, q, r;
    private static char d;
    private static int[][] map;

    private static void shiftRow(int row, int direction){
        if (direction == 1){//오른쪽으로 밀기
            int tmp = map[row][m-1];
            for(int i=m-1;i>0;i--){
                map[row][i] = map[row][i-1];
            }            
            map[row][0] = tmp;
        }else{ //왼쪽으로 밀기
            int tmp = map[row][0];
            for(int i=0;i<m-1;i++){
                map[row][i] = map[row][i+1];
            }
            map[row][m-1] = tmp;
        }
    }
    private static void Uppropagate(int row, int direction){
        
        if (row == 0) {
            return;
        }
        if (canPropagate(row, row-1)) {
            direction = -direction;
            shiftRow(row-1, direction);
            Uppropagate(row-1, direction);
        }
    
    }
    private static void DownPropagate(int row, int direction){
        if (row == n-1) {
            return;
        }
        if (canPropagate(row, row+1)) {
            direction = -direction;
            shiftRow(row+1, direction);
            DownPropagate(row+1, direction);
        }
    }
    private static boolean canPropagate(int fromRow, int toRow){
        for(int i=0 ; i<m;i++){
            if (map[fromRow][i] == map[toRow][i]) {
                return true;
            }
        }
        return false;
    }

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

        while (q-- >0) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            d = st.nextToken().charAt(0);

            shiftRow(r-1, d == 'L' ? 1 : -1);
            Uppropagate(r-1, d == 'L' ? 1 : -1);
            DownPropagate(r-1, d == 'L' ? 1 : -1);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }
}