package Woowa;

public class Woowa1 {
	public int solution(int[] restaurant, int[][] riders, int k) {
        int answer = 0;
        int len = riders.length;
        int dist[] = new int[len];
        
        double num1, num2;
        for(int i = 0; i < len; i++) {
        	num1 = riders[i][0];
        	num2 = riders[i][1];
        	dist[i] = (int) Math.sqrt(Math.pow(num1, 2) + Math.pow(num2, 2));
        	if(dist[i] < k) answer++;
        }
        
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int restaurant[] = new int[2];
		int riders[][] = new int[2][7];
		int k = 1000;
		
		
	}

}
