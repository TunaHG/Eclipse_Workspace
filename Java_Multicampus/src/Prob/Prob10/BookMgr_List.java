package Prob.Prob10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookMgr_List {
	private List<Book> booklist;
	private Iterator<Book> it;
	
	public BookMgr_List() {
		booklist = new ArrayList<Book>();
	}
	
	public void addBook(Book book) {
		booklist.add(book);
	}
	public void updateBook(String title, int price) {
		boolean flag = false;
		it = booklist.iterator();
		while (it.hasNext()) {
			Book book = (Book) it.next();
			
			if(book.getTitle().toLowerCase().equals(title.toLowerCase())) {
				book.setPrice(price);
				System.out.printf("%s 책의 가격이 %d로 변경되었습니다.\n", book.getTitle(), book.getPrice());
				flag = true;
			}
		}
		if(flag == false) System.out.printf("제목이 %s인 책은 없습니다.\n", title);
	}
	public void searchBookTitle(String title) {
		boolean flag = false;
		it = booklist.iterator();
		while (it.hasNext()) {
			Book book = (Book) it.next();
			
			if(book.getTitle().toLowerCase().equals(title.toLowerCase())) {
				System.out.printf("%s 책의 가격은 %d원 입니다.\n", book.getTitle(), book.getPrice());
				flag = true;
			}
		}
		if(flag == false) System.out.printf("제목이 %s인 책은 없습니다.\n", title);
	}
	public void searchBookPrice(int price) {
		boolean flag = false;
		it = booklist.iterator();
		while (it.hasNext()) {
			Book book = (Book) it.next();
			
			if(book.getPrice() == price) {
				System.out.printf("%d원인 책의 제목은 %s입니다.\n", book.getPrice(), book.getTitle());
				flag = true;
			}
		}
		if(flag == false) System.out.printf("가격이 %d원인 책은 없습니다.\n", price);
	}
	public void deleteBook(String title) {
		boolean flag = false;
		it = booklist.iterator();
		while (it.hasNext()) {
			Book book = (Book) it.next();
			
			if(book.getTitle().toLowerCase().equals(title.toLowerCase())) {
				it.remove();
				flag = true;
			}
		}
		if(flag == false) System.out.println("해당 제목을 가진 책은 없습니다.");
	}
	public void printBookList() {
		it = booklist.iterator();
		while (it.hasNext()) {
			Book book = (Book) it.next();
			System.out.println(book);
		}
	}
}
