import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();  // 테스트 케이스 개수
        
        for (int testCase = 0; testCase < t; testCase++) {
            int m = scanner.nextInt();  // 수열의 크기
            
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            
            StringBuilder result = new StringBuilder();
            
            for (int i = 1; i <= m; i++) {
                int num = scanner.nextInt();
                
                if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                    maxHeap.add(num);
                } else {
                    minHeap.add(num);
                }
                
                // 균형을 맞추기 위해 힙 조정
                if (maxHeap.size() > minHeap.size() + 1) {
                    minHeap.add(maxHeap.poll());
                } else if (minHeap.size() > maxHeap.size()) {
                    maxHeap.add(minHeap.poll());
                }
                
                // 홀수 번째 원소일 때만 중앙값을 출력
                if (i % 2 == 1) {
                    result.append(maxHeap.peek()).append(" ");
                }
            }
            
            // 결과 출력
            System.out.println(result.toString().trim());
        }
    }
}