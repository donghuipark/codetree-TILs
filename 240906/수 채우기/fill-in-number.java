import java.util.*;
import java.io.*;

public class Main{

    private static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int ans = -1;
        for(int i = n/5; i>=0 ; i--){
            int remain = n - (5*i);
            if(remain%2 == 0){
                ans = i + (remain/2);
                break;
            }
        }
        System.out.println(ans);
    }
}