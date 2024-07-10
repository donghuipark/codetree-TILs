import java.util.*;

public class Main {
    public static HashMap<String, Integer> map = new HashMap<>();
    public static int result = 0;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0;i < n; i++){
            String key = sc.next();

            if(!map.containsKey(key)){
                map.put(key, 1);
            }else{
                map.put(key, map.get(key)+1);
            }
            
            if(map.get(key) > result){
                result = map.get(key);
            }
        }

        System.out.println(result);
    }
}