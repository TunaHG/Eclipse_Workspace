package Step12;
import java.util.Scanner;

public class Q1003 {
//	// 시간초과
//	// 0과 1을 카운트 할 변수 선언
//	static int cntZero, cntOne;
//	// 피보나치의 수 재귀함수 
//	static int fibo(int n) {
//		// 0이 나오면
//		if(n == 0) {
//			// 0의 카운트 1증가
//			cntZero++;
//			// 값 0 return
//			return 0;
//		}
//		// 1이 나오면
//		if(n == 1) {
//			// 1의 카운트 1증가
//			cntOne++;
//			// 값 1 return
//			return 1;
//		}
//		// 0과 1 이외의 수일 경우 피보나치의 수 재귀함수 호출
//		return fibo(n - 1) + fibo(n - 2);
//	}
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		
//		// 테스트 케이스 개수 입력
//		int T = scan.nextInt();
//		
//		// 테스트 케이스 개수만큼 반복
//		while(T-- > 0) {
//			// 테스크 케이스 입력
//			int N = scan.nextInt();
//			// 전역변수 0의 카운트와 1의 카운트 초기화
//			cntZero = 0;
//			cntOne = 0;
//			// 피보나치의 수 함수 호출
//			int result = fibo(N);
//			
//			// 함수 호출 이후에 카운트 된 0과 1의 카운트 출력
//			System.out.println(cntZero + " " + cntOne);
//		}
//	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 테스트 케이스 개수 입력
		int T = scan.nextInt();

		// 0의 카운트와 1의 카운트 배열선언
		// 피보나치의 수를 40번째까지 진행하기 때문에 크기를 41로 선언
		int cntZero[] = new int[41];
		int cntOne[] = new int[41];
		
		// 0의 카운트 초기값 설정
		cntZero[0] = 1;
		cntZero[1] = 0;
		// 1의 카운트 초기값 설정
		cntOne[0] = 0;
		cntOne[1] = 1;
		
		// 피보나치의 수가 40번째까지라고 조건이 주어졌으므로 40번째까지 반복문 진행
		for(int i = 2; i <= 40; i++) {
			// 0의 카운트 피보나치의 수처럼 진행
			cntZero[i] = cntZero[i - 1] + cntZero[i - 2];
			// 1의 카운트 피보나치의 수처럼 진행
			cntOne[i] = cntOne[i - 1] + cntOne[i - 2];
		}
		
		// 테스트 케이스 개수만큼 반복문 진행
		while(T-- > 0) {
			// 테스트 케이스 입력
			int N = scan.nextInt();
			
			// 테스트 케이스에 해당하는 위치의 0과 1의 카운트 출력
			System.out.println(cntZero[N] + " " + cntOne[N]);
		}
	}
}
