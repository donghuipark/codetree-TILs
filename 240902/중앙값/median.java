import java.util.*;
import java.io.*;

public class Main{

    private static int t, m;
    private static int[] arr;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        
        while(t-->0){
            m = Integer.parseInt(br.readLine());
            arr = new int[m];
            st = new StringTokenizer(br.readLine());
            
            for(int i=0;i<m;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            int median = arr[0];

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            System.out.print(median + " ");

            for(int i=1;i<m;i++){
                //1이지만 0부터 시작했기때문에 지금이 짝수인 경우
                // 여기서는 arr[i]값이 어디에 들어갈지 정해야한다.
                // arr[i]>median 이면 
                if(i%2 == 1){
                    if(arr[i] < median){
                        maxHeap.add(-arr[i]);
                    }
                    else{
                        minHeap.add(arr[i]);
                    }
                }
                // 이제 홀수인 경우 
                else{
                    int tmp;
                    if(maxHeap.size() > minHeap.size()){
                        tmp = -maxHeap.poll();
                    }
                    else{
                        tmp = minHeap.poll();
                    }

                    // tmp랑 arr[i], median 비교

                    int[] nums = new int[]{tmp, arr[i], median};
                    Arrays.sort(nums);

                    maxHeap.add(-nums[0]);
                    median = nums[1];
                    minHeap.add(nums[2]);

                    System.out.print(median + " ");
                }
            }

            System.out.println();
            
        }
        
    }
}