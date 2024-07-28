import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int n,m;
    private static int[][] ladder;
    //처음 사다리 타기 했을 때 결과값 저장하기 위한 배열.
    private static int[] result;
    private static int ans;
    private static List<int[]> lines = new ArrayList<>();

    // 사다리르 하나씩 지우거나, 유지시키면서 결과가 같은지 확인해보자...

    private static void simulate(int depth, int cnt){
        // 모든 가로줄 유지or삭제 결정이 되었다면?
        if (depth == m) {
            int[] tmp = new int[n+1];
            for(int i=1;i<=n;i++){
                int col = i;
                int row = 15;
                while (row>0) {
                    if (ladder[row][col] !=0) {
                        col += ladder[row][col];
                    }
                    row--;
                }
                tmp[i] = col;
            }

            if (same(tmp)) {
                ans = Math.min(ans, m-cnt);
            }
            return;
        }

        int[] line = lines.get(depth);
        int a = line[0];
        int b = line[1];
        // 지우기
        ladder[b][a] = 0;
        ladder[b][a+1] =0;
        simulate(depth+1, cnt+1);
        // 유지하기
        ladder[b][a] = 1;
        ladder[b][a+1] = -1;
        simulate(depth+1, cnt);
    }

    private static boolean same(int[] tmp){
        for (int i = 1; i <= n; i++) {
            if (tmp[i] != result[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());    

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ladder = new int[16][n+1];
        ans = m;

        int a,b;
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            lines.add(new int[]{a, b});
            ladder[b][a] = 1; // a -> a+1로 가라는 소리야.
            ladder[b][a+1] = -1; // a+1 -> a로 가라는 소리야.
        }

        // 일단 주어진 사다리로 결과 도출하기.
        result = new int[n+1];
        for(int i=1; i<=n; i++){
            int col = i;
            int row = 15;
            //밑에서부터 가는거 있는지 판별하는거.
            while (row>0) {
                if (ladder[row][col] != 0) {
                    col += ladder[row][col];
                }                
                row--;
            }
            result[i] = col;
        }

        simulate(0, 0);
        System.out.println(ans);
    }
}