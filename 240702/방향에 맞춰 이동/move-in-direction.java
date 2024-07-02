import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        // 동, 서, 남, 북
        int[] dy = {0, 0, -1, 1};
        int[] dx = {1, -1, 0, 0};
        int nx=0;
        int ny =0;

        for (int i=0;i<n;i++){
            String dir = sc.next();
            int amount = sc.nextInt();

            if(dir.equals("S")){
                nx += dx[2]*amount;
                ny += dy[2]*amount; 
            }
            else if(dir.equals("W")){
                nx += dx[1]*amount;
                ny += dy[1]*amount; 
            }
            
            if(dir.equals("N")){
                nx += dx[3]*amount;
                ny += dy[3]*amount; 
            }
            
            if(dir.equals("E")){
                nx += dx[0]*amount;
                ny += dy[0]*amount; 
            }
        
        }
        System.out.println(nx+" "+ny);
    }
}