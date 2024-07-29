import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    private static String input;
    private static int[] mapper;
    private static int[] arr = {1, 2, 3, 4};
    private static int max = Integer.MIN_VALUE;

    private static void backtracking(int depth){
        if (depth == 6) {
            cal();
            return;
        }
        for(int i=1; i<=4; i++){
            mapper['a' + depth] = i;
            backtracking(depth+1);
        }
    }
    private static void cal(){
        int res = mapper[input.charAt(0)];
        for(int i=1; i<input.length(); i+=2){
            char op = input.charAt(i);
            int num = mapper[input.charAt(i+1)];

            if (op == '+') {
                res += num;
            }
            if (op == '-') {
                res -= num;
            }
            if (op == '*') {
                res *= num;
            }
        }

        max = Math.max(res, max);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();

        mapper = new int['z'];
        for(char i ='a'; i<'g'; i++){
            mapper[i] = 1;
        }

        backtracking(0);
        System.out.println(max);
    }
}