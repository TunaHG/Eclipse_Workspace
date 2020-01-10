package LineInternCodingTest;
import java.util.Scanner;

public class Line6 {
	static char result[][];
	static int idx = 0;
	public static void zero(int size) {
		for(int i = 0; i < size * 2 - 1; i++) {
			result[i][idx] = '#';
			result[i][idx + size - 1] = '#';
		}
		for(int i = 0; i < size; i++) {
			result[0][idx + i] = '#';
			result[size * 2 - 2][idx + i] = '#';
		}
	}
	public static void one(int size) {
		for(int i = 0; i < size * 2 - 1; i++) {
			result[i][idx + size - 1] = '#';
		}
	}
	public static void two(int size) {
		for(int i = 0; i < size; i++) {
			result[0][idx + i] = '#';
			result[size - 1][idx + i] = '#';
			result[size * 2 - 2][idx + i] = '#';
			result[i][idx + size - 1] = '#';
			result[i + size - 1][idx] = '#';
		}
	}
	public static void three(int size) {
		for(int i = 0; i < size; i++) {
			result[0][idx + i] = '#';
			result[size - 1][idx + i] = '#';
			result[size * 2 - 2][idx + i] = '#';
			result[i][idx + size - 1] = '#';
			result[i + size - 1][idx + size - 1] = '#';
		}
	}
	public static void four(int size) {
		for(int i = 0; i < size * 2 - 1; i++) {
			if(i < size - 1) {
				result[i][idx] = '#';
				result[i][idx + size - 1] = '#';
			} else if(i < size) {
				for(int j = 0; j < size; j++) {
					result[i][idx + j] = '#';
				}
			} else {
				result[i][idx + size - 1] = '#';				
			}
		}
	}
	public static void five(int size) {
		for(int i = 0; i < size; i++) {
			result[0][idx + i] = '#';
			result[size - 1][idx + i] = '#';
			result[size * 2 - 2][idx + i] = '#';
			result[i][idx] = '#';
			result[i + size - 1][idx + size - 1] = '#';
		}
	}
	public static void six(int size) {
		for(int i = 0; i < size * 2 - 1; i++) {
			if(i < size - 1) {
				result[i][idx] = '#';
			} else if(i == size - 1 | i == size * 2 - 2) {
				for(int j = 0; j < size; j++) {
					result[i][idx + j] = '#';
				}
			} else {
				result[i][idx] = '#';
				result[i][idx + size - 1] = '#';				
			}
		}
	}
	public static void seven(int size) {
		for(int i = 0; i < size; i++) {
			result[0][idx + i] = '#';
		}
		for(int i = 0; i < size * 2 - 1; i++) {
			result[i][idx + size - 1] = '#';
		}
	}
	public static void eight(int size) {
		for(int i = 0; i < size; i++) {
			result[0][idx + i] = '#';
			result[size - 1][idx + i] = '#';
			result[size * 2 - 2][idx + i] = '#';
			result[i][idx + size - 1] = '#';
			result[i + size - 1][idx + size - 1] = '#';
			result[i + size - 1][idx] = '#';
			result[i][idx] = '#';
		}
	}
	public static void nine(int size) {
		for(int i = 0; i < size * 2 - 1; i++) {
			if(i < size - 1 & i != 0) {
				result[i][idx] = '#';
				result[i][idx + size - 1] = '#';
			} else if(i == 0 | i == size - 1) {
				for(int j = 0; j < size; j++) {
					result[i][idx + j] = '#';
				}
			} else {
				result[i][idx + size - 1] = '#';				
			}
		}
	}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        String sort = sc.nextLine().trim();
        
        String size = "";
        String num = "";
        while(N-- > 0){
            int tmpSize = sc.nextInt();
            String tmpNum = sc.nextLine().trim();
            
            for(int i = 0; i < tmpNum.length(); i++) {
            	size += tmpSize;
            	num += tmpNum.charAt(i);
            }
        }
        
        int length = num.length();
        int arr[][] = new int[2][length];
        
        int sum = 0;
        int max = 0;
        for(int i = 0; i < length; i++) {
        	arr[0][i] = Integer.valueOf(size.charAt(i)) - 48;
        	arr[1][i] = Integer.valueOf(num.charAt(i)) - 48;
        	sum += arr[0][i];
        	if(arr[0][i] > max) max = arr[0][i];
        }
        result = new char[max * 2 - 1][sum + length];
        for(int i = 0; i < max * 2 - 1; i++) {
        	for(int j = 0; j < sum + length; j++) {
        		result[i][j] = '.';
        	}
        }
        
        for(int i = 0; i < length; i++) {
        	if(arr[1][i] == 0) {
        		zero(arr[0][i]);
        		idx += arr[0][i];
        	}
        	else if(arr[1][i] == 1) {
        		one(arr[0][i]);
        		idx += arr[0][i];
        	}
        	else if(arr[1][i] == 2) {
        		two(arr[0][i]);
        		idx += arr[0][i];
        	}
        	else if(arr[1][i] == 3) {
        		three(arr[0][i]);
        		idx += arr[0][i];
        	}
        	else if(arr[1][i] == 4) {
        		four(arr[0][i]);
        		idx += arr[0][i];
        	}
        	else if(arr[1][i] == 5) {
        		five(arr[0][i]);
        		idx += arr[0][i];
        	}
        	else if(arr[1][i] == 6) {
        		six(arr[0][i]);
        		idx += arr[0][i];
        	}
        	else if(arr[1][i] == 7) {
        		seven(arr[0][i]);
        		idx += arr[0][i];
        	}
        	else if(arr[1][i] == 8) {
        		eight(arr[0][i]);
        		idx += arr[0][i];
        	}
        	else if(arr[1][i] == 9) {
        		nine(arr[0][i]);
        		idx += arr[0][i];
        	}
        	for(int j = 0; j < max * 2 - 1; j++) {
        		result[j][idx] = ' ';
        	}
        	idx++;
        }
        
        for(int i = 0; i < max * 2 - 1; i++) {
        	for(int j = 0; j < sum + length; j++) {
        		System.out.print(result[i][j]);
        	}
        	System.out.println();
        }
    }
}