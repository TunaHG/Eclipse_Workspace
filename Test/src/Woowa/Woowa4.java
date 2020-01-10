package Woowa;

public class Woowa4 {
	public boolean[] solution(String[] infos, String[] actions) {
        boolean[] answer = new boolean[actions.length];
        
        boolean loginStatus = false;
        boolean addStatus = false;
        
        String idpw;
        for(int i = 0; i < actions.length; i++) {
        	if(actions[i].startsWith("LOGIN")) {
        		if(loginStatus == true) answer[i] = false;
        		else {
        			idpw = actions[i].substring(6);
            		for(int j = 0; j < infos.length; j++) {
            			if(idpw.equals(infos[j])) {
            				loginStatus = true;
            				answer[i] = true;
            				break;
            			} else answer[i] = false;
            		}
        		}
        	}
        	if(actions[i].startsWith("ADD")) {
        		if(loginStatus == true) {
        			addStatus = true;
        			answer[i] = true;
        		}
        		else answer[i] = false;
        	}
        	if(actions[i].startsWith("ORDER")) {
        		if(addStatus == true) {
        			addStatus = false;
        			answer[i] = true;
        		}
        		else answer[i] = false;
        	}
        }
        
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
