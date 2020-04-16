package javaIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class EXAM03_ObjectStream {
	public static void main(String[] args) {
		// 1. 로직처리를 통해서 만들어진 데이터 구조를 준비
		//    최종 결과 데이터가 HashMap으로 만들어졌다고 가정
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("1", "홍길동");
		map.put("2", "신사임당");
		map.put("3", "강감찬");
		map.put("4", "유관순");
		
		// 이 정보를 file에 저장한다.
		// file에 어떤 방식으로 저장할지 결정(문자열 형태로 저장)
		File file = new File("asset/StringData.txt");
		FileOutputStream fos;
		try {
			// 대표적인 출력 Stream : PrintWriter
//			PrintWriter pw = new PrintWriter(file);
			
			// println()은 통로에 데이터를 쓰는 작업
			// 실제 데이터가 전달되지 않음
//			pw.println("이것은 소리없는 아우성!");
//			pw.flush(); // 통로에서 실제 데이터를 보낸다.
//			pw.close(); // 사용이 끝난 통로를 닫는다.
			// 단일문자열과 같은 형태를 전달할 때는 문제되지 않음
			// 내가 저장할 데이터가 자료구조가 있음
			
			fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// 객체 직렬화를 통해서 저장하기 원하는 객체를 Stream을 통해서 전달(Object Serialization)
			oos.writeObject(map);
			oos.flush();
			
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
