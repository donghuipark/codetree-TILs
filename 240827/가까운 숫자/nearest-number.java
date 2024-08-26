import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        TreeSet<Integer> set = new TreeSet<>();

        set.add(0);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(st.nextToken());
            int min, max;
            
            min = set.lower(num);
            //System.out.print("min : "+min);
            if(set.higher(num) != null){
                max = set.higher(min);
            }
            else{
                max = Integer.MAX_VALUE;
            }
            //System.out.println("max : "+max);
            set.add(num);
            int tmp = Math.min(num-min, max-num);
            ans = Math.min(ans, tmp);
            System.out.println(ans);
        }
        
    }
}