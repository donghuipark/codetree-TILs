import java.util.*;

public class Main {
    public static HashMap<String, Integer> stringToindex = new HashMap<>();
    public static HashMap<Integer, String> indexTostring = new HashMap<>();
    
    public static boolean isNumberic(String str) {
        return str.chars().allMatch(Character::isDigit);
      }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        
        for(int i=1 ; i<n+1 ; i++){
            String word = sc.next();
            stringToindex.put(word, i);
            indexTostring.put(i, word);
        }
        for(int i=0; i<m ;i++){
            String question = sc.next();
            if(isNumberic(question)){
                int q = Integer.parseInt(question);
                System.out.println(indexTostring.get(q));
            }else{
                System.out.println(stringToindex.get(question));
            }
        }
    }
}