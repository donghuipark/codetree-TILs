import java.util.*;
import java.io.*;
import java.util.Map.*;

public class Main {
    private static int n;

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        Iterator<Entry<String, Integer>> it;

        n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            String voca = br.readLine();
            if(treeMap.containsKey(voca)){
                treeMap.put(voca, treeMap.get(voca)+1);
            }
            else{
                treeMap.put(voca, 1);
            }
        }

        it = treeMap.entrySet().iterator();
        while(it.hasNext()){
            Entry<String, Integer> entry = it.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}