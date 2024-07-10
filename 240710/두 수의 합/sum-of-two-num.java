import java.util.*;

public class Main {
    public static HashMap<Integer, Integer> m = new HashMap<>();
    public static int result = 0;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        for(int i=0 ; i<n; i++){
            int num = sc.nextInt();
            m.put(num, k-num);
            if(m.containsKey(m.get(num))){
                result++;
            }
        }
        System.out.println(result);
    }
}