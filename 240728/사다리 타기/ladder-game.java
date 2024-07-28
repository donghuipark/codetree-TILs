import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    private static int n, m;
    private static int[][] ladder;
    private static List<int[]> lines = new ArrayList<>();
    private static int[] result;
    private static int ans;

    private static void simulate(int depth, int cnt){
        if (depth == m) {
            int[] tmp = res();
            if (same(tmp)) {
                ans = Math.min(ans, m-cnt);
            }
            return;
        }

        int[] pos = lines.get(depth);
        int a = pos[0];
        int b = pos[1];
        //지우기
        ladder[b][a] = 0;
        ladder[b][a+1] = 0;
        simulate(depth+1, cnt+1);
        //유지하기
        ladder[b][a] = 1;
        ladder[b][a+1] = -1;
        simulate(depth+1, cnt);
    }
    
    private static boolean same(int[] tmp){
        for(int i=1;i<=n;i++){
            if (result[i] != tmp[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] res(){
        int[] res = new int[n+1];

        for(int i=1;i<=n;i++){
            int col = i;
            int row = 15;
            while (row > 0) {
                if (ladder[row][col] != 0) {
                    col += ladder[row][col];
                }
                row--;
            }
            res[i] = col;
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ladder = new int[16][n+1];
        result = new int[n+1];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            //a는 가로줄, b는 위치
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lines.add(new int[]{a,b});
            ladder[b][a] = 1;
            ladder[b][a+1] = -1;
        }

        result = res();
        ans = m;
        simulate(0, 0);
        System.out.println(ans);
    }
}