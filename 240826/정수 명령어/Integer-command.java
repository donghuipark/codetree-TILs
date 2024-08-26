import java.util.*;
import java.io.*;

public class Main {
    private static int t, k;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            k = Integer.parseInt(br.readLine());
            TreeSet<Integer> set = new TreeSet<>();
            for(int i=0;i<k;i++){
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();

                if(command.equals("I")){
                    int num = Integer.parseInt(st.nextToken());
                    set.add(num);
                }
                else if(command.equals("D")){
                    if(set.isEmpty()){
                        continue;
                    }
                    else{
                        int num = Integer.parseInt(st.nextToken());
                        if(num == 1){
                            set.remove(set.last());
                        }
                        else if(num == -1){
                            set.remove(set.first());
                        }
                        
                    }
                }
            }
            if(set.isEmpty()){
                System.out.println("EMPTY");
            }
            else{
                System.out.println(set.last() + " " + set.first());
            }
        }
    }
}