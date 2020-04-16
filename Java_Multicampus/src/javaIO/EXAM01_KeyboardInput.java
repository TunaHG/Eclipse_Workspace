package javaIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
 * Java IO(입력과 출력)
 * Stream을 이용해서 처리
 * Stream : Data를 받아들이고 보낼 수 있는 통로
 * 우리 Java Program이 표준출력(Dos창)에 문자열을 출력하고 싶다면
 * Java Program과 연결된 Dos창에 대한 Stream이 존재해야 한다. 
 * 
 * Stream
 * Stream은 객체 => Class가 존재
 * 이 Class의 객체를 생성, method를 이용해서 Data의 입출력을 수행
 * 
 * Stream은 입력 Stream과 출력 Stream 두 개로 구분된다.
 * 데이터 연결 통로는 단방향이다.
 * InputStream => 가장 기본적인 입력 Stream
 * OutputStream => 가장 기본적인 출력 Stream
 * ==> 가장 기본적인 두 Stream은 상당히 성능이 좋지 않다.(속도가 느리다)
 * 
 * Stream을 결합하여 더 좋은 Stream을 만들 수 있다. 
 */
public class EXAM01_KeyboardInput {
	public static void main(String[] args) {
		System.out.println("Print Message");
		// System.out : 표준출력(Dos창)에 연결된 Stream(이미 제공되어있음)
		// Stream이 가지는 println()이라는 method를 이용해서 실제 문자열을 Dos창에 전달
		
		// Dos에서 문자열을 입력받고 싶다.
		// 기본적으로 InputStream이 있어야 데이터를 받을 수 있다.
		// System.in => Dos와 연결된 InputStream
		// InputStream은 효율도 좋지 않고 문자열을 읽어들이기에 좋지 않다.
		// InputStream을 문자열 입력받기 좋은 InputStreamReader로 업그레이드
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			String msg = br.readLine();
			System.out.println("입력받은 문자열 : " + msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
