import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static int cnt = 0;
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        TreeSet<Integer> s = new TreeSet<>();
        for(int i=1;i<=m;i++){
            s.add(i);
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(st.nextToken());
            if(s.floor(num) != null){
                cnt++;
                //System.out.println("s.floor(num) is "+ s.floor(num));
                s.remove(s.floor(num));
            }
            else{
                break;
            }
        }
        System.out.println(cnt);
    }
}