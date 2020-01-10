package Day09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

import Prob.Prob05.Book;

public class Test08_StringTokenizer {

	public static void main(String[] args) {
		System.out.println("-------------Start-------------");
		
		try(Scanner sc = new Scanner(new File("bookdata.txt"));) {
			StringTokenizer st = null;
			while(sc.hasNextLine()) {
				st = new StringTokenizer(sc.nextLine());
				String title = st.nextToken();
				int price = Integer.parseInt(st.nextToken());
				
				Book book = new Book(title, price);
				System.out.println(book);
			}
		} catch (FileNotFoundException e) {
			System.out.println("bookdata.txt 파일 확인 해 주세요.");
		} 
		
		System.out.println("--------------End--------------");
	}

}
