import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {
    private static int n;
    private static TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("add")){
                int key = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());

                treeMap.put(key, value);
            }
            else if(command.equals("remove")){
                int key = Integer.parseInt(st.nextToken());
                treeMap.remove(key);
            }
            else if(command.equals("find")){
                int key = Integer.parseInt(st.nextToken());
                if(treeMap.containsKey(key)){
                    System.out.println(treeMap.get(key));
                }
                else{
                    System.out.println("None");
                }
            }
            else if(command.equals("print_list")){
                if (treeMap.isEmpty()) {
                    System.out.println("None");
                }
                else{
                    Iterator<Entry<Integer, Integer>> it = treeMap.entrySet().iterator();
                    while(it.hasNext()){
                        Entry<Integer, Integer> entry = it.next();
                        System.out.print(entry.getValue() + " ");
                    }        
                    System.out.println();
                }
            }


        }
    }
}