import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    private static int n,m,c;
    private static int[][] grid;
    private static int[][] memo;
    private static int[] steal;
    private static int maxValue, ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        memo = new int[n][n];
        steal = new int[m];

        for(int i=0;i<n;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
                memo[i][j] = -1;
            }
        }

        for(int x1=0;x1<n;x1++){
            for(int y1=0;y1<n;y1++){
                for(int x2=0;x2<n; x2++){
                    for(int y2=0;y2<n;y2++){
                        if(possible(x1, y1, x2, y2)){
                            ans = Math.max(ans, findMax(x1, y1) + findMax(x2, y2));
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
    
    private static boolean possible(int x1, int y1, int x2, int y2){
        //격자 안에 있는가?
        if (y1+m-1 >= n || y2+m-1 >= n) {
            return false;
        }
        // 같은 줄에 있는가?
        if (x1 == x2) {
            //그럼 겹치는가?
            if (! (y1+m-1 < y2 ||  y2+m-1 < y1)) {
                return false;
            }
        } 
        return true;
    }

    private static int findMax(int x, int y){
        //이미 memo에 있는가?
        if (memo[x][y] != -1) {
            return memo[x][y];
        }

        //memo에 없으면 새로해야지 한놈이 낼수 있는 최대 점수
        for(int i=y; i <= y+m-1; i++){
            steal[i-y] = grid[x][i];
        }

        maxValue =0;
        findMaxSum(0, 0, 0);

        memo[x][y] = maxValue;
        return maxValue;
    }
    
    private static void findMaxSum(int depth, int curWeight, int curVal){
        if (depth == m) {
            if (curWeight <= c) {
                maxValue = Math.max(maxValue, curVal);
            }
            return;
        }

        //선택노
        findMaxSum(depth+1, curWeight, curVal);
        //선택 ㅇ
        findMaxSum(depth+1, curWeight+ steal[depth], curVal+ steal[depth] * steal[depth]);
    }

}