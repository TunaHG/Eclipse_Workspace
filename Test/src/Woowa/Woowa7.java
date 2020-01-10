package Woowa;
import java.util.Arrays;

public class Woowa7 {
	public static String[] solution(String user, String[][] friends, String[] visitors) {
        String[] answer = new String[friends.length];
        Arrays.fill(answer, "");
        int[] point = new int[friends.length];
        Arrays.fill(point, 0);
        
        String[] alreadyFriends = new String[friends.length];
        
        int cnt = 0;
        String fname = "";
        for(int i = 0; i < friends.length; i++) {
        	if(friends[i][1].equals(user)) {
        		fname = friends[i][0];
        		alreadyFriends[i] = fname;
        		for(int j = 0; j < friends.length; j++) {
        			if(friends[j][0].equals(fname)) {
        				if(friends[j][1] != user) {
            				for(int k = 0; k < friends.length; k++) {
            					if(answer[k] == friends[j][1]) {
            						point[k] += 10;
            						break;
            					}
            					if(answer[k].contentEquals("")) {
            						answer[k] = friends[j][1];
            						point[k] += 10;
            						cnt++;
            						break;
            					}
            				}
        				}
        			}
        		}
        	}
        }
        boolean SW = false;
        for(int i = 0; i < visitors.length; i++) {
        	for(int j = 0; j < friends.length; j++) {
        		if(visitors[i] == alreadyFriends[j]) {
        			SW = true;
        			break;
        		}
        	}
        	if(SW == true) {
        		SW = false;
        		break;
        	}
        	for(int j = 0; j < friends.length; j++) {
        		if(visitors[i] == answer[j]) {
        			point[j] += 1;
        			break;
        		}
        		if(answer[j].contentEquals("")) {
        			answer[j] = visitors[i];
        			point[j] += 1;
        			cnt++;
        			break;
        		}
        	}
        }
        
        for(int i = 0; i < friends.length; i++) {
        	if(answer[i].equals("")) break;
        	for(int j = i + 1; j < friends.length; j++) {
        		if(point[j] > point[i]) {
        			int tmp = point[i];
        			point[i] = point[j];
        			point[j] = tmp;
        			String tmp2 = answer[i];
        			answer[i] = answer[j];
        			answer[j] = tmp2;
        		} else if(point[i] == point[j]) {
        			if(answer[i].charAt(0) > answer[j].charAt(0)) {
            			String tmp2 = answer[i];
            			answer[i] = answer[j];
            			answer[j] = tmp2;
    				}
        		}
        	}
        }
        for(int i = 0; i < friends.length; i++) {
        	System.out.print(answer[i] + "\t");
        	System.out.println(point[i]);
        }
        System.out.println(cnt);
        
        String[] result = new String[cnt];
        for(int i = 0; i < cnt; i++) {
        	result[i] = answer[i];
        }
        
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String user = "mrko";
		String[][] friends = {{"donut","andole"}, {"donut", "jun"}, {"donut", "mrko"}, {"shakevan", "andole"},
				{"shakevan", "jun"}, {"shakevan", "mrko"}};
		String[] visitors = {"bedi", "bedi", "bedi", "donut", "shakevan"};
		
		String[] result = solution(user, friends, visitors);
		
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

}
