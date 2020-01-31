package servicespring;

public class ProductService12 implements ProductService {
	ProductDAO dao;
	
	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public ProductVO sell() {
		System.out.println("December Sale percent is 50%");
		return dao.sell(0.5, 0);
	}
	
}
