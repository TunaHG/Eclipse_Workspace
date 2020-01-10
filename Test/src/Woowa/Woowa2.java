package Woowa;

public class Woowa2 {
	public static int[] solution(String logs) {
        int[] answer = new int[24];
        
        String str[] = logs.split("\n");
        for(int i = 0; i < str.length; i++) {
        	str[i] = str[i].substring(11, 13);
        	int time = Integer.parseInt(str[i]) + 9;
        	if(time > 24) time =- 24;
        	answer[time]++;
        }
        
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String logs = "2019/05/01 00:59:19\r\n" + 
				"2019/06/01 01:35:20\r\n" + 
				"2019/08/01 02:01:22\r\n" + 
				"2019/08/01 02:01:23\r\n" + 
				"2019/08/02 03:02:35\r\n" + 
				"2019/10/03 04:05:40\r\n" + 
				"2019/10/04 06:23:10\r\n" + 
				"2019/10/10 08:23:20\r\n" + 
				"2019/10/12 08:42:24\r\n" + 
				"2019/10/23 08:43:26\r\n" + 
				"2019/11/14 08:43:29\r\n" + 
				"2019/11/01 10:19:02\r\n" + 
				"2019/12/01 11:23:10";
		int answer[] = new int[24];
		answer = solution(logs);
		
		for(int i = 0; i < 24; i++) {
			System.out.println(answer[i]);
		}
	}

}
