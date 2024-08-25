import java.util.*;
import java.io.*;
import java.util.Map.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeMap <String, Integer> treeMap = new TreeMap<>();
        for(int i=0;i<n;i++){
            String color = br.readLine();
            if(treeMap.containsKey(color)){
                int cnt = treeMap.get(color);
                treeMap.put(color, cnt+1);
            }
            else{
                treeMap.put(color, 1);
            }
        }

        Iterator<Entry<String, Integer>> it = treeMap.entrySet().iterator();
        while(it.hasNext()){
            Entry<String, Integer> entry = it.next();
           
            double percentage = (double)entry.getValue()/n*100;
            
            System.out.println(entry.getKey() + " " + String.format("%.4f", percentage));
        }
    }
}