import java.util.*;

public class Main {

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i=0;i<n;i++){
            String command = sc.next();

            if( command.equals("add")){
                int k = sc.nextInt();
                int v = sc.nextInt();
                hashMap.put(k, v);
            }
            else if( command.equals("remove")){
                int k = sc.nextInt();
                hashMap.remove(k);
            }
            else if (command.equals("find")){
                int k = sc.nextInt();
                if(hashMap.containsKey(k)){
                    System.out.println(hashMap.get(k));
                }
                else{
                    System.out.println("None");
                }
            }
        }
    }
}