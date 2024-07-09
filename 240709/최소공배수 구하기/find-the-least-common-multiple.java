import java.util.*;

public class Main {
    public static int gcd(int a, int b){
        if (b == 0 ){
            return a;
        }
        else{
            return gcd(b, a%b);
        }
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int result = 1;
        if(n < m){
            result = n * m / gcd(n, m);
        }
        else{
            result = n * m / gcd(m , n);
        }
        System.out.println(result);
    }
}