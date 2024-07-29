import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    private static int n,m,c;
    private static int ans, maxValue;
    private static int[][] grid;
    private static int[][] memo;
    private static int[] stolen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        memo = new int[n][n];
        stolen = new int[m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //dp 초기화
        for(int sx = 0; sx<n; sx++){
            for(int sy =0; sy<n; sy++){
                memo[sx][sy] = -1;
            }
        }

        // 1번 도둑 (sx1, sy1) ~ (sx1, sy1+m-1) 까지 훔치기
        // 2번 도둑 (sx2, sy2) ~ (sx2, sy2+m-1) 까지 훔치기
        for(int sx1 =0; sx1<n; sx1++){
            for(int sy1 =0; sy1<n; sy1++){
                for(int sx2 =0; sx2<n; sx2++){
                    for(int sy2=0; sy2<n; sy2++){
                        // 일단 1번, 2번도둑이 제대로 된 곳에서 끝나는지
                        // 그리고 겹치지 않았는지 확인해야한다.
                        if (possible(sx1, sy1, sx2, sy2)) {
                            ans = Math.max(ans, findMax(sx1, sy1) + findMax(sx2, sy2));
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

    private static boolean possible(int x1, int y1, int x2, int y2){
        // y1, y2가 격자밖이면 false
        if (y1+m-1 >= n || y2+m-1 >= n) {
            return false;
        }

        // row가 다르면 true
        if (x1 != x2) {
            return true;
        }
        else{ // 같은 row일땐 겹치지는지 확인해야한다.
            if (!(y1+m-1 < y2 || y1 > y2-m+1)) {
                return false;
            }
        }

        return true;
    }

    // (x, y) ~ (x, y+m-1) 까지 숫자중 적절하게 고른다음.
    // 합이 용량을 넘기않으면 최대값으로 배출
    private static int findMax(int x, int y){
        //memo에 값이 있다면 그거 반환
        if (memo[x][y] != -1) {
            return memo[x][y];
        }

        // y1~y1+m-1까지 훔친거 저장하는해야돼.
        for(int i = y; i<= y + m-1; i++){
            stolen[i-y] = grid[x][i];
        }

        maxValue =0;
        findMaxSum(0, 0, 0);

        memo[x][y] = maxValue;
        return maxValue;
    }
    //시작점으로부터 m까지 선택할지 안할지에 대해서 ..?
    private static void findMaxSum(int depth, int currWeight, int currVal){
        if (depth == m) {
            if(currWeight <= c){
                maxValue = Math.max(maxValue, currVal);
            }
            return;
        }
        
        // currIdx index 에 있는 숫자를 선택하지 않은 경우
        findMaxSum(depth + 1, currWeight, currVal);

        // currIdx index 에 있는 숫자를 선택한 경우
        // 무게는 a[currIdx] 만큼 늘지만
        // 문제 정의에 의해 가치는 a[currIdx] * a[currIdx] 만큼 늘어납니다.
        findMaxSum(depth + 1, currWeight + stolen[depth], 
                   currVal + stolen[depth] * stolen[depth]);
    }
}