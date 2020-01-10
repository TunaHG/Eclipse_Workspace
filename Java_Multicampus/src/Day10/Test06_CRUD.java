package Day10;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;

public class Test06_CRUD {
	public static void main(String[] args) {
		Set<Book> bookList = new HashSet<Book>();
		
		//등록
		bookList.add(new Book("java", 500));
		bookList.add(new Book("sql", 1500));
		bookList.add(new Book("jsp", 5500));
		bookList.add(new Book("java", 500));
		bookList.add(new Book("스프링 5", 4500));
		bookList.add(new Book("하둡", 65000));
		bookList.add(new Book("R", 3000));
		
		//출력
		Iterator<Book> it = bookList.iterator();
		while (it.hasNext()) {
			Book book = (Book) it.next();
			System.out.println(book);
		}
		
		//검색
		String keyword = JOptionPane.showInputDialog("검색 : 도서명");
		System.out.println(keyword + " 도서 검색 결과 ");
		
		it = bookList.iterator();
		while (it.hasNext()) {
			Book book = (Book) it.next();
			
			if(book.title.toUpperCase().contains(keyword.toUpperCase())) {
			     System.out.println(book);
			}
		}
		
        //삭제
		Scanner scanner = new Scanner(System.in);
		System.out.println("삭제할 도서 이름을 입력하세요");
		String msg = scanner.nextLine().trim();
		
		it = bookList.iterator();
		while (it.hasNext()) {
			Book book = (Book) it.next();
			
			if(book.title.contains(msg)) {
			     System.out.println(book);
			     System.out.println("삭제할까요? y를 입력 하면 삭제합니다.");
			     String yy = scanner.nextLine().trim();
			     if(yy.equalsIgnoreCase("y")) {
			    	 it.remove();
			     }
			}
		}
		
		//출력
		it = bookList.iterator();
		while (it.hasNext()) {
			Book book = (Book) it.next();
			System.out.println(book);
		}
				
		//수정
		System.out.println("수정할 도서 이름을 입력하세요");
		msg = scanner.nextLine().trim();
		it = bookList.iterator();
		while (it.hasNext()) {
			Book book = (Book) it.next();
			
			if(book.title.contains(msg)) {
			     book.title = book.title+"___";
			}
		}
		
		
		//출력
		it = bookList.iterator();
		while (it.hasNext()) {
			Book book = (Book) it.next();
			System.out.println(book);
		}
		
	    scanner.close();
	    scanner = null;
	}
}

class Book{
	String title;
	int price;
	
	public Book(String title, int price) {
		super();
		this.title = title;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + price;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (price != other.price)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
}






