package Prob.Prob10;

public class Prob10_BookApp {

	public static void main(String[] args) {
		BookMgr_List bm = new BookMgr_List();
		
		bm.addBook(new Book("Java1", 13000));
		bm.addBook(new Book("JSP", 17000));
		bm.addBook(new Book("Java2", 13000));
		bm.addBook(new Book("Java Script", 23000));
		bm.addBook(new Book("JDBC", 10000));
		
		bm.printBookList();
		System.out.println();
		
		bm.updateBook("JDBC", 20000);
		bm.printBookList();
		bm.updateBook("Java", 10000);
		System.out.println();
		
		bm.searchBookTitle("JDBC");
		bm.printBookList();
		bm.searchBookTitle("JDBC2");
		System.out.println();
		
		bm.searchBookPrice(13000);
		bm.printBookList();
		bm.searchBookPrice(14000);
		System.out.println();
		
		bm.deleteBook("Java Script2");
		bm.deleteBook("Java Script");
		bm.printBookList();
		System.out.println();
	}

}
