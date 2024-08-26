import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        TreeSet<Integer> treeSet = new TreeSet<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("add")){
                int num = Integer.parseInt(st.nextToken());
                treeSet.add(num);
            }
            else if(command.equals("remove")){
                int num = Integer.parseInt(st.nextToken());
                treeSet.remove(num);
            }
            else if(command.equals("find")){
                int num = Integer.parseInt(st.nextToken());
                if(treeSet.contains(num)){
                    System.out.println("true");
                }
                else{
                    System.out.println("false");
                }
            }
            else if(command.equals("lower_bound")){
                int num = Integer.parseInt(st.nextToken());
                
                if(treeSet.ceiling(num) != null){
                    System.out.println(treeSet.ceiling(num));
                }
                else{
                    System.out.println("None");
                }
            }
            else if(command.equals("upper_bound")){
                int num = Integer.parseInt(st.nextToken());
                if(treeSet.higher(num) != null){
                    System.out.println(treeSet.higher(num));
                }
                else{
                    System.out.println("None");
                }
            }
            else if(command.equals("largest")){
                if(treeSet.isEmpty()){
                    System.out.println("None");
                }
                else{
                    System.out.println(treeSet.last());
                }
            }
            else if(command.equals("smallest")){
                if(treeSet.isEmpty()){
                    System.out.println("None");
                }
                else{
                    System.out.println(treeSet.first());
                }
            }            
        }
    }
}