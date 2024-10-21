import java.util.*;
import java.io.*;

public class Main {
    private static int n, t;
    private static int[] times;
    private static int simul(int k){
        //k명씩 올라갈 수 있음.
        Queue<Integer> stage = new PriorityQueue<>();
        int totalTime = 0;
        int index = 0;

        for(int i=0;i<k&&i<n;i++){
            stage.add(times[index++]);
        }

        while(!stage.isEmpty()){
            int tempTime = stage.poll();

            totalTime += tempTime;
            Queue<Integer> tempStage = new PriorityQueue<>();
            while(!stage.isEmpty()){
                tempStage.add(stage.poll() - tempTime);
            }

            stage = tempStage;

            //다시 넣어.
            for(int i=0;i<k-stage.size()&& index<n;i++){
                stage.add(times[index++]);
            }
        }

        return totalTime;
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        times = new int[n];
        for(int i=0;i<n;i++){
            times[i] = Integer.parseInt(br.readLine());
        }

        int left = 1;
        int right = n;
        int mid = 0;
        while(left<=right){
            mid = (left+right) / 2;

            if(simul(mid) <= t){
                // 올라가는 사람이 많은 거니깐... mide를 줄여야겠군.
                right = mid - 1;
            }
            else{
                //시간이 너무 걸리니깐 올라가는 사람이 많아야돼.
                left = mid + 1;
            }
        }
        System.out.println(mid);
    }
}