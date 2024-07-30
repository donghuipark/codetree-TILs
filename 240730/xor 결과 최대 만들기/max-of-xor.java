import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    private static int n,m;
    private static int[] arr;
    private static List<Integer> list = new ArrayList<>();
    private static int ans;


    private static int xor(){
        int res = list.get(0);
        for(int i=1; i<list.size();i++){
            res ^= list.get(i);
        }
        return res;
    }
    private static void backtracking(int curNumIdx, int choose){
        if (curNumIdx == arr.length) {
            if (choose == m) {
                ans = Math.max(ans, xor());
            }
            return;
        }

        list.add(arr[curNumIdx]);
        backtracking(curNumIdx+1, choose+1);

        list.remove(list.size()-1);
        backtracking(curNumIdx+1, choose);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(0, 0);
        System.out.println(ans);
    }
}