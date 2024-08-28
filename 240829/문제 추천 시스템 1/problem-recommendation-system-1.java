import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair>{
    int p, l;

    public Pair(int p, int l){
        this.p = p;
        this.l = l;
    }

    @Override
    public int compareTo(Pair p){
        if(this.l != p.l){
            return this.l - p.l;
        }
        else{
            return this.p - p.p;
        }
    }
}

public class Main{
    private static int n, m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        TreeSet<Pair> s = new TreeSet<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            s.add(new Pair(p, l));
        }

        m = Integer.parseInt(br.readLine());

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("rc")){
                int num = Integer.parseInt(st.nextToken());

                if (num == 1){
                    Pair ans = s.last();
                    System.out.println(ans.p);
                }
                else{
                    Pair ans = s.first();
                    System.out.println(ans.p);
                }
                

            }
            else if(command.equals("ad")){
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());

                s.add(new Pair(p, l));
            }
            else if(command.equals("sv")){
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                
                s.remove(new Pair(p, l));
            }
        }
    } 
}