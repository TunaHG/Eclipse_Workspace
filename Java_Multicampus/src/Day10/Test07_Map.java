package Day10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Test07_Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("java01", "1234");
		map.put("java32", "1235");
		map.put("java03", "1111");
		map.put("java14", "2222");
		map.put("java05", "1237");
		map.put("java26", "1235");
		map.put("java07", "1225");
		map.put("java58", "1612");
		map.put("java09", "4213");
		
		// map 구조 순회
		Set<String> keys = map.keySet();
		
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String id = (String) it.next();
			System.out.println(id + " = " + map.get(id));
		}
		
		// 로그인 처리
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("ID 입력하세요");
			String id = sc.nextLine().trim();
			System.out.println("PW 입력하세요");
			String pw = sc.nextLine().trim();
			
			if(!map.containsKey(id)) {
				System.out.println("id x ");
				continue;
			} else {
				if(map.get(id).equals(pw)) {
					System.out.println("로그인 성공");
					break;
				} else {
					System.out.println("로그인 실패");
					
				}
			}
		}
		
		sc.close();
		sc = null;
		
		System.out.println("END");
	}

}
