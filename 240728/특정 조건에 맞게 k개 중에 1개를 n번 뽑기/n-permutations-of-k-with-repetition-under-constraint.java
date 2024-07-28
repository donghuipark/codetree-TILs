import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    private static int k,n;
    private static List<Integer> result = new ArrayList<>();

    private static void print(){
        for(int i=0;i < result.size(); i++){
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
    }
    private static boolean checkThreeMore(){
        int cnt=1;
        for(int i=0;i<result.size()-1;i++){
            if (result.get(i) == result.get(i+1)) {
                cnt++;
                if (cnt > 2) {
                    return false;
                }
            }else{
                cnt=1;
            }
        }
        return true;
    }
    private static void simulate(int depth){
        if(depth == n){
            if (checkThreeMore()) {
                print();                
            }
            return;
        }

        for(int i=1; i<=k; i++){
            result.add(i);
            simulate(depth+1);
            result.remove(result.size()-1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        simulate(0);
    }
}