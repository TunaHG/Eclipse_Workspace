package Prob.Prob05;

import javax.swing.JOptionPane;

// Prob05
public class Prob05_BookApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		BookMgr b1 = new BookMgr();
		BookMgr b1 = new BookMgr(4);
		
		Book book = new Book("Java Program", 27000);
		b1.addBook(book);
		
		b1.addBook(new Book("JSP Program", 22000));
		b1.addBook(new Book("SQL Fundamentals", 24000));
		b1.addBook(new Book("JDBC Program", 31000));
		b1.addBook(new Book("EJB Program", 28000));
		
		b1.printBookList();
		
		b1.printTotalPrice();
		System.out.println();
		
		String title = JOptionPane.showInputDialog("검색할 도서를 입력하세요");
		b1.printSearchTitle(title);
	}

}
