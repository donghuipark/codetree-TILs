import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[] exp;
    private static int[] time;
    private static List<int[]> pick = new ArrayList<>();
    private static int res = Integer.MAX_VALUE;

    private static void backtracking(int idx, int sum) {
        if (sum >= m) {
            int times = 0;
            for (int[] tmp : pick) {
                times += tmp[1];
            }
            res = Math.min(res, times);
            return;
        }

        for (int i = idx; i < n; i++) {
            // 선택
            pick.add(new int[]{exp[i], time[i]});
            backtracking(i + 1, sum + exp[i]);  // i + 1로 호출하여 중복 선택 방지
            // 선택 취소
            pick.remove(pick.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        exp = new int[n];
        time = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            exp[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0, 0);
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }
}