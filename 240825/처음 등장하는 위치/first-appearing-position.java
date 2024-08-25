import java.io.*;
import java.util.*;
import java.util.Map.*;

public class Main {

    private static int n;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            int key = Integer.parseInt(st.nextToken());
            if(!treeMap.containsKey(key)){
                treeMap.put(key, i);
            }
        }

        Iterator<Entry<Integer, Integer>> it = treeMap.entrySet().iterator();
        while(it.hasNext()){
            Entry<Integer, Integer> entry = it.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}