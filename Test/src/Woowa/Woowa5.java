package Woowa;

public class Woowa5 {
	public int[] solution(String[] history) {
        int[] answer = new int[history.length];
        
        int[] wrong = new int[1];
        wrong[0] = -1;
        
        int arr[][] = {{4, 50, 10, 10, 4},
        		{10, 100, 30, 50, 10},
        		{10000, 3000, 1000, 2000, 1000},
        		{5, 100, 10, 5, 2}};
        
        for(int i = 0; i < history.length; i++) {
        	if(history[i].equals("1.0")) {
        		for(int j = 0; j < 5; j++) {
        			arr[3][j] -= arr[0][j];
        			if(arr[3][j] < 0) {
        				arr[3][j] += arr[1][j];
        				answer[i] += arr[2][j];
        				if(arr[3][j] < 0) {
        					arr[3][j] += arr[1][j];
            				answer[i] += arr[2][j];
        				}
        			}
        		}
        	} else if(history[i].equals("1.5")) {
        		for(int j = 0; j < 5; j++) {
        			if(j != 5) arr[3][j] -= arr[0][j] * 1.5;
        			else arr[3][j] -= (arr[0][j] * 1.5 / 2);
        			if(arr[3][j] < 0) {
        				arr[3][j] += arr[1][j];
        				answer[i] += arr[2][j];
        				if(arr[3][j] < 0) {
        					arr[3][j] += arr[1][j];
            				answer[i] += arr[2][j];
        				}
        			}
        		}
        	} else if(history[i].equals("2.0")) {
        		for(int j = 0; j < 5; j++) {
        			arr[3][j] -= arr[0][j] * 2;
        			if(arr[3][j] < 0) {
        				arr[3][j] += arr[1][j];
        				answer[i] += arr[2][j];
        				if(arr[3][j] < 0) {
        					arr[3][j] += arr[1][j];
            				answer[i] += arr[2][j];
        				}
        			}
        		}
        	} else if(history[i].equals("2.5")) {
        		for(int j = 0; j < 5; j++) {
        			if(j != 5) arr[3][j] -= arr[0][j] * 2.5;
        			else arr[3][j] -= (arr[0][j] * 2.5 / 2);
        			if(arr[3][j] < 0) {
        				arr[3][j] += arr[1][j];
        				answer[i] += arr[2][j];
        				if(arr[3][j] < 0) {
        					arr[3][j] += arr[1][j];
            				answer[i] += arr[2][j];
        				}
        			}
        		}
        	} else return wrong;
        }
        
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
