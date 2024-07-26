import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{
    private static int n, ans;
    private static ArrayList<Integer> arr = new ArrayList<>(); 
    private static void makeNum(int curNum){
        if (curNum > n) {
            if(isBeautyNum()){
                ans++;
            }
            return;
        }

        for(int i=1; i<=4; i++){
            arr.add(i);
            makeNum(curNum+1);
            arr.remove(arr.size()-1);
        }
    }
    private static boolean isBeautyNum(){
        int cnt =1;
        for(int i=0; i<arr.size()-1; i++){
            if (arr.get(i) == arr.get(i+1)) {
                if (cnt == arr.get(i)) {
                    cnt = 1;
                    continue;                   
                }
                cnt++;
            }else{
                if (cnt == arr.get(i)) {
                    cnt = 1;                    
                }else{
                    return false;
                }
            }

            
        }
        if (arr.get(arr.size()-1) != cnt) {
            return false;
        }

        return true;
       
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        makeNum(1);
        System.out.println(ans);
    }
}