package LineInternCodingTest;
import java.util.Scanner;

public class Line4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int seat[] = new int[N];
        
        for(int i = 0; i < N; i++){
            seat[i] = sc.nextInt();
        }
        
        int start = 0, end = 0, idx = 0, distance, result = 0;
        while(idx < N){
            if(seat[idx] == 1){
                start = end;
                end = idx;
            }
            if(start == 0 || end == 0){
                distance = end - start;
            } else {
                distance = (end - start) / 2;
            }
            result = Math.max(result, distance);
            idx++;
        }
        System.out.print(result);
    }
}