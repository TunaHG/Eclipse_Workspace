package servicespring;

public class ProductService05 implements ProductService {
	ProductDAO dao;
	
	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public ProductVO sell() {
		System.out.println("May Sale percent is 30%");
		return dao.sell(0.3, 1);
	}
	
}
