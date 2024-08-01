import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[][] cost;
    private static boolean[] visited;
    private static List<Integer> list = new ArrayList<>();
    private static int ans;

    private static void backtracking(int curPos){
        //마지막 조건 (다 픽했을때)
        if (curPos == n) {
            int total =0;
            for(int i=0; i<list.size()-1; i++){
                int curCost = cost[list.get(i)][list.get(i+1)];
                if (curCost == 0) {
                    return;
                }
                total += curCost;
            }

            //이제 다시 돌아가는거 봐야한다.
            int lastPos = list.get(list.size()-1);
            int backCost = cost[lastPos][0];
            if (backCost == 0) {
                return;
            }
            ans = Math.min(ans, total + backCost);
            return;
        }
        
        for(int i=1;i<n;i++){
            if (visited[i]) {
                continue;
            }
            //픽하는경우
            list.add(i);
            visited[i] = true;

            backtracking(curPos+1);

            //픽 x
            visited[i] = false;
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        cost = new int[n][n];
        visited = new boolean[n];
        visited[0] = true;
        list.add(0);
        for(int i=0;i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(1);
        System.out.println(ans);
    }
}