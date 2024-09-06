import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());

        int ans = 0;
        if(n%2 == 1){
            ans++;
            n -= 2;
        }
        while(n>=5){
            ans++;
            n -= 5;
        }
        while(n>=2){
            ans++;
            n -= 2;
        }
    
        if(n != 0){
            System.out.println(-1);
        }
        else{
            System.out.println(ans);
        }
        
    }
}