import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        TreeSet<Integer> set = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=0;i<m;i++){
            int num = Integer.parseInt(br.readLine());
            if(set.ceiling(num) != null){
                System.out.println(set.ceiling(num));
            }
            else{
                System.out.println(-1);
            }
        }

    }
}