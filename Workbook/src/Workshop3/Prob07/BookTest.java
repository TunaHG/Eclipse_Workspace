package Workshop3.Prob07;

public class BookTest {

	public static void main(String[] args) {
		Book bookArray[] = new Book[3];
		
		bookArray[0] = new Book("SQL Plus", 50000, 5);
		bookArray[1] = new Book("Java 2.0", 40000, 3);
		bookArray[2] = new Book("JSP Servlet", 60000, 6);
		
		int totalPrice = 0;
		double totalDiscountPrice = 0;
		for (int i = 0; i < bookArray.length; i++) {
			System.out.printf("%s\t%d원\t%.1f%%\t%.1f원\n", 
					bookArray[i].getBookName(), bookArray[i].getBookPrice(),
					bookArray[i].getBookDiscountRate(), bookArray[i].getDiscountBookPrice());
			totalPrice += bookArray[i].getBookPrice();
			totalDiscountPrice += bookArray[i].getDiscountBookPrice();
		}
		System.out.println();
		System.out.println("책 가격의 합: " + totalPrice);
		System.out.println("할인 된 책 가격의 합: " + totalDiscountPrice);
	}

}
