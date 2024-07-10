import java.util.*;

public class Main {
    
    public static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i =0; i<n; i++){
            int k = sc.nextInt();
            if(map.containsKey(k)){
                map.put(k, map.get(k)+1);
            }else{
                map.put(k, 1);
            }
        }
        for (int i=0; i<m ;i++){
            int k = sc.nextInt();
            if (map.containsKey(k)){
                System.out.print(map.get(k)+ " ");
            }else{
                System.out.print(0 + " ");
            }
        }
    }
}