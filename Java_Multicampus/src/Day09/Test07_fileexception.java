package Day09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Prob.Prob05.Book;

public class Test07_fileexception {

	public static void main(String[] args) {
		System.out.println("-------------Start-------------");
		
		Scanner sc = null;
		try {
			sc = new Scanner(new File("bookdata.txt"));
			while(sc.hasNextLine()) {
				String[] data = sc.nextLine().split(" ");
				Book book = new Book(data[0], Integer.parseInt(data[1]));
				System.out.println(book);
			}
		} catch (FileNotFoundException e) {
			System.out.println("bookdata.txt 파일 확인 해 주세요.");
		} finally {
			if(sc != null) {
				sc.close();
				sc = null;
			}
		}
		
		System.out.println("--------------End--------------");
	}

}
