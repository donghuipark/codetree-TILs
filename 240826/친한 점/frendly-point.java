import java.util.*;
import java.io.*;
class Pair implements Comparable<Pair>{
    int x, y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair p){
        if(this.x != p.x){
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

        TreeSet<Pair> set = new TreeSet<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            set.add(new Pair(x, y));
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int cx = Integer.parseInt(st.nextToken());
            int cy = Integer.parseInt(st.nextToken());

            if(set.ceiling(new Pair(cx, cy)) != null){
                Pair closePair = set.ceiling(new Pair(cx, cy));
                System.out.println(closePair.x + " " + closePair.y);
            }
            else{
                System.out.println(-1 + " " + -1);
            }

        }
        


    }
}