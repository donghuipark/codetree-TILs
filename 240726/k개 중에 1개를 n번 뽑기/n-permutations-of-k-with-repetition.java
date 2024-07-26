import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    private static int k, n;
    private static ArrayList<Integer> ans = new ArrayList<>();

    private static void recur(int curNum){
        if (curNum > n) {
            print();
            return;
        }

        for(int i=1;i<=k;i++){
            ans.add(i);
            recur(curNum+1);
            ans.remove(ans.size()-1);
        }
    }
    private static void print(){
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+ " ");
        }
        System.out.println();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        recur(1);
    }
    
}