package App;

import java.util.Scanner;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = 0;
		String exit = "";
		String name = "";
		String nameList[] = new String[100];
		int index = 0;
		String searchName = "";
		String deleteName = "";

		A: while (true) {
			System.out.println("원하는 메뉴를 입력하세요.");
			System.out.println("1. 입력");
			System.out.println("2. 출력");
			System.out.println("3. 검색");
			System.out.println("4. 삭제");
			System.out.println("9. 종료");

			num = sc.nextInt();
			sc.nextLine();

			switch (num) {
			case 1:
				System.out.println("이름를 입력하세요.");
				name = sc.nextLine();
				nameList[index++] = name;
				break;
			case 2:
				System.out.println("입력된 모든 이름을 출력합니다.");
				for (int i = 0; i < 100; i++) {
					if (nameList[i] == null)
						break;
					System.out.println(nameList[i]);
				}
				break;
			case 3:
				System.out.println("검색할 이름을 입력하세요.");
				searchName = sc.nextLine();
				for (int i = 0; i < 100; i++) {
					if (nameList[i] == null) {
						System.out.println("입력한 이름이 없습니다.");
						break;
					} else if (nameList[i].equals(searchName)) {
						System.out.print("입력한 이름이 있습니다. ");
						System.out.println(searchName);
						break;
					}
				}
				break;
			case 4:
				// ???
				System.out.println("삭제할 이름을 입력하세요.");
				deleteName = sc.nextLine();
				for (int i = 0; i < 100; i++) {
					if (nameList[i] == null) {
						System.out.println("입력한 이름이 없습니다.");
						break;
					} else if (nameList[i].equals(deleteName)) {
						nameList[i] = null;
						index--;
						for (int j = i; j < 99; j++) {
							nameList[j] = nameList[j + 1];
							if (nameList[j] == null)
								break;
						}
						System.out.println("입력한 이름을 삭제했습니다.");
						break;
					}
				}
				break;
			case 9:
				System.out.println("정말 종료하시겠습니까?(Y)");
				exit = sc.nextLine().toUpperCase();
				if (exit.equals("Y".toUpperCase())) {
					System.out.println("종료합니다.");
					// return을 이용한 main Method종료.
//					sc.close();
//					sc = null;
//					return ;
					// while반복문 종료를 통한 아래 코드 실행.
					break A;
				} else {
					System.out.println("초기화면으로 돌아갑니다.");
					break;
				}
			default:
				System.out.println("다시 메뉴를 선택해주세요.");
			}
		}
		sc.close();
		sc = null;
		return;
	}

}
