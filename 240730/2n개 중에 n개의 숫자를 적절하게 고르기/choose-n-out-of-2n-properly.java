import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    private static int n;
    private static int[] arr;
    private static List<Integer> group1 = new ArrayList<>();
    private static int ans = Integer.MAX_VALUE;

    private static int dif(){
        int part1 =0;
        int part2 =0;
        for(int i=0;i<2*n;i++){
            if (have1(i)) {
                part1 += arr[i];
            }else{
                part2 += arr[i];
            }
        }
        return Math.abs(part2-part1);
    }
    private static boolean have1(int idx){
        for(int i=0;i < group1.size(); i++){
            if (group1.get(i) == idx) {
                return true;
            }
        }
        return false;
    }
    private static void backtracking(int curIdx, int cnt){
        if (curIdx == arr.length) {
            if (cnt == n) {
                ans = Math.min(ans, dif());
            }
            return;
        }
        

        //group1에 들어갈 새끼들 고르기
        group1.add(curIdx);
        backtracking(curIdx+1, cnt+1);

        // 안고르기
        group1.remove(group1.size()-1);
        backtracking(curIdx+1, cnt);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[2*n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<2*n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0, 0);
        System.out.println(ans);
    }
}