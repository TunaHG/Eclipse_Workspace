package LineInternCodingTest;
import java.util.Scanner;

public class Line5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int sizeX = sc.nextInt();
        int sizeY = sc.nextInt();
        
        int arr[][] = new int[sizeX][sizeY];
        for(int i = 0; i < sizeX; i++){
            arr[i][0] = 1;
        }
        for(int i = 0; i < sizeY; i++){
            arr[0][i] = 1;
        }
        for(int i = 1; i < sizeX; i++){
            for(int j = 1; j < sizeY; j++){
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }
        
        int conyX = sc.nextInt();
        int conyY = sc.nextInt();
        
        if(conyX == 0 & conyY == 0) System.out.print("fail");
        else if(conyX > sizeX | conyY > sizeY) System.out.print("fail");
        else {
            System.out.println(conyX + conyY);
            System.out.print(arr[conyX][conyY]);
        }
    }
}