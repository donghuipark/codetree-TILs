import java.util.*;

class Pair implements Comparable<Pair> {
    int arr1Idx;
    int arr2Idx;
    int sum;

    public Pair(int arr1Idx, int arr2Idx, int sum) {
        this.arr1Idx = arr1Idx;
        this.arr2Idx = arr2Idx;
        this.sum = sum;
    }

    @Override
    public int compareTo(Pair other) {
        return Integer.compare(this.sum, other.sum);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        
        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            arr2[i] = scanner.nextInt();
        }
        
        System.out.println(kthSmallestPairSum(n, m, k, arr1, arr2));
        
        scanner.close();
    }
    
    public static int kthSmallestPairSum(int n, int m, int k, int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        
        // 첫 번째 배열의 첫 번째 원소와 두 번째 배열의 모든 원소의 합을 힙에 추가
        for (int i = 0; i < m; i++) {
            minHeap.offer(new Pair(0, i, arr1[0] + arr2[i]));
        }
        
        int count = 0;
        int result = 0;
        
        while (count < k) {
            Pair curr = minHeap.poll();
            result = curr.sum;
            int arr1Idx = curr.arr1Idx;
            int arr2Idx = curr.arr2Idx;
            count++;
            
            // 첫 번째 배열의 다음 원소와 두 번째 배열의 현재 원소의 합을 힙에 추가
            if (arr1Idx + 1 < n) {
                minHeap.offer(new Pair(arr1Idx + 1, arr2Idx, arr1[arr1Idx + 1] + arr2[arr2Idx]));
            }
        }
        
        return result;
    }
}