package Woowa;

public class Woowa6 {
	static void swap(String arr[], int a, int b) {
		String tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	public static String[] solution(String[][] forms) {
        boolean[] tmp = new boolean[forms.length];
        
        int sd = 0, cnt = 0;
        String str = "";
        for(int i = 0; i < forms.length; i++) {
        	if(forms[i][1].length() <= 1) continue;
        	sd = 0;
        	while(true) {
        		if(sd + 2 > forms[i][1].length()) break;
        		str = forms[i][1].substring(sd, sd + 2);
        		for(int j = 0; j < forms.length; j++) {
        			if(i == j) continue;
        			if(forms[j][1].contains(str)) {
        				tmp[i] = true;
        				cnt++;
        				break;
        			}
        		}
        		sd++;
        	}
        }
        String[] answer = new String[cnt];
        cnt = 0;
        for(int i = 0; i < forms.length; i++) {
        	if(tmp[i] == true) {
        		answer[cnt++] = forms[i][0].replace("@email.com", "");
        	}
        }
        
        int result = cnt;
        for(int i = 0; i < cnt; i++) {
        	for(int j = i + 1; j < cnt; j++) {
        		if(answer[i].equals(answer[j])) {
        			answer[j] = "";
        			result--;
        			continue;
        		}
        		for(int k = 0; k < answer[i].length(); k++) {
        			if(answer[i].charAt(k) > answer[j].charAt(k)) {
        				swap(answer, i, j);
        				break;
        			} else if (answer[i].charAt(k) < answer[j].charAt(k)) break;
        		}
        	}
        }
        
        String[] last = new String[result];
        result = 0;
        
        for(int i = 0; i < cnt; i++) {
        	if(answer[i] != "") last[result++] = answer[i] + "@email.com";
        }
        return last;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[][] forms = {{"aaab@email.com", "Á¦ÀÌ¿¥"}, {"aaab@email.com", "¿¥Á¦ÀÌ"}, {"asdf@email.com", "¿ö³Ê"}};
		
		String[] answer = solution(forms);
		for(int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

}
