import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static int n;
    private static int[][] grid;
    private static int[] start;
    private static int[] end;
    private static List<int[]> coins = new ArrayList<>();
    private static int coinCnt;
    private static int ans;
    private static List<int[]> coinBox = new ArrayList<>();
    
    private static void backtracking(int curCoinIdx, int cnt){
        // 모든 동전을 고려한 경우
        if (curCoinIdx == coins.size()) {
            if (cnt >= 3) {
                ans = Math.min(ans, move());
            }
            return;            
        }
        
        // 현재 동전을 선택하는 경우
        coinBox.add(new int[]{coins.get(curCoinIdx)[1], coins.get(curCoinIdx)[2]});
        backtracking(curCoinIdx + 1, cnt + 1);
        
        // 현재 동전을 선택하지 않는 경우
        coinBox.remove(coinBox.size() - 1);
        backtracking(curCoinIdx + 1, cnt);
    }
    
    private static int move(){
        int moveCnt = 0;
        int nx = start[0];
        int ny = start[1];
        
        for(int i = 0; i < coinBox.size(); i++){
            moveCnt += Math.abs(coinBox.get(i)[0] - nx) + Math.abs(coinBox.get(i)[1] - ny);
            nx = coinBox.get(i)[0];
            ny = coinBox.get(i)[1];
        }
        
        moveCnt += Math.abs(end[0] - nx) + Math.abs(end[1] - ny);
        return moveCnt;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        start = new int[2];
        end = new int[2];
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < n; j++){
                if (str.charAt(j) == '.') {
                    continue;
                }
                if (str.charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                    continue;
                }
                if (str.charAt(j) == 'E') {
                    end[0] = i;
                    end[1] = j;
                    continue;
                }
                grid[i][j] = (int) str.charAt(j) - '0';
                coins.add(new int[]{grid[i][j], i, j});
            }
        }
        
        coinCnt = coins.size();
        ans = Integer.MAX_VALUE; // `ans`를 가장 큰 값으로 초기화

        if (coinCnt < 3) {
            ans = -1;
        } else {
            Collections.sort(coins, (o1, o2) -> Integer.compare(o1[0], o2[0]));
            backtracking(0, 0);
        }
        
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}