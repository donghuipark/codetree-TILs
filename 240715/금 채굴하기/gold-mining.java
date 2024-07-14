import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    private static int n, m;
    private static int[][] map;

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<=2*(n-1);k++){
                    int gold = checkGold(i, j, k);
                    int cost = calCost(k);
                    
                    if (cost <= m*gold) {
                        ans = Math.max(ans, gold);                        
                    }
                }
            }
        }
        System.out.println(ans);
    }
    public static int calCost(int k){
        return k*k + (k+1)*(k+1);
    }

    public static int checkGold(int x, int y, int k){
        int num =0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(Math.abs(i-x)+Math.abs(j-y) <= k){
                    num += map[i][j];
                }
            }
        }
        return num;
    }
}