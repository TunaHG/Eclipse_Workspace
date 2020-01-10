package LineInternCodingTest;
import java.util.Scanner;

public class Line3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int people = sc.nextInt();
        int time[] = new int[151];
        
        while(people-->0){
            int start = sc.nextInt();
            int end = sc.nextInt();
            
            for(int i = start; i < end; i++){
                time[i]++;
            }
        }
        
        int max = 0;
        for(int i = 0; i < 151; i++){
            if(time[i] > max) max = time[i];
        }
        System.out.print(max);
    }
}