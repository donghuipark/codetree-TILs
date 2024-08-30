import java.util.*;
import java.io.*;

public class Main {
    private static int n;

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
    
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if(command.equals("push")){
                int num = Integer.parseInt(st.nextToken());

                pq.add(-num);
            }
            else if(command.equals("pop")){
                int res = pq.poll();
                System.out.println(-res);
            }
            else if(command.equals("size")){
                System.out.println(pq.size());
            }
            else if(command.equals("empty")){
                if(pq.isEmpty()){
                    System.out.println(1);
                }
                else{
                    System.out.println(0);
                }
            }
            else if(command.equals("top")){
                int res = pq.peek();
                System.out.println(-res);
            }
        }
    }
}