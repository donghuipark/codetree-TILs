import java.util.Scanner;

public class Main{
    private static String str;
    private static int shift(int amount){
        //옮길거 빼기
        String tmp ="";
        for(int i=str.length()-amount;i<str.length();i++){
            tmp += str.charAt(i);
        }
        //앞에 붙이기..?
        for(int i=0; i<str.length()-amount;i++){
            tmp += str.charAt(i);
        }
        
        int cnt =1;
        char pre = tmp.charAt(0);
        for(int i=1;i<tmp.length();i++){
            char cur = tmp.charAt(i);
            if (pre == cur) {
                continue;
            }else{
                cnt++;
                pre = cur;
            }
            
        }
        if (cnt == 1) {
            return 3;
        }
        return 2*cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.next();
        sc.close();

        int result = Integer.MAX_VALUE;
        for(int i=0;i<str.length();i++){
            result = Math.min(result, shift(i));
        }
        System.out.println(result);
    }
}