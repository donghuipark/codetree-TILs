import java.io.*;
import java.util.*;

public class Main {
    private static int n, k;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        TreeSet<Integer> s = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            s.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=0;i<k;i++){
            System.out.print(s.last() + " ");
            s.remove(s.last());
        }
    }
}