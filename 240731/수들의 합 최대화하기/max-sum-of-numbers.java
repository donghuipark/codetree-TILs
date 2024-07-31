import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[][] grid;
    // 0은 row, 1은 col
    private static boolean[][] visited;
    private static List<Integer> list = new ArrayList<>();
    private static int ans = Integer.MIN_VALUE;

    private static int cal(){
        int sum =0;
        for(int i=0;i<list.size();i++){
            sum += list.get(i);
        }
        return sum;
    }
    private static void backtracking(int curRow){
        if (curRow == n) {
            ans = Math.max(ans, cal());
            return;
        }

        for(int j=0;j<n;j++){
            if (visited[0][j] || visited[1][j]) {
                continue;
            }
            list.add(grid[curRow][j]);
            visited[0][j] = true;
            visited[1][j] = true;

            backtracking(curRow+1);
            visited[0][j] = false;
            visited[1][j] = false;
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n]; 
        visited = new boolean[2][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0);
        System.out.println(ans);
    }
}