import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int n;
    private static int[] arr;
    private static List<Integer> list = new ArrayList<>();
    private static boolean[] visited;

    private static void print(){
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
    
    private static void backtracking(int curIdx){
        if (curIdx == n+1) {
            print();
            return;
        }

        for(int i = n; i>=1; i--){
            if (visited[i]) {
                continue;
            }

            list.add(i);
            visited[i] = true;

            backtracking(curIdx+1);

            visited[i] = false;
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n+1];

        backtracking(1);
    }
}