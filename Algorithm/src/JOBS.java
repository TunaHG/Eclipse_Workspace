import java.util.Scanner;

public class JOBS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner num = new Scanner(System.in);
	      
	      while(true){
	        int size = num.nextInt();
	        if(size < 3 || size > 25){
	          System.out.println("n must have value between 3 and 25");
	          continue;
	        }
	        int array[][] = new int[size][size];
	        int total = size * size;
	        int visited[] = new int[total];
	        for(int i = 0; i < total; i++){
	          visited[i] = i+1;
	        }
	        int half;
	        int index;
	        if(size % 2 == 0){
	          half = size / 2;
	          index = 2;
	        } else {
	          half = (size / 2);
	          index = 1;
	        }
	        int a = 0;
	        for(int i = 0; i < half; i++){
	          for(int j = 0; j < (size - (index*i) - 1); j++){
	            array[i][i+j] = visited[a++];
	          }
	          for(int j = 0; j < (size - (index*i) - 1); j++){
	            array[i+j][size-i-1] = visited[a++];
	          }
	          for(int j = 0; j < (size - (index*i) - 1); j++){
	            array[size-i-1][size-j-i-1] = visited[a++];
	          }
	          for(int j = 0; j < (size - (index*i) - 1); j++){
	            array[size-j-i-1][i] = visited[a++];
	          }
	        }
	        for(int i = 0; i < size; i++){
	          for(int j = 0; j < size; j++){
	            System.out.print(array[i][j] + "\t");
	          }
	          System.out.println();
	        }
	        break;
	      }
	}
}
