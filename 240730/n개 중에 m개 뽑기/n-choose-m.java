import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    private static int n,m;
    private static List<Integer> list = new ArrayList<>();
    private static void print(){
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+ " ");
        }
        System.out.println();
    }
    
    private static void backtracking(int curIdx){
        if (list.size() == m) {
            print();
            return;
        }

        for(int i=curIdx; i<=n; i++){
            list.add(i);
            backtracking(i+1);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
       
        backtracking( 1);

    }
}