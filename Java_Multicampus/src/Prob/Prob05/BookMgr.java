package Prob.Prob05;

public class BookMgr {
	private Book[] booklist = null;
	private int index;
	
	public BookMgr() {
		index = 0;
		booklist = new Book[10];
	}
	public BookMgr(int size) {
		index = 0;
		booklist = new Book[size];
	}
	public void addBook(Book book) {
		if(booklist.length <= index) {
			Book[] temp = new Book[booklist.length * 2];
			System.arraycopy(booklist, 0, temp, 0, booklist.length);
			booklist = temp;
			temp = null;
		}
		booklist[index++] = book;
	}
	public void printBookList() {
		System.out.println("=== 책 목록 ===");
		for(int i = 0; i < index; i++) {
			System.out.println(booklist[i].getTitle());
		}
		System.out.println();
	}
	public void printTotalPrice() {
		int sum = 0;
		for(int i = 0; i < index; i++) {
			sum += booklist[i].getPrice();
		}
		System.out.println("=== 책 가격의 총합 ===");
		System.out.printf("전체 책 가격의 합 : %d\n", sum);
	}
	public void printSearchTitle(String title) {
		System.out.println("=== 검색 결과 ===");
		for(int i = 0; i < index; i++) {
			if(booklist[i].getTitle().toLowerCase().contains(title.trim().toLowerCase())) {
				booklist[i].print();
			}
		}
		
	}
}
