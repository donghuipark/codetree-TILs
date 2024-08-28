import java.io.*;
import java.util.*;
class Pair implements Comparable<Pair>{
    int x, y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair p){
        if(p.x != this.x){
            return this.x - p.x;
        }
        else{
            return this.y - p.y;
        }
    }

    
}
public class Main {
    private static int n, m;

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        TreeSet<Pair> s = new TreeSet<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            s.add(new Pair(x, y));
        }

        
        for(int i=0;i<m;i++){
            int k = Integer.parseInt(br.readLine());
            if(s.ceiling(new Pair(k,1)) != null){
                Pair p = s.ceiling(new Pair(k,1));
                System.out.println(p.x + " "+ p.y);
                s.remove(new Pair(p.x, p.y));
            }
            else{
                System.out.println(-1+" "+-1);
            }
        }
    }
}