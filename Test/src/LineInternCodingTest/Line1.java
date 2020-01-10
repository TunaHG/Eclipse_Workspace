package LineInternCodingTest;
import java.util.Scanner;

public class Line1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int message = sc.nextInt();
        int consumer = sc.nextInt();
        
        int messageTime[] = new int[message];
        for(int i = 0; i < message; i++){
            messageTime[i] = sc.nextInt();
        }
        
        int consumerTime[] = new int[consumer];
        for(int i = 0; i < consumer; i++){
            consumerTime[i] = messageTime[i];
        }
        
        int idx = consumer;
        while(idx < message){
            int min = 10000000;
            int minIdx = 0;
            for(int i = 0; i < consumer; i++){
                if(consumerTime[i] < min){
                    min = consumerTime[i];
                    minIdx = i;
                }
            }
            consumerTime[minIdx] += messageTime[idx++];
        }
        
        int max = 0;
        for(int i = 0; i < consumer; i++){
            if(consumerTime[i] > max) max = consumerTime[i];
        }
        System.out.println(max);
    }
}